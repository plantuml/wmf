package Oxage.Wmf;

public enum PostScriptJoin
{
	PostScriptNotSet(-2),
	PostScriptGdiJoin(-1),
	PostScriptMiterJoin(0),
	PostScriptRoundJoin(1),
	PostScriptBevelJoin(2);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, PostScriptJoin> mappings;
	private static java.util.HashMap<Integer, PostScriptJoin> getMappings()
	{
		if (mappings == null)
		{
			synchronized (PostScriptJoin.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, PostScriptJoin>();
				}
			}
		}
		return mappings;
	}

	private PostScriptJoin(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static PostScriptJoin forValue(int value)
	{
		return getMappings().get(value);
	}
}