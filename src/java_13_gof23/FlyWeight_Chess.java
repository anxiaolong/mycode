package java_13_gof23;
/**
 * 棋子类实现
 * @author Administrator
 *
 */
public interface FlyWeight_Chess {
	String getColor();
	void setColor(String c);
	void disPlay(FlyWeight_Coordinate coordinate);
}

class Chess implements FlyWeight_Chess{
	private String color;

	public Chess(String color) {
		this.color = color;
	}
	
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	@Override
	public void setColor(String c) {
		this.color = c;
	}

	@Override
	public void disPlay(FlyWeight_Coordinate coordinate) {
		System.out.println("棋子颜色："+this.color);
		System.out.println("棋子位置："+coordinate.getX()+","+coordinate.getY());
	}
	
}