package Oxage.Wmf.Records;

import Oxage.Wmf.*;
import java.util.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_POLYPOLYGON, SizeIsVariable = true)] public class WmfPolyPolygonRecord : WmfBinaryRecord
public class WmfPolyPolygonRecord extends WmfBinaryRecord
{
	public WmfPolyPolygonRecord()
	{
		super();
		this.setNumberOfPolygons((short)0);
		this.setPointsPerPolygon(new ArrayList<Integer>());
		this.setPoints(new ArrayList<Point>());
	}

	private short NumberOfPolygons;
	public final short getNumberOfPolygons()
	{
		return NumberOfPolygons;
	}
	public final void setNumberOfPolygons(short value)
	{
		NumberOfPolygons = value;
	}

	private ArrayList<Integer> PointsPerPolygon;
	public final ArrayList<Integer> getPointsPerPolygon()
	{
		return PointsPerPolygon;
	}
	public final void setPointsPerPolygon(ArrayList<Integer> value)
	{
		PointsPerPolygon = value;
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

	public final int GetPointsCount()
	{
		return this.getPointsPerPolygon().Sum(x -> x);
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setPoints(new ArrayList<Point>());
		this.setPointsPerPolygon(new ArrayList<Integer>());
		this.setNumberOfPolygons(reader.ReadInt16());

		int count = 0;
		for (int i = 0; i < this.getNumberOfPolygons(); i++)
		{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: ushort n = reader.ReadUInt16();
			short n = reader.ReadUInt16();
			this.getPointsPerPolygon().add((int)n);
			count += n;
		}

		for (int i = 0; i < count; i++)
		{
			short x = reader.ReadInt16();
			short y = reader.ReadInt16();
			this.getPoints().add(new Point(x, y));
		}
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		if (this.getPointsPerPolygon().size() != this.getNumberOfPolygons())
		{
			throw new WmfException(this.getRecordType().toString() + ".NumberOfPolygons does not match with actual number of polygons!");
		}

		//Record size is variable
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: base.RecordSizeBytes = (uint)(4 + 2 + 2 + 2 * this.NumberOfPolygons + 4 * GetPointsCount());
		super.setRecordSizeBytes((int)(4 + 2 + 2 + 2 * this.getNumberOfPolygons() + 4 * GetPointsCount()));
		super.Write(writer);

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getNumberOfPolygons());

		for (int n : this.getPointsPerPolygon())
		{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)n);
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)n);
		}

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
		builder.append("NumberOfPolygons: " + this.getNumberOfPolygons() + "\r\n");

		builder.append("PointsPerPolygon:" + "\r\n");
		for (int i = 0; i < this.getPointsPerPolygon().size(); i++)
		{
			int count = this.getPointsPerPolygon().get(i);
			builder.append(String.format("%1$s", count)).append("\r\n");
		}

		builder.append("Points:" + "\r\n");
		for (int i = 0; i < this.getPoints().size(); i++)
		{
			Point point = this.getPoints().get(i);
			builder.append(String.format("%1$s, %2$s", point.X, point.Y)).append("\r\n");
		}
	}
}