package junit;
/**
 * ²âÊÔÌ×¼şSuite
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Test_HashSet.class,
	Test_String.class
})
public class AllTests {
	
}
