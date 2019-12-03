package gof23;
/**
 * 部门接口实体类
 * @author Administrator
 *
 */
public interface Mediator_Department {
	void selfAction();//做本部门的事情
	void outAction();//向总经理发出申请
}

class Development implements Mediator_Department{
	private Mediator_Mediator m;//持有中介者的引用
	
	public Development(Mediator_Mediator m) {
		this.m = m;
		//部门名和对象存入m的map中
		m.register("development", this);
	}
	
	@Override
	public void selfAction() {
		System.out.println("开发项目，专心写代码");
	}

	@Override
	public void outAction() {
		System.out.println("汇报工作，需要资金支持");
		m.command("Finacial");
	}
	
}

class Finacial implements Mediator_Department {
	private Mediator_Mediator m;
	
	public Finacial(Mediator_Mediator m) {
		this.m = m;
		m.register("Finacial", this);
	}
	
	@Override
	public void selfAction() {
		System.out.println("处理账务，数钱");
	}

	@Override
	public void outAction() {
		System.out.println("没钱了，钱太多，怎么花");
	}
	
}

class Market implements Mediator_Department{
	private Mediator_Mediator m;
	
	public Market(Mediator_Mediator m) {
		this.m = m;
		m.register("Market", this);
	}
	
	@Override
	public void selfAction() {
		System.out.println("跑去接项目");
		
	}

	@Override
	public void outAction() {
		System.out.println("汇报项目进度");
		//通过总经理，向财务部要钱
		m.command("Finacial");
	}
	
}





