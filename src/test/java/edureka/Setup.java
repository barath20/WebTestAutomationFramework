package edureka;

import org.testng.annotations.BeforeSuite;
import framework.InitialSetup;
import framework.PageDriver;

public class Setup extends PageDriver {
	
	public static PageDriver pD;
	
  @BeforeSuite
  public void beforeSuite() {
	  
	  InitialSetup iS = new InitialSetup(); 
	  System.out.println("Inside suite");
	  pD = new PageDriver();
	  pD.Driver(iS.SetWebPage());
  }
}