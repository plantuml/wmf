package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 8)] public class PointL : WmfBinaryObject
public class PointL extends WmfBinaryObject
{
	public PointL()
	{
		super();
	}

	private int X;
	public final int getX()
	{
		return X;
	}
	public final void setX(int value)
	{
		X = value;
	}

	private int Y;
	public final int getY()
	{
		return Y;
	}
	public final void setY(int value)
	{
		Y = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setX(reader.ReadInt32());
		this.setY(reader.ReadInt32());
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