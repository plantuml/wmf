package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SETPIXEL, Size = 7)] public class WmfSetPixelRecord : WmfBinaryRecord
public class WmfSetPixelRecord extends WmfBinaryRecord
{
	public WmfSetPixelRecord()
	{
		super();
	}

	private Color Color = new Color();
	public final Color getColor()
	{
		return Color;
	}
	public final void setColor(Color value)
	{
		Color = value;
	}

	private short Y;
	public final short getY()
	{
		return Y;
	}
	public final void setY(short value)
	{
		Y = value;
	}

	private short X;
	public final short getX()
	{
		return X;
	}
	public final void setX(short value)
	{
		X = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		//ColorRef
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] buffer = reader.ReadBytes(4);
		byte[] buffer = reader.ReadBytes(4);
		this.setColor(getColor().FromArgb(buffer[0], buffer[1], buffer[2]));

		this.setY(reader.ReadInt16());
		this.setX(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);

		//ColorRef
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)this.Color.R);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)this.getColor().R);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)this.Color.G);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)this.getColor().G);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)this.Color.B);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)this.getColor().B);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)0x00);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)0x00);

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getY());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getX());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("ColorRef: " + this.getColor() + "\r\n");
		builder.append("Y: " + this.getY() + "\r\n");
		builder.append("X: " + this.getX() + "\r\n");
	}
}