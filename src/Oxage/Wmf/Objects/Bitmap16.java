package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(SizeIsVariable = true)] public class Bitmap16 : WmfBinaryObject
public class Bitmap16 extends WmfBinaryObject
{
	public Bitmap16()
	{
		super();
	}

	private short Type;
	public final short getType()
	{
		return Type;
	}
	public final void setType(short value)
	{
		Type = value;
	}

	private short Width;
	public final short getWidth()
	{
		return Width;
	}
	public final void setWidth(short value)
	{
		Width = value;
	}

	private short Height;
	public final short getHeight()
	{
		return Height;
	}
	public final void setHeight(short value)
	{
		Height = value;
	}

	private short WidthBytes;
	public final short getWidthBytes()
	{
		return WidthBytes;
	}
	public final void setWidthBytes(short value)
	{
		WidthBytes = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte getPlanes()
	public final byte getPlanes()
	{
		return 0x01; //Must be 0x01 according to the documentation
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private byte BitsPixel;
	private byte BitsPixel;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte getBitsPixel()
	public final byte getBitsPixel()
	{
		return BitsPixel;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setBitsPixel(byte value)
	public final void setBitsPixel(byte value)
	{
		BitsPixel = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private byte[] Bits;
	private byte[] Bits;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte[] getBits()
	public final byte[] getBits()
	{
		return Bits;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setBits(byte[] value)
	public final void setBits(byte[] value)
	{
		Bits = value;
	}

	@Override
	public int GetSize()
	{
		return 10 + (this.getBits() != null ? this.getBits().length : 0);
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setType(reader.ReadInt16());
		this.setWidth(reader.ReadInt16());
		this.setHeight(reader.ReadInt16());
		this.setWidthBytes(reader.ReadInt16());

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte planes = reader.ReadByte();
		byte planes = reader.ReadByte();
		if (planes != this.getPlanes())
		{
			throw new WmfException("Planes field in Bitmap16 Object must be 0x01!");
		}

		this.setBitsPixel(reader.ReadByte());

//C# TO JAVA CONVERTER WARNING: The right shift operator was not replaced by Java's logical right shift operator since the left operand was not confirmed to be of an unsigned type, but you should review whether the logical right shift operator (>>>) is more appropriate:
		int length = (((this.getWidth() * this.getBitsPixel() + 15) >> 4) << 1) * this.getHeight(); //Calculation according to the documentation
		this.setBits(reader.ReadBytes(length));
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getType());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getWidth());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getHeight());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getWidthBytes());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getPlanes());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBitsPixel());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBits());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tType: " + this.getType() + "\r\n");
		builder.append("\tWidth: " + this.getWidth() + "\r\n");
		builder.append("\tHeight: " + this.getHeight() + "\r\n");
		builder.append("\tWidthBytes: " + this.getWidthBytes() + "\r\n");
		builder.append("\tPlanes: " + this.getPlanes() + "\r\n");
		builder.append("\tBitsPixel: " + this.getBitsPixel() + "\r\n");
		builder.append("\tBits: " + WmfHelper.DumpByteArray(this.getBits()) + "\r\n");
	}
}