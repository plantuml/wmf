package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_CREATEBRUSHINDIRECT, Size = 7)] public class WmfCreateBrushIndirectRecord : WmfBinaryRecord
public class WmfCreateBrushIndirectRecord extends WmfBinaryRecord
{
	public WmfCreateBrushIndirectRecord()
	{
		super();
		this.setColor(getColor().Black);
		this.setStyle(BrushStyle.BS_SOLID);
		this.setHatch(HatchStyle.HS_HORIZONTAL);
	}

	private BrushStyle Style = BrushStyle.values()[0];
	public final BrushStyle getStyle()
	{
		return Style;
	}
	public final void setStyle(BrushStyle value)
	{
		Style = value;
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

	private HatchStyle Hatch = HatchStyle.values()[0];
	public final HatchStyle getHatch()
	{
		return Hatch;
	}
	public final void setHatch(HatchStyle value)
	{
		Hatch = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setStyle(BrushStyle.forValue(reader.ReadUInt16()));

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] buffer = reader.ReadBytes(4);
		byte[] buffer = reader.ReadBytes(4);
		this.setColor(getColor().FromArgb(buffer[0], buffer[1], buffer[2]));

		this.setHatch(HatchStyle.forValue(reader.ReadUInt16()));
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.Style);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getStyle().getValue());
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
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.Hatch);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getHatch().getValue());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("BrushStyle: " + this.getStyle() + "\r\n");
		builder.append("ColorRef: " + this.getColor() + "\r\n");
		builder.append("BrushHatch: " + this.getHatch() + "\r\n");
	}
}