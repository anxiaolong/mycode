package gof23;
/**
 * �������ģʽ
 * �ļ���������ļ��У�ִ��killVirus()������ʱ��һ���̶��Ͽ���ʵ�ֵݹ�Ч��
 * @author Administrator
 *
 */
public class Composite_Client {
	public static void main(String[] args) {
		Composite_AbstractFile f2,f3,f4,f5;
		Folder f1 = new Folder("�ҵ��ղ�");
		
		f2 = new ImageFile("�ϸߵ�ͷ��.jpg");
		f3 = new TextFile("Hellp.txt");
		f1.add(f2);
		f1.add(f3);
		
		Folder f11 = new Folder("��Ӱ");
		f4 = new VideoFile("Ц������.avi");
		f5 = new VideoFile("�������.avi");
		f11.add(f4);
		f11.add(f5);
		f1.add(f11);
		
		f1.killVirus();
				
	}
}
