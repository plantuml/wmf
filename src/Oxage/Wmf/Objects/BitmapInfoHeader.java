package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 40)] public class BitmapInfoHeader : WmfBinaryObject, IDIBHeaderInfo
public class BitmapInfoHeader extends WmfBinaryObject implements IDIBHeaderInfo
{
	public BitmapInfoHeader()
	{
		super();
		this.setHeaderSize(40);
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

	private int Width;
	public final int getWidth()
	{
		return Width;
	}
	public final void setWidth(int value)
	{
		Width = value;
	}

	private int Height;
	public final int getHeight()
	{
		return Height;
	}
	public final void setHeight(int value)
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

	private Compression Compression = getCompression().values()[0];
	public final Compression getCompression()
	{
		return Compression;
	}
	public final void setCompression(Compression value)
	{
		Compression = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint ImageSize;
	private int ImageSize;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getImageSize()
	public final int getImageSize()
	{
		return ImageSize;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setImageSize(uint value)
	public final void setImageSize(int value)
	{
		ImageSize = value;
	}

	private int XPelsPerMeter;
	public final int getXPelsPerMeter()
	{
		return XPelsPerMeter;
	}
	public final void setXPelsPerMeter(int value)
	{
		XPelsPerMeter = value;
	}

	private int YPelsPerMeter;
	public final int getYPelsPerMeter()
	{
		return YPelsPerMeter;
	}
	public final void setYPelsPerMeter(int value)
	{
		YPelsPerMeter = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint ColorUsed;
	private int ColorUsed;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getColorUsed()
	public final int getColorUsed()
	{
		return ColorUsed;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setColorUsed(uint value)
	public final void setColorUsed(int value)
	{
		ColorUsed = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint ColorImportant;
	private int ColorImportant;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getColorImportant()
	public final int getColorImportant()
	{
		return ColorImportant;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setColorImportant(uint value)
	public final void setColorImportant(int value)
	{
		ColorImportant = value;
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

		this.setWidth(reader.ReadInt32());
		this.setHeight(reader.ReadInt32());

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: ushort planes = reader.ReadUInt16();
		short planes = reader.ReadUInt16();
		if (planes != this.getPlanes())
		{
			throw new WmfException("Planes field in BitmapInfoHeader Object must be 0x0001!");
		}

		this.setBitCount(BitCount.forValue(reader.ReadUInt16()));
		this.setCompression(Compression.forValue(reader.ReadUInt32()));
		this.setImageSize(reader.ReadUInt32());
		this.setXPelsPerMeter(reader.ReadInt32());
		this.setYPelsPerMeter(reader.ReadInt32());
		this.setColorUsed(reader.ReadUInt32());
		this.setColorImportant(reader.ReadUInt32());
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
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((uint)this.Compression);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (int)this.getCompression().getValue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getImageSize());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXPelsPerMeter());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYPelsPerMeter());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getColorUsed());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getColorImportant());
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
		builder.append("\tCompression: " + this.getCompression() + "\r\n");
		builder.append("\tImageSize: " + this.getImageSize() + "\r\n");
		builder.append("\tXPelsPerMeter: " + this.getXPelsPerMeter() + "\r\n");
		builder.append("\tYPelsPerMeter: " + this.getYPelsPerMeter() + "\r\n");
		builder.append("\tColorUsed: " + this.getColorUsed() + "\r\n");
		builder.append("\tColorImportant: " + this.getColorImportant() + "\r\n");
	}
}