package api_test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PicSize_Test {
	private static BufferedWriter bw;
	private static StringBuilder sb= new StringBuilder();
	private static int picName=0;
	static {
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("c:/test/picSize.result"))));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//提取picUrl
	public static void match() throws Exception {
		Pattern p = Pattern.compile("picUrl\":\"(.*?)\",");
		Matcher m = p.matcher(sb.toString());
		bw.write("按顺序提取picUrl："+"\r\n");
		while (m.find()) {
			bw.write(m.group(1)+"\r\n");
			savePic(m.group(1));
		}
		bw.flush();
	}
	public static void getMusicInfo(String musicId) throws IOException {
		bw.write("歌曲id查歌曲接口："+"\r\n");
		String getMusicUrl = "https://open.migu.cn:98/sportMusic/2.0/rest/music/get?evident";
		String header = "OEPAUTH chCode=\"a39d713b25e95b2b\", smartDeviceId=\"11c8478c000068\"";
		String body = "{\"musicId\":\""+musicId+"\"}";
		String bodyS = "{\"musicId\":\""+musicId+"\",\"picSize\":\"S\"}";
		String bodyM = "{\"musicId\":\""+musicId+"\",\"picSize\":\"M\"}";
		String bodyL = "{\"musicId\":\""+musicId+"\",\"picSize\":\"L\"}";
		
		bw.write(RequestUtils.postData(getMusicUrl, body,header)+"\r\n");
		sb.append(RequestUtils.postData(getMusicUrl, body,header)+"\r\n");
		
		bw.write(RequestUtils.postData(getMusicUrl, bodyS,header)+"\r\n");
		sb.append(RequestUtils.postData(getMusicUrl, bodyS,header)+"\r\n");
		
		bw.write(RequestUtils.postData(getMusicUrl, bodyM,header)+"\r\n");
		sb.append(RequestUtils.postData(getMusicUrl, bodyM,header)+"\r\n");
		
		bw.write(RequestUtils.postData(getMusicUrl, bodyL,header)+"\r\n");
		sb.append(RequestUtils.postData(getMusicUrl, bodyL,header)+"\r\n");
		
		bw.write("\r\n");
		bw.flush();
	}
	
	public static void musicSheet() throws Exception {
		bw.write("获取歌单歌曲接口："+"\r\n");
		String header = "OEPAUTH chCode=\"a39d713b25e95b2b\", smartDeviceId=\"11c8478c000068\"";
		String url = "https://open.migu.cn:98/sportMusic/1.0/rest/musicSheet/music/query?evident";
		String body = "{\"musicSheetId\":\"1781\",\"startNum\":0,\"endNum\":3}";
		String bodyS = "{\"musicSheetId\":\"1781\",\"startNum\":0,\"endNum\":3,\"picSize\":\"S\"}";
		String bodyM = "{\"musicSheetId\":\"1781\",\"startNum\":0,\"endNum\":3,\"picSize\":\"M\"}";
		String bodyL = "{\"musicSheetId\":\"1781\",\"startNum\":0,\"endNum\":3,\"picSize\":\"L\"}";
		
		bw.write(RequestUtils.postData(url, body,header)+"\r\n");
		sb.append(RequestUtils.postData(url, body,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyS,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyS,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyM,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyM,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyL,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyL,header)+"\r\n");
		
		bw.write("\r\n");
		bw.flush();
	}
	
	public static void listbykey() throws Exception {
		bw.write("关键字搜歌："+"\r\n");
		String header = "OEPAUTH chCode=\"a39d713b25e95b2b\", smartDeviceId=\"11c8478c000068\"";
		String url = "https://open.migu.cn:98/sportMusic/2.0/search/music/listbykey?evident";
		String body = "{\"key\": \"老友记\",\"keyType\": \"2\"}";
		String bodyS = "{\"key\": \"老友记\",\"keyType\": \"2\",\"picSize\":\"S\"}";
		String bodyM = "{\"key\": \"老友记\",\"keyType\": \"2\",\"picSize\":\"M\"}";
		String bodyL = "{\"key\": \"老友记\",\"keyType\": \"2\",\"picSize\":\"L\"}";
		
		bw.write(RequestUtils.postData(url, body,header)+"\r\n");
		sb.append(RequestUtils.postData(url, body,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyS,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyS,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyM,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyM,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyL,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyL,header)+"\r\n");
		
		bw.write("\r\n");
		bw.flush();
	}
	
	public static void collection() throws Exception {
		bw.write("获取收藏歌曲接口："+"\r\n");
		String header = "OEPAUTH chCode=\"e2bb16040025cc1b\", smartDeviceId=\"005910310005\",uid=\"005910310005\"";
		String url = "https://open.migu.cn:98/sportMusic/2.0/rest/collection/query?evident";
		String body = "{\"startNum\":0,\"endNum\":20}";
		String bodyS = "{\"startNum\":0,\"endNum\":20,\"picSize\":\"S\"}";
		String bodyM = "{\"startNum\":0,\"endNum\":20,\"picSize\":\"M\"}";
		String bodyL = "{\"startNum\":0,\"endNum\":20,\"picSize\":\"L\"}";
		
		bw.write(RequestUtils.postData(url, body,header)+"\r\n");
		sb.append(RequestUtils.postData(url, body,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyS,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyS,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyM,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyM,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyL,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyL,header)+"\r\n");
		
		bw.write("\r\n");
		bw.flush();
	}
	
	public static void tag() throws Exception {
		bw.write("tagid获取歌曲接口："+"\r\n");
		String header = "OEPAUTH chCode=\"a39d713b25e95b2b\", smartDeviceId=\"11c8478c000068\"";
		String url = "https://open.migu.cn:98/sportMusic/1.0/rest/tag/music/query?evident";
		String body = "{\"tagId\":\"2\",\"startNum\":\"0\",\"endNum\":\"3\"}";
		String bodyS = "{\"tagId\":\"2\",\"startNum\":\"0\",\"endNum\":\"3\",\"picSize\":\"S\"}";
		String bodyM = "{\"tagId\":\"2\",\"startNum\":\"0\",\"endNum\":\"3\",\"picSize\":\"M\"}";
		String bodyL = "{\"tagId\":\"2\",\"startNum\":\"0\",\"endNum\":\"3\",\"picSize\":\"L\"}";
		
		bw.write(RequestUtils.postData(url, body,header)+"\r\n");
		sb.append(RequestUtils.postData(url, body,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyS,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyS,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyM,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyM,header)+"\r\n");
		
		bw.write(RequestUtils.postData(url, bodyL,header)+"\r\n");
		sb.append(RequestUtils.postData(url, bodyL,header)+"\r\n");
		
		bw.write("\r\n");
		bw.flush();
	}
	
	public static void savePic(String picurl) throws Exception {
		URL url = new URL(picurl);
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream(new File("c:/test/temp/"+picName+".jpg"));
		picName++;
		byte[] data = new byte[1024*1024];
		int len = 0;
		while ((len=is.read(data))!=-1) {
			fos.write(data, 0, len);
		}
		
		fos.flush();
		fos.close();
	}
	
	public static void main(String[] args) throws Exception {
		getMusicInfo("6008460GHXF");
		getMusicInfo("6005971J9GE");
		getMusicInfo("63261202820");
		getMusicInfo("60076263104");
		musicSheet();
		listbykey();
		collection();
		tag();
		
		match();	
	}
}
