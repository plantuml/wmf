package Oxage.Wmf;

public enum FamilyFont
{
	FF_DONTCARE(0x00),
	FF_ROMAN(0x01),
	FF_SWISS(0x02),
	FF_MODERN(0x03),
	FF_SCRIPT(0x04),
	FF_DECORATIVE(0x05);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, FamilyFont> mappings;
	private static java.util.HashMap<Integer, FamilyFont> getMappings()
	{
		if (mappings == null)
		{
			synchronized (FamilyFont.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, FamilyFont>();
				}
			}
		}
		return mappings;
	}

	private FamilyFont(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static FamilyFont forValue(int value)
	{
		return getMappings().get(value);
	}
}