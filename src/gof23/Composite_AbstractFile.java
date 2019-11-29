package gof23;

import java.util.ArrayList;
import java.util.List;
//抽象构建
public interface Composite_AbstractFile {
	void killVirus();//杀毒
}

class ImageFile implements Composite_AbstractFile {
	private String name;
	
	
	public ImageFile(String name) {
		this.name = name;
	}
	
	@Override
	public void killVirus() {
		System.out.println("图片文件："+this.name+"进行杀毒！");
	}
	
}

class TextFile implements Composite_AbstractFile{
	private String name;
	
	public TextFile(String name) {
		this.name = name;
	}
	
	@Override
	public void killVirus() {
		System.out.println("文本文件："+this.name+"进行杀毒！");
	}
	
}

class VideoFile implements Composite_AbstractFile {
	private String name;
	
	public VideoFile(String name) {
		this.name = name;
	}
	@Override
	public void killVirus() {
		System.out.println("视频文件："+this.name+"进行杀毒");
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
		System.out.println("---文件夹："+name+",进行杀毒");
		
		for (Composite_AbstractFile composite_AbstractFile : list) {
			composite_AbstractFile.killVirus();
		}
	}
	
}










