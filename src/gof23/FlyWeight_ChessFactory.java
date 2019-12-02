package gof23;
/**
 * ÏíÔª¹¤³§
 */
import java.util.HashMap;
import java.util.Map;

public class FlyWeight_ChessFactory {
	
	public static Map<String, FlyWeight_Chess> map = new HashMap<String, FlyWeight_Chess>();
	
	public static FlyWeight_Chess getChess(String color) {
		if (map.get(color)!=null) {
			return map.get(color);
		} else {
			FlyWeight_Chess chess = new Chess(color);
			map.put(color, chess);
			return chess;
		}
	}
}
