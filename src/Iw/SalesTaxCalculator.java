package Iw;

/**
 * JUnit Test Case attached
 * 
 * DESIGN ASPECTS considered :
 * 
 * 1. Expandable exemptedItems list
 * 2. Float (instead of Double) level calculation of price to avoid overhead
 * 3. Object orientedness of functions would result in easier maintanance
 * 
 */
public class SalesTaxCalculator {
	
	String exemptedItems[] = {"book","chocolate","pill"};
	
	float fPriceSum=0, fTaxSum=0;
	
    public String[] returnTaxedBill(String[] sItemList)
   	{
    	// Retrun Array contains result for UnitTest
    	String[] sRetArr = new String[sItemList.length+2];
    	fTaxSum = 0; fPriceSum = 0;
    	int i;
    	
   		for(i=0;i<sItemList.length;i++) 
   		{
   			String sItem= sItemList[i];
   			
   			float dPrice = getPriceFromItemString(sItem) , fTaxedPrice = dPrice;
   			
   			if(isSalesTaxApplicable(sItem))
   			{
   				float temp = roundOffToNearest5paise(dPrice/10.0f);
   				fTaxedPrice += temp;
   				fTaxSum     += temp;
   			}
   			
   			if(isImportTaxApplicable(sItem))
   			{
   				float temp     = roundOffToNearest5paise (dPrice/20.0f);
   				fTaxedPrice    += temp ;
   				fTaxSum        += temp;
   			}
   			
   			int iItemCnt = getItemCntFromItemString(sItem);
   			
   			String sRndTaxedPrice = roundOffTo2DecPlaces( fTaxedPrice * iItemCnt);

   			// Add to total sum
   			fPriceSum += Float.parseFloat(sRndTaxedPrice);
   			
   			// Print Current item price
   			String temp = sItem.substring(0,sItem.lastIndexOf("at")-1)+": "+ sRndTaxedPrice;
   			System.out.println(temp);	sRetArr[i] = temp;
   		}
   		
   		// Sales Tax
   		String temp = "Sales Taxes: "+ roundOffTo2DecPlaces(fTaxSum);
   		System.out.println(temp);  sRetArr[i] =temp; 
   		
   		// Total
   		temp = "Total: "+roundOffTo2DecPlaces(fPriceSum);
   		System.out.println(temp);  sRetArr[i+1] =temp;
   		
   		return sRetArr;
   	}
	
	boolean isSalesTaxApplicable(String sItem)
	{
		for(String sExmpItem : exemptedItems)
			if(sItem.contains(sExmpItem))
			{
				return false; 
			}
		
		return true;
	}
	
	boolean isImportTaxApplicable(String sItem)
	{
		if(sItem.contains("import"))
			return true;
		return false;
	}
	
	float roundOffToNearest5paise(float val)
	{
		return ((float)(Math.ceil(val*20)))/20.0f;     // Scale down the ceil method to work at 0.05 level
	}
	
	String roundOffTo2DecPlaces(float val)
	{
		return String.format("%.2f", val);
		
		// truncate on 2 decimal places
		
		//DecimalFormat df = new DecimalFormat(".##");
		// df.format(val);
	}
	
	float getPriceFromItemString(String s)
	{
		return Float.valueOf(s.substring(s.lastIndexOf("at")+3, s.length()));
	}
	
	int getItemCntFromItemString(String s)
	{
		return Integer.parseInt(s.substring(0,s.indexOf(" ")));
	}
	
}
