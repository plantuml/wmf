package Oxage.Wmf;

public enum Compression
{
	BI_RGB(0x0000),
	BI_RLE8(0x0001),
	BI_RLE4(0x0002),
	BI_BITFIELDS(0x0003),
	BI_JPEG(0x0004),
	BI_PNG(0x0005),
	BI_CMYK(0x000B),
	BI_CMYKRLE8(0x000C),
	BI_CMYKRLE4(0x000D);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, Compression> mappings;
	private static java.util.HashMap<Integer, Compression> getMappings()
	{
		if (mappings == null)
		{
			synchronized (Compression.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, Compression>();
				}
			}
		}
		return mappings;
	}

	private Compression(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static Compression forValue(int value)
	{
		return getMappings().get(value);
	}
}