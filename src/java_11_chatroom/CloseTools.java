package java_11_chatroom;
/**
 * 用于回收ChatChannel对象的资源
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
