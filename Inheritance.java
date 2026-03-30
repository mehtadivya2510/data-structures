class Animal {
    public void makeSound() {
        try{
            System.out.println("The animal makes a sound.");
            System.out.println(Days.Mon.num);
            System.exit(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("finally");
        }

    }
    public static void make() {
        System.out.println("MAKE animal");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog barks.");
    }
    public static void make() {
        System.out.println("MAKE dog");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Animal myAnimal = new Dog(); // Reference type is Animal, actual object type is Dog
        myAnimal.makeSound();
        Animal myAnimal2 = new Animal();
        myAnimal2.makeSound();
        myAnimal.make();
    }
}

enum Days{
    Mon(1), Tues, Wed(3), Thur, Fri, Sat, SUn;
    int num;
    Days(int num){
        this.num=num;
    }
    Days(){
        this.num=-1;
    }
}
