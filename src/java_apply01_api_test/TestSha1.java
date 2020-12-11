package java_apply01_api_test;
/**
 * ≤‚ ‘sha1º”√‹
 */
import org.apache.commons.codec.digest.DigestUtils;

public class TestSha1 {
	public static void main(String[] args) {
		String sign = DigestUtils.sha1Hex("anxiaolong");
		System.out.println(sign);
	}
}
