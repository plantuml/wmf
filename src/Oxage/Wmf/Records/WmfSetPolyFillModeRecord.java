package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SETPOLYFILLMODE, Size = 4)] public class WmfSetPolyFillModeRecord : WmfBinaryRecord
public class WmfSetPolyFillModeRecord extends WmfBinaryRecord
{
	public WmfSetPolyFillModeRecord()
	{
		super();
	}

	private PolyFillMode Mode = PolyFillMode.values()[0];
	public final PolyFillMode getMode()
	{
		return Mode;
	}
	public final void setMode(PolyFillMode value)
	{
		Mode = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setMode(PolyFillMode.forValue(reader.ReadUInt16()));
		Oxage.Wmf.BinaryReaderExtensions.Skip(reader, (int)super.getRecordSizeBytes() - 8);
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.Mode);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getMode().getValue());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: builder.AppendFormat("PolyFillMode: 0x{0:x4} (PolyFillMode.{1})", (ushort)this.Mode, this.Mode.ToString()).AppendLine();
		builder.append(String.format("PolyFillMode: 0x%04x (PolyFillMode.%2$s)", (short)this.getMode().getValue(), this.getMode().toString())).append("\r\n");
	}
}