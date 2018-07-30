package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_DELETEOBJECT, Size = 4)] public class WmfDeleteObjectRecord : WmfBinaryRecord
public class WmfDeleteObjectRecord extends WmfBinaryRecord
{
	public WmfDeleteObjectRecord()
	{
		super();
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort ObjectIndex;
	private short ObjectIndex;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getObjectIndex()
	public final short getObjectIndex()
	{
		return ObjectIndex;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setObjectIndex(ushort value)
	public final void setObjectIndex(short value)
	{
		ObjectIndex = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setObjectIndex(reader.ReadUInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getObjectIndex());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("ObjectIndex: " + this.getObjectIndex() + "\r\n");
	}
}