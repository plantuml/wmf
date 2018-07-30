package Oxage.Wmf;

public enum ExtTextOutOptions
{
	ETO_OPAQUE(0x0002),
	ETO_CLIPPED(0x0004),
	ETO_GLYPH_INDEX(0x0010),
	ETO_RTLREADING(0x0080),
	ETO_NUMERICSLOCAL(0x0400),
	ETO_NUMERICSLATIN(0x0800),
	ETO_IGNORELANGUAGE(0x1000),
	ETO_PDY(0x2000);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, ExtTextOutOptions> mappings;
	private static java.util.HashMap<Integer, ExtTextOutOptions> getMappings()
	{
		if (mappings == null)
		{
			synchronized (ExtTextOutOptions.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, ExtTextOutOptions>();
				}
			}
		}
		return mappings;
	}

	private ExtTextOutOptions(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static ExtTextOutOptions forValue(int value)
	{
		return getMappings().get(value);
	}
}