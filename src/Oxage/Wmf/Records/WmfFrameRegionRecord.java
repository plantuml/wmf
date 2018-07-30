package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_FRAMEREGION, Size = 7)] public class WmfFrameRegionRecord : WmfBinaryRecord
public class WmfFrameRegionRecord extends WmfBinaryRecord
{
	public WmfFrameRegionRecord()
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

	private short Height;
	public final short getHeight()
	{
		return Height;
	}
	public final void setHeight(short value)
	{
		Height = value;
	}

	private short Width;
	public final short getWidth()
	{
		return Width;
	}
	public final void setWidth(short value)
	{
		Width = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setRegion(reader.ReadUInt16());
		this.setBrush(reader.ReadUInt16());
		this.setHeight(reader.ReadInt16());
		this.setWidth(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRegion());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBrush());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getHeight());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getWidth());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("Region: " + this.getRegion() + "\r\n");
		builder.append("Brush: " + this.getBrush() + "\r\n");
		builder.append("Height: " + this.getHeight() + "\r\n");
		builder.append("Width: " + this.getWidth() + "\r\n");
	}
}