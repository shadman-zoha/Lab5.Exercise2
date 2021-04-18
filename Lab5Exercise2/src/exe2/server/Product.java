package exe2.server;

import java.io.Serializable;

import exe2.ItemProduct.ItemProduct;

public class Product  {
	
	
	public String validateItemName(ItemProduct item)
	{
		
		String result = "Valid Name. ", name = item.getName();
		
		for(int i=0; i<name.length();i++)
		{
		    
			char ch = name.charAt(i);
		    
			// check alphabet or space
			if (!(Character.isLetter(ch) || ch == ' ') )
			{
				
				result="Invalid Name. ";
				
		    }
		
		}
		return result;	
	

	}



}