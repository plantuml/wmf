package Oxage.Wmf.Records;

import Oxage.Wmf.Objects.*;
import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_EXTFLOODFILL, Size = 8)] public class WmfExtFloodFillRecord : WmfBinaryRecord
public class WmfExtFloodFillRecord extends WmfBinaryRecord
{
	public WmfExtFloodFillRecord()
	{
		super();
		this.setColorRef(new ColorRef());
	}

	private FloodFill Mode = FloodFill.values()[0];
	public final FloodFill getMode()
	{
		return Mode;
	}
	public final void setMode(FloodFill value)
	{
		Mode = value;
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

	private short Y;
	public final short getY()
	{
		return Y;
	}
	public final void setY(short value)
	{
		Y = value;
	}

	private short X;
	public final short getX()
	{
		return X;
	}
	public final void setX(short value)
	{
		X = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setMode(FloodFill.forValue(reader.ReadUInt16()));
		this.setColorRef(Oxage.Wmf.BinaryReaderExtensions.<ColorRef>ReadWmfObject(reader));
		this.setY(reader.ReadInt16());
		this.setX(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.Mode);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getMode().getValue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getColorRef());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getY());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getX());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("Mode: " + this.getMode() + "\r\n");
		builder.append("ColorRef: " + this.getColorRef().Dump() + "\r\n");
		builder.append("Y: " + this.getY() + "\r\n");
		builder.append("X: " + this.getX() + "\r\n");
	}
}