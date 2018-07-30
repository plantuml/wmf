package Oxage.Wmf;

public enum BitCount
{
	/** 
	 Bits per pixel is undefined, only for JPEG and PNG
	*/
	BI_BITCOUNT_0(0x0000),
	/** 
	 Monochrome
	*/
	BI_BITCOUNT_1(0x0001),
	/** 
	 16 colors
	*/
	BI_BITCOUNT_2(0x0004),
	/** 
	 256 colors
	*/
	BI_BITCOUNT_3(0x0008),
	/** 
	 16-bit colors
	*/
	BI_BITCOUNT_4(0x0010),
	/** 
	 24-bit colors
	*/
	BI_BITCOUNT_5(0x0018),
	/** 
	 24-bit colors
	*/
	BI_BITCOUNT_6(0x0020);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, BitCount> mappings;
	private static java.util.HashMap<Integer, BitCount> getMappings()
	{
		if (mappings == null)
		{
			synchronized (BitCount.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, BitCount>();
				}
			}
		}
		return mappings;
	}

	private BitCount(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static BitCount forValue(int value)
	{
		return getMappings().get(value);
	}
}