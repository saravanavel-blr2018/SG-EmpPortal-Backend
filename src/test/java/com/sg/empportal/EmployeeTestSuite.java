package com.sg.empportal;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;		

@RunWith(Suite.class)				
@Suite.SuiteClasses({				
  EmployeeServiceTests.class,
  EmployeeControllerTests.class,
  EmployeeRepositoryTests.class
})
public class EmployeeTestSuite {
	// This class remains empty, it is used only as a holder for the above annotations
}
					
