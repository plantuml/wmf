package Oxage.Wmf;

public enum LogicalColorSpace
{
	LCS_CALIBRATED_RGB(0x00000000),
	LCS_sRGB(0x73524742),
	LCS_WINDOWS_COLOR_SPACE(0x57696E20);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, LogicalColorSpace> mappings;
	private static java.util.HashMap<Integer, LogicalColorSpace> getMappings()
	{
		if (mappings == null)
		{
			synchronized (LogicalColorSpace.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, LogicalColorSpace>();
				}
			}
		}
		return mappings;
	}

	private LogicalColorSpace(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static LogicalColorSpace forValue(int value)
	{
		return getMappings().get(value);
	}
}