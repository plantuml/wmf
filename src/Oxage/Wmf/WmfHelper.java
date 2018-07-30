package Oxage.Wmf;

import Oxage.Wmf.Records.*;

public class WmfHelper
{
	public static IBinaryRecord GetRecordByType(RecordType rt)
	{
//C# TO JAVA CONVERTER TODO TASK: There is no equivalent to implicit typing in Java unless the Java 10 inferred typing option is selected:
		var types = WmfHelper.class.getPackage().GetTypes();

//C# TO JAVA CONVERTER TODO TASK: There is no equivalent to implicit typing in Java unless the Java 10 inferred typing option is selected:
		for (var type : types)
		{
			if (type.isAssignableFrom(IBinaryRecord.class))
			{
				Object tempVar = Attribute.GetCustomAttribute(type, WmfRecordAttribute.class);
				WmfRecordAttribute attribute = tempVar instanceof WmfRecordAttribute ? (WmfRecordAttribute)tempVar : null;
				if (attribute != null && attribute.getType() == rt)
				{
					Object tempVar2 = type.newInstance();
					IBinaryRecord record = tempVar2 instanceof IBinaryRecord ? (IBinaryRecord)tempVar2 : null;
					return record;
				}
			}
		}

		return null;
	}

	public static Encoding GetAnsiEncoding()
	{
		//ANSI Encoding: http://weblogs.asp.net/ahoffman/archive/2004/01/19/60094.aspx
		//Not sure, should be Encoding.Default? Documentation says "ANSI Character Set" but not specifically which code page
		//return Encoding.Default; //Depends on user's system localization settings
		return Encoding.GetEncoding(1252); //Western European code page
	}

	public static WmfDocument GetExampleFromSpecificationDocument()
	{
		WmfDocument wmf = new WmfDocument();
		wmf.getRecords().clear();

		//META_HEADER
		WmfHeader tempVar = new WmfHeader();
		tempVar.setType(MetafileType.forValue(0x0001));
		tempVar.setHeaderSize(0x0009);
		tempVar.setVersion(0x0300);
		tempVar.setFileSize(0x36);
		tempVar.setNumberOfObjects(0x02);
		tempVar.setMaxRecord(0x0C);
		tempVar.setNumberOfMembers(0x00);
		wmf.getRecords().add(tempVar);

		//META_CREATEPENINDIRECT
		WmfCreatePenIndirectRecord tempVar2 = new WmfCreatePenIndirectRecord();
		tempVar2.setStyle(PenStyle.forValue(0x0004));
		tempVar2.setWidth(new Point(0, 0));
		tempVar2.setColor(Color.FromArgb(0, 0, 0));
		wmf.getRecords().add(tempVar2);

		//META_SELECTOBJECT
		WmfSelectObjectRecord tempVar3 = new WmfSelectObjectRecord();
		tempVar3.setObjectIndex(0);
		wmf.getRecords().add(tempVar3);

		//META_CREATEBRUSHINDIRECT
		WmfCreateBrushIndirectRecord tempVar4 = new WmfCreateBrushIndirectRecord();
		tempVar4.setStyle(BrushStyle.forValue(0x0002));
		tempVar4.setColor(Color.FromArgb(0xFF, 0x00, 0xFF));
		tempVar4.setHatch(HatchStyle.forValue(0x0004));
		wmf.getRecords().add(tempVar4);

		//META_SELECTOBJECT
		WmfSelectObjectRecord tempVar5 = new WmfSelectObjectRecord();
		tempVar5.setObjectIndex(1);
		wmf.getRecords().add(tempVar5);

		//META_RECTANGLE
		WmfRectangleRecord tempVar6 = new WmfRectangleRecord();
		tempVar6.setBottomRect(0x0046);
		tempVar6.setRightRect(0x0096);
		tempVar6.setTopRect(0x0000);
		tempVar6.setLeftRect(0x0000);
		wmf.getRecords().add(tempVar6);

		//META_TEXTOUT
		WmfTextoutRecord tempVar7 = new WmfTextoutRecord();
		tempVar7.setStringLength(0x000C);
		tempVar7.setStringValue("Hello People");
		tempVar7.setYStart(0x000A);
		tempVar7.setXStart(0x000A);
		wmf.getRecords().add(tempVar7);

		//META_EOF
		wmf.getRecords().add(new WmfEndOfFileRecord());

		return wmf;
	}

	/** 
	 Gets byte array dump as human-readable "byte[n]" or "null" instead of binary data.
	 
	 @param data
	 @return 
	*/
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public static string DumpByteArray(byte[] data)
	public static String DumpByteArray(byte[] data)
	{
		return (data != null ? "byte[" + data.length + "]" : "null");
	}
}