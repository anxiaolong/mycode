package java_07_datastructure;
/**
 * �������ӿ�
 * @author Administrator
 *
 */
public interface Btree_BinaryTree {
	//�Ƿ�Ϊ��
	public boolean isEmpty();
	
	//���ڵ�����
	public int size();
	
	//��ȡ�������߶�
	public int getHeight();
	
	//����ָ��ֵ���
	public Btree_Node findKey(int value);
	
	//ǰ��ݹ����
	public void preOrderTraverse();
	
	//����ݹ����
	public void inOrderTraverse();
	
	//�����ݹ��������
	public  void postOrderTraverse();
	
	//�����ݹ��������
	public  void postOrderTraverse(Btree_Node node); 
	
	/**
	 * ��������ǵݹ����
	 * 1����������ڵ�current�����ýڵ㲻Ϊ���򽫸ýڵ�ѹջ�������������ڵ���Ϊcurrent���ظ��˲�����ֱ��currentΪ�ա� 
	 * 2����������Ϊ�գ�ջ���ڵ��ջ�����ʽڵ�󽫸ýڵ����������Ϊcurrent
	 * 3) �ظ�1��2��������ֱ��currentΪ����ջ�ڽڵ�Ϊ�ա� 
	 */
	public void inOrderByStack();
	
	/**
	 *   ǰ������ǵݹ����
	 *   1����������ڵ�current�����ýڵ㲻Ϊ������ʸýڵ���ٽ��ڵ�ѹջ�������������ڵ���Ϊcurrent���ظ��˲�����ֱ��currentΪ�ա� 
	 *   2����������Ϊ�գ�ջ���ڵ��ջ�����ýڵ����������Ϊcurrent 
	 *   3) �ظ�1��2��������ֱ��currentΪ����ջ�ڽڵ�Ϊ�ա�
	 */
	public  void preOrderByStack();
	
	/**
	 * ��������ǵݹ����
	 * 1����������ڵ�current�����ýڵ㲻Ϊ������ʸýڵ���ٽ��ڵ�ѹջ�������������ڵ���Ϊcurrent���ظ��˲�����ֱ��currentΪ�ա� 
	 * 2����������Ϊ�գ�ȡջ���ڵ�������������������Ϊ�ջ��������շ��ʹ�������ʸýڵ㣬����preNode��Ϊ�ýڵ� 
	 * 3) �ظ�1��2��������ֱ��currentΪ����ջ�ڽڵ�Ϊ�ա� 
	 */
	public  void postOrderByStack();
	
	/**
	 * ���ղ�α���������
	 */
	public void levelOrderByStack();
}






