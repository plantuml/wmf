package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SELECTPALETTE, Size = 4)] public class WmfSelectPalette : WmfBinaryRecord
public class WmfSelectPalette extends WmfBinaryRecord
{
	public WmfSelectPalette()
	{
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Palette;
	private short Palette;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getPalette()
	public final short getPalette()
	{
		return Palette;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setPalette(ushort value)
	public final void setPalette(short value)
	{
		Palette = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setPalette(reader.ReadUInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getPalette());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("Palette: " + this.getPalette() + "\r\n");
	}
}