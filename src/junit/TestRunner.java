package junit;
/**
 * 执行测试套件里面的Case
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTests.class);
		System.out.println("失败用例信息：");
		for (Failure temp : result.getFailures()) {
			System.out.println(temp.toString());
		}
		System.out.println("是否全部通过："+result.wasSuccessful());
	}
}
