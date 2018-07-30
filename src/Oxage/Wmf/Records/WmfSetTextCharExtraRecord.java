package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SETTEXTCHAREXTRA, Size = 4)] public class WmfSetTextCharExtraRecord : WmfBinaryRecord
public class WmfSetTextCharExtraRecord extends WmfBinaryRecord
{
	public WmfSetTextCharExtraRecord()
	{
		super();
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort CharExtra;
	private short CharExtra;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getCharExtra()
	public final short getCharExtra()
	{
		return CharExtra;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setCharExtra(ushort value)
	public final void setCharExtra(short value)
	{
		CharExtra = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setCharExtra(reader.ReadUInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getCharExtra());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("CharExtra: " + this.getCharExtra() + "\r\n");
	}
}