package java_01_grammar;
/**
 * 字符型变量和布尔类型的测试
 * @author Administrator
 *
 */
public class TestPrimitiveDataType3 {
    public static void main(String[] args) {
        char  a = 'T';
        char  b = '尚';
        char c = '\u0061';
        System.out.println(c);
         
        //转义字符
        System.out.println(""+'a'+'\n'+'b'); 
        System.out.println(""+'a'+'\t'+'b'); 
        System.out.println(""+'a'+'\''+'b');        //a'b 
              
        //String就是字符序列
        String  d = "abc";
        
        //布尔值的使用，默认为false
        boolean flag;
        flag =false;
        if(flag) {
        	System.out.println(flag);
        } else {
        	System.out.println(flag);
		}
         
    }
}
