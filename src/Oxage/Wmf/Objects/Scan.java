package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(SizeIsVariable = true)] public class Scan : WmfBinaryObject
public class Scan extends WmfBinaryObject
{
	public Scan()
	{
		super();
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Count;
	private short Count;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getCount()
	public final short getCount()
	{
		return Count;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setCount(ushort value)
	public final void setCount(short value)
	{
		Count = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Top;
	private short Top;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getTop()
	public final short getTop()
	{
		return Top;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setTop(ushort value)
	public final void setTop(short value)
	{
		Top = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Bottom;
	private short Bottom;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getBottom()
	public final short getBottom()
	{
		return Bottom;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setBottom(ushort value)
	public final void setBottom(short value)
	{
		Bottom = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private byte[] ScanLines;
	private byte[] ScanLines;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte[] getScanLines()
	public final byte[] getScanLines()
	{
		return ScanLines;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setScanLines(byte[] value)
	public final void setScanLines(byte[] value)
	{
		ScanLines = value;
	}

	@Override
	public int GetSize()
	{
		return 8 + (this.getScanLines() != null ? this.getScanLines().length : 0);
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setCount(reader.ReadUInt16());
		this.setTop(reader.ReadUInt16());
		this.setBottom(reader.ReadUInt16());
		this.setScanLines(reader.ReadBytes(4 * this.getCount())); //2 bytes for Left, 2 bytes for Right
		//TODO: Create ScanLine object with Left and Right field/property

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: ushort count2 = reader.ReadUInt16();
		short count2 = reader.ReadUInt16();
		if (this.getCount() != count2)
		{
			throw new WmfException("Count and Count2 fields in Scan Object should have equal value!");
		}
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getCount());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getTop());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBottom());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getScanLines());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getCount()); //Count2 should have the same value as Count
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tCount: " + this.getCount() + "\r\n");
		builder.append("\tTop: " + this.getTop() + "\r\n");
		builder.append("\tBottom: " + this.getBottom() + "\r\n");
		builder.append("\tScanLines: " + WmfHelper.DumpByteArray(this.getScanLines()) + "\r\n");
		builder.append("\tCount2: " + this.getCount() + "\r\n");
	}
}