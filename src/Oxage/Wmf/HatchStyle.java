package Oxage.Wmf;

public enum HatchStyle
{
	HS_HORIZONTAL(0x0000),
	HS_VERTICAL(0x0001),
	HS_FDIAGONAL(0x0002),
	HS_BDIAGONAL(0x0003),
	HS_CROSS(0x0004),
	HS_DIAGCROSS(0x0005);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, HatchStyle> mappings;
	private static java.util.HashMap<Integer, HatchStyle> getMappings()
	{
		if (mappings == null)
		{
			synchronized (HatchStyle.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, HatchStyle>();
				}
			}
		}
		return mappings;
	}

	private HatchStyle(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static HatchStyle forValue(int value)
	{
		return getMappings().get(value);
	}
}