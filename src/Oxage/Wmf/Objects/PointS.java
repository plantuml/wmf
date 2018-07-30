package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 4)] public class PointS : WmfBinaryObject
public class PointS extends WmfBinaryObject
{
	public PointS()
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

	@Override
	public void Read(BinaryReader reader)
	{
		this.setX(reader.ReadInt16());
		this.setY(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getX());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getY());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tx: " + this.getX() + "\r\n");
		builder.append("\ty: " + this.getY() + "\r\n");
	}
}