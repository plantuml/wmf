package Oxage.Wmf;

public enum ClipPrecision
{
	CLIP_DEFAULT_PRECIS(0x00000000),
	CLIP_CHARACTER_PRECIS(0x00000001),
	CLIP_STROKE_PRECIS(0x00000002),
	CLIP_LH_ANGLES(0x00000010),
	CLIP_TT_ALWAYS(0x00000020),
	CLIP_DFA_DISABLE(0x00000040),
	CLIP_EMBEDDED(0x00000080);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, ClipPrecision> mappings;
	private static java.util.HashMap<Integer, ClipPrecision> getMappings()
	{
		if (mappings == null)
		{
			synchronized (ClipPrecision.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, ClipPrecision>();
				}
			}
		}
		return mappings;
	}

	private ClipPrecision(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static ClipPrecision forValue(int value)
	{
		return getMappings().get(value);
	}
}