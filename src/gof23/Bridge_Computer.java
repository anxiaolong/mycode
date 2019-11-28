package gof23;
/**
 * 品牌作为一个属性放到电脑抽象类中
 * @author Administrator
 *
 */
public class Bridge_Computer {
	private Bridge_Brand brand;
	
	public Bridge_Computer(Bridge_Brand brand) {
		this.brand = brand;
	}
	
	public void sale() {
		brand.sale();
	}
}

class Desktop extends Bridge_Computer {

	public Desktop(Bridge_Brand brand) {
		super(brand);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		super.sale();
		System.out.println("销售台式机");
	}
}

class Laptop extends Bridge_Computer {

	public Laptop(Bridge_Brand brand) {
		super(brand);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		super.sale();
		System.out.println("销售笔记本");
	}
}
