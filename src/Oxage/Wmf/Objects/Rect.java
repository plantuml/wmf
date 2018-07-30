package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 8)] public class Rect : WmfBinaryObject
public class Rect extends WmfBinaryObject
{
	public Rect()
	{
		super();
	}

	private short Left;
	public final short getLeft()
	{
		return Left;
	}
	public final void setLeft(short value)
	{
		Left = value;
	}

	private short Top;
	public final short getTop()
	{
		return Top;
	}
	public final void setTop(short value)
	{
		Top = value;
	}

	private short Right;
	public final short getRight()
	{
		return Right;
	}
	public final void setRight(short value)
	{
		Right = value;
	}

	private short Bottom;
	public final short getBottom()
	{
		return Bottom;
	}
	public final void setBottom(short value)
	{
		Bottom = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setLeft(reader.ReadInt16());
		this.setTop(reader.ReadInt16());
		this.setRight(reader.ReadInt16());
		this.setBottom(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getLeft());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getTop());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRight());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBottom());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tLeft: " + this.getLeft() + "\r\n");
		builder.append("\tTop: " + this.getTop() + "\r\n");
		builder.append("\tRight: " + this.getRight() + "\r\n");
		builder.append("\tBottom: " + this.getBottom() + "\r\n");
	}
}