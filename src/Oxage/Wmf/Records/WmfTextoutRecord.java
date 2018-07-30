package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_TEXTOUT, SizeIsVariable = true)] public class WmfTextoutRecord : WmfBinaryRecord
public class WmfTextoutRecord extends WmfBinaryRecord
{
	public WmfTextoutRecord()
	{
		super();
	}

	private short StringLength;
	public final short getStringLength()
	{
		return StringLength;
	}
	public final void setStringLength(short value)
	{
		StringLength = value;
	}

	private String StringValue;
	public final String getStringValue()
	{
		return StringValue;
	}
	public final void setStringValue(String value)
	{
		StringValue = value;
	}

	private short YStart;
	public final short getYStart()
	{
		return YStart;
	}
	public final void setYStart(short value)
	{
		YStart = value;
	}

	private short XStart;
	public final short getXStart()
	{
		return XStart;
	}
	public final void setXStart(short value)
	{
		XStart = value;
	}

	protected final Encoding getStringEncoding()
	{
		return WmfHelper.GetAnsiEncoding();
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setStringLength(reader.ReadInt16());

		if (this.getStringLength() > 0)
		{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] ansi = reader.ReadBytes(this.StringLength);
			byte[] ansi = reader.ReadBytes(this.getStringLength());
			this.setStringValue(getStringEncoding().GetString(ansi));
		}

		this.setYStart(reader.ReadInt16());
		this.setXStart(reader.ReadInt16());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		String tempVar = this.getStringValue();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] ansi = getStringEncoding().GetBytes((tempVar != null) ? tempVar : "");
		byte[] ansi = getStringEncoding().GetBytes((tempVar != null) ? tempVar : "");
		int offset = (ansi.length % 2 == 1 ? +1 : +0); //1 extra byte for odd-length string

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: base.RecordSizeBytes = (uint)(6 + 2 + (ansi.Length + offset) + 2 + 2);
		super.setRecordSizeBytes((int)(6 + 2 + (ansi.length + offset) + 2 + 2));
		super.Write(writer);

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getStringLength() > 0 ? this.getStringLength() : (short)(ansi.length + offset));
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, ansi);

		if (ansi.length % 2 == 1)
		{
			//Write a dummy byte after odd-length string so the record aligns to 16-bit boundary
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)0x00);
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)0x00);
		}

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getYStart());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getXStart());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("StringLength: " + this.getStringLength() + "\r\n");
		builder.append("String: " + this.getStringValue() + "\r\n");
		builder.append("YStart: " + this.getYStart() + "\r\n");
		builder.append("XStart: " + this.getXStart() + "\r\n");
	}
}