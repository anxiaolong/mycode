package gof23;
/**
 * 测试享元模式
 * @author Administrator
 *
 */
public class FlyWeight_Client {
	public static void main(String[] args) {
		FlyWeight_Chess chess1 = FlyWeight_ChessFactory.getChess("黑色");
		FlyWeight_Chess chess2 = FlyWeight_ChessFactory.getChess("黑色");
		System.out.println(chess1);
		System.out.println(chess2);
		
		System.out.println("################################");
		chess1.disPlay(new FlyWeight_Coordinate(10, 23));
		chess1.disPlay(new FlyWeight_Coordinate(78, 13));
		
		System.out.println(chess1);
		System.out.println(chess2);
	}
}
