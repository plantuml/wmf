package Oxage.Wmf;

public enum MetafileVersion
{
	/** 
	 DIBs are not supported.
	*/
	METAVERSION100(0x0100),
	/** 
	 DIBs are supported.
	*/
	METAVERSION300(0x0300);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, MetafileVersion> mappings;
	private static java.util.HashMap<Integer, MetafileVersion> getMappings()
	{
		if (mappings == null)
		{
			synchronized (MetafileVersion.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, MetafileVersion>();
				}
			}
		}
		return mappings;
	}

	private MetafileVersion(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static MetafileVersion forValue(int value)
	{
		return getMappings().get(value);
	}
}