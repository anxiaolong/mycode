package java_02_oop;
/**
 * 1.�ȴ���g1��������g1Ϊ��������l1����
 * 2.l1 ִ��askQuestion
 * 3.askQuestion����g1��excute����
 * 4.g1��excute����ִ�й����У��ֵ�����l1��answer����
 * @author Administrator
 *
 */
public class TestHuidiao {
	public static void main(String[] args) {
		Gxq g1 = new Gxq();
		Ldb l1 = new Ldb(g1);
		l1.askQuestion("where");;
		
	}
}

interface Callback {
	public void answer(String result);
}

class Ldb implements Callback {
	Gxq gaoGxq;
	
	@Override
	public void answer(String result) {
		System.out.println(result);
	}
	
	public Ldb(Gxq gao) {
		this.gaoGxq = gao;
	}
	
	public void askQuestion(String question) {
		System.out.println(question);
		gaoGxq.excute(Ldb.this, question); //Ldb.this�Ǹ������ָ������
	}
}

class Gxq{
	
	public void excute(Callback callback,String question) {
		System.out.println("С���ʵ������ǣ�" + question); 
		String result = "ѧJava��Ȼȥ������ѧ��";
		callback.answer(result);
	}
}