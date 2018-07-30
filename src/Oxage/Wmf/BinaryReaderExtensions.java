package Oxage.Wmf;

public final class BinaryReaderExtensions
{
	public static <T extends IBinaryObject> T ReadWmfObject(BinaryReader reader)
	{
		T result = System.Activator.<T>CreateInstance();
		result.Read(reader);
		return result;
	}

	/** 
	 Skips excess bytes. Work-around for some WMF files that contain undocumented fields.
	 
	 @param reader
	 @param excess
	*/
	public static void Skip(BinaryReader reader, int excess)
	{
		if (excess > 0)
		{
			//Skip unknown bytes
			reader.BaseStream.Seek(excess, SeekOrigin.Current);
			//var dummy = reader.ReadBytes(excess);
		}
	}
}