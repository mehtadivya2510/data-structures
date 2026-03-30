public class Generics {
    public static void main(String[] args) {
        GenericClass<String,Integer> genericClass=new GenericClass<>("Vijay",67);
        genericClass.display();

        Emp employee= new Emp("Naina", 34);
        GenericClass<Emp,Integer> genericClass1=new GenericClass<>(employee, 10);
        genericClass1.display();

        Emp emp= new Emp("Bina", 46);
        genericMethod(emp);
    }
    
    public static <T> void genericMethod(T t){
        System.out.println("From generic method: "+t);
    }
}

class GenericClass<T,U>{
    T instance1;
    U instance2;
    GenericClass(T t, U u){
        this.instance1=t;
        this.instance2=u;
    }
    public void display(){
        System.out.println("Member 1: "+instance1);
        System.out.println("Member 2: "+instance2);
    }
}

class Emp{
    String name;
    Integer age;
    Emp(String name, Integer age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
