package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_PATBLT, Size = 9)] public class WmfPatBltRecord : WmfBinaryRecord
public class WmfPatBltRecord extends WmfBinaryRecord
{
	public WmfPatBltRecord()
	{
		super();
	}

	private TernaryRasterOperation RasterOperation = TernaryRasterOperation.values()[0];
	public final TernaryRasterOperation getRasterOperation()
	{
		return RasterOperation;
	}
	public final void setRasterOperation(TernaryRasterOperation value)
	{
		RasterOperation = value;
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

	private short YLeft;
	public final short getYLeft()
	{
		return YLeft;
	}
	public final void setYLeft(short value)
	{
		YLeft = value;
	}

	private short XLeft;
	public final short getXLeft()
	{
		return XLeft;
	}
	public final void setXLeft(short value)
	{
		XLeft = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setRasterOperation(TernaryRasterOperation.forValue(reader.ReadUInt32()));
		this.setHeight(reader.ReadInt16());
		this.setWidth(reader.ReadInt16());
		this.setYLeft(reader.ReadInt16());
		this.setXLeft(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((uint)this.RasterOperation);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (int)this.getRasterOperation().getValue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getHeight());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getWidth());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYLeft());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXLeft());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("RasterOperation: " + this.getRasterOperation() + "\r\n");
		builder.append("Height: " + this.getHeight() + "\r\n");
		builder.append("Width: " + this.getWidth() + "\r\n");
		builder.append("YLeft: " + this.getYLeft() + "\r\n");
		builder.append("XLeft: " + this.getXLeft() + "\r\n");
	}
}