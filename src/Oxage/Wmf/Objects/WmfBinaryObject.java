package Oxage.Wmf.Objects;

import Oxage.Wmf.*;

public abstract class WmfBinaryObject implements IBinaryObject
{
//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#region IBinaryRecord Members

	/** 
	 Gets the size of the object in bytes. Important: variable size objects should override this method.
	 
	 @return Returns size of the object in bytes.
	*/
	public int GetSize()
	{
		Object tempVar = (this.getClass() ? Attribute.getAnnotations() : Attribute.getDeclaredAnnotations()).FirstOrDefault(x -> x instanceof WmfObjectAttribute);
		WmfObjectAttribute attribute = tempVar instanceof WmfObjectAttribute ? (WmfObjectAttribute)tempVar : null;
		if (attribute != null)
		{
			if (attribute.getSizeIsVariable())
			{
				//Variable size object - should be overridden
				throw new UnsupportedOperationException();
			}
			else
			{
				//Fixed size object
				return attribute.getSize();
			}
		}

		throw new WmfException("Cannot get size of the object [" + this.getClass().toString() + "], missing WmfObject attribute.");
	}

	public abstract void Read(BinaryReader reader);

	public abstract void Write(BinaryWriter writer);

	public final String Dump()
	{
		StringBuilder builder = new StringBuilder();
		Dump(builder);
		return builder.toString();
	}

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
		///#endregion

	public void Dump(StringBuilder builder)
	{
		builder.append(String.format("\t== %1$s ==", this.getClass().getSimpleName())).append("\r\n");
		//Other fields should be added in overridden method
	}
}