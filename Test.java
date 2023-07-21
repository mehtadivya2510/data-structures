public class Test {
    public void print(Integer i) {
        System.out.println("Integer");
    }

    public void print(int i) {
        System.out.println("int");
    }

    public void print(long i) {
        System.out.println("long");
    }

    public static void main(String args[]) {
        Test test = new Test();
        test.print(10);
    }

    static class Shape {
    protected void display() {
        System.out.println("Display-base");
    }
}
// Circle.java
    static class Circle extends Shape { 
    public void display() {
        System.out.println("Display-derived");
    }
}
}


