package em;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import em.calc.*;

@RunWith(Suite.class)
@SuiteClasses({ ElementTest.class, MainTest.class, CalculatorTest.class })
public class AllTests {

}
