package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(SizeIsVariable = true)] public class Region : WmfBinaryObject
public class Region extends WmfBinaryObject
{
	public Region()
	{
		super();
	}

	private short NextInChain;
	public final short getNextInChain()
	{
		return NextInChain;
	}
	protected final void setNextInChain(short value)
	{
		NextInChain = value;
	}

	public final short getObjectType()
	{
		return 0x0006; //Must be 0x0006
	}

	private int ObjectCount;
	public final int getObjectCount()
	{
		return ObjectCount;
	}
	protected final void setObjectCount(int value)
	{
		ObjectCount = value;
	}

	private short RegionSize;
	public final short getRegionSize()
	{
		return RegionSize;
	}
	public final void setRegionSize(short value)
	{
		RegionSize = value;
	}

	private short ScanCount;
	public final short getScanCount()
	{
		return ScanCount;
	}
	public final void setScanCount(short value)
	{
		ScanCount = value;
	}

	private short MaxScan;
	public final short getMaxScan()
	{
		return MaxScan;
	}
	public final void setMaxScan(short value)
	{
		MaxScan = value;
	}

	private Rect BoundingRectangle;
	public final Rect getBoundingRectangle()
	{
		return BoundingRectangle;
	}
	public final void setBoundingRectangle(Rect value)
	{
		BoundingRectangle = value;
	}

	private Scan[] Scans;
	public final Scan[] getScans()
	{
		return Scans;
	}
	public final void setScans(Scan[] value)
	{
		Scans = value;
	}

	@Override
	public int GetSize()
	{
		return 22 + (this.getScans() != null ? this.getScans().length * 12 : 0);
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setNextInChain(reader.ReadInt16());

		short objectType = reader.ReadInt16();
		if (objectType != this.getObjectType())
		{
			throw new WmfException("ObjectType field in Region Object must be 0x0006!");
		}

		this.setObjectCount(reader.ReadInt32());
		this.setRegionSize(reader.ReadInt16());
		this.setScanCount(reader.ReadInt16());
		this.setMaxScan(reader.ReadInt16());

		this.setBoundingRectangle(Oxage.Wmf.BinaryReaderExtensions.<Rect>ReadWmfObject(reader));

		this.setScans(new Scan[this.getScanCount()]);
		for (int i = 0; i < this.getScanCount(); i++)
		{
			this.getScans()[i] = Oxage.Wmf.BinaryReaderExtensions.<Scan>ReadWmfObject(reader);
		}
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getNextInChain());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getObjectType());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getObjectCount());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRegionSize());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getScanCount() > 0 ? this.getScanCount() : (this.getScans() != null ? this.getScans().length : 0)); //Calculate ScanCount from array length
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getMaxScan());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBoundingRectangle());

		if (this.getScans() != null)
		{
			for (Oxage.Wmf.Objects.Scan scan : this.getScans())
			{
				Oxage.Wmf.BinaryWriterExtensions.Write(writer, scan);
			}
		}
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);

		builder.append("\tNextInChain: " + this.getNextInChain() + "\r\n");
		builder.append("\tObjectType: " + this.getObjectType() + "\r\n");
		builder.append("\tObjectCount: " + this.getObjectCount() + "\r\n");
		builder.append("\tRegionSize: " + this.getRegionSize() + "\r\n");
		builder.append("\tScanCount: " + this.getScanCount() + "\r\n");
		builder.append("\tMaxScan: " + this.getMaxScan() + "\r\n");
		builder.append("\tBoundingRectangle: " + "\r\n").append(this.getBoundingRectangle().Dump());

		builder.append("\tScans[" + (this.getScans() != null ? this.getScans().length : 0) + "]: " + "\r\n");
		if (this.getScans() != null)
		{
			for (Oxage.Wmf.Objects.Scan scan : this.getScans())
			{
				scan.Dump(builder);
			}
		}
	}
}