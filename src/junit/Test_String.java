package junit;
/**
 * ʹ��Junit����String��
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
		System.out.println("������ʼ��");
	}
	
	@AfterAll
	static void release() {
		System.out.println("������ԭ");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("������ʼִ��");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("����ִ�н���");
	}

	@Test
	@DisplayName("startsWith��������")
	void testStartsWithString() {
		assertEquals(true, testString.startsWith("an"));
	}
	
	@Test
	@DisplayName("����ִ�г�ʱ����")
	void testTimeOut() {
		assertTimeout(Duration.of(2, ChronoUnit.SECONDS), ()->{
			testString.startsWith("an");
			Thread.sleep(2000);
		});
	}

}
