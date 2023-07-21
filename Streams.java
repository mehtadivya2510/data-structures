import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>(Arrays.asList(21,3,54,7,21,6,8,10,9));
        System.out.println(set);

        //filter
        set.stream().filter(val -> val%2==0).sorted().forEach(val-> System.out.println(val));
        //map       //sorted
        set.stream().map(val-> val+2).sorted().forEach(val-> System.out.print(val+" "));;
        //reduce
        List<Integer> list=set.stream().filter(val->val<4).collect(Collectors.toList());
        System.out.println(list+" "+list.stream().reduce((c,e)->c+e));
        //count number of elements
        System.out.println("Count: "+set.stream().count());
        //min and max
        System.out.println("MAX:"+set.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer-t1;
            }
        })+" MIN: "+ set.stream().min(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer-t1;
            }
        }));
        //toArray
        Object arr[]=set.stream().toArray();
        //Of method
        Stream.of(1,2,3,4,5,6).map(x->x*x).forEach(x-> System.out.print(x+"  "));
        Stream.of("divya").forEach(x-> System.out.println(x+" "));
        //parallel stream
        ArrayList<Integer> arrList=new ArrayList<>(Arrays.asList(4,6,8,9,2,34));
        arrList.stream().forEach(x-> System.out.print(x+" "));
        System.out.println();
        arrList.parallelStream().forEach(x-> System.out.print(x+" "));
        System.out.println();
        //flatMap- flattens list of list        //distinct
        Employee e1=new Employee("ABC",new ArrayList(Arrays.asList("Pune","Bangalore")),"Physics",30);
        Employee e2=new Employee("PQR",new ArrayList(Arrays.asList("Nagpur","Bangalore")),"Chemistry",28);
        Employee e3=new Employee("xyZ",new ArrayList(Arrays.asList("Pune","Bangalore","Hyd")),"Physics",29);
        ArrayList<Employee> emplist=new ArrayList<>(Arrays.asList(e1,e2,e3));
        List<List<String>> cities= emplist.stream().map(e-> e.getCities()).collect(Collectors.toList());
        System.out.println(cities);
        List<String> flatList=emplist.stream().flatMap(x->x.getCities().stream()).distinct().collect(Collectors.toList());
        System.out.println(flatList);
        //grouping [groupBy]
            //group by the employees based on their department
        Map<String, List<Employee>> deptGrouping= emplist.stream().collect(Collectors.groupingBy(emp->emp.getDept()));
        System.out.println(deptGrouping);
        //summary statistics- max,min,avg,count,sum

        //skip and limit for slicing
        Object[] sortedEmployees= emplist.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.name.compareTo(e2.name);
            }
        }).toArray();
        Stream s1=Stream.of(sortedEmployees);
        Stream s2=Stream.of(sortedEmployees);
        Stream s3=Stream.of(sortedEmployees);
        System.out.println("First emp: "+s1.limit(1).collect(Collectors.toList()));
        System.out.println("Last emp:"+s2.skip(s3.count()-1).collect(Collectors.toList()));

        //get summary statistics-max,min,avg,sum  [IntSummaryStatistics]
        IntSummaryStatistics  summary=emplist.stream().map(e->e.getAge()).mapToInt(x->x).summaryStatistics();
        System.out.println("max age: "+summary.getMax());
        System.out.println("min age: "+summary.getMin());
        System.out.println("sum of ages: "+summary.getSum());
        System.out.println("avg age: "+summary.getAverage());

        //joining-return in form of string
            //Eg: get all names separated by comma
        String empNames= emplist.stream().map(e->e.getName()).collect(Collectors.joining(", "));
        System.out.println(empNames);

        //mapToInt -- IntegerStream
        ArrayList<String> str=new ArrayList<>(Arrays.asList("1","2","3"));
        int[] intArray= str.stream().mapToInt(x->Integer.parseInt(x)).toArray();
        for(int el:intArray)
            System.out.print(el+"  ");

        //find duplicate elements
        ArrayList<Integer> duplicateList= new ArrayList<>(Arrays.asList(2,2,4,6,7,8,8,10,3,7,1,0));
        Map<Integer, List<Integer>> map=duplicateList.stream().collect(Collectors.groupingBy(x->x));
        System.out.println("\nDuplicate values: ");
        map.forEach((key,value)->{
            if(value.size()>1)
                System.out.print(key+"  ");
        });

    }

    static class Employee{
        String name;
        String dept;
        List<String> cities;
        int age;
        Employee(String name, ArrayList cities,String dept,int age){
            this.name=name;
            this.cities=cities;
            this.dept=dept;
            this.age=age;
        }
        public List<String> getCities(){
            return cities;
        }
        public String getDept(){
            return dept;
        }
        public int getAge(){
            return age;
        }
        public String getName(){
            return name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
    
}
