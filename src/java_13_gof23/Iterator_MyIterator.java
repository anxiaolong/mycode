package java_13_gof23;
/**
 * �������ӿ�
 * @author Administrator
 *
 */
public interface Iterator_MyIterator {
	void first();//���α�ָ���һ��Ԫ��
	void next();//���α�ָ����һ��Ԫ��
	boolean hasNext();//�Ƿ������һ��Ԫ��
	
	boolean isFirst();
	boolean isLast();
	
	Object getCurrentObj();//��ȡ��ǰ�α�ָ��Ķ���
	
}
