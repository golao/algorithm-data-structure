package org.golao.com.n2020;

public class TestConstruct {
    private int a;
    private int b;
    public TestConstruct(){
        this.a = 10;
    }
    public TestConstruct(int b){
//        new TestConstruct();
        this();
        this.b = b;
    }
    public void print(){
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    public static void main(String[] args) {
        TestConstruct t = new TestConstruct(9);
        t.print();
    }
}
