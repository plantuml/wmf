package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SETTEXTJUSTIFICATION, Size = 5)] public class WmfSetTextJustificationRecord : WmfBinaryRecord
public class WmfSetTextJustificationRecord extends WmfBinaryRecord
{
	public WmfSetTextJustificationRecord()
	{
		super();
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort BreakCount;
	private short BreakCount;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getBreakCount()
	public final short getBreakCount()
	{
		return BreakCount;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setBreakCount(ushort value)
	public final void setBreakCount(short value)
	{
		BreakCount = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort BreakExtra;
	private short BreakExtra;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getBreakExtra()
	public final short getBreakExtra()
	{
		return BreakExtra;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setBreakExtra(ushort value)
	public final void setBreakExtra(short value)
	{
		BreakExtra = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setBreakCount(reader.ReadUInt16());
		this.setBreakExtra(reader.ReadUInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBreakCount());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBreakExtra());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("BreakCount: " + this.getBreakCount() + "\r\n");
		builder.append("BreakExtra: " + this.getBreakExtra() + "\r\n");
	}
}