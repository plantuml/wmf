package Oxage.Wmf.Records;

import Oxage.Wmf.*;

public class WmfUnknownRecord extends WmfBinaryRecord
{
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
	public void Read(BinaryReader reader)
	{
		int length = (int)super.getRecordSizeBytes() - 6; //Size without RecordSize and RecordType field
		if (length > 0)
		{
			this.setData(reader.ReadBytes(length));
		}
	}
}