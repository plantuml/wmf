package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(SizeIsVariable = true)] public class Palette : WmfBinaryObject
public class Palette extends WmfBinaryObject
{
	public Palette(RecordType rt)
	{
		super();
		if (rt == RecordType.META_CREATEPALETTE)
		{
			this.setStart((short)0x300);
		}
	}

	private short Start;
	public final short getStart()
	{
		return Start;
	}
	public final void setStart(short value)
	{
		Start = value;
	}

	private short NumberOfEntries;
	public final short getNumberOfEntries()
	{
		return NumberOfEntries;
	}
	public final void setNumberOfEntries(short value)
	{
		NumberOfEntries = value;
	}

	private PaletteEntry[] PaletteEntries;
	public final PaletteEntry[] getPaletteEntries()
	{
		return PaletteEntries;
	}
	public final void setPaletteEntries(PaletteEntry[] value)
	{
		PaletteEntries = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getSizeBytes()
	public final int getSizeBytes()
	{
		if (getPaletteEntries() == null)
		{
			return 4;
		}
		else
		{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: return 4 + (uint)PaletteEntries.Length * PaletteEntry.SizeBytes;
			return 4 + (int)getPaletteEntries().length * PaletteEntry.SizeBytes;
		}
	}

	@Override
	public int GetSize()
	{
		return (int)this.getSizeBytes();
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setStart(reader.ReadInt16());
		this.setNumberOfEntries(reader.ReadInt16());
		setPaletteEntries(new PaletteEntry[this.getNumberOfEntries()]);
		for (int i = 0; i < getNumberOfEntries(); i++)
		{
			getPaletteEntries()[i] = new PaletteEntry();
			getPaletteEntries()[i].Read(reader);
		}
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getStart());
		if (getPaletteEntries() == null)
		{
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)0);
		}
		else
		{
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getPaletteEntries().length);
			for (Oxage.Wmf.Objects.PaletteEntry paletteEntry : getPaletteEntries())
			{
				paletteEntry.Write(writer);
			}
		}
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tStart: " + this.getStart() + "\r\n");
		builder.append("\tNumberOfEntries: " + this.getNumberOfEntries() + "\r\n");
		if (this.getPaletteEntries() != null)
		{
			for (Oxage.Wmf.Objects.PaletteEntry paletteEntry : getPaletteEntries())
			{
				paletteEntry.Dump(builder);
			}
		}
	}
}