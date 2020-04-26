package edureka;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import framework.LaunchWebPage;

public class Setup {
  @BeforeSuite
  public void beforeSuite() {
	  
	  LaunchWebPage lwp = new LaunchWebPage();
	//  lwp.SetAndLaunch();
	  System.out.println("Inside suite");
  }

}
