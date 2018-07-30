package Oxage.Wmf.Records;

import Oxage.Wmf.Objects.*;
import Oxage.Wmf.*;

//NOTE: The attribute is commented because the records is not fully implemented and thus wont be present while parsing WMF document
//[WmfRecord(Type = RecordType.META_EXTTEXTOUT, SizeIsVariable = true)]
public class WmfExtTextoutRecord extends WmfBinaryRecord
{
	public WmfExtTextoutRecord()
	{
		super();
	}

	private short Y;
	public final short getY()
	{
		return Y;
	}
	public final void setY(short value)
	{
		Y = value;
	}

	private short X;
	public final short getX()
	{
		return X;
	}
	public final void setX(short value)
	{
		X = value;
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

	private ExtTextOutOptions fwOpts = ExtTextOutOptions.values()[0];
	public final ExtTextOutOptions getfwOpts()
	{
		return fwOpts;
	}
	public final void setfwOpts(ExtTextOutOptions value)
	{
		fwOpts = value;
	}

	private Rect Rectangle;
	public final Rect getRectangle()
	{
		return Rectangle;
	}
	public final void setRectangle(Rect value)
	{
		Rectangle = value;
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

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private byte[] Dx;
	private byte[] Dx;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public byte[] getDx()
	public final byte[] getDx()
	{
		return Dx;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setDx(byte[] value)
	public final void setDx(byte[] value)
	{
		Dx = value;
	}

	protected final Encoding getStringEncoding()
	{
		return WmfHelper.GetAnsiEncoding();
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setY(reader.ReadInt16());
		this.setX(reader.ReadInt16());
		this.setStringLength(reader.ReadInt16());
		this.setfwOpts(ExtTextOutOptions.forValue(reader.ReadUInt16()));

		//TODO: Rectangle is optional, what if empty?!
		this.setRectangle(new Rect());
		this.getRectangle().Read(reader);

		if (this.getStringLength() > 0)
		{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] ansi = reader.ReadBytes(this.StringLength);
			byte[] ansi = reader.ReadBytes(this.getStringLength());
			this.setStringValue(getStringEncoding().GetString(ansi));
		}

		//this.Dx = reader.ReadBytes(); //TODO: Number of bytes left
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		int dxLength = (this.getDx() != null ? this.getDx().length : 0);
		String tempVar = this.getStringValue();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] ansi = getStringEncoding().GetBytes((tempVar != null) ? tempVar : "");
		byte[] ansi = getStringEncoding().GetBytes((tempVar != null) ? tempVar : "");

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: base.RecordSizeBytes = (uint)(6 + 16 + ansi.Length + dxLength);
		super.setRecordSizeBytes((int)(6 + 16 + ansi.length + dxLength));
		super.Write(writer);

		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getY());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getX());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getStringLength() > 0 ? this.getStringLength() : (short)ansi.length);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.fwOpts);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getfwOpts().getValue());
		this.getRectangle().Write(writer); //TODO: Rectangle is optional, what if empty?!
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, ansi); //String (variable)

		//Dx is optional
		if (dxLength > 0)
		{
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getDx());
		}
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("Y: " + this.getY() + "\r\n");
		builder.append("X: " + this.getX() + "\r\n");
		builder.append("StringLength: " + this.getStringLength() + "\r\n");
		builder.append("fwOpts: " + this.getfwOpts() + "\r\n");

		builder.append("Rectangle: " + "\r\n");
		this.getRectangle().Dump(builder);

		builder.append("StringValue: " + this.getStringValue() + "\r\n");
		//builder.AppendLine("Dx: " + this.Dx);
	}
}