package Oxage.Wmf;

public enum ColorUsage
{
	DIB_RGB_COLORS(0x0000),
	DIB_PAL_COLORS(0x0001),
	DIB_PAL_INDICES(0x0002);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, ColorUsage> mappings;
	private static java.util.HashMap<Integer, ColorUsage> getMappings()
	{
		if (mappings == null)
		{
			synchronized (ColorUsage.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, ColorUsage>();
				}
			}
		}
		return mappings;
	}

	private ColorUsage(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static ColorUsage forValue(int value)
	{
		return getMappings().get(value);
	}
}