package Oxage.Wmf.Records;

import Oxage.Wmf.*;

public class WmfFormat implements IBinaryRecord
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Public properties
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Handle;
	private short Handle;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getHandle()
	public final short getHandle()
	{
		return Handle;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setHandle(ushort value)
	public final void setHandle(short value)
	{
		Handle = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Left;
	private short Left;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getLeft()
	public final short getLeft()
	{
		return Left;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setLeft(ushort value)
	public final void setLeft(short value)
	{
		Left = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Top;
	private short Top;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getTop()
	public final short getTop()
	{
		return Top;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setTop(ushort value)
	public final void setTop(short value)
	{
		Top = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Right;
	private short Right;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getRight()
	public final short getRight()
	{
		return Right;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setRight(ushort value)
	public final void setRight(short value)
	{
		Right = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Bottom;
	private short Bottom;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getBottom()
	public final short getBottom()
	{
		return Bottom;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setBottom(ushort value)
	public final void setBottom(short value)
	{
		Bottom = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Unit;
	private short Unit;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getUnit()
	public final short getUnit()
	{
		return Unit;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setUnit(ushort value)
	public final void setUnit(short value)
	{
		Unit = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Checksum;
	private short Checksum;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getChecksum()
	public final short getChecksum()
	{
		return Checksum;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setChecksum(ushort value)
	public final void setChecksum(short value)
	{
		Checksum = value;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Public methods
	public final WmfFormat Clone()
	{
		WmfFormat tempVar = new WmfFormat();
		tempVar.setHandle(this.getHandle());
		tempVar.setLeft(this.getLeft());
		tempVar.setTop(this.getTop());
		tempVar.setRight(this.getRight());
		tempVar.setBottom(this.getBottom());
		tempVar.setUnit(this.getUnit());
		tempVar.setChecksum(this.getChecksum());
		return tempVar;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort CalculateChecksum()
	public final short CalculateChecksum()
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: ushort sum = 0;
		short sum = 0;
		try (MemoryStream stream = new MemoryStream())
		{
			try (BinaryWriter writer = new BinaryWriter(stream))
			{
				//Get record without checksum
				Object clone = Clone();
				clone.Checksum = 0;
				clone.Write(writer);

				//Convert record to byte array
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] data = stream.ToArray();
				byte[] data = stream.ToArray();

				//Use BinaryReader to read word by word (word = ushort = 16 bit)
				try (BinaryReader reader = new BinaryReader(new MemoryStream(data)))
				{
					//Calculate checksum from the first 10 words
					for (int i = 0; i < 10; i++)
					{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: ushort word = reader.ReadUInt16();
						short word = reader.ReadUInt16();
						sum ^= word;
					}
				}
			}
		}
		return sum;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Public methods
	@Override
	public String toString()
	{
		return Dump();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region IBinaryRecord Members
	public final void Read(BinaryReader reader)
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] key = reader.ReadBytes(4);
		byte[] key = reader.ReadBytes(4);
		if (key[0] != 0xD7 || key[1] != 0xCD || key[2] != 0xC6 || key[3] != 0x9A)
		{
			throw new WmfException("WMF key does not match the pattern!");
		}

		this.setHandle(reader.ReadUInt16());
		this.setLeft(reader.ReadUInt16());
		this.setTop(reader.ReadUInt16());
		this.setRight(reader.ReadUInt16());
		this.setBottom(reader.ReadUInt16());
		this.setUnit(reader.ReadUInt16());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: uint reserved = reader.ReadUInt32();
		int reserved = reader.ReadUInt32();
		this.setChecksum(reader.ReadUInt16());
	}

	public final void Write(BinaryWriter writer)
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write(new byte[] { 0xD7, 0xCD, 0xC6, 0x9A });
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, new byte[] {(byte)0xD7, (byte)0xCD, (byte)0xC6, (byte)0x9A}); //Key
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getHandle());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getLeft());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getTop());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRight());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBottom());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getUnit());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((uint)0);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (int)0); //Reserved
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getChecksum());
	}

	public final String Dump()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("== WmfFormat ==" + "\r\n");
		builder.append("Handle: " + this.getHandle() + "\r\n");
		builder.append("Left: " + this.getLeft() + "\r\n");
		builder.append("Top: " + this.getTop() + "\r\n");
		builder.append("Right: " + this.getRight() + "\r\n");
		builder.append("Bottom: " + this.getBottom() + "\r\n");
		builder.append("Unit: " + this.getUnit() + "\r\n");
		builder.append("Checksum: " + this.getChecksum() + "\r\n");
		return builder.toString();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}