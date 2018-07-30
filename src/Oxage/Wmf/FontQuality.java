package Oxage.Wmf;

public enum FontQuality
{
	DEFAULT_QUALITY(0x00),
	DRAFT_QUALITY(0x01),
	PROOF_QUALITY(0x02),
	NONANTIALIASED_QUALITY(0x03),
	ANTIALIASED_QUALITY(0x04),
	CLEARTYPE_QUALITY(0x05);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, FontQuality> mappings;
	private static java.util.HashMap<Integer, FontQuality> getMappings()
	{
		if (mappings == null)
		{
			synchronized (FontQuality.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, FontQuality>();
				}
			}
		}
		return mappings;
	}

	private FontQuality(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static FontQuality forValue(int value)
	{
		return getMappings().get(value);
	}
}