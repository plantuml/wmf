package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_LINETO, Size = 5)] public class WmfLineToRecord : WmfBinaryRecord
public class WmfLineToRecord extends WmfBinaryRecord
{
	public WmfLineToRecord()
	{
		super();
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

	private short Y;
	public final short getY()
	{
		return Y;
	}
	public final void setY(short value)
	{
		Y = value;
	}

	public final void SetDestination(Point point)
	{
		this.setX((short)point.X);
		this.setY((short)point.Y);
	}

	public final Point GetDestination()
	{
		return new Point(this.getX(), this.getY());
	}

	@Override
	public void Read(BinaryReader reader)
	{
		setY(reader.ReadInt16());
		setX(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, getY());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, getX());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("X: " + this.getX());
		builder.append("Y: " + this.getY());
	}
}