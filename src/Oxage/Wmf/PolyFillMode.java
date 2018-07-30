package Oxage.Wmf;

public enum PolyFillMode
{
	ALTERNATE(0x0001),
	WINDING(0x0002);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, PolyFillMode> mappings;
	private static java.util.HashMap<Integer, PolyFillMode> getMappings()
	{
		if (mappings == null)
		{
			synchronized (PolyFillMode.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, PolyFillMode>();
				}
			}
		}
		return mappings;
	}

	private PolyFillMode(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static PolyFillMode forValue(int value)
	{
		return getMappings().get(value);
	}
}