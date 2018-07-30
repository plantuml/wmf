package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_RECTANGLE, Size = 7)] public class WmfRectangleRecord : WmfBinaryRecord
public class WmfRectangleRecord extends WmfBinaryRecord
{
	public WmfRectangleRecord()
	{
		super();
	}

	private short BottomRect;
	public final short getBottomRect()
	{
		return BottomRect;
	}
	public final void setBottomRect(short value)
	{
		BottomRect = value;
	}

	private short RightRect;
	public final short getRightRect()
	{
		return RightRect;
	}
	public final void setRightRect(short value)
	{
		RightRect = value;
	}

	private short TopRect;
	public final short getTopRect()
	{
		return TopRect;
	}
	public final void setTopRect(short value)
	{
		TopRect = value;
	}

	private short LeftRect;
	public final short getLeftRect()
	{
		return LeftRect;
	}
	public final void setLeftRect(short value)
	{
		LeftRect = value;
	}

	public final void SetRectangle(Rectangle rect)
	{
		this.setTopRect((short)rect.Top);
		this.setLeftRect((short)rect.Left);
		this.setBottomRect((short)rect.Bottom);
		this.setRightRect((short)rect.Right);
	}

	public final Rectangle GetRectangle()
	{
		return new Rectangle(this.getLeftRect(), this.getTopRect(), this.getRightRect() - this.getLeftRect(), this.getBottomRect() - this.getTopRect());
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setBottomRect(reader.ReadInt16());
		this.setRightRect(reader.ReadInt16());
		this.setTopRect(reader.ReadInt16());
		this.setLeftRect(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBottomRect());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRightRect());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getTopRect());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getLeftRect());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("BottomRect: " + this.getBottomRect() + "\r\n");
		builder.append("RightRect: " + this.getRightRect() + "\r\n");
		builder.append("TopRect: " + this.getTopRect() + "\r\n");
		builder.append("LeftRect: " + this.getLeftRect() + "\r\n");
	}
}