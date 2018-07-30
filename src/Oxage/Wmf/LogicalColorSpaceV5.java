package Oxage.Wmf;

public enum LogicalColorSpaceV5
{
	LCS_PROFILE_LINKED(0x4C494E4B),
	LCS_PROFILE_EMBEDDED(0x4D424544);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, LogicalColorSpaceV5> mappings;
	private static java.util.HashMap<Integer, LogicalColorSpaceV5> getMappings()
	{
		if (mappings == null)
		{
			synchronized (LogicalColorSpaceV5.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, LogicalColorSpaceV5>();
				}
			}
		}
		return mappings;
	}

	private LogicalColorSpaceV5(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static LogicalColorSpaceV5 forValue(int value)
	{
		return getMappings().get(value);
	}
}