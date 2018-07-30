package Oxage.Wmf;

public interface IBinaryRecord
{
	void Read(BinaryReader reader);
	void Write(BinaryWriter writer);
	String Dump();
}