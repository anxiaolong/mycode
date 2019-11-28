package gof23;
/**
 * 品牌接口和实体类
 * @author Administrator
 *
 */
public interface Bridge_Brand {
	public void sale();
}

class Lenovo implements Bridge_Brand {

	@Override
	public void sale() {
		System.out.println("销售联想电脑");
	}
	
}

class Dell implements Bridge_Brand {

	@Override
	public void sale() {
		System.out.println("销售戴尔电脑");
	}
	
}

class Shenzhou implements Bridge_Brand {

	@Override
	public void sale() {
		System.out.println("销售神州电脑");
	}
	
}