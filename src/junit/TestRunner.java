package junit;
/**
 * ִ�в����׼������Case
 */
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTests.class);
		System.out.println("ʧ��������Ϣ��");
		for (Failure temp : result.getFailures()) {
			System.out.println(temp.toString());
		}
		System.out.println("�Ƿ�ȫ��ͨ����"+result.wasSuccessful());
	}
}
