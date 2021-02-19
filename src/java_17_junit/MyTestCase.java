package java_17_junit;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString; 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyTestCase {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass执行");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass执行");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp执行");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown执行");
	}

	@Test
	public void test1() {
		System.out.println("test1执行");
		assertEquals(2, 1+1);
	}
	
	@Test
	public void test2() {
		System.out.println("test2执行");
		assertThat("dddfdffdf", containsString("ddd"));
	}
}
