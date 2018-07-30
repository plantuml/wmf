package Oxage.Wmf;

public enum StretchMode
{
	BLACKONWHITE(0x0001),
	WHITEONBLACK(0x0002),
	COLORONCOLOR(0x0003),
	HALFTONE(0x0004);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, StretchMode> mappings;
	private static java.util.HashMap<Integer, StretchMode> getMappings()
	{
		if (mappings == null)
		{
			synchronized (StretchMode.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, StretchMode>();
				}
			}
		}
		return mappings;
	}

	private StretchMode(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static StretchMode forValue(int value)
	{
		return getMappings().get(value);
	}
}