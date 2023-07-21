import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    int id;
    String name;
    String dept;
    float salary;

    Employee(int id, String name, String dept, float salary){
        this.id=id;
        this.name=name;
        this.dept=dept;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return this.name +"  " + this.dept;
    }

  public static void main(String[] args) {
    Employee e1=new Employee(1, "ABC", "Chem", 1000);
    Employee e2=new Employee(1, "PQR", "Chem", 2000);
    Employee e3=new Employee(1, "ABC", "Phy", 2000);

    ArrayList<Employee> list=new ArrayList<>();
    list.add(e1); list.add(e2);list.add(e3);

    List<Employee> list2= list.stream().sorted(new Comparator<Employee>() {
            @Override
    public int compare(Employee o1, Employee o2) {
        int temp= o1.name.compareTo(o2.name);
        if(temp==0)
            return o1.dept.compareTo(o2.dept);
        else
            return temp;
    }
    }).collect(Collectors.toList());

    System.out.println(list2);


}
  
  
}
