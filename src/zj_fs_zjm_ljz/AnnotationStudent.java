package zj_fs_zjm_ljz;
/**
 * ʹ��ע���������ó�Ա���������ݿ���λ��
 * @author Administrator
 *
 */

@Annotation02(value = "student_table")
public class AnnotationStudent {
	@Annotation03(columnName = "id",type = "int",length = 10)
	int id;
	@Annotation03(columnName = "sname",type = "varchar",length = 10)
	String name;
	@Annotation03(columnName = "age",type = "int",length = 3)
	int age;
}
