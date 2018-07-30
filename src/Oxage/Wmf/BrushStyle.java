package Oxage.Wmf;

public enum BrushStyle
{
	BS_SOLID(0x0000),
	BS_NULL(0x0001),
	BS_HATCHED(0x0002),
	BS_PATTERN(0x0003),
	BS_INDEXED(0x0004),
	BS_DIBPATTERN(0x0005),
	BS_DIBPATTERNPT(0x0006),
	BS_PATTERN8X8(0x0007),
	BS_DIBPATTERN8X8(0x0008),
	BS_MONOPATTERN(0x0009);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, BrushStyle> mappings;
	private static java.util.HashMap<Integer, BrushStyle> getMappings()
	{
		if (mappings == null)
		{
			synchronized (BrushStyle.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, BrushStyle>();
				}
			}
		}
		return mappings;
	}

	private BrushStyle(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static BrushStyle forValue(int value)
	{
		return getMappings().get(value);
	}
}