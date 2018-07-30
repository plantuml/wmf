package Oxage.Wmf;

public enum Layout
{
	/** 
	 Sets right-to-left as the default horizontal layout.
	*/
	LAYOUT_RTL(0x00000001),
	/** 
	 Sets bottom-to-top as the default horizontal layout.
	*/
	LAYOUT_BTT(0x00000002),
	/** 
	 Sets the default layout to vertical.
	*/
	LAYOUT_VBH(0x00000004),
	/** Disables any reflection (META_BITBLT and META_STRETCHBLT operations)
	*/
	LAYOUT_BITMAPORIENTATIONPRESERVED(0x00000008);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, Layout> mappings;
	private static java.util.HashMap<Integer, Layout> getMappings()
	{
		if (mappings == null)
		{
			synchronized (Layout.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, Layout>();
				}
			}
		}
		return mappings;
	}

	private Layout(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static Layout forValue(int value)
	{
		return getMappings().get(value);
	}
}