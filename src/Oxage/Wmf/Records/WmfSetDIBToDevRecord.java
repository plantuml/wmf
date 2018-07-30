package Oxage.Wmf.Records;

import Oxage.Wmf.Objects.*;
import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SETDIBTODEV, SizeIsVariable = true)] public class WmfSetDIBToDevRecord : WmfBinaryRecord
public class WmfSetDIBToDevRecord extends WmfBinaryRecord
{
	public WmfSetDIBToDevRecord()
	{
		super();
	}

	private ColorUsage ColorUsage = getColorUsage().values()[0];
	public final ColorUsage getColorUsage()
	{
		return ColorUsage;
	}
	public final void setColorUsage(ColorUsage value)
	{
		ColorUsage = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort ScanCount;
	private short ScanCount;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getScanCount()
	public final short getScanCount()
	{
		return ScanCount;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setScanCount(ushort value)
	public final void setScanCount(short value)
	{
		ScanCount = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort StartScan;
	private short StartScan;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getStartScan()
	public final short getStartScan()
	{
		return StartScan;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setStartScan(ushort value)
	public final void setStartScan(short value)
	{
		StartScan = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort YDIB;
	private short YDIB;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getYDIB()
	public final short getYDIB()
	{
		return YDIB;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setYDIB(ushort value)
	public final void setYDIB(short value)
	{
		YDIB = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort XDIB;
	private short XDIB;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getXDIB()
	public final short getXDIB()
	{
		return XDIB;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setXDIB(ushort value)
	public final void setXDIB(short value)
	{
		XDIB = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Height;
	private short Height;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getHeight()
	public final short getHeight()
	{
		return Height;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setHeight(ushort value)
	public final void setHeight(short value)
	{
		Height = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Width;
	private short Width;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getWidth()
	public final short getWidth()
	{
		return Width;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setWidth(ushort value)
	public final void setWidth(short value)
	{
		Width = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort YDest;
	private short YDest;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getYDest()
	public final short getYDest()
	{
		return YDest;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setYDest(ushort value)
	public final void setYDest(short value)
	{
		YDest = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort XDest;
	private short XDest;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getXDest()
	public final short getXDest()
	{
		return XDest;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setXDest(ushort value)
	public final void setXDest(short value)
	{
		XDest = value;
	}

	private DeviceIndependentBitmap DIB;
	public final DeviceIndependentBitmap getDIB()
	{
		return DIB;
	}
	public final void setDIB(DeviceIndependentBitmap value)
	{
		DIB = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setColorUsage(ColorUsage.forValue(reader.ReadUInt16()));
		this.setScanCount(reader.ReadUInt16());
		this.setStartScan(reader.ReadUInt16());
		this.setYDIB(reader.ReadUInt16());
		this.setXDIB(reader.ReadUInt16());
		this.setHeight(reader.ReadUInt16());
		this.setWidth(reader.ReadUInt16());
		this.setYDest(reader.ReadUInt16());
		this.setXDest(reader.ReadUInt16());
		this.setDIB(Oxage.Wmf.BinaryReaderExtensions.<DeviceIndependentBitmap>ReadWmfObject(reader));
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.ColorUsage);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getColorUsage().getValue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getScanCount());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getStartScan());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYDIB());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXDIB());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getHeight());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getWidth());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYDest());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXDest());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getDIB());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("ColorUsage: " + this.getColorUsage() + "\r\n");
		builder.append("ScanCount: " + this.getScanCount() + "\r\n");
		builder.append("StartScan: " + this.getStartScan() + "\r\n");
		builder.append("yDib: " + this.getYDIB() + "\r\n");
		builder.append("xDib: " + this.getXDIB() + "\r\n");
		builder.append("Height: " + this.getHeight() + "\r\n");
		builder.append("Width: " + this.getWidth() + "\r\n");
		builder.append("yDest: " + this.getYDest() + "\r\n");
		builder.append("xDest: " + this.getXDest() + "\r\n");

		builder.append("DIB: " + "\r\n");
		this.getDIB().Dump(builder);
	}
}