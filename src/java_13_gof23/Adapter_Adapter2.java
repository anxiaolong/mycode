package java_13_gof23;
/**
 * ʹ�����ģʽ��ʵ��������
 * @author Administrator
 *
 */
public class Adapter_Adapter2 implements Adapter_Target {
	
	private Adapter_Keyboard keyboard;
	
	public Adapter_Adapter2(Adapter_Keyboard keyboard) {
		this.keyboard = keyboard;
	}
	
	public void name() {
		
	}

	@Override
	public void handleInput() {
		keyboard.acceptInput();
	}
}
