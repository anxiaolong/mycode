package gof23;
/**
 * 测试组合模式
 * 文件夹中添加文件夹，执行killVirus()方法的时候，一定程度上可以实现递归效果
 * @author Administrator
 *
 */
public class Composite_Client {
	public static void main(String[] args) {
		Composite_AbstractFile f2,f3,f4,f5;
		Folder f1 = new Folder("我的收藏");
		
		f2 = new ImageFile("老高的头像.jpg");
		f3 = new TextFile("Hellp.txt");
		f1.add(f2);
		f1.add(f3);
		
		Folder f11 = new Folder("电影");
		f4 = new VideoFile("笑傲江湖.avi");
		f5 = new VideoFile("神雕侠侣.avi");
		f11.add(f4);
		f11.add(f5);
		f1.add(f11);
		
		f1.killVirus();
				
	}
}
