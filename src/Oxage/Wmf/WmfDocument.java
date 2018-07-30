package Oxage.Wmf;

import Oxage.Wmf.Records.*;
import java.util.*;
import java.io.*;

//Human-friendly reader and writer
public class WmfDocument
{
	public WmfDocument()
	{
		this.setRecords(new ArrayList<IBinaryRecord>());
		this.getRecords().add(new WmfFormat());
		this.getRecords().add(new WmfHeader());
		this.getRecords().add(new WmfSetMapModeRecord());
		this.getRecords().add(new WmfSetWindowOrgRecord());
		this.getRecords().add(new WmfSetWindowExtRecord()); //Add SetWindowExtRecord for compatibility
	}

	/** 
	 Get the current position
	*/
	private Point Position = new Point();
	public final Point getPosition()
	{
		return Position;
	}
	private void setPosition(Point value)
	{
		Position = value;
	}

	private ArrayList<IBinaryRecord> Records;
	public final ArrayList<IBinaryRecord> getRecords()
	{
		return Records;
	}
	public final void setRecords(ArrayList<IBinaryRecord> value)
	{
		Records = value;
	}

	public final WmfFormat getFormat()
	{
		Object tempVar = this.getRecords().FirstOrDefault(x -> x instanceof WmfFormat);
		return tempVar instanceof WmfFormat ? (WmfFormat)tempVar : null;
	}

	public final WmfHeader getHeader()
	{
		Object tempVar = this.getRecords().FirstOrDefault(x -> x instanceof WmfHeader);
		return tempVar instanceof WmfHeader ? (WmfHeader)tempVar : null;
	}

	public final int getWidth()
	{
		return this.getFormat().getRight() - this.getFormat().getLeft();
	}
	public final void setWidth(int value)
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.Format.Right = (ushort)(this.Format.Left + value);
		this.getFormat().setRight((short)(this.getFormat().getLeft() + value));

