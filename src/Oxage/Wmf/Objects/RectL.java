package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 16)] public class RectL : WmfBinaryObject
public class RectL extends WmfBinaryObject
{
	public RectL()
	{
		super();
	}

	private int Left;
	public final int getLeft()
	{
		return Left;
	}
	public final void setLeft(int value)
	{
		Left = value;
	}

	private int Top;
	public final int getTop()
	{
		return Top;
	}
	public final void setTop(int value)
	{
		Top = value;
	}

	private int Right;
	public final int getRight()
	{
		return Right;
	}
	public final void setRight(int value)
	{
		Right = value;
	}

	private int Bottom;
	public final int getBottom()
	{
		return Bottom;
	}
	public final void setBottom(int value)
	{
		Bottom = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setLeft(reader.ReadInt32());
		this.setTop(reader.ReadInt32());
		this.setRight(reader.ReadInt32());
		this.setBottom(reader.ReadInt32());
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