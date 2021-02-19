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
		System.out.println("setUpBeforeClassִ��");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClassִ��");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUpִ��");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDownִ��");
	}

	@Test
	public void test1() {
		System.out.println("test1ִ��");
		assertEquals(2, 1+1);
	}
	
	@Test
	public void test2() {
		System.out.println("test2ִ��");
		assertThat("dddfdffdf", containsString("ddd"));
	}
}
