package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 10)] public class Pen : WmfBinaryObject
public class Pen extends WmfBinaryObject
{
	public Pen()
	{
		super();
	}

	private PenStyle PenStyle = getPenStyle().values()[0];
	public final PenStyle getPenStyle()
	{
		return PenStyle;
	}
	public final void setPenStyle(PenStyle value)
	{
		PenStyle = value;
	}

	private PointS Width;
	public final PointS getWidth()
	{
		return Width;
	}
	public final void setWidth(PointS value)
	{
		Width = value;
	}

	private ColorRef ColorRef;
	public final ColorRef getColorRef()
	{
		return ColorRef;
	}
	public final void setColorRef(ColorRef value)
	{
		ColorRef = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setPenStyle(PenStyle.forValue(reader.ReadUInt16()));
		this.setWidth(Oxage.Wmf.BinaryReaderExtensions.<PointS>ReadWmfObject(reader));
		this.setColorRef(Oxage.Wmf.BinaryReaderExtensions.<ColorRef>ReadWmfObject(reader));
	}

	@Override
	public void Write(BinaryWriter writer)
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.PenStyle);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getPenStyle().getValue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getWidth());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getColorRef());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tPenStyle: " + this.getPenStyle() + "\r\n");

		builder.append("\tWidth: " + "\r\n");
		this.getWidth().Dump(builder);

		builder.append("\tColorRef: " + "\r\n");
		this.getColorRef().Dump(builder);
	}
}