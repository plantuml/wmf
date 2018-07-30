package Oxage.Wmf.Records;

import Oxage.Wmf.Objects.*;
import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_CREATEREGION, SizeIsVariable = true)] public class WmfCreateRegionRecord : WmfBinaryRecord
public class WmfCreateRegionRecord extends WmfBinaryRecord
{
	public WmfCreateRegionRecord()
	{
		super();
	}

	private Region Region;
	public final Region getRegion()
	{
		return Region;
	}
	public final void setRegion(Region value)
	{
		Region = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setRegion(new Region());
		this.getRegion().Read(reader);
	}

	@Override
	public void Write(BinaryWriter writer)
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: base.RecordSizeBytes = (uint)(6 + this.Region.GetSize());
		super.setRecordSizeBytes((int)(6 + this.getRegion().GetSize()));
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRegion());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("Region: " + "\r\n");
		this.getRegion().Dump(builder);
	}
}