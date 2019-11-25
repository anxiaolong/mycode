package gof23;
/**
 * ���Գ��󹤳�ģʽ
 * ���󹤳��ǽ���Ʒ���һ�����зֽ⣬����Ϊ�����
 * ���븴�Ӷ����ӣ�����������չ
 * @author Administrator
 *
 */
public class FactoryAbstarct_Client {
	public static void main(String[] args) {
		FactoryAbstract_CarFactory factory = new FactoryAbstract_LuxuryCarFactory();
		FactoryAbstract_Engine engine = factory.createEngine();
		FactoryAbstract_Seat seat = factory.createSeat();
		FactoryAbstract_Tyre tyre = factory.createTyre();
		engine.start();
		seat.seat();
		tyre.run();
	}
}
