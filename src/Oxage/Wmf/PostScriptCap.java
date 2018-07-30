package Oxage.Wmf;

public enum PostScriptCap
{
	/** 
	 Do NOT use this value
	*/
	PostScriptGdiCap(-1),
	/** 
	 Squared ends of a line.
	*/
	PostscriptFlatCap(0),
	/** 
	 Circular ends of a line.
	*/
	PostScriptRoundCap(1),
	/** 
	 Squared ends of a line where center of the square is the same as line point.
	*/
	PostScriptSquareCap(2);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, PostScriptCap> mappings;
	private static java.util.HashMap<Integer, PostScriptCap> getMappings()
	{
		if (mappings == null)
		{
			synchronized (PostScriptCap.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, PostScriptCap>();
				}
			}
		}
		return mappings;
	}

	private PostScriptCap(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static PostScriptCap forValue(int value)
	{
		return getMappings().get(value);
	}
}