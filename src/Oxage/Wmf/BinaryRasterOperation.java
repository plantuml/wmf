package Oxage.Wmf;

public enum BinaryRasterOperation
{
	R2_BLACK(0x0001),
	R2_NOTMERGEPEN(0x0002),
	R2_MASKNOTPEN(0x0003),
	R2_NOTCOPYPEN(0x0004),
	R2_MASKPENNOT(0x0005),
	R2_NOT(0x0006),
	R2_XORPEN(0x0007),
	R2_NOTMASKPEN(0x0008),
	R2_MASKPEN(0x0009),
	R2_NOTXORPEN(0x000A),
	R2_NOP(0x000B),
	R2_MERGENOTPEN(0x000C),
	R2_COPYPEN(0x000D),
	R2_MERGEPENNOT(0x000E),
	R2_MERGEPEN(0x000F),
	R2_WHITE(0x0010);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, BinaryRasterOperation> mappings;
	private static java.util.HashMap<Integer, BinaryRasterOperation> getMappings()
	{
		if (mappings == null)
		{
			synchronized (BinaryRasterOperation.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, BinaryRasterOperation>();
				}
			}
		}
		return mappings;
	}

	private BinaryRasterOperation(int value)
	{
		intValue = value;
		getMappings().put(value, this);
	}

	public int getValue()
	{
		return intValue;
	}

	public static BinaryRasterOperation forValue(int value)
	{
		return getMappings().get(value);
	}
}