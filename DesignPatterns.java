public class DesignPatterns {
    
    static class Singleton{
        private int a;
        private Singleton s;
        private Singleton(int a){this.a=a;}

        public Singleton getInstance(int a){
            if (s==null){
                s=new Singleton(a);
            }
            return s;
        }
    }

    public interface Factory{
        void method1();
        void method2();
    }

    static class FactoryProducer{
        public Factory getFactory(String type){
            if(type.equals("c1")){return new FactoryConsumer1();}
            else if(type.equals("c2")){return new FactoryConsumer2();}
            return null;
        }
    }

    static class FactoryConsumer1 implements Factory{
        @Override
        public void method1() {
        }
        @Override
        public void method2() {
        }
    }

    static class FactoryConsumer2 implements Factory{
        @Override
        public void method1() {
        }
        @Override
        public void method2() {
        }
    }

    static class Builder{
        int a,b,c;
        Builder(int a,int b,int c){
            this.a=a; this.b=b; this.c=c;
        }
        
        @Override
        public String toString() {
            return a +" "+b+ " "+c;
        }

    }

    static class DesignBuilder{
        int a,b,c;
        public DesignBuilder setA(int a){
            this.a=a;
            return this;
        }
        public DesignBuilder setB(int a){
            this.b=a;
            return this;
        }
        public DesignBuilder setC(int a){
            this.c=a;
            return this;
        }

        public Builder getBuilder(){
            return new Builder(this.a,this.b,this.c);
        }

    }

    public static void main(String[] args) {
        Builder db= new DesignBuilder().setA(1).setC(3).getBuilder();
        System.out.println(db);
    }
}
