package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_CREATEFONTINDIRECT, SizeIsVariable = true)] public class WmfCreateFontIndirectRecord : WmfBinaryRecord
public class WmfCreateFontIndirectRecord extends WmfBinaryRecord
{
	public WmfCreateFontIndirectRecord()
	{
		super();
		this.setHeight((short)-48);
		this.setWeight((short)400);
		this.setCharSet(CharacterSet.ANSI_CHARSET);
		this.setOutPrecision(OutPrecision.OUT_TT_ONLY_PRECIS);
		this.setClipPrecision(ClipPrecision.CLIP_STROKE_PRECIS);
		this.setQuality(FontQuality.DEFAULT_QUALITY);
		this.setPitch(PitchFont.DEFAULT_PITCH);
		this.setFamily(FamilyFont.FF_DONTCARE);
	}

	private short Height;
	public final short getHeight()
	{
		return Height;
	}
	public final void setHeight(short value)
	{
		Height = value;
	}

	private short Width;
	public final short getWidth()
	{
		return Width;
	}
	public final void setWidth(short value)
	{
		Width = value;
	}

	private short Escapement;
	public final short getEscapement()
	{
		return Escapement;
	}
	public final void setEscapement(short value)
	{
		Escapement = value;
	}

	private short Orientation;
	public final short getOrientation()
	{
		return Orientation;
	}
	public final void setOrientation(short value)
	{
		Orientation = value;
	}

	private short Weight;
	public final short getWeight()
	{
		return Weight;
	}
	public final void setWeight(short value)
	{
		Weight = value;
	}

	private boolean Italic;
	public final boolean getItalic()
	{
		return Italic;
	}
	public final void setItalic(boolean value)
	{
		Italic = value;
	}

	private boolean Underline;
	public final boolean getUnderline()
	{
		return Underline;
	}
	public final void setUnderline(boolean value)
	{
		Underline = value;
	}

	private boolean StrikeOut;
	public final boolean getStrikeOut()
	{
		return StrikeOut;
	}
	public final void setStrikeOut(boolean value)
	{
		StrikeOut = value;
	}

	private CharacterSet CharSet = CharacterSet.values()[0];
	public final CharacterSet getCharSet()
	{
		return CharSet;
	}
	public final void setCharSet(CharacterSet value)
	{
		CharSet = value;
	}

	private OutPrecision OutPrecision = getOutPrecision().values()[0];
	public final OutPrecision getOutPrecision()
	{
		return OutPrecision;
	}
	public final void setOutPrecision(OutPrecision value)
	{
		OutPrecision = value;
	}

	private ClipPrecision ClipPrecision = getClipPrecision().values()[0];
	public final ClipPrecision getClipPrecision()
	{
		return ClipPrecision;
	}
	public final void setClipPrecision(ClipPrecision value)
	{
		ClipPrecision = value;
	}

	private FontQuality Quality = FontQuality.values()[0];
	public final FontQuality getQuality()
	{
		return Quality;
	}
	public final void setQuality(FontQuality value)
	{
		Quality = value;
	}

	private PitchFont Pitch = PitchFont.values()[0];
	public final PitchFont getPitch()
	{
		return Pitch;
	}
	public final void setPitch(PitchFont value)
	{
		Pitch = value;
	}

	private FamilyFont Family = FamilyFont.values()[0];
	public final FamilyFont getFamily()
	{
		return Family;
	}
	public final void setFamily(FamilyFont value)
	{
		Family = value;
	}

	private String FaceName;
	public final String getFaceName()
	{
		return FaceName;
	}
	public final void setFaceName(String value)
	{
		FaceName = value;
	}

	protected final Encoding getAnsiEncoding()
	{
		return WmfHelper.GetAnsiEncoding();
	}

