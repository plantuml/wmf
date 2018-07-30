package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfObject(Size = 124)] public class BitmapV5Header : WmfBinaryObject
public class BitmapV5Header extends WmfBinaryObject
{
	public BitmapV5Header()
	{
		super();
		this.setBitmapV4Header(new BitmapV4Header());
	}

	private BitmapV4Header BitmapV4Header;
	public final BitmapV4Header getBitmapV4Header()
	{
		return BitmapV4Header;
	}
	public final void setBitmapV4Header(BitmapV4Header value)
	{
		BitmapV4Header = value;
	}

	private LogicalColorSpace Intent = LogicalColorSpace.values()[0];
	public final LogicalColorSpace getIntent()
	{
		return Intent;
	}
	public final void setIntent(LogicalColorSpace value)
	{
		Intent = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint ProfileData;
	private int ProfileData;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getProfileData()
	public final int getProfileData()
	{
		return ProfileData;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setProfileData(uint value)
	public final void setProfileData(int value)
	{
		ProfileData = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint ProfileSize;
	private int ProfileSize;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getProfileSize()
	public final int getProfileSize()
	{
		return ProfileSize;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setProfileSize(uint value)
	public final void setProfileSize(int value)
	{
		ProfileSize = value;
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private uint Reserved;
	private int Reserved;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public uint getReserved()
	public final int getReserved()
	{
		return Reserved;
	}
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public void setReserved(uint value)
	public final void setReserved(int value)
	{
		Reserved = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setBitmapV4Header(Oxage.Wmf.BinaryReaderExtensions.<BitmapV4Header>ReadWmfObject(reader));
		this.setIntent(LogicalColorSpace.forValue(reader.ReadUInt32()));
		this.setProfileData(reader.ReadUInt32());
		this.setProfileSize(reader.ReadUInt32());
		this.setReserved(reader.ReadUInt32());
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getBitmapV4Header());
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((uint)this.Intent);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (int)this.getIntent().getValue());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getProfileData());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getProfileSize());
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, this.getReserved());
	}

	@Override
	public void Dump(StringBuilder builder)
	{
		super.Dump(builder);
		builder.append("\tBitmapV4Header: " + "\r\n").append(this.getBitmapV4Header().Dump());
		builder.append("\tIntent: " + this.getIntent() + "\r\n");
		builder.append("\tProfileData: " + this.getProfileData() + "\r\n");
		builder.append("\tProfileSize: " + this.getProfileSize() + "\r\n");
		builder.append("\tReserved: " + this.getReserved() + "\r\n");
	}
}