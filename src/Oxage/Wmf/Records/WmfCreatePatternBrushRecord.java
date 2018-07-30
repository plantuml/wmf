package Oxage.Wmf.Records;

import Oxage.Wmf.Objects.*;
import Oxage.Wmf.*;

//[WmfRecord(Type = RecordType.META_CREATEPATTERNBRUSH, SizeIsVariable = true)]
public class WmfCreatePatternBrushRecord extends WmfBinaryRecord
{
	public WmfCreatePatternBrushRecord()
	{
		super();
	}

	private Bitmap16 Bitmap16;
	public final Bitmap16 getBitmap16()
	{
		return Bitmap16;
	}
	public final void setBitmap16(Bitmap16 value)
	{
		Bitmap16 = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private byte[] Bits;
	private byte[] Bits;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte[] getBits()
	public final byte[] getBits()
	{
		return Bits;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setBits(byte[] value)
	public final void setBits(byte[] value)
	{
		Bits = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		//NOTE: The documentation is confusing, uses only the first part of Bitmap16 object?!
		throw new UnsupportedOperationException();
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);

		//NOTE: The documentation is confusing, uses only the first part of Bitmap16 object?!
		throw new UnsupportedOperationException();
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		getBitmap16().Dump(builder);
		builder.append("Bits: " + WmfHelper.DumpByteArray(this.getBits()) + "\r\n");
	}
}