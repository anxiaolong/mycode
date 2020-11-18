package java_12_zj_fs_zjm_ljz;
/**
 * 测试自定义注解的使用
 * @author Administrator
 *
 */
@Annotation01
public class AnnotationTest02 {
	@Annotation01(studentName="anxiaolong",age=27,id=1,
			school= {"成都大学"})
	public void test1() {
		
	}
	
	@Annotation02(value = "test")
	public void test2() {
		
	}
}
