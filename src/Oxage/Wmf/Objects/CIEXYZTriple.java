package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 36)] public class CIEXYZTriple : WmfBinaryObject
public class CIEXYZTriple extends WmfBinaryObject
{
	public CIEXYZTriple()
	{
		super();
		this.setRed(new CIEXYZ());
		this.setGreen(new CIEXYZ());
		this.setBlue(new CIEXYZ());
	}

	private CIEXYZ Red;
	public final CIEXYZ getRed()
	{
		return Red;
	}
	public final void setRed(CIEXYZ value)
	{
		Red = value;
	}

	private CIEXYZ Green;
	public final CIEXYZ getGreen()
	{
		return Green;
	}
	public final void setGreen(CIEXYZ value)
	{
		Green = value;
	}

	private CIEXYZ Blue;
	public final CIEXYZ getBlue()
	{
		return Blue;
	}
	public final void setBlue(CIEXYZ value)
	{
		Blue = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setRed(Oxage.Wmf.BinaryReaderExtensions.<CIEXYZ>ReadWmfObject(reader));
		this.setGreen(Oxage.Wmf.BinaryReaderExtensions.<CIEXYZ>ReadWmfObject(reader));
		this.setBlue(Oxage.Wmf.BinaryReaderExtensions.<CIEXYZ>ReadWmfObject(reader));
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getRed());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getGreen());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBlue());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);

		builder.append("\tciexyzRed: " + "\r\n");
		this.getRed().Dump(builder);

		builder.append("\tciexyzGreen: " + "\r\n");
		this.getGreen().Dump(builder);

		builder.append("\tciexyzBlue: " + "\r\n");
		this.getBlue().Dump(builder);
	}
}