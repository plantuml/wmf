package Oxage.Wmf;

public enum PostScriptFeatureSetting
{
	FEATURESETTING_NUP(0),
	FEATURESETTING_OUTPUT(1),
	FEATURESETTING_PSLEVEL(2),
	FEATURESETTING_CUSTPAPER(3),
	FEATURESETTING_MIRROR(4),
	FEATURESETTING_NEGATIVE(5),
	FEATURESETTING_PROTOCOL(6);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, PostScriptFeatureSetting> mappings;
	private static java.util.HashMap<Integer, PostScriptFeatureSetting> getMappings()
	{
		if (mappings == null)
		{
			synchronized (PostScriptFeatureSetting.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, PostScriptFeatureSetting>();
				}
			}
		}
		return mappings;
	}

	private PostScriptFeatureSetting(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static PostScriptFeatureSetting forValue(int value)
	{
		return getMappings().get(value);
	}
}