		Object tempVar = this.getRecords().FirstOrDefault(x -> x instanceof WmfSetWindowExtRecord);
		WmfSetWindowExtRecord ext = tempVar instanceof WmfSetWindowExtRecord ? (WmfSetWindowExtRecord)tempVar : null;
		if (ext != null)
		{
			ext.setX((short)(this.getFormat().getRight() - this.getFormat().getLeft()));
		}
	}

	public final int getHeight()
	{
		return this.getFormat().getBottom() - this.getFormat().getTop();
	}
	public final void setHeight(int value)
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: this.Format.Bottom = (ushort)(this.Format.Top + value);
		this.getFormat().setBottom((short)(this.getFormat().getTop() + value));

		Object tempVar = this.getRecords().FirstOrDefault(x -> x instanceof WmfSetWindowExtRecord);
		WmfSetWindowExtRecord ext = tempVar instanceof WmfSetWindowExtRecord ? (WmfSetWindowExtRecord)tempVar : null;
		if (ext != null)
		{
			ext.setY((short)(this.getFormat().getBottom() - this.getFormat().getTop()));
		}
	}

	public final void Load(String path)
	{
		try (System.IO.FileStream stream = File.OpenRead(path))
		{
			Load(stream);
		}
	}

	public final void Load(InputStream stream)
	{
		this.setRecords(new ArrayList<IBinaryRecord>());
		try (WmfReader reader = new WmfReader(stream))
		{
			while (!reader.getIsEndOfFile())
			{
				try
				{
					Oxage.Wmf.IBinaryRecord record = reader.Read();
					if (record != null)
					{
						this.getRecords().add(record);
					}
				}
				catch (EndOfStreamException e)
				{
					//End of stream
					break;
				}
			}
		}
	}

	public final void Save(String path)
	{
		try (FileStream stream = new FileStream(path, FileMode.Create, FileAccess.ReadWrite))
		{
			Save(stream);
		}
	}

	public final void Save(OutputStream stream)
	{
		this.getFormat().setChecksum(this.getFormat().CalculateChecksum());

		if (!this.getRecords().<WmfEndOfFileRecord>OfType().Any())
		{
			this.getRecords().add(new WmfEndOfFileRecord());
		}

		try (WmfWriter writer = new WmfWriter(stream))
		{
			for (IBinaryRecord record : this.getRecords())
			{
				writer.Write(record);
			}

			writer.FixHeader();
			writer.FixPadding();
		}
	}

	public final String Dump()
	{
		StringBuilder builder = new StringBuilder();
		for (IBinaryRecord record : this.getRecords())
		{
			builder.append(record.Dump() + "\r\n");
			builder.append("\r\n");
		}
		return builder.toString();
	}

	/** 
	 Move the current position to the destination
	 
	 @param destination
	*/
	public final void MoveTo(Point destination)
	{
		WmfMoveToRecord record = new WmfMoveToRecord();
		record.SetDestination(destination);
		this.getRecords().add(record);
		this.setPosition(destination);
	}

	public final void AddSelectObject(int index)
	{
		WmfSelectObjectRecord tempVar = new WmfSelectObjectRecord();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: tempVar.setObjectIndex((ushort)index);
		tempVar.setObjectIndex((short)index);
		this.getRecords().add(tempVar);
	}

	public final void AddDeleteObject(int index)
	{
		WmfDeleteObjectRecord tempVar = new WmfDeleteObjectRecord();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: tempVar.setObjectIndex((ushort)index);
		tempVar.setObjectIndex((short)index);
		this.getRecords().add(tempVar);
	}

	/** 
	 Add a line from start to end.
	 
	 @param start Starting Point
	 @param end Ending Point
	*/
	public final void AddLine(Point start, Point end)
	{
		Point oldPosition = this.getPosition();
		MoveTo(start);
		AddLineTo(end.X, end.Y);
		MoveTo(oldPosition);
	}

	/** 
	 Add a line from current Position to (x,y)
	 
	 @param destination
	*/
	public final WmfLineToRecord AddLineTo(int x, int y)
	{
		WmfLineToRecord record = new WmfLineToRecord();
		record.SetDestination(new Point(x, y));
		this.getRecords().add(record);
		return record;
	}

	public final WmfPolylineRecord AddPolyline(java.lang.Iterable<Point> points)
	{
		ArrayList<Object> list = points.ToList();
		WmfPolylineRecord record = new WmfPolylineRecord();
		record.setNumberOfPoints((short)list.size());
		record.setPoints(list);
		this.getRecords().add(record);
		return record;
	}

	public final WmfPolygonRecord AddPolygon(java.lang.Iterable<Point> points)
	{
		ArrayList<Object> list = points.ToList();
		WmfPolygonRecord record = new WmfPolygonRecord();
		record.setNumberOfPoints((short)list.size());
		record.setPoints(list);
		this.getRecords().add(record);
		return record;
	}

	public final WmfPolyPolygonRecord AddPolyPolygon(java.lang.Iterable<java.lang.Iterable<Point>> polygons)
	{
		ArrayList<Object> list = polygons.ToList();

		WmfPolyPolygonRecord record = new WmfPolyPolygonRecord();
		record.setNumberOfPolygons((short)list.size());
		record.setPointsPerPolygon(new ArrayList<Integer>());
		record.setPoints(new ArrayList<Point>());

		for (Object polygon : list)
		{
			ArrayList<Object> points = polygon.ToList();
			record.getPointsPerPolygon().add(points.size());

//C# TO JAVA CONVERTER TODO TASK: There is no equivalent to implicit typing in Java unless the Java 10 inferred typing option is selected:
			for (var point : polygon)
			{
				record.getPoints().add(point);
			}
		}

		this.getRecords().add(record);
		return record;
	}


	public final IBinaryRecord AddRectangle(int x, int y, int width, int height)
	{
		return AddRectangle(x, y, width, height, 0);
	}

//C# TO JAVA CONVERTER NOTE: Java does not support optional parameters. Overloaded method(s) are created above:
//ORIGINAL LINE: public IBinaryRecord AddRectangle(int x, int y, int width, int height, int cornerRadius = 0)
	public final IBinaryRecord AddRectangle(int x, int y, int width, int height, int cornerRadius)
	{
		return AddRectangle(new Rectangle(x, y, width, height), cornerRadius);
	}


	public final IBinaryRecord AddRectangle(Point corner, Size size)
	{
		return AddRectangle(corner, size, 0);
	}

