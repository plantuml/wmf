package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SETTEXTALIGN)] public class WmfSetTextAlignRecord : WmfBinaryRecord
public class WmfSetTextAlignRecord extends WmfBinaryRecord //Fixed size by spec. but some WMF files have variable size
{
	public WmfSetTextAlignRecord()
	{
		super();
	}

	private TextAlignmentMode Mode = TextAlignmentMode.values()[0];
	public final TextAlignmentMode getMode()
	{
		return Mode;
	}
	public final void setMode(TextAlignmentMode value)
	{
		Mode = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setMode(TextAlignmentMode.forValue(reader.ReadUInt16()));

		//Work-around for some WMF files
		if (super.getRecordSizeBytes() > 8)
		{
			//Skip unknown bytes
			reader.BaseStream.Seek(super.getRecordSizeBytes() - 8, SeekOrigin.Current);
		}
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.setRecordSize(4);
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
//ORIGINAL LINE: builder.AppendFormat("TextAlignmentMode: 0x{0:x4} (TextAlignmentMode.{1})", (ushort)this.Mode, this.Mode.ToString()).AppendLine();
		builder.append(String.format("TextAlignmentMode: 0x%04x (TextAlignmentMode.%2$s)", (short)this.getMode().getValue(), this.getMode().toString())).append("\r\n");
	}
}