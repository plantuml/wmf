package Oxage.Wmf.Records;

import Oxage.Wmf.Objects.*;
import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_DIBCREATEPATTERNBRUSH, SizeIsVariable = true)] public class WmfDIBCreatePatternBrushRecord : WmfBinaryRecord
public class WmfDIBCreatePatternBrushRecord extends WmfBinaryRecord
{
	public WmfDIBCreatePatternBrushRecord()
	{
		super();
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

	private ColorUsage ColorUsage = getColorUsage().values()[0];
	public final ColorUsage getColorUsage()
	{
		return ColorUsage;
	}
	public final void setColorUsage(ColorUsage value)
	{
		ColorUsage = value;
	}

	private DeviceIndependentBitmap Target;
	public final DeviceIndependentBitmap getTarget()
	{
		return Target;
	}
	public final void setTarget(DeviceIndependentBitmap value)
	{
		Target = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setStyle(BrushStyle.forValue(reader.ReadUInt16()));
		this.setColorUsage(ColorUsage.forValue(reader.ReadUInt16()));
		this.setTarget(Oxage.Wmf.BinaryReaderExtensions.<DeviceIndependentBitmap>ReadWmfObject(reader)); //TODO: How many bytes?
	}

	@Override
	public void Write(BinaryWriter writer)
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: base.RecordSizeBytes = (uint)(10 + this.Target.GetSize());
		super.setRecordSizeBytes((int)(10 + this.getTarget().GetSize()));
		super.Write(writer);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.Style);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getStyle().getValue());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.ColorUsage);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getColorUsage().getValue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getTarget());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("Style: " + this.getStyle() + "\r\n");
		builder.append("ColorUsage: " + this.getColorUsage() + "\r\n");
		builder.append("Target: " + this.getTarget().Dump() + "\r\n");
	}
}