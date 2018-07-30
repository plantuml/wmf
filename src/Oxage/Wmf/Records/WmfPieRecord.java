package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_PIE, Size = 11)] public class WmfPieRecord : WmfBinaryRecord
public class WmfPieRecord extends WmfBinaryRecord
{
	public WmfPieRecord()
	{
		super();
	}

	private short YRadial2;
	public final short getYRadial2()
	{
		return YRadial2;
	}
	public final void setYRadial2(short value)
	{
		YRadial2 = value;
	}

	private short XRadial2;
	public final short getXRadial2()
	{
		return XRadial2;
	}
	public final void setXRadial2(short value)
	{
		XRadial2 = value;
	}

	private short YRadial1;
	public final short getYRadial1()
	{
		return YRadial1;
	}
	public final void setYRadial1(short value)
	{
		YRadial1 = value;
	}

	private short XRadial1;
	public final short getXRadial1()
	{
		return XRadial1;
	}
	public final void setXRadial1(short value)
	{
		XRadial1 = value;
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

	public final void SetPie(Rectangle rectangle, Point firstRadial, Point secondRadial)
	{
		this.setYRadial2((short)(secondRadial.Y));
		this.setXRadial2((short)(secondRadial.X));
		this.setYRadial1((short)(firstRadial.Y));
		this.setXRadial1((short)(firstRadial.X));

		this.setBottomRect((short)rectangle.Bottom);
		this.setRightRect((short)rectangle.Right);
		this.setTopRect((short)rectangle.Top);
		this.setLeftRect((short)rectangle.Left);
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setYRadial2(reader.ReadInt16());
		this.setXRadial2(reader.ReadInt16());
		this.setYRadial1(reader.ReadInt16());
		this.setXRadial1(reader.ReadInt16());

		this.setBottomRect(reader.ReadInt16());
		this.setRightRect(reader.ReadInt16());
		this.setTopRect(reader.ReadInt16());
		this.setLeftRect(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYRadial2());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXRadial2());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYRadial1());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXRadial1());

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBottomRect());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRightRect());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getTopRect());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getLeftRect());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("YRadial2: " + this.getYRadial2() + "\r\n");
		builder.append("XRadial2: " + this.getXRadial2() + "\r\n");
		builder.append("YRadial1: " + this.getYRadial1() + "\r\n");
		builder.append("XRadial1: " + this.getXRadial1() + "\r\n");
		builder.append("BottomRect: " + this.getBottomRect() + "\r\n");
		builder.append("RightRect: " + this.getRightRect() + "\r\n");
		builder.append("TopRect: " + this.getTopRect() + "\r\n");
		builder.append("LeftRect: " + this.getLeftRect() + "\r\n");
	}
}