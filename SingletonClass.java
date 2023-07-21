public class SingletonClass {
    private static final SingletonClass i=new SingletonClass();;
    private SingletonClass(){}
    public static SingletonClass get(){
        return i;
    }
    public static void main(String[] args) {
        SingletonClass s1=get();
        SingletonClass s2=get();
        System.out.println(s1==s2);
    }
}
