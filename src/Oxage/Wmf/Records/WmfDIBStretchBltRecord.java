package Oxage.Wmf.Records;

import Oxage.Wmf.Objects.*;
import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_DIBSTRETCHBLT, SizeIsVariable = true)] public class WmfDIBStretchBltRecord : WmfBinaryRecord
public class WmfDIBStretchBltRecord extends WmfBinaryRecord
{
	public WmfDIBStretchBltRecord()
	{
		super();
	}

	private TernaryRasterOperation RasterOperation = TernaryRasterOperation.values()[0];
	public final TernaryRasterOperation getRasterOperation()
	{
		return RasterOperation;
	}
	public final void setRasterOperation(TernaryRasterOperation value)
	{
		RasterOperation = value;
	}

	private short SrcHeight;
	public final short getSrcHeight()
	{
		return SrcHeight;
	}
	public final void setSrcHeight(short value)
	{
		SrcHeight = value;
	}

	private short SrcWidth;
	public final short getSrcWidth()
	{
		return SrcWidth;
	}
	public final void setSrcWidth(short value)
	{
		SrcWidth = value;
	}

	private short YSrc;
	public final short getYSrc()
	{
		return YSrc;
	}
	public final void setYSrc(short value)
	{
		YSrc = value;
	}

	private short XSrc;
	public final short getXSrc()
	{
		return XSrc;
	}
	public final void setXSrc(short value)
	{
		XSrc = value;
	}

	private short DestHeight;
	public final short getDestHeight()
	{
		return DestHeight;
	}
	public final void setDestHeight(short value)
	{
		DestHeight = value;
	}

	private short DestWidth;
	public final short getDestWidth()
	{
		return DestWidth;
	}
	public final void setDestWidth(short value)
	{
		DestWidth = value;
	}

	private short YDest;
	public final short getYDest()
	{
		return YDest;
	}
	public final void setYDest(short value)
	{
		YDest = value;
	}

	private short XDest;
	public final short getXDest()
	{
		return XDest;
	}
	public final void setXDest(short value)
	{
		XDest = value;
	}

	private DeviceIndependentBitmap Target;
	public final DeviceIndependentBitmap getTarget()
	{
		return Target;
	}
	public final void setTarget(DeviceIndependentBitmap value)
	{
		Target = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		boolean isWithoutBitmap = (this.getRecordSize() == 24);

		this.setRasterOperation(TernaryRasterOperation.forValue(reader.ReadUInt32()));

		if (!isWithoutBitmap)
		{
			this.setSrcHeight(reader.ReadInt16());
			this.setSrcWidth(reader.ReadInt16());
		}

		this.setYSrc(reader.ReadInt16());
		this.setXSrc(reader.ReadInt16());

		if (isWithoutBitmap)
		{
			short dummy = reader.ReadInt16();
		}

		this.setDestHeight(reader.ReadInt16());
		this.setDestWidth(reader.ReadInt16());
		this.setYDest(reader.ReadInt16());
		this.setXDest(reader.ReadInt16());

		if (!isWithoutBitmap)
		{
			this.setTarget(Oxage.Wmf.BinaryReaderExtensions.<DeviceIndependentBitmap>ReadWmfObject(reader));
		}
	}

	@Override
	public void Write(BinaryWriter writer)
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: base.RecordSizeBytes = (uint)(6 + 18 + (this.Target == null ? 2 :this.Target.GetSize()));
		super.setRecordSizeBytes((int)(6 + 18 + (this.getTarget() == null ? 2 :this.getTarget().GetSize())));
		super.Write(writer);

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((uint)this.RasterOperation);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (int)this.getRasterOperation().getValue());

		if (this.getTarget() != null)
		{
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getSrcHeight());
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getSrcWidth());
		}

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYSrc());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXSrc());

		if (this.getTarget() == null)
		{
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)0x0000);
		}

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getDestHeight());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getDestWidth());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYDest());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXDest());

		if (this.getTarget() != null)
		{
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getTarget());
		}
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("RasterOperation: " + this.getRasterOperation() + "\r\n");

		if (this.getTarget() != null)
		{
			builder.append("SrcHeight: " + this.getSrcHeight() + "\r\n");
			builder.append("SrcWidth: " + this.getSrcWidth() + "\r\n");
		}

		builder.append("YSrc: " + this.getYSrc() + "\r\n");
		builder.append("XSrc: " + this.getXSrc() + "\r\n");
		builder.append("DestHeight: " + this.getDestHeight() + "\r\n");
		builder.append("DestWidth: " + this.getDestWidth() + "\r\n");
		builder.append("YDest: " + this.getYDest() + "\r\n");
		builder.append("XDest: " + this.getXDest() + "\r\n");

		if (this.getTarget() != null)
		{
			builder.append("Target: " + "\r\n");
			this.getTarget().Dump(builder);
		}
		else
		{
			builder.append("Target: (without bitmap)" + "\r\n");
		}
	}
}