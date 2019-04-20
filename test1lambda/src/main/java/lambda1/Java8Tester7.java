package lambda1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8Tester7 {
    public static void main(String[] args) {
        Java8Tester7 java8Tester6 = new Java8Tester7();
        List<Employee> employees = java8Tester6.getEmployees();

        List<Employee> list = java8Tester6.getEmployeesBy(employees, e -> e.getSal() >= 3000);
        for(Employee employee:list){
            System.out.println(employee);
        }
        System.out.println("===============");
        list = java8Tester6.getEmployeesBy(employees, e -> e.getSal() >= 3000 && e.getAge()<18);
        for(Employee employee:list){
            System.out.println(employee);
        }


//        List<Employee> list = employees.forEach(employee -> new Filter1(employee));

    }

    public List<Employee> getEmployeesBy(List<Employee> employees,Filter1 filter1){
        List<Employee> list = new ArrayList<>();
        for (Employee employee:employees){
            if(filter1.filter(employee))
                list.add(employee);
        }
        return list;
    }


    public List<Employee> getEmployees(){
        return Arrays.asList(
                new Employee("张三",11,1111),
                new Employee("李四",22,2222),
                new Employee("王二",33,3333),
                new Employee("麻子",44,4444),
                new Employee("王五",55,5555),
                new Employee("赵六",66,6666)
        );
    }

}
