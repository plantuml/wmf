package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 12)] public class CIEXYZ : WmfBinaryObject
public class CIEXYZ extends WmfBinaryObject
{
	public CIEXYZ()
	{
		super();
	}

	private float X;
	public final float getX()
	{
		return X;
	}
	public final void setX(float value)
	{
		X = value;
	}

	private float Y;
	public final float getY()
	{
		return Y;
	}
	public final void setY(float value)
	{
		Y = value;
	}

	private float Z;
	public final float getZ()
	{
		return Z;
	}
	public final void setZ(float value)
	{
		Z = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setX(reader.ReadSingle());
		this.setY(reader.ReadSingle());
		this.setZ(reader.ReadSingle());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getX());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getY());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getZ());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tciexyzX: " + this.getX() + "\r\n");
		builder.append("\tciexyzY: " + this.getY() + "\r\n");
		builder.append("\tciexyzZ: " + this.getZ() + "\r\n");
	}
}