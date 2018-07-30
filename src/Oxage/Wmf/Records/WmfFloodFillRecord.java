package Oxage.Wmf.Records;

import Oxage.Wmf.Objects.*;
import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_FLOODFILL, Size = 7)] public class WmfFloodFillRecord : WmfBinaryRecord
public class WmfFloodFillRecord extends WmfBinaryRecord
{
	public WmfFloodFillRecord()
	{
		super();
		this.setColorRef(new ColorRef());
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

	private short YStart;
	public final short getYStart()
	{
		return YStart;
	}
	public final void setYStart(short value)
	{
		YStart = value;
	}

	private short XStart;
	public final short getXStart()
	{
		return XStart;
	}
	public final void setXStart(short value)
	{
		XStart = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setColorRef(Oxage.Wmf.BinaryReaderExtensions.<ColorRef>ReadWmfObject(reader));
		this.setYStart(reader.ReadInt16());
		this.setXStart(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getColorRef());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYStart());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXStart());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("ColorRef: " + this.getColorRef().Dump() + "\r\n");
		builder.append("YStart: " + this.getYStart() + "\r\n");
		builder.append("XStart: " + this.getXStart() + "\r\n");
	}
}