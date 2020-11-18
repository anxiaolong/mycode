package java_02_oop;

class Test10 {
    int x, y;
    Test10(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Test9 {
    int count=9;
    public void count1(){
        count=10;
        System.out.println("count1="+count);
    }
    public void count2(){
        System.out.println("count2="+count);
    }
    public static void main(String[ ] args) {
        Test9 t=new Test9();
        t.count1();
        t.count2();
        
        Test10 pt1, pt2;
        pt1 = new Test10(3, 3);
        pt2 = new Test10(4, 4);
        System.out.println(pt1.x + pt2.x);
    }
}