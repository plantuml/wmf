package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SETWINDOWEXT, Size = 5)] public class WmfSetWindowExtRecord : WmfBinaryRecord
public class WmfSetWindowExtRecord extends WmfBinaryRecord
{
	public WmfSetWindowExtRecord()
	{
		super();
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
		this.setY(reader.ReadInt16());
		this.setX(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getY()); //Note that Y is before X
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getX());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("Y: " + this.getY() + "\r\n");
		builder.append("X: " + this.getX() + "\r\n");
	}
}