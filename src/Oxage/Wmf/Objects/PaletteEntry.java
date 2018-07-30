package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 4)] public class PaletteEntry : WmfBinaryObject
public class PaletteEntry extends WmfBinaryObject
{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public const uint SizeBytes = 4;
	public static final int SizeBytes = 4;

	public PaletteEntry()
	{
		super();
	}

	private PaletteEntryFlag Values = PaletteEntryFlag.values()[0];
	public final PaletteEntryFlag getValues()
	{
		return Values;
	}
	public final void setValues(PaletteEntryFlag value)
	{
		Values = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private byte Blue;
	private byte Blue;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte getBlue()
	public final byte getBlue()
	{
		return Blue;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setBlue(byte value)
	public final void setBlue(byte value)
	{
		Blue = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private byte Green;
	private byte Green;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte getGreen()
	public final byte getGreen()
	{
		return Green;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setGreen(byte value)
	public final void setGreen(byte value)
	{
		Green = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private byte Red;
	private byte Red;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte getRed()
	public final byte getRed()
	{
		return Red;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setRed(byte value)
	public final void setRed(byte value)
	{
		Red = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setValues(PaletteEntryFlag.forValue(reader.ReadByte()));
		this.setBlue(reader.ReadByte());
		this.setGreen(reader.ReadByte());
		this.setRed(reader.ReadByte());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)this.Values);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)this.getValues().getValue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBlue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getGreen());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRed());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tValues: " + this.getValues() + "\r\n");
		builder.append("\tBlue: " + this.getBlue() + "\r\n");
		builder.append("\tGreen: " + this.getGreen() + "\r\n");
		builder.append("\tRed: " + this.getRed() + "\r\n");
	}
}