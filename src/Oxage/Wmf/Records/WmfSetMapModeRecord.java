package Oxage.Wmf.Records;

import Oxage.Wmf.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [WmfRecord(Type = RecordType.META_SETMAPMODE, Size = 4)] public class WmfSetMapModeRecord : WmfBinaryRecord
public class WmfSetMapModeRecord extends WmfBinaryRecord
{
	public WmfSetMapModeRecord()
	{
		super();
		//Most compatible mode (WMF Specifications, Structure Examples on page 192)
		this.setMode(MapMode.MM_ANISOTROPIC);
	}

	private MapMode Mode = MapMode.values()[0];
	public final MapMode getMode()
	{
		return Mode;
	}
	public final void setMode(MapMode value)
	{
		Mode = value;
	}

	@Override
	public void Read(BinaryReader reader)
	{
		this.setMode(MapMode.forValue(reader.ReadUInt16()));
	}

	@Override
	public void Write(BinaryWriter writer)
	{
		super.Write(writer);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: writer.Write((ushort)this.Mode);
		Oxage.Wmf.BinaryWriterExtensions.Write(writer, (short)this.getMode().getValue());
	}

	@Override
	protected void Dump(StringBuilder builder)
	{
		super.Dump(builder);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: builder.AppendFormat("MapMode: 0x{0:x4} (MapMode.{1})", (ushort)this.Mode, this.Mode.ToString()).AppendLine();
		builder.append(String.format("MapMode: 0x%04x (MapMode.%2$s)", (short)this.getMode().getValue(), this.getMode().toString())).append("\r\n");
	}
}