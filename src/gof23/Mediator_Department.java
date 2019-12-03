package gof23;
/**
 * ���Žӿ�ʵ����
 * @author Administrator
 *
 */
public interface Mediator_Department {
	void selfAction();//�������ŵ�����
	void outAction();//���ܾ���������
}

class Development implements Mediator_Department{
	private Mediator_Mediator m;//�����н��ߵ�����
	
	public Development(Mediator_Mediator m) {
		this.m = m;
		//�������Ͷ������m��map��
		m.register("development", this);
	}
	
	@Override
	public void selfAction() {
		System.out.println("������Ŀ��ר��д����");
	}

	@Override
	public void outAction() {
		System.out.println("�㱨��������Ҫ�ʽ�֧��");
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
		System.out.println("����������Ǯ");
	}

	@Override
	public void outAction() {
		System.out.println("ûǮ�ˣ�Ǯ̫�࣬��ô��");
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
		System.out.println("��ȥ����Ŀ");
		
	}

	@Override
	public void outAction() {
		System.out.println("�㱨��Ŀ����");
		//ͨ���ܾ��������ҪǮ
		m.command("Finacial");
	}
	
}





