package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SETWINDOWORG, Size = 5)] public class WmfSetWindowOrgRecord : WmfBinaryRecord
public class WmfSetWindowOrgRecord extends WmfBinaryRecord
{
	public WmfSetWindowOrgRecord()
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
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getX());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getY());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("X: " + this.getX() + "\r\n");
		builder.append("Y: " + this.getY() + "\r\n");
	}
}