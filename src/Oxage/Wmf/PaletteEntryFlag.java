package Oxage.Wmf;

public class PaletteEntryFlag
{
	public static final PaletteEntryFlag PC_RESERVED = new PaletteEntryFlag(0x01);
	public static final PaletteEntryFlag PC_EXPLICIT = new PaletteEntryFlag(0x02);
	public static final PaletteEntryFlag PC_NOCOLLAPSE = new PaletteEntryFlag(0x04);

	public static final int SIZE = java.lang.Integer.SIZE;

	private int intValue;
	private static java.util.HashMap<Integer, PaletteEntryFlag> mappings;
	private static java.util.HashMap<Integer, PaletteEntryFlag> getMappings()
	{
		if (mappings == null)
		{
			synchronized (PaletteEntryFlag.class)
			{
				if (mappings == null)
				{
					mappings = new java.util.HashMap<Integer, PaletteEntryFlag>();
				}
			}
		}
		return mappings;
	}

	private PaletteEntryFlag(int value)
	{
		intValue = value;
		synchronized (PaletteEntryFlag.class)
		{
			getMappings().put(value, this);
		}
	}

	public int getValue()
	{
		return intValue;
	}

	public static PaletteEntryFlag forValue(int value)
	{
		synchronized (PaletteEntryFlag.class)
		{
			PaletteEntryFlag enumObj = getMappings().get(value);
			if (enumObj == null)
			{
				return new PaletteEntryFlag(value);
			}
			else
			{
				return enumObj;
			}
		}
	}
}