package Oxage.Wmf;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [AttributeUsage(AttributeTargets.Class, Inherited = true, AllowMultiple = false)] public sealed class WmfRecordAttribute : Attribute
public final class WmfRecordAttribute extends Attribute
{
	public WmfRecordAttribute()
	{
	}

	/** 
	 Gets or sets a record type (aka record function)
	*/
	private RecordType Type = RecordType.values()[0];
	public RecordType getType()
	{
		return Type;
	}
	public void setType(RecordType value)
	{
		Type = value;
	}

	/** 
	 Gets or sets record size in WORDs (number of 16-bit segments)
	*/
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint Size;
	private int Size;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getSize()
	public int getSize()
	{
		return Size;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setSize(uint value)
	public void setSize(int value)
	{
		Size = value;
	}

	/** 
	 Gets or sets if the size is defined as variable (false by default)
	*/
	private boolean SizeIsVariable;
	public boolean getSizeIsVariable()
	{
		return SizeIsVariable;
	}
	public void setSizeIsVariable(boolean value)
	{
		SizeIsVariable = value;
	}
}