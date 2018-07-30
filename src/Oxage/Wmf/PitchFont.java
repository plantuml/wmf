package Oxage.Wmf;

public enum PitchFont
{
	DEFAULT_PITCH(0),
	FIXED_PITCH(1),
	VARIABLE_PITCH(2);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, PitchFont> mappings;
	private static java.util.HashMap<Integer, PitchFont> getMappings()
	{
		if (mappings == null)
		{
			synchronized (PitchFont.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, PitchFont>();
				}
			}
		}
		return mappings;
	}

	private PitchFont(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static PitchFont forValue(int value)
	{
		return getMappings().get(value);
	}
}