package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 8)] public class SizeL : WmfBinaryObject
public class SizeL extends WmfBinaryObject
{
	public SizeL()
	{
		super();
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint CX;
	private int CX;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getCX()
	public final int getCX()
	{
		return CX;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setCX(uint value)
	public final void setCX(int value)
	{
		CX = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint CY;
	private int CY;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getCY()
	public final int getCY()
	{
		return CY;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setCY(uint value)
	public final void setCY(int value)
	{
		CY = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setCX(reader.ReadUInt32());
		this.setCY(reader.ReadUInt32());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getCX());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getCY());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tcx: " + this.getCX() + "\r\n");
		builder.append("\tcy: " + this.getCY() + "\r\n");
	}
}