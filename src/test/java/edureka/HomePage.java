package edureka;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import framework.Elements;

public class HomePage {
	
	Elements ele = new Elements();
  @Test
  public void f1() {
	  ele.click();
	  System.out.println("Test Ones");
  }
  @Test
  public void f2() {
	  System.out.println("Test2");
  }
  @Test
  public void f3() {
	  System.out.println("Test3");
  }
}
