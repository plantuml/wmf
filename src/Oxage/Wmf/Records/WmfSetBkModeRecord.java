package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SETBKMODE, Size = 4)] public class WmfSetBkModeRecord : WmfBinaryRecord
public class WmfSetBkModeRecord extends WmfBinaryRecord
{
	public WmfSetBkModeRecord()
	{
		super();
	}

	private MixMode Mode = MixMode.values()[0];
	public final MixMode getMode()
	{
		return Mode;
	}
	public final void setMode(MixMode value)
	{
		Mode = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setMode(MixMode.forValue(reader.ReadUInt16()));
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
//ORIGINAL LINE: builder.AppendFormat("MixMode: 0x{0:x4} (MixMode.{1})", (ushort)this.Mode, this.Mode.ToString()).AppendLine();
		builder.append(String.format("MixMode: 0x%04x (MixMode.%2$s)", (short)this.getMode().getValue(), this.getMode().toString())).append("\r\n");
	}
}