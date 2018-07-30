package Oxage.Wmf;

public enum CharacterSet
{
	ANSI_CHARSET(0x00000000),
	DEFAULT_CHARSET(0x00000001),
	SYMBOL_CHARSET(0x00000002),
	MAC_CHARSET(0x0000004D),
	SHIFTJIS_CHARSET(0x00000080),
	HANGUL_CHARSET(0x00000081),
	JOHAB_CHARSET(0x00000082),
	GB2312_CHARSET(0x00000086),
	CHINESEBIG5_CHARSET(0x00000088),
	GREEK_CHARSET(0x000000A1),
	TURKISH_CHARSET(0x000000A2),
	VIETNAMESE_CHARSET(0x000000A3),
	HEBREW_CHARSET(0x000000B1),
	ARABIC_CHARSET(0x000000B2),
	BALTIC_CHARSET(0x000000BA),
	RUSSIAN_CHARSET(0x000000CC),
	THAI_CHARSET(0x000000DE),
	EASTEUROPE_CHARSET(0x000000EE),
	OEM_CHARSET(0x000000FF);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, CharacterSet> mappings;
	private static java.util.HashMap<Integer, CharacterSet> getMappings()
	{
		if (mappings == null)
		{
			synchronized (CharacterSet.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, CharacterSet>();
				}
			}
		}
		return mappings;
	}

	private CharacterSet(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static CharacterSet forValue(int value)
	{
		return getMappings().get(value);
	}
}