package junit;
/**
 * 使用Junit测试HashSet
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class Test_HashSet {
	Set<String> set1 = new HashSet<String>();

	@Test
	@DisplayName("测试HashSet去重")
	void testSize() {
		set1.add("anxiaolong");
		set1.add("anxiaolong");
		set1.add("anxiaolong");
		assertEquals(1, set1.size());
	}

}
