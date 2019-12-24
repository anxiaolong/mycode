package datastructure;
/**
 * ���Ա�ӿ�
 * @author Administrator
 *
 */
public interface LineTable_List {
	//�������Ա�Ĵ�С����Ԫ�صĸ���
	public int size();
	
	//�������Ա������Ϊi������
	public Object get(int i);
	
	//������Ա�Ϊ�շ���true�����򷵻�false
	public boolean isEmpty();
	
	//�ж����Ա��Ƿ����Ԫ��e
	public boolean contains(Object e);
	
	//��������Ԫ��e�������Ա��е����
	public int indexOf(Object e);
	
	//������Ԫ��e ���뵽i��λ��
	public void add(int i,Object e);
	
	//��Ԫ��e���뵽���Ա�ĩβ
	public void add(Object e);
	
	//��Ԫ��e ���뵽obj֮ǰ
	public void addBefore(Object obj,Object e);
	
	//��Ԫ��e ���뵽obj֮��
	public void addAfter(Object obj,Object e);
	
	//ɾ�����Ա������δi��Ԫ�أ�������Ԫ��
	public Object remove(int i);
	
	//ɾ�����Ա��е�һ����e��ͬ��Ԫ��
	public boolean remove(Object e);
	
	//�滻���Ա������δi������Ԫ��δe,����ԭ����Ԫ��
	public Object replace(int i,Object e);
}



