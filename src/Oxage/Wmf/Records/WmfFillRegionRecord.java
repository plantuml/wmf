package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_FILLREGION, Size = 5)] public class WmfFillRegionRecord : WmfBinaryRecord
public class WmfFillRegionRecord extends WmfBinaryRecord
{
	public WmfFillRegionRecord()
	{
		super();
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Region;
	private short Region;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getRegion()
	public final short getRegion()
	{
		return Region;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setRegion(ushort value)
	public final void setRegion(short value)
	{
		Region = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Brush;
	private short Brush;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getBrush()
	public final short getBrush()
	{
		return Brush;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setBrush(ushort value)
	public final void setBrush(short value)
	{
		Brush = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setRegion(reader.ReadUInt16());
		this.setBrush(reader.ReadUInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRegion());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBrush());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("Region: " + this.getRegion() + "\r\n");
		builder.append("Brush: " + this.getBrush() + "\r\n");
	}
}