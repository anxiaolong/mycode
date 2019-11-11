package zj_fs_zjm_ljz;
/**
 * 使用注解标记这个类得成员变量在数据库中位置
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