//C# TO JAVA CONVERTER NOTE: Java does not support optional parameters. Overloaded method(s) are created above:
//ORIGINAL LINE: public IBinaryRecord AddRectangle(Point corner, Size size, int cornerRadius = 0)
	public final IBinaryRecord AddRectangle(Point corner, Size size, int cornerRadius)
	{
		return AddRectangle(new Rectangle(corner.X, corner.Y, size.Width, size.Height), cornerRadius);
	}


	public final IBinaryRecord AddRectangle(Rectangle rect)
	{
		return AddRectangle(rect, 0);
	}

//C# TO JAVA CONVERTER NOTE: Java does not support optional parameters. Overloaded method(s) are created above:
//ORIGINAL LINE: public IBinaryRecord AddRectangle(Rectangle rect, int cornerRadius = 0)
	public final IBinaryRecord AddRectangle(Rectangle rect, int cornerRadius)
	{
		if (cornerRadius > 0)
		{
			//Rounded rectangle
			WmfRoundRectRecord record = new WmfRoundRectRecord();
			record.SetRectangle(rect, cornerRadius);
			this.getRecords().add(record);
			return record;
		}
		else
		{
			//Classic rectangle
			WmfRectangleRecord record = new WmfRectangleRecord();
			record.SetRectangle(rect);
			this.getRecords().add(record);
			return record;
		}
	}

	/** 
	 Add an ellipse by specifying its bounding rectangle.
	 
	 @param x
	 @param y
	 @param width
	 @param height
	*/
	public final WmfEllipseRecord AddEllipse(int x, int y, int width, int height)
	{
		WmfEllipseRecord record = new WmfEllipseRecord();
		record.SetRectangle(new Rectangle(x, y, width, height));
		this.getRecords().add(record);
		return record;
	}

	/** 
	 Add an ellipse by specifying its center and x/y radius
	 
	 @param center
	 @param radius
	*/
	public final WmfEllipseRecord AddEllipse(Point center, Point radius)
	{
		WmfEllipseRecord record = new WmfEllipseRecord();
		record.SetEllipse(center, radius);
		this.getRecords().add(record);
		return record;
	}

	/** 
	 Add a circle (equi-radius ellipse) by specifying its center and radius
	 
	 @param center
	 @param radius
	*/
	public final WmfEllipseRecord AddCircle(int x, int y, int radius)
	{
		return AddEllipse(new Point(x, y), new Point(radius, radius));
	}

	/** 
	 Add a circle (equi-radius ellipse) by specifying its center and radius
	 
	 @param center
	 @param radius
	*/
	public final WmfEllipseRecord AddCircle(Point center, int radius)
	{
		return AddEllipse(center, new Point(radius, radius));
	}

	/** 
	 Draws an arc. Doesn't seem to preserve shape when ungrouped in excel.
	 
	 @param rectangle
	 @param start
	 @param end
	*/
	public final WmfArcRecord AddArc(Rectangle rectangle, Point start, Point end)
	{
		WmfArcRecord record = new WmfArcRecord();
		record.SetArc(rectangle, start, end);
		this.getRecords().add(record);
		return record;
	}

	public final WmfSetPolyFillModeRecord AddPolyFillMode(PolyFillMode mode)
	{
		WmfSetPolyFillModeRecord record = new WmfSetPolyFillModeRecord();
		record.setMode(mode);
		this.getRecords().add(record);
		return record;
	}


	public final WmfCreateBrushIndirectRecord AddCreateBrushIndirect(Color color, BrushStyle style)
	{
		return AddCreateBrushIndirect(color, style, HatchStyle.HS_HORIZONTAL);
	}

	public final WmfCreateBrushIndirectRecord AddCreateBrushIndirect(Color color)
	{
		return AddCreateBrushIndirect(color, BrushStyle.BS_SOLID, HatchStyle.HS_HORIZONTAL);
	}

