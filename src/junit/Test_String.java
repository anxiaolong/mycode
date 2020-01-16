package junit;
/**
 * 使用Junit测试String类
 */
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class Test_String {
	String testString = "anxiaolong";
	
	@BeforeAll
	static void init() {
		System.out.println("环境初始化");
	}
	
	@AfterAll
	static void release() {
		System.out.println("环境还原");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("用例开始执行");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("用例执行结束");
	}

	@Test
	@DisplayName("startsWith方法测试")
	void testStartsWithString() {
		assertEquals(true, testString.startsWith("an"));
	}
	
	@Test
	@DisplayName("方法执行超时测试")
	void testTimeOut() {
		assertTimeout(Duration.of(2, ChronoUnit.SECONDS), ()->{
			testString.startsWith("an");
			Thread.sleep(2000);
		});
	}

}
