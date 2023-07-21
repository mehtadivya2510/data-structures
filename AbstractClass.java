abstract class AbstractClass1 {
    void run(){
        System.out.println("inside run");
    }
    void run1(){
        System.out.println("inside run");
    }
    void run2(){
        System.out.println("inside run");
    }
}
abstract class AbstractClass2 {
    abstract void run2();
}

interface A{
    default void run(){
        System.out.println("inside A");
      };
}

interface B{
    default void run2(){
        System.out.println("inside B");
    }
}

class AbstractClass implements A,B{
    public static void main(String[] args) {
        (new AbstractClass()).run();
        (new AbstractClass()).run2();
    }

}
