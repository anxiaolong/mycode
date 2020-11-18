package java_11_chatroom;
/**
 * ���ڻ���ChatChannel�������Դ
 */
import java.io.Closeable;
import java.io.IOException;

public class CloseTools {
	public static void closeAll(Closeable...target) {
		for (Closeable closeable : target) {
			try {
				if (null!=closeable) {
					closeable.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
