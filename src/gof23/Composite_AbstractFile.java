package gof23;

import java.util.ArrayList;
import java.util.List;
//���󹹽�
public interface Composite_AbstractFile {
	void killVirus();//ɱ��
}

class ImageFile implements Composite_AbstractFile {
	private String name;
	
	
	public ImageFile(String name) {
		this.name = name;
	}
	
	@Override
	public void killVirus() {
		System.out.println("ͼƬ�ļ���"+this.name+"����ɱ����");
	}
	
}

class TextFile implements Composite_AbstractFile{
	private String name;
	
	public TextFile(String name) {
		this.name = name;
	}
	
	@Override
	public void killVirus() {
		System.out.println("�ı��ļ���"+this.name+"����ɱ����");
	}
	
}

class VideoFile implements Composite_AbstractFile {
	private String name;
	
	public VideoFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("��Ƶ�ļ���"+this.name+"����ɱ��");
	}
	
}

class Folder implements Composite_AbstractFile{
	private String name;
	
	private List<Composite_AbstractFile> list = new ArrayList<Composite_AbstractFile>();
	
	public Folder(String name) {
		this.name = name;
	}
	
	public void add(Composite_AbstractFile file) {
		list.add(file);
	}
	
	public void remove(Composite_AbstractFile file) {
		list.add(file);
	}
	
	public Composite_AbstractFile getChild(int index) {
		return list.get(index);
	}
	
	@Override
	public void killVirus() {
		System.out.println("---�ļ��У�"+name+",����ɱ��");
		
		for (Composite_AbstractFile composite_AbstractFile : list) {
			composite_AbstractFile.killVirus();
		}
	}
	
}










