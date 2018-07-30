package Oxage.Wmf;

public enum TextAlignmentMode
{
	TA_NOUPDATECP(0x0000),
	TA_LEFT(0x0000),
	TA_TOP(0x0000),
	TA_UPDATECP(0x0001),
	TA_RIGHT(0x0002),
	TA_CENTER(0x0006),
	TA_BOTTOM(0x0008),
	TA_BASELINE(0x0018),
	TA_RTLREADING(0x0100),
	VTA_TOP(0x0000),
	VTA_RIGHT(0x0000),
	VTA_BOTTOM(0x0002),
	VTA_CENTER(0x0006),
	VTA_LEFT(0x0008),
	VTA_BASELINE(0x0018);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, TextAlignmentMode> mappings;
	private static java.util.HashMap<Integer, TextAlignmentMode> getMappings()
	{
		if (mappings == null)
		{
			synchronized (TextAlignmentMode.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, TextAlignmentMode>();
				}
			}
		}
		return mappings;
	}

	private TextAlignmentMode(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static TextAlignmentMode forValue(int value)
	{
		return getMappings().get(value);
	}
}