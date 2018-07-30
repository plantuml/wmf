package Oxage.Wmf;

public enum PenStyle
{
	PS_COSMETIC(0x0000),
	PS_ENDCAP_ROUND(0x0000),
	PS_JOIN_ROUND(0x0000),
	PS_SOLID(0x0000),
	PS_DASH(0x0001),
	PS_DOT(0x0002),
	PS_DASHDOT(0x0003),
	PS_DASHDOTDOT(0x0004),
	PS_NULL(0x0005),
	PS_INSIDEFRAME(0x0006),
	PS_USERSTYLE(0x0007),
	PS_ALTERNATE(0x0008),
	PS_ENDCAP_SQUARE(0x0100),
	PS_ENDCAP_FLAT(0x0200),
	PS_JOIN_BEVEL(0x1000),
	PS_JOIN_MITER(0x2000);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, PenStyle> mappings;
	private static java.util.HashMap<Integer, PenStyle> getMappings()
	{
		if (mappings == null)
		{
			synchronized (PenStyle.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, PenStyle>();
				}
			}
		}
		return mappings;
	}

	private PenStyle(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static PenStyle forValue(int value)
	{
		return getMappings().get(value);
	}
}