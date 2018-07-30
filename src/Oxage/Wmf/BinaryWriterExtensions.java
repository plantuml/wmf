package Oxage.Wmf;

public final class BinaryWriterExtensions
{
	public static <T extends IBinaryObject> void Write(BinaryWriter writer, T obj)
	{
		obj.Write(writer);
	}
}