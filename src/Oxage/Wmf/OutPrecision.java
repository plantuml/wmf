package Oxage.Wmf;

public enum OutPrecision
{
	OUT_DEFAULT_PRECIS(0x00000000),
	OUT_STRING_PRECIS(0x00000001),
	OUT_CHARACTER_PRECIS(0x00000002),
	OUT_STROKE_PRECIS(0x00000003),
	OUT_TT_PRECIS(0x00000004),
	OUT_DEVICE_PRECIS(0x00000005),
	OUT_RASTER_PRECIS(0x00000006),
	OUT_TT_ONLY_PRECIS(0x00000007),
	OUT_OUTLINE_PRECIS(0x00000008),
	OUT_SCREEN_OUTLINE_PRECIS(0x00000009),
	OUT_PS_ONLY_PRECIS(0x0000000A);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, OutPrecision> mappings;
	private static java.util.HashMap<Integer, OutPrecision> getMappings()
	{
		if (mappings == null)
		{
			synchronized (OutPrecision.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, OutPrecision>();
				}
			}
		}
		return mappings;
	}

	private OutPrecision(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static OutPrecision forValue(int value)
	{
		return getMappings().get(value);
	}
}