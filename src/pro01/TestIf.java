package pro01;


public class TestIf {
	public static void main(String[] args) {
//		System.out.println(Math.random());
//		int a = (int)(6*Math.random())+1; //函数取值范围[0,1)
//		int b = (int)(6*Math.random())+1;
//		int c = (int)(6*Math.random())+1;
//		int sum = a + b + c;
//		System.out.println(sum);
//		sum = 16;
//		
//		if (sum>15) {
//			System.out.println("运气真好");
//		}
//		if (sum>=10&&sum<=15) {
//			System.out.println("一般");
//		}
//		if (sum<10) {
//			System.out.println("太差");
//		}
//		double r = 4*Math.random();
//		double mj = Math.PI*Math.pow(r, 2);
//		double zc = 2*Math.PI*r;
//		System.out.printf("%f\n %f\n %f\n", r,mj,zc);
//		System.out.println(Math.PI);
		
//		if (mj > zc) {
//			System.out.println("面积大于周长");
//		} else {
//			System.out.println("周长大于面积");
//		}
		
//		System.out.println(mj>zc?"面积大于周长":"周长大于面积");  //三目运算处理该分支
		int p = (int)(100*Math.random());
		p = 64;
		//这样顺序写，只能从范围最小的开始判断
		if (p < 60) {
			System.out.println("不及格 分数："+p);
		} else if (p <= 70) {
			System.out.println("及格 分数："+p);
		} else if (p <= 84) {
			System.out.println("良 分数："+p);
		} else {
			System.out.println("优秀 分数："+p);
		}
		
		
	}
}
