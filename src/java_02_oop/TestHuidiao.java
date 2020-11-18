package java_02_oop;
/**
 * 1.先创建g1对象，再以g1为参数创建l1对象
 * 2.l1 执行askQuestion
 * 3.askQuestion调用g1的excute方法
 * 4.g1的excute方法执行过程中，又调用了l1的answer方法
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
		gaoGxq.excute(Ldb.this, question); //Ldb.this是父类对象指向子类
	}
}

class Gxq{
	
	public void excute(Callback callback,String question) {
		System.out.println("小刘问的问题是：" + question); 
		String result = "学Java当然去北京尚学堂";
		callback.answer(result);
	}
}