package Assingnment_jan26;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass1;

public class OpenTab4Test extends BaseClass1{

	
		@Test
		public void OpenTab()
		{
			driver.get("https://www.google.com/");
			wLib.waitPageLoad(driver, 20);
			wLib.openNewTab(driver);
			driver.get("https://www.facebook.com/");
			
		}


}