//C# TO JAVA CONVERTER NOTE: Java does not support optional parameters. Overloaded method(s) are created above:
//ORIGINAL LINE: public WmfCreateBrushIndirectRecord AddCreateBrushIndirect(Color color, BrushStyle style = BrushStyle.BS_SOLID, HatchStyle hatch = HatchStyle.HS_HORIZONTAL)
	public final WmfCreateBrushIndirectRecord AddCreateBrushIndirect(Color color, BrushStyle style, HatchStyle hatch)
	{
		WmfCreateBrushIndirectRecord record = new WmfCreateBrushIndirectRecord();
		record.setColor(color);
		record.setStyle(style);
		record.setHatch(hatch);

		this.getRecords().add(record);
		return record;
	}


	public final WmfCreatePenIndirectRecord AddCreatePenIndirect(Color color, PenStyle style)
	{
		return AddCreatePenIndirect(color, style, 1);
	}

	public final WmfCreatePenIndirectRecord AddCreatePenIndirect(Color color)
	{
		return AddCreatePenIndirect(color, PenStyle.PS_SOLID, 1);
	}

//C# TO JAVA CONVERTER NOTE: Java does not support optional parameters. Overloaded method(s) are created above:
//ORIGINAL LINE: public WmfCreatePenIndirectRecord AddCreatePenIndirect(Color color, PenStyle style = PenStyle.PS_SOLID, int size = 1)
	public final WmfCreatePenIndirectRecord AddCreatePenIndirect(Color color, PenStyle style, int size)
	{
		WmfCreatePenIndirectRecord record = new WmfCreatePenIndirectRecord();
		record.setColor(color);
		record.setStyle(style);
		record.setWidth(new Point(size, size));

		this.getRecords().add(record);
		return record;
	}


	public final WmfCreateFontIndirectRecord AddCreateFontIndirect(String fontName, int size, int weight, boolean italic)
	{
		return AddCreateFontIndirect(fontName, size, weight, italic, false);
	}

	public final WmfCreateFontIndirectRecord AddCreateFontIndirect(String fontName, int size, int weight)
	{
		return AddCreateFontIndirect(fontName, size, weight, false, false);
	}

	public final WmfCreateFontIndirectRecord AddCreateFontIndirect(String fontName, int size)
	{
		return AddCreateFontIndirect(fontName, size, 400, false, false);
	}

//C# TO JAVA CONVERTER NOTE: Java does not support optional parameters. Overloaded method(s) are created above:
//ORIGINAL LINE: public WmfCreateFontIndirectRecord AddCreateFontIndirect(string fontName, int size, int weight = 400, bool italic = false, bool underline = false)
	public final WmfCreateFontIndirectRecord AddCreateFontIndirect(String fontName, int size, int weight, boolean italic, boolean underline)
	{
		WmfCreateFontIndirectRecord record = new WmfCreateFontIndirectRecord();
		record.setHeight((short)size);
		record.setWeight((short)weight);
		record.setItalic(italic);
		record.setUnderline(underline);
		record.setFaceName(fontName);

		this.getRecords().add(record);
		return record;
	}

	public final WmfSetTextAlignRecord AddTextAlignment(TextAlignmentMode mode)
	{
		WmfSetTextAlignRecord record = new WmfSetTextAlignRecord();
		record.setMode(mode);
		this.getRecords().add(record);
		return record;
	}

	public final WmfSetTextColorRecord AddTextColor(Color color)
	{
		WmfSetTextColorRecord record = new WmfSetTextColorRecord();
		record.setColor(color);
		this.getRecords().add(record);
		return record;
	}


	public final WmfTextoutRecord AddText(String text, int x)
	{
		return AddText(text, x, 0);
	}

	public final WmfTextoutRecord AddText(String text)
	{
		return AddText(text, 0, 0);
	}

//C# TO JAVA CONVERTER NOTE: Java does not support optional parameters. Overloaded method(s) are created above:
//ORIGINAL LINE: public WmfTextoutRecord AddText(string text, int x = 0, int y = 0)
	public final WmfTextoutRecord AddText(String text, int x, int y)
	{
		WmfTextoutRecord record = new WmfTextoutRecord();
		record.setStringValue(text);
		record.setXStart((short)x);
		record.setYStart((short)y);
		this.getRecords().add(record);
		return record;
	}

	public final WmfTextoutRecord AddText(String text, Point start)
	{
		return AddText(text, start.X, start.Y);
	}
}