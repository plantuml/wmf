package Oxage.Wmf;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [AttributeUsage(AttributeTargets.Class, Inherited = true, AllowMultiple = false)] public sealed class WmfObjectAttribute : Attribute
public final class WmfObjectAttribute extends Attribute
{
	public WmfObjectAttribute()
	{
	}

	/** 
	 Gets or sets objects size in WORDs (number of 16-bit segments)
	*/
	private int Size;
	public int getSize()
	{
		return Size;
	}
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