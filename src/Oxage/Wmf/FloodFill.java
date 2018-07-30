package Oxage.Wmf;

public enum FloodFill
{
	FLOODFILLBORDER(0x0000),
	FLOODFILLSURFACE(0x0001);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, FloodFill> mappings;
	private static java.util.HashMap<Integer, FloodFill> getMappings()
	{
		if (mappings == null)
		{
			synchronized (FloodFill.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, FloodFill>();
				}
			}
		}
		return mappings;
	}

	private FloodFill(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static FloodFill forValue(int value)
	{
		return getMappings().get(value);
	}
}