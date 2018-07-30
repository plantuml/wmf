package Oxage.Wmf;

public enum MapMode
{
	MM_TEXT(0x0001),
	MM_LOMETRIC(0x0002),
	MM_HIMETRIC(0x0003),
	MM_LOENGLISH(0x0004),
	MM_HIENGLISH(0x0005),
	MM_TWIPS(0x0006),
	MM_ISOTROPIC(0x0007),
	MM_ANISOTROPIC(0x0008);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, MapMode> mappings;
	private static java.util.HashMap<Integer, MapMode> getMappings()
	{
		if (mappings == null)
		{
			synchronized (MapMode.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, MapMode>();
				}
			}
		}
		return mappings;
	}

	private MapMode(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static MapMode forValue(int value)
	{
		return getMappings().get(value);
	}
}