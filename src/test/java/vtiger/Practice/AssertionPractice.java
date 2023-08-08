package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void SampleTest(){
		SoftAssert sa = new SoftAssert();
		
		int a=1;
		int b=2;
		
		System.out.println("Step 1");
		sa.assertEquals(false, true);
		
		System.out.println("Step 2");
		Assert.assertEquals(a, b);
		
		System.out.println("Step 3");
		
		System.out.println("Step 4");
		
		sa.assertTrue(false);
		
		System.out.println("Step 5");
		
		
		
		
		
		
		
		
		
		
	}

}
