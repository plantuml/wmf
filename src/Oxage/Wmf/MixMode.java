package Oxage.Wmf;

public enum MixMode
{
	/** 
	 Transparent background, no color fill.
	*/
	TRANSPARENT(0x0001),
	/** 
	 Solid color background filled before the text, pen, etc.
	*/
	OPAQUE(0x0002);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, MixMode> mappings;
	private static java.util.HashMap<Integer, MixMode> getMappings()
	{
		if (mappings == null)
		{
			synchronized (MixMode.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, MixMode>();
				}
			}
		}
		return mappings;
	}

	private MixMode(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static MixMode forValue(int value)
	{
		return getMappings().get(value);
	}
}