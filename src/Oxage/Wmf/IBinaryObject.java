package Oxage.Wmf;

public interface IBinaryObject
{
	int GetSize();
	void Read(BinaryReader reader);
	void Write(BinaryWriter writer);
	String Dump();
}