	@Override
	public void Read(BinaryReader reader)
	{
		//Read parameters
		this.setHeight(reader.ReadInt16());
		this.setWidth(reader.ReadInt16());
		this.setEscapement(reader.ReadInt16());
		this.setOrientation(reader.ReadInt16());
		this.setWeight(reader.ReadInt16());
		this.setItalic((reader.ReadByte() == 0x01));
		this.setUnderline((reader.ReadByte() == 0x01));
		this.setStrikeOut((reader.ReadByte() == 0x01));
		this.setCharSet(CharacterSet.forValue(reader.ReadByte()));
		this.setOutPrecision(OutPrecision.forValue(reader.ReadByte()));
		this.setClipPrecision(ClipPrecision.forValue(reader.ReadByte()));
		this.setQuality(FontQuality.forValue(reader.ReadByte()));

		//Read pitch and family
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte b = reader.ReadByte();
		byte b = reader.ReadByte();
		//TODO: Process pitch and family

		//Read font typeface name
		this.setFaceName(null);
		int left = (int)super.getRecordSizeBytes() - 6 - 18;
		if (left > 0)
		{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] buffer = reader.ReadBytes(left);
			byte[] buffer = reader.ReadBytes(left);
			this.setFaceName(getAnsiEncoding().GetString(buffer));
		}
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		//Get font typeface name as byte array of ANSI chars
		String tempVar = this.getFaceName();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] ansi = getAnsiEncoding().GetBytes((tempVar != null) ? tempVar : "");
		byte[] ansi = getAnsiEncoding().GetBytes((tempVar != null) ? tempVar : "");
		if (ansi.length > 32)
		{
			throw new WmfException("Font typeface name must not exceed 32 chars including the null-terminated char.");
		}

		//Calculate record length
		int length = 4 + 2 + 2 + 2 + 2 + 2 + 2 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + ansi.length; // ClipPrecision -  Underline -  Orientation -  Width -  RecordFunction

		int padding = length % 2 == 1 ? 1 : 0;
		int words = length / 2 + padding;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: base.RecordSize = (uint)words;
		super.setRecordSize((int)words);

		//Write length and function
		super.Write(writer);

		//Write initial parameters
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getHeight());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getWidth());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getEscapement());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getOrientation());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getWeight());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)(this.Italic ? 0x01 : 0x00));
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)(this.getItalic() ? 0x01 : 0x00));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)(this.Underline ? 0x01 : 0x00));
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)(this.getUnderline() ? 0x01 : 0x00));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)(this.StrikeOut ? 0x01 : 0x00));
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)(this.getStrikeOut() ? 0x01 : 0x00));
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)this.CharSet);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)this.getCharSet().getValue());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)this.OutPrecision);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)this.getOutPrecision().getValue());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)this.ClipPrecision);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)this.getClipPrecision().getValue());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((byte)this.Quality);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (byte)this.getQuality().getValue());

		//Write pitch and family - two parameters combined in one byte
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte p = (byte)this.Pitch;
		byte p = (byte)this.getPitch().getValue();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte f = (byte)this.Family;
		byte f = (byte)this.getFamily().getValue();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte b = (byte)(((f << 4) & 0xF0) | (p & 0x0F));
		byte b = (byte)(((f << 4) & 0xF0) | (p & 0x0F)); //TODO: Check, not sure if 'f' and 'p' are in right order, should be swapped?
		//byte b = (byte)(((p << 4) & 0xF0) | (f & 0x0F)); //Uncomment this if line above does not work
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, b);

		//Write font typeface name
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, ansi);

		//Write empty bytes for padding - align to 16-bit word boundary
		if (padding > 0)
		{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write(new byte[padding]);
			Oxage.Wmf.BinaryWriterExtensions.Write(writer, new byte[padding]);
		}
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("Height: " + this.getHeight() + "\r\n");
		builder.append("Width: " + this.getWidth() + "\r\n");
		builder.append("Escapement: " + this.getEscapement() + "\r\n");
		builder.append("Orientation: " + this.getOrientation() + "\r\n");
		builder.append("Weight: " + this.getWeight() + "\r\n");
		builder.append("Italic: " + this.getItalic() + "\r\n");
		builder.append("Underline: " + this.getUnderline() + "\r\n");
		builder.append("StrikeOut: " + this.getStrikeOut() + "\r\n");
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: builder.AppendFormat("CharSet: 0x{0:x4} (CharacterSet.{1})", (byte)this.CharSet, this.CharSet.ToString()).AppendLine();
		builder.append(String.format("CharSet: 0x%04x (CharacterSet.%2$s)", (byte)this.getCharSet().getValue(), this.getCharSet().toString())).append("\r\n");
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: builder.AppendFormat("OutPrecision: 0x{0:x2} (OutPrecision.{1})", (byte)this.OutPrecision, this.OutPrecision.ToString()).AppendLine();
		builder.append(String.format("OutPrecision: 0x%02x (OutPrecision.%2$s)", (byte)this.getOutPrecision().getValue(), this.getOutPrecision().toString())).append("\r\n");
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: builder.AppendFormat("ClipPrecision: 0x{0:x2} (ClipPrecision.{1})", (byte)this.ClipPrecision, this.ClipPrecision.ToString()).AppendLine();
		builder.append(String.format("ClipPrecision: 0x%02x (ClipPrecision.%2$s)", (byte)this.getClipPrecision().getValue(), this.getClipPrecision().toString())).append("\r\n");
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: builder.AppendFormat("Quality: 0x{0:x2} (FontQuality.{1})", (byte)this.Quality, this.Quality.ToString()).AppendLine();
		builder.append(String.format("Quality: 0x%02x (FontQuality.%2$s)", (byte)this.getQuality().getValue(), this.getQuality().toString())).append("\r\n");
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: builder.AppendFormat("Pitch: 0x{0:x2} (PitchFont.{1})", (byte)this.Pitch, this.Pitch.ToString()).AppendLine();
		builder.append(String.format("Pitch: 0x%02x (PitchFont.%2$s)", (byte)this.getPitch().getValue(), this.getPitch().toString())).append("\r\n");
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: builder.AppendFormat("Family: 0x{0:x2} (FamilyFont.{1})", (byte)this.Family, this.Family.ToString()).AppendLine();
		builder.append(String.format("Family: 0x%02x (FamilyFont.%2$s)", (byte)this.getFamily().getValue(), this.getFamily().toString())).append("\r\n");
		builder.append("Facename: " + this.getFaceName() + "\r\n");
	}
}