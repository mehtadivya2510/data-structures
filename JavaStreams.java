import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) {
        //Links to questions
        //  https://medium.com/@mehar.chand.cloud/java-stream-coding-interview-questions-part-1-dc39e3575727


        Integer arr[]={1, 2, 3, 4, 5, 6};
        ArrayList<Integer> list=new ArrayList<>(List.of(arr));
        //even num
        System.out.println(list.stream().filter(x->x%2==0).collect(Collectors.toList()));
        //longest string in a list of strings
        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");
        System.out.println(strings.stream().max(Comparator.comparingInt(x->x.length())).get());
        //average age of a list of Person objects
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        System.out.println(persons.stream().mapToInt(x->x.age).average());
        //Remove duplicates from a list -- distinct
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        System.out.println(numbersWithDuplicates.stream().distinct().collect(Collectors.toList()));
        //Given a list of transactions, find the sum of transaction amounts for each day.
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );
        System.out.println(transactions.stream().collect(Collectors.groupingBy(x->x.date,Collectors.summarizingInt(x->x.amount)))); //all statistics
        System.out.println(transactions.stream().collect(Collectors.groupingBy(x->x.date,Collectors.summingInt(x->x.amount)))); //group by date->sum
        System.out.println(transactions.stream().collect(Collectors.groupingBy(x->x.date,Collectors.averagingInt(x->x.amount)))); //group by date->average
        //group by date->average & find max average
        System.out.println(transactions.stream().collect(Collectors.groupingBy(x->x.date,Collectors.averagingInt(x->x.amount)))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get());

        //kth smallest element
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k=3;
        System.out.println("Kth smallest: "+Arrays.stream(array).sorted().skip(k-1).findFirst().getAsInt());

        //find the frequency of each string
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        System.out.println(words.stream().collect(Collectors.groupingBy(x->x,Collectors.counting())));

        //find duplicate elements
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,98,32,15);
        HashSet<Integer> set=new HashSet<>();
        System.out.println("Duplicate items: "+myList.stream().filter(x->!set.add(x)).collect(Collectors.toList()));

        //find the total number of elements
        System.out.println(myList.stream().count());
        //find min value
        System.out.println(myList.stream().min(Comparator.comparingInt(x->x)));
        //find max value
        System.out.println(myList.stream().max(Comparator.naturalOrder()));
        System.out.println(myList.stream().max(Comparator.comparingInt(x->x)));
        System.out.println(myList.stream().min(Comparator.reverseOrder()));

        //find the first non-repeated character
        String input = "Java articles are Awesome";
        Map.Entry<Integer,Long> entry = input.chars().mapToObj(x->x).collect(Collectors.groupingBy(x->x, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue()).findFirst().get();
        System.out.println((char) entry.getKey().intValue());

        //concatenate two Streams - myList & list
        System.out.println(Stream.concat(myList.stream(),list.stream()).collect(Collectors.toList()));

        //find only duplicate elements with its count
        System.out.println(myList.stream().collect(Collectors.groupingBy(x->x,Collectors.counting())).
                entrySet().stream().filter(x->x.getValue()>1).collect(Collectors.toList()));

        //Top N Most Frequent Elements
        List<String> elements= Arrays
                .asList("break", "shake", "make", "break", "shake", "date", "take","break", "shake","break");
        int N=3;
        System.out.println(elements.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(N).collect(Collectors.toList()));

        //Group employees by department and find the highest-paid employee
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 95000),
                new Employee("Bob", "IT", 105000),
                new Employee("Charlie", "IT", 88000),

                new Employee("David", "HR", 75000),
                new Employee("Emma", "HR", 68000),
                new Employee("Fiona", "HR", 82000),

                new Employee("George", "Finance", 120000),
                new Employee("Ginni", "Finance", 120000),
                new Employee("Helen", "Finance", 115000),
                new Employee("Ian", "Finance", 108000),

                new Employee("Jack", "Sales", 90000),
                new Employee("Karen", "Sales", 95000),
                new Employee("Leo", "Sales", 87000)
        );
        System.out.println(employees.stream().collect(Collectors.groupingBy
                (x->x.dept,Collectors.maxBy(Comparator.comparingDouble(x->x.salary)))));

        //Group orders by customer and return only customers whose total order amount exceeds a threshold
        List<Order> orders = Arrays.asList(
                new Order("Alice", 250.00),
                new Order("Alice", 300.50),
                new Order("Alice", 475.00),

                new Order("Bob", 100.00),
                new Order("Bob", 200.00),

                new Order("Charlie", 900.00),
                new Order("Charlie", 250.00),
                new Order("Charlie", 100.00),

                new Order("Diana", 50.00),
                new Order("Diana", 75.00),

                new Order("Edward", 1200.00)
        );
        int threshold=200;
        System.out.println(orders.stream().filter(x->x.amount>=threshold).collect(Collectors.groupingBy(x->x.customer)));

        //employees who have the second highest salary
        System.out.println();
        Map<String, List<Employee>> empMap= employees.stream().collect(Collectors.groupingBy(x->x.dept,
                Collectors.collectingAndThen(Collectors.toList(), tempList->{
                    double secondMax= tempList.stream().mapToDouble(x->x.salary).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
                    return tempList.stream().filter(x->x.salary==secondMax).collect(Collectors.toList());
                })));
        System.out.println(empMap);

        //Partition numbers into primes and non-primes
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
        Map<Boolean, List<Integer>> partitionedPrime = numbers.stream().collect(Collectors.partitioningBy(x->isPrime(x)));
        System.out.println("Prime num"+partitionedPrime.get(true));
        System.out.println("Non Prime num"+partitionedPrime.get(false));

        String[][] names={{"Ram","70"},{"Shyam","40"},{"Ram","50"},{"Shyam","80"},{"Monica","55"}};
        //max avg
        List<Student> students=new ArrayList<>();
        for (int i=0;i<names.length;i++){
            students.add(new Student(names[i][0],Double.parseDouble(names[i][1])));
        }
        System.out.println(students.stream().collect(Collectors.groupingBy(x->x.name,Collectors.averagingDouble(x->x.marks)))
                .entrySet().stream().sorted(
                        (o1, o2) -> {
                            int diff = Double.compare(o2.getValue(), o1.getValue());
                            return (diff==0)? o1.getKey().compareTo(o2.getKey()):diff;
                        }).findFirst().orElse(null));

    }
    private static boolean isPrime(int num){
        if (num<2) return false;
        for (int i=2;i<=num/2;i++){
            if (num%i==0)
                return false;
        }
        return true;
    }
}
class Student{
    String name;
    double marks;
    Student(String name, double marks){
        this.name=name;
        this.marks=marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

class Order {
    String customer;
    double amount;

    public Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer='" + customer + '\'' +
                ", amount=" + amount +
                '}';
    }
}
class Employee {
    String name;
    String dept;
    double salary;
    Employee(String name, String dept, double salary){
        this.name=name;
        this.dept=dept;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class Person{
    String name;
    int age;
    Person(String name, int age){
        this.name=name;
        this.age=age;
    }
}
class Transaction{
    String date;
    int amount;
    Transaction(String name, int age){
        this.date=name;
        this.amount=age;
    }
}

