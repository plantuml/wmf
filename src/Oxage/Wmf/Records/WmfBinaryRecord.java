package Oxage.Wmf.Records;

import Oxage.Wmf.*;

/** 
 Implements a WMF META record. Each inherited record should also define WmfRecordAttribute above the class definition.
 NOTE: Always inherit META record directly from this class to avoid conflicts with different WmfRecordAttribute values.
*/
public abstract class WmfBinaryRecord implements IBinaryRecord
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Constructor
	public WmfBinaryRecord()
	{
		Object tempVar = Attribute.GetCustomAttribute(this.getClass(), WmfRecordAttribute.class);
		WmfRecordAttribute attribute = tempVar instanceof WmfRecordAttribute ? (WmfRecordAttribute)tempVar : null;
		if (attribute != null)
		{
			this.setRecordType(attribute.getType());
			if (!attribute.getSizeIsVariable())
			{
				this.setRecordSize(attribute.getSize());
			}
		}
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Public properties
	/** 
	 Gets or sets record length in 16-bit words.
	*/
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint RecordSize;
	private int RecordSize;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getRecordSize()
	public final int getRecordSize()
	{
		return RecordSize;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setRecordSize(uint value)
	public final void setRecordSize(int value)
	{
		RecordSize = value;
	}

	/** 
	 Gets or sets record length in bytes.
	*/
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getRecordSizeBytes()
	public final int getRecordSizeBytes()
	{
		return this.getRecordSize() * 2;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setRecordSizeBytes(uint value)
	public final void setRecordSizeBytes(int value)
	{
		this.setRecordSize(value / 2);
	}

	/** 
	 Gets or sets record type (aka RecordFunction)
	*/
	private RecordType RecordType = getRecordType().values()[0];
	public final RecordType getRecordType()
	{
		return RecordType;
	}
	public final void setRecordType(RecordType value)
	{
		RecordType = value;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Public methods
	@Override
	public String toString()
	{
		String tempVar = Dump();
		return (tempVar != null) ? tempVar : this.getRecordType().toString();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region IBinaryRecord Members
	/** 
	 Reads a record from binary stream. If this method is not overridden it will skip this record and go to next record.
	 NOTE: When overriding this method remove the base.Read(reader) line from code.
	 
	 @param reader
	*/
	public void Read(BinaryReader reader)
	{
		//RecordSize and RecordType should already be set by WmfReader

		//Skip record if not overridden
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: var length = this.RecordSizeBytes - 6;
		int length = this.getRecordSizeBytes() - 6; //Size without RecordSize and RecordType field
		if (length > 0)
		{
			reader.BaseStream.Seek(0, SeekOrigin.Current);
		}
	}

	/** 
	 Writes a record to binary stream. This method must be overridden if RecordSize > 3 and
	 should include base.Write(writer) in overridden method (unlike Read where base method
	 should be removed)
	 
	 @param writer
	*/
	public void Write(BinaryWriter writer)
	{
		if (this.getRecordSize() < 3)
		{
			throw new WmfException("RecordSize cannot be lower than 3 WORDs! Record: " + this.getClass());
		}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((uint)this.RecordSize);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (int)this.getRecordSize());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.RecordType);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getRecordType().getValue());
	}

	public final String Dump()
	{
		StringBuilder builder = new StringBuilder();
		Dump(builder);
		return builder.toString();
	}

	protected void Dump(StringBuilder builder)
	{
		builder.append(String.format("== %1$s ==", this.getClass().getSimpleName())).append("\r\n");
		builder.append(String.format("RecordSize: %1$s words = %2$s bytes", this.getRecordSize(), this.getRecordSizeBytes())).append("\r\n");
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: builder.AppendFormat("RecordType: 0x{0:x4} (RecordType.{1})", (ushort)this.RecordType, this.RecordType.ToString()).AppendLine();
		builder.append(String.format("RecordType: 0x%04x (RecordType.%2$s)", (short)this.getRecordType().getValue(), this.getRecordType().toString())).append("\r\n");
		//Other fields should be added in overridden method
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}