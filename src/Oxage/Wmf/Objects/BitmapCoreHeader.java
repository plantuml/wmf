package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 12)] public class BitmapCoreHeader : WmfBinaryObject, IDIBHeaderInfo
public class BitmapCoreHeader extends WmfBinaryObject implements IDIBHeaderInfo
{
	public BitmapCoreHeader()
	{
		super();
		this.setHeaderSize(12);
	}

	/** 
	 Gets or sets the size of this object in bytes.
	*/
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint HeaderSize;
	private int HeaderSize;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getHeaderSize()
	public final int getHeaderSize()
	{
		return HeaderSize;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setHeaderSize(uint value)
	public final void setHeaderSize(int value)
	{
		HeaderSize = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Width;
	private short Width;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getWidth()
	public final short getWidth()
	{
		return Width;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setWidth(ushort value)
	public final void setWidth(short value)
	{
		Width = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Height;
	private short Height;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getHeight()
	public final short getHeight()
	{
		return Height;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setHeight(ushort value)
	public final void setHeight(short value)
	{
		Height = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getPlanes()
	public final short getPlanes()
	{
		return 0x0001; //Must be 0x0001 according to the documentation;
	}

	private BitCount BitCount = getBitCount().values()[0];
	public final BitCount getBitCount()
	{
		return BitCount;
	}
	public final void setBitCount(BitCount value)
	{
		BitCount = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		Read(reader, true);
	}

	public final void Read(BinaryReader reader, boolean readHeaderSize)
	{
		if (readHeaderSize)
		{
			this.setHeaderSize(reader.ReadUInt32());
			//NOTE: Documentation does not clearly defined whether the object size is fixed (12 bytes) or variable
			//if (this.HeaderSize != 12)
			//{
			//  throw new WmfException("HeaderSize field in BitmapCoreHeader Object must be 12!");
			//}
		}

		this.setWidth(reader.ReadUInt16());
		this.setHeight(reader.ReadUInt16());

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: ushort planes = reader.ReadUInt16();
		short planes = reader.ReadUInt16();
		if (planes != this.getPlanes())
		{
			throw new WmfException("Planes field in BitmapCoreHeader Object must be 0x0001!");
		}

		this.setBitCount(BitCount.forValue(reader.ReadUInt16()));
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getHeaderSize());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getWidth());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getHeight());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getPlanes());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.BitCount);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getBitCount().getValue());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tHeaderSize: " + this.getHeaderSize() + "\r\n");
		builder.append("\tWidth: " + this.getWidth() + "\r\n");
		builder.append("\tHeight: " + this.getHeight() + "\r\n");
		builder.append("\tPlanes: " + this.getPlanes() + "\r\n");
		builder.append("\tBitCount: " + this.getBitCount() + "\r\n");
	}
}