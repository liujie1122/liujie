package lambda1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8Tester6 {
    public static void main(String[] args) {
        Java8Tester6 java8Tester6 = new Java8Tester6();
        List<Employee> employees = java8Tester6.getEmployees();

        List<Employee> list = java8Tester6.getEmployeesBy(employees);
        System.out.println(list.toString());

    }


    public List<Employee> getEmployeesBy(List<Employee> employees){
        List<Employee> list = new ArrayList<>();
        for (Employee employee:employees){
            if (employee.getAge()>30)
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
