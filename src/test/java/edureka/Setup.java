package edureka;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import framework.InitialSetup;

public class Setup {
  @BeforeSuite
  public void beforeSuite() {
	  
	  InitialSetup lwp = new InitialSetup();
	//  lwp.SetAndLaunch();
	  System.out.println("Inside suite");
  }

}
