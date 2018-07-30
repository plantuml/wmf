package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 108)] public class BitmapV4Header : WmfBinaryObject
public class BitmapV4Header extends WmfBinaryObject
{
	public BitmapV4Header()
	{
		super();
		this.setBitmapInfoHeader(new BitmapInfoHeader());
		this.setEndpoints(new CIEXYZTriple());
	}

	private BitmapInfoHeader BitmapInfoHeader;
	public final BitmapInfoHeader getBitmapInfoHeader()
	{
		return BitmapInfoHeader;
	}
	public final void setBitmapInfoHeader(BitmapInfoHeader value)
	{
		BitmapInfoHeader = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint RedMask;
	private int RedMask;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getRedMask()
	public final int getRedMask()
	{
		return RedMask;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setRedMask(uint value)
	public final void setRedMask(int value)
	{
		RedMask = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint GreenMask;
	private int GreenMask;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getGreenMask()
	public final int getGreenMask()
	{
		return GreenMask;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setGreenMask(uint value)
	public final void setGreenMask(int value)
	{
		GreenMask = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint BlueMask;
	private int BlueMask;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getBlueMask()
	public final int getBlueMask()
	{
		return BlueMask;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setBlueMask(uint value)
	public final void setBlueMask(int value)
	{
		BlueMask = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint AlphaMask;
	private int AlphaMask;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getAlphaMask()
	public final int getAlphaMask()
	{
		return AlphaMask;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setAlphaMask(uint value)
	public final void setAlphaMask(int value)
	{
		AlphaMask = value;
	}

	private LogicalColorSpace ColorSpaceType = LogicalColorSpace.values()[0];
	public final LogicalColorSpace getColorSpaceType()
	{
		return ColorSpaceType;
	}
	public final void setColorSpaceType(LogicalColorSpace value)
	{
		ColorSpaceType = value;
	}

	private CIEXYZTriple Endpoints;
	public final CIEXYZTriple getEndpoints()
	{
		return Endpoints;
	}
	public final void setEndpoints(CIEXYZTriple value)
	{
		Endpoints = value;
	}

	private float GammaRed;
	public final float getGammaRed()
	{
		return GammaRed;
	}
	public final void setGammaRed(float value)
	{
		GammaRed = value;
	}

	private float GammaGreen;
	public final float getGammaGreen()
	{
		return GammaGreen;
	}
	public final void setGammaGreen(float value)
	{
		GammaGreen = value;
	}

	private float GammaBlue;
	public final float getGammaBlue()
	{
		return GammaBlue;
	}
	public final void setGammaBlue(float value)
	{
		GammaBlue = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setBitmapInfoHeader(Oxage.Wmf.BinaryReaderExtensions.<BitmapInfoHeader>ReadWmfObject(reader));
		this.setRedMask(reader.ReadUInt32());
		this.setGreenMask(reader.ReadUInt32());
		this.setBlueMask(reader.ReadUInt32());
		this.setAlphaMask(reader.ReadUInt32());
		this.setColorSpaceType(LogicalColorSpace.forValue(reader.ReadUInt32()));
		this.setEndpoints(Oxage.Wmf.BinaryReaderExtensions.<CIEXYZTriple>ReadWmfObject(reader));
		this.setGammaRed(reader.ReadSingle());
		this.setGammaGreen(reader.ReadSingle());
		this.setGammaBlue(reader.ReadSingle());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBitmapInfoHeader());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRedMask());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getGreenMask());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBlueMask());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getAlphaMask());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((uint)this.ColorSpaceType);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (int)this.getColorSpaceType().getValue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getEndpoints());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getGammaRed());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getGammaGreen());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getGammaBlue());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		this.getBitmapInfoHeader().Dump(builder);
		builder.append("\tRedMask: " + this.getRedMask() + "\r\n");
		builder.append("\tGreenMask: " + this.getGreenMask() + "\r\n");
		builder.append("\tBlueMask: " + this.getBlueMask() + "\r\n");
		builder.append("\tAlphaMask: " + this.getAlphaMask() + "\r\n");
		builder.append("\tColorSpaceType: " + this.getColorSpaceType() + "\r\n");
		this.getEndpoints().Dump(builder);
		builder.append("\tGammaRed: " + this.getGammaRed() + "\r\n");
		builder.append("\tGammaGreen: " + this.getGammaGreen() + "\r\n");
		builder.append("\tGammaBlue: " + this.getGammaBlue() + "\r\n");
	}
}