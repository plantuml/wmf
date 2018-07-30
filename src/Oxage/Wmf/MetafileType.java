package Oxage.Wmf;

public enum MetafileType
{
	/** 
	 Metafile is stored in memory.
	*/
	MEMORYMETAFILE(0x0001),
	/** 
	 Metafile is stored on disk.
	*/
	DISKMETAFILE(0x0002);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, MetafileType> mappings;
	private static java.util.HashMap<Integer, MetafileType> getMappings()
	{
		if (mappings == null)
		{
			synchronized (MetafileType.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, MetafileType>();
				}
			}
		}
		return mappings;
	}

	private MetafileType(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static MetafileType forValue(int value)
	{
		return getMappings().get(value);
	}
}