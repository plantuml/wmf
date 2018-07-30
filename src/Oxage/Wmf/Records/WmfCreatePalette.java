package Oxage.Wmf.Records;

import Oxage.Wmf.Objects.*;
import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_CREATEPALETTE, SizeIsVariable = true)] public class WmfCreatePalette : WmfBinaryRecord
public class WmfCreatePalette extends WmfBinaryRecord
{
	public WmfCreatePalette()
	{
		super();
	}

	/** 
	 1-based index for WmfSelectPalette.Palette
	*/
	private short PaletteIndex;
	public final short getPaletteIndex()
	{
		return PaletteIndex;
	}
	public final void setPaletteIndex(short value)
	{
		PaletteIndex = value;
	}

	private Palette Palette;
	public final Palette getPalette()
	{
		return Palette;
	}
	public final void setPalette(Palette value)
	{
		Palette = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		setPalette(new Palette(RecordType.META_CREATEPALETTE));
		getPalette().Read(reader);
		this.setRecordSizeBytes(getPalette().getSizeBytes());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		getPalette().Write(writer);
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		getPalette().Dump(builder);
	}
}