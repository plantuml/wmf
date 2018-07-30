package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_CREATEPENINDIRECT, Size = 8)] public class WmfCreatePenIndirectRecord : WmfBinaryRecord
public class WmfCreatePenIndirectRecord extends WmfBinaryRecord
{
	public WmfCreatePenIndirectRecord()
	{
		super();
		this.setColor(getColor().Black);
		this.setStyle(PenStyle.PS_SOLID);
		this.setWidth(new Point(4, 4));
	}

	private PenStyle Style = PenStyle.values()[0];
	public final PenStyle getStyle()
	{
		return Style;
	}
	public final void setStyle(PenStyle value)
	{
		Style = value;
	}

	private Point Width = new Point();
	public final Point getWidth()
	{
		return Width;
	}
	public final void setWidth(Point value)
	{
		Width = value;
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

	@Override
	public void Read(BinaryReader reader)
	{
		this.setStyle(PenStyle.forValue(reader.ReadUInt16()));

		short x = reader.ReadInt16();
		short y = reader.ReadInt16();
		this.setWidth(new Point(x, y));

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] buffer = reader.ReadBytes(4);
		byte[] buffer = reader.ReadBytes(4);
		this.setColor(getColor().FromArgb(buffer[0], buffer[1], buffer[2]));
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.Style);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getStyle().getValue());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.Width.X);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getWidth().X); //PointS.X is used as width
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.Width.Y);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getWidth().Y); //PointS.Y is ignored according to the documentation
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
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("PenStyle: " + this.getStyle() + "\r\n");
		builder.append("Width: " + this.getWidth() + "\r\n");
		builder.append("ColorRef: " + this.getColor() + "\r\n");
	}
}