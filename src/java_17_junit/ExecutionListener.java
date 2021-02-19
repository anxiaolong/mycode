package java_17_junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class ExecutionListener extends RunListener {
    MyResultRecorder recorder;
    MethodInfo methodInfo;
    List<MethodInfo> list;

    public ExecutionListener() {
        this.list = new ArrayList<>();
    }

    public void testRunStarted(Description description) throws Exception {
        System.out.println("--------- START ----------");
        recorder = new MyResultRecorder();
    }

    public void testRunFinished(Result result) throws Exception {
        recorder.setResult(result.wasSuccessful());
        recorder.setList(list);
        System.out.println("--------- END ----------");
        System.out.println("ִ�н�� : " + result.wasSuccessful());
        System.out.println("ִ��ʱ�� : " + result.getRunTime());
        System.out.println("ִ������ : " + result.getRunCount());
        System.out.println("ʧ������ : " + result.getFailureCount());
        System.out.println("�������� : " + result.getIgnoreCount());
    }

    public void testStarted(Description description) throws Exception {
        recorder.setScript_name(description.getClassName());
        System.out.println(description.getMethodName() + " begin");
        methodInfo = new MethodInfo();
        methodInfo.setMethod_name(description.getMethodName());
    }

    public void testFinished(Description description) throws Exception {
        System.out.println(description.getMethodName() + " end");
        if (methodInfo.getError_msg() == null)
            methodInfo.setResult(true);
        list.add(methodInfo);
    }

    public void testFailure(Failure failure) throws Exception {
        System.out.println("Execution of test case failed : " + failure.getMessage());
        methodInfo.setResult(false);
        methodInfo.setError_msg(failure.getMessage());
    }

    public void testIgnored(Description description) throws Exception {

    }
}