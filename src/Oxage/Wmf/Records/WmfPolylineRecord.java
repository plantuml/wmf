package Oxage.Wmf.Records;

import Oxage.Wmf.*;
import java.util.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_POLYLINE, SizeIsVariable = true)] public class WmfPolylineRecord : WmfBinaryRecord
public class WmfPolylineRecord extends WmfBinaryRecord
{
	public WmfPolylineRecord()
	{
		super();
		this.setPoints(new ArrayList<Point>());
	}

	private short NumberOfPoints;
	public final short getNumberOfPoints()
	{
		return NumberOfPoints;
	}
	public final void setNumberOfPoints(short value)
	{
		NumberOfPoints = value;
	}

	private ArrayList<Point> Points;
	public final ArrayList<Point> getPoints()
	{
		return Points;
	}
	public final void setPoints(ArrayList<Point> value)
	{
		Points = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setPoints(new ArrayList<Point>());
		this.setNumberOfPoints(reader.ReadInt16());
		for (int i = 0; i < this.getNumberOfPoints(); i++)
		{
			short x = reader.ReadInt16();
			short y = reader.ReadInt16();
			this.getPoints().add(new Point(x, y));
		}
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		if (this.getPoints().size() != this.getNumberOfPoints())
		{
			throw new WmfException(this.getRecordType().toString() + ".NumberOfPoints does not match with actual number of points!");
		}

		//Record size is variable
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: base.RecordSizeBytes = (uint)(4 + 2 + 2 + 4 * this.NumberOfPoints);
		super.setRecordSizeBytes((int)(4 + 2 + 2 + 4 * this.getNumberOfPoints()));
		super.Write(writer);

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getNumberOfPoints());
		for (Point point : this.getPoints())
		{
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)point.X);
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)point.Y);
		}
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("NumberOfPoints: " + this.getNumberOfPoints() + "\r\n");
		builder.append("aPoints:" + "\r\n");

		for (int i = 0; i < this.getPoints().size(); i++)
		{
			Point point = this.getPoints().get(i);
			//builder.AppendFormat("P{0:0000}: X = {1}, Y = {2}", i, point.X, point.Y).AppendLine();
			builder.append(String.format("%1$s, %2$s", point.X, point.Y)).append("\r\n"); //Simplified
		}
	}
}