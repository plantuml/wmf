package Oxage.Wmf;

import Oxage.Wmf.Records.*;
import java.io.*;

/** 
 Low-level WMF parser
*/
public class WmfReader implements Closeable
{
	private InputStream stream;
	private BinaryReader reader;

	public WmfReader(InputStream stream)
	{
		this.stream = stream;
		this.reader = new BinaryReader(stream);
	}

	private boolean IsFormatRead;
	public final boolean getIsFormatRead()
	{
		return IsFormatRead;
	}
	protected final void setIsFormatRead(boolean value)
	{
		IsFormatRead = value;
	}

	private boolean IsHeaderRead;
	public final boolean getIsHeaderRead()
	{
		return IsHeaderRead;
	}
	protected final void setIsHeaderRead(boolean value)
	{
		IsHeaderRead = value;
	}

	public final boolean getIsEndOfFile()
	{
		return stream.getLength() == stream.Position;
	}

	public final IBinaryRecord Read()
	{
		if (!this.getIsFormatRead())
		{
			this.setIsFormatRead(true);
			WmfFormat format = new WmfFormat();
			format.Read(reader);
			return format;
		}

		if (!this.getIsHeaderRead())
		{
			this.setIsHeaderRead(true);
			WmfHeader header = new WmfHeader();
			header.Read(reader);
			return header;
		}

		long begin = reader.BaseStream.Position;

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: uint length = reader.ReadUInt32();
		int length = reader.ReadUInt32(); //Length in WORDs
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: ushort type = reader.ReadUInt16();
		short type = reader.ReadUInt16();

		RecordType rt = RecordType.forValue(type);
		Oxage.Wmf.IBinaryRecord tempVar = WmfHelper.GetRecordByType(rt);
		WmfBinaryRecord record = tempVar instanceof WmfBinaryRecord ? (WmfBinaryRecord)tempVar : null;

		if (record == null)
		{
			record = new WmfUnknownRecord();
			record.setRecordType(rt); //Only set for UnknownRecord otherwise it is already defined by attribute above the class
		}

		record.setRecordSize(length);
		record.Read(reader);

		long end = reader.BaseStream.Position;
		long rlen = end - begin; //Read length
		long excess = 2 * length - rlen;
		if (excess > 0)
		{
			//Oops, reader did not read whole record?!
			Oxage.Wmf.BinaryReaderExtensions.Skip(reader, (int)excess);
		}

		return record;
	}

	public final void close() throws IOException
	{
		if (this.reader != null)
		{
			this.reader.Close();
			this.reader = null;
		}
	}
}