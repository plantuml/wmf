package Oxage.Wmf.Records;

import Oxage.Wmf.*;

public class WmfHeader implements IBinaryRecord
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Constructor
	public WmfHeader()
	{
		this.setType(MetafileType.MEMORYMETAFILE);
		this.setHeaderSize((short)9);
		this.setVersion((short)0x0300);
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Public properties
	private MetafileType Type = MetafileType.values()[0];
	public final MetafileType getType()
	{
		return Type;
	}
	public final void setType(MetafileType value)
	{
		Type = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort HeaderSize;
	private short HeaderSize;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getHeaderSize()
	public final short getHeaderSize()
	{
		return HeaderSize;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setHeaderSize(ushort value)
	public final void setHeaderSize(short value)
	{
		HeaderSize = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort Version;
	private short Version;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getVersion()
	public final short getVersion()
	{
		return Version;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setVersion(ushort value)
	public final void setVersion(short value)
	{
		Version = value;
	}

	/** 
	 Gets or sets number of WORDs in the entire WMF.
	*/
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint FileSize;
	private int FileSize;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getFileSize()
	public final int getFileSize()
	{
		return FileSize;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setFileSize(uint value)
	public final void setFileSize(int value)
	{
		FileSize = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort NumberOfObjects;
	private short NumberOfObjects;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getNumberOfObjects()
	public final short getNumberOfObjects()
	{
		return NumberOfObjects;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setNumberOfObjects(ushort value)
	public final void setNumberOfObjects(short value)
	{
		NumberOfObjects = value;
	}

	/** 
	 Gets or sets size in WORDs of the largest record in WMF.
	*/
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint MaxRecord;
	private int MaxRecord;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getMaxRecord()
	public final int getMaxRecord()
	{
		return MaxRecord;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setMaxRecord(uint value)
	public final void setMaxRecord(int value)
	{
		MaxRecord = value;
	}

	/** 
	 Gets or sets number of members. This value should always be 0x0000 according to the WMF specification.
	*/
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private ushort NumberOfMembers;
	private short NumberOfMembers;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public ushort getNumberOfMembers()
	public final short getNumberOfMembers()
	{
		return NumberOfMembers;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setNumberOfMembers(ushort value)
	public final void setNumberOfMembers(short value)
	{
		NumberOfMembers = value;
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region Public methods
	@Override
	public String toString()
	{
		return Dump();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region IBinaryRecord Members
	public final void Read(BinaryReader reader)
	{
		this.setType(MetafileType.forValue(reader.ReadUInt16()));
		this.setHeaderSize(reader.ReadUInt16());
		this.setVersion(reader.ReadUInt16());
		this.setFileSize(reader.ReadUInt32());
		this.setNumberOfObjects(reader.ReadUInt16());
		this.setMaxRecord(reader.ReadUInt32());
		this.setNumberOfMembers(reader.ReadUInt16());
	}

	public final void Write(BinaryWriter writer)
	{
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.Type);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getType().getValue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getHeaderSize());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getVersion());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getFileSize());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getNumberOfObjects());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getMaxRecord());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getNumberOfMembers());
	}

	public final String Dump()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("== WmfHeader ==" + "\r\n");
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: builder.AppendFormat("Type: 0x{0:x4} (MetafileType.{1})", (ushort)this.Type, this.Type.ToString()).AppendLine();
		builder.append(String.format("Type: 0x%04x (MetafileType.%2$s)", (short)this.getType().getValue(), this.getType().toString())).append("\r\n");
		builder.append(String.format("HeaderSize: %1$s", this.getHeaderSize())).append("\r\n");
		builder.append(String.format("Version: 0x%04x", this.getVersion())).append("\r\n");
		builder.append(String.format("FileSize: %1$s words = %2$s bytes", this.getFileSize(), this.getFileSize() * 2)).append("\r\n");
		builder.append(String.format("NumberOfObjects: %1$s", this.getNumberOfObjects())).append("\r\n");
		builder.append(String.format("MaxRecord: %1$s words = %2$s bytes", this.getMaxRecord(), this.getMaxRecord() * 2)).append("\r\n");
		builder.append(String.format("NumberOfMembers: %1$s", this.getNumberOfMembers())).append("\r\n");
		return builder.toString();
	}
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion
}