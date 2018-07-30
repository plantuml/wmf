package Oxage.Wmf;

import Oxage.Wmf.Records.*;
import java.io.*;

/** 
 Low-level WMF builder
*/
public class WmfWriter implements Closeable
{
	private OutputStream stream;
	private BinaryWriter writer;

	public WmfWriter(OutputStream stream)
	{
		this.stream = stream;
		this.writer = new BinaryWriter(stream);
	}

	public final void Write(IBinaryRecord record)
	{
		record.Write(writer);
	}

	/** 
	 Fixes file size field, max records field and number of objects field.
	*/
	public final void FixHeader()
	{
		if (!stream.CanSeek)
		{
			throw new WmfException("Cannot fix WMF header since the stream does not support seeking!");
		}

		//Skip WmfFormat record
		stream.Seek(22, SeekOrigin.Begin);

		//Read whole WmfHeader record
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] buffer = new byte[18];
		byte[] buffer = new byte[18];
		stream.Read(buffer, 0, 18);

		//Create new header record
		WmfHeader header = new WmfHeader();
		try (MemoryStream ms = new MemoryStream(buffer))
		{
			try (BinaryReader reader = new BinaryReader(ms))
			{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: uint max, count;
				int max, count;
				tangible.OutObject<Integer> tempOut_max = new tangible.OutObject<Integer>();
				tangible.OutObject<Integer> tempOut_count = new tangible.OutObject<Integer>();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: Find(out max, out count);
				Find(tempOut_max, tempOut_count);
			count = tempOut_count.argValue;
			max = tempOut_max.argValue;

				long l = stream.getLength() - 22; //Length without WmfFormat in bytes
				if (l % 2 == 1)
				{
					l += 1; //Round to WORD padding
				}
				long size = l / 2; //Length in words

				header.Read(reader);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: header.FileSize = (uint)size;
				header.setFileSize((int)size);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: header.NumberOfObjects = (ushort)count;
				header.setNumberOfObjects((short)count);
				header.setMaxRecord(max);
			}
		}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] fix = new byte[18];
		byte[] fix = new byte[18];
		try (MemoryStream ms = new MemoryStream())
		{
			try (BinaryWriter writer = new BinaryWriter(ms))
			{
				header.Write(writer);
				fix = ms.ToArray();
			}
		}

		//Rewind back to position of overwrite
		this.stream.Seek(22, SeekOrigin.Begin);
		Oxage.Wmf.BinaryWriterExtensions.Write(this.writer, fix);

		//Forward to when fixing started
		stream.Seek(0, SeekOrigin.End);
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: protected void Find(out uint maxRecordSize, out uint numberOfObjects)
	protected final void Find(tangible.OutObject<Integer> maxRecordSize, tangible.OutObject<Integer> numberOfObjects)
	{
		maxRecordSize.argValue = 0;
		numberOfObjects.argValue = 0;

		//Skip WmfFormat and WmfHeader record
		stream.Seek(22 + 18, SeekOrigin.Begin);

		BinaryReader reader = new BinaryReader(stream);
		//using (var reader = new BinaryReader(stream)) //Do NOT use 'using' here as will close the stream

		while (true)
		{
			try
			{
				//End of stream
				if (stream.Position == stream.getLength())
				{
					break;
				}

				//Read record size in WORDs and record type
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: uint length = reader.ReadUInt32();
				int length = reader.ReadUInt32();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: ushort type = reader.ReadUInt16();
				short type = reader.ReadUInt16();
				int offset = 4 + 2; //4 bytes read for 'length' and 2 for 'type'

				//Find maximum record size
				maxRecordSize.argValue = Math.max(length, maxRecordSize.argValue);

				//Find maximum object index, since indices are sorted incrementally it is assumed that index + 1 means number of objects
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: if (type == (ushort)RecordType.META_SELECTOBJECT || type == (ushort)RecordType.META_DELETEOBJECT)
				if (type == (short)RecordType.META_SELECTOBJECT.getValue() || type == (short)RecordType.META_DELETEOBJECT.getValue())
				{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: ushort objectIndex = reader.ReadUInt16();
					short objectIndex = reader.ReadUInt16();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: numberOfObjects = Math.Max((uint)objectIndex + 1, numberOfObjects);
					numberOfObjects.argValue = Math.max((int)objectIndex + 1, numberOfObjects.argValue);
					offset += 2;
				}

				//Skip record
				stream.Seek(2 * length - offset, SeekOrigin.Current);
			}
			catch (EndOfStreamException e)
			{
				//End of stream
				break;
			}
		}

		//Forward to when fixing started
		stream.Seek(0, SeekOrigin.End);
	}

	/** 
	 Fixes padding to align to 16-bit boundary.
	*/
	public final void FixPadding()
	{
		//WMF must align to 16-bit (? not sure, cannot find in docs but it's logical since size value is in 16-bit worda)
		if (stream.getLength() % 2 == 1)
		{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)0);
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)0);
		}
	}

	public final void close() throws IOException
	{
		if (this.writer != null)
		{
			this.writer.Close();
			this.writer = null;
		}
	}
}