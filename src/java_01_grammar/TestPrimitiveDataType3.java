package java_01_grammar;
/**
 * �ַ��ͱ����Ͳ������͵Ĳ���
 * @author Administrator
 *
 */
public class TestPrimitiveDataType3 {
    public static void main(String[] args) {
        char  a = 'T';
        char  b = '��';
        char c = '\u0061';
        System.out.println(c);
         
        //ת���ַ�
        System.out.println(""+'a'+'\n'+'b'); 
        System.out.println(""+'a'+'\t'+'b'); 
        System.out.println(""+'a'+'\''+'b');        //a'b 
              
        //String�����ַ�����
        String  d = "abc";
        
        //����ֵ��ʹ�ã�Ĭ��Ϊfalse
        boolean flag;
        flag =false;
        if(flag) {
        	System.out.println(flag);
        } else {
        	System.out.println(flag);
		}
         
    }
}
