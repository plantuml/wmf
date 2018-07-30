package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(SizeIsVariable = true)] public class DeviceIndependentBitmap : WmfBinaryObject
public class DeviceIndependentBitmap extends WmfBinaryObject
{
	public DeviceIndependentBitmap()
	{
		super();
	}

	/** 
	 Gets or sets DIBHeaderInfo, either BitmapCoreHeader or BitmapInfoHeader.
	*/
	private IDIBHeaderInfo DIBHeaderInfo;
	public final IDIBHeaderInfo getDIBHeaderInfo()
	{
		return DIBHeaderInfo;
	}
	public final void setDIBHeaderInfo(IDIBHeaderInfo value)
	{
		DIBHeaderInfo = value;
	}

	/** 
	 Gets or sets an array of colors, either array of RGBQuad objects or array of uint16 values.
	*/
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private byte[] Colors;
	private byte[] Colors;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte[] getColors()
	public final byte[] getColors()
	{
		return Colors;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setColors(byte[] value)
	public final void setColors(byte[] value)
	{
		Colors = value;
	}

	/** 
	 Gets or sets actual bitmap bits.
	*/
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private byte[] Data;
	private byte[] Data;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte[] getData()
	public final byte[] getData()
	{
		return Data;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setData(byte[] value)
	public final void setData(byte[] value)
	{
		Data = value;
	}

	@Override
	public int GetSize()
	{
		return this.getDIBHeaderInfo().GetSize() + (this.getColors() != null ? this.getColors().length : 0) + (this.getData() != null ? this.getData().length : 0);
	}

	@Override
	public void Read(BinaryReader reader)
	{
		//Determine whether to read BitmapCoreHeader or BitmapInfoHeader
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: uint headerSize = reader.ReadUInt32();
		int headerSize = reader.ReadUInt32();
		if (headerSize == 12)
		{
			BitmapCoreHeader header = new BitmapCoreHeader();
			header.Read(reader, false);
			this.setDIBHeaderInfo(header);
		}
		else
		{
			BitmapInfoHeader header = new BitmapInfoHeader();
			header.Read(reader, false);
			this.setDIBHeaderInfo(header);
		}

		//Read Colors field
		//this.Colors = reader.ReadBytes(); //TODO: How to determine length of array?!

		//Read aData field
		if (this.getDIBHeaderInfo() instanceof BitmapCoreHeader)
		{
			Oxage.Wmf.IDIBHeaderInfo tempVar = this.getDIBHeaderInfo();
			BitmapCoreHeader header = tempVar instanceof BitmapCoreHeader ? (BitmapCoreHeader)tempVar : null;
			int length = (((header.getWidth() * header.getPlanes() * header.getBitCount().getValue() + 31) & ~31) / 8) * Math.abs(header.getHeight());
			this.setData(reader.ReadBytes(length));
		}
		else if (this.getDIBHeaderInfo() instanceof BitmapInfoHeader)
		{
			Oxage.Wmf.IDIBHeaderInfo tempVar2 = this.getDIBHeaderInfo();
			BitmapInfoHeader header = tempVar2 instanceof BitmapInfoHeader ? (BitmapInfoHeader)tempVar2 : null;
			switch (header.getCompression())
			{
				case BI_RGB:
				case BI_BITFIELDS:
				case BI_CMYK:
					int length = (((header.getWidth() * header.getPlanes() * header.getBitCount().getValue() + 31) & ~31) / 8) * Math.abs(header.getHeight());
					this.setData(reader.ReadBytes(length));
					break;

				default:
					this.setData(reader.ReadBytes((int)header.getImageSize()));
					break;
			}
		}
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		this.getDIBHeaderInfo().Write(writer);

		if (this.getColors() != null)
		{
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getColors());
		}

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getData());

		//Write dummy byte to align padding to WORD
		if (this.getData().length % 2 == 1)
		{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)0x00);
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)0x00);
		}
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		builder.append("\tDIBHeaderInfo: " + this.getDIBHeaderInfo().Dump() + "\r\n");
		builder.append("\tColors: " + "?" + "\r\n"); //TODO: Value output?
		builder.append("\taData: " + WmfHelper.DumpByteArray(this.getData()) + "\r\n");
	}
}