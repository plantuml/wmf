package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_ARC, Size = 11)] public class WmfArcRecord : WmfBinaryRecord
public class WmfArcRecord extends WmfBinaryRecord
{
	public WmfArcRecord()
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

	private short YEndArc;
	public final short getYEndArc()
	{
		return YEndArc;
	}
	public final void setYEndArc(short value)
	{
		YEndArc = value;
	}

	private short XEndArc;
	public final short getXEndArc()
	{
		return XEndArc;
	}
	public final void setXEndArc(short value)
	{
		XEndArc = value;
	}

	private short YStartArc;
	public final short getYStartArc()
	{
		return YStartArc;
	}
	public final void setYStartArc(short value)
	{
		YStartArc = value;
	}

	private short XStartArc;
	public final short getXStartArc()
	{
		return XStartArc;
	}
	public final void setXStartArc(short value)
	{
		XStartArc = value;
	}

	public final void SetArc(Rectangle rectangle, Point start, Point end)
	{
		this.setYEndArc((short)(end.Y));
		this.setXEndArc((short)(end.X));
		this.setYStartArc((short)(start.Y));
		this.setXStartArc((short)(start.X));

		this.setBottomRect((short)rectangle.Bottom);
		this.setRightRect((short)rectangle.Right);
		this.setTopRect((short)rectangle.Top);
		this.setLeftRect((short)rectangle.Left);
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setYEndArc(reader.ReadInt16());
		this.setXEndArc(reader.ReadInt16());
		this.setYStartArc(reader.ReadInt16());
		this.setXStartArc(reader.ReadInt16());

		this.setBottomRect(reader.ReadInt16());
		this.setRightRect(reader.ReadInt16());
		this.setTopRect(reader.ReadInt16());
		this.setLeftRect(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYEndArc());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXEndArc());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYStartArc());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXStartArc());

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBottomRect());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRightRect());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getTopRect());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getLeftRect());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("YEndArc: " + this.getYEndArc() + "\r\n");
		builder.append("XEndArc: " + this.getXEndArc() + "\r\n");
		builder.append("YStartArc: " + this.getYStartArc() + "\r\n");
		builder.append("XStartArc: " + this.getXStartArc() + "\r\n");
		builder.append("BottomRect: " + this.getBottomRect() + "\r\n");
		builder.append("RightRect: " + this.getRightRect() + "\r\n");
		builder.append("TopRect: " + this.getTopRect() + "\r\n");
		builder.append("LeftRect: " + this.getLeftRect() + "\r\n");
	}
}