package java_17_junit;

import org.junit.runner.JUnitCore;

public class Execute {

    public static void main(String[] args) {
        run(MyTestCase.class);
    }

    private static void run(Class<?>... classes) {
        for (Class<?> clazz : classes) {
            JUnitCore runner = new JUnitCore();
            ExecutionListener listener = new ExecutionListener();
            runner.addListener(listener);
            runner.run(clazz);
            MyResultRecorder recorder = listener.recorder;
            System.out.println(recorder);
        }
    }
}