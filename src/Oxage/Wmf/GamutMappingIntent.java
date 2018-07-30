package Oxage.Wmf;

public enum GamutMappingIntent
{
	LCS_GM_ABS_COLORIMETRIC(0x00000008),
	LCS_GM_BUSINESS(0x00000001),
	LCS_GM_GRAPHICS(0x00000002),
	LCS_GM_IMAGES(0x00000004);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, GamutMappingIntent> mappings;
	private static java.util.HashMap<Integer, GamutMappingIntent> getMappings()
	{
		if (mappings == null)
		{
			synchronized (GamutMappingIntent.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, GamutMappingIntent>();
				}
			}
		}
		return mappings;
	}

	private GamutMappingIntent(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static GamutMappingIntent forValue(int value)
	{
		return getMappings().get(value);
	}
}