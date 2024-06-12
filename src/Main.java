import pojo.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Added here new changes

       // This is stat rt of programing
     // join() method
        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 6, 6, 7, 2);
        numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        int sendhigh[] = {12,34,23,45,23,56,76,11};
       Integer no =  Arrays.stream(sendhigh).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

        String str = "madam";
        String temp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            temp = temp + str.charAt(i);
        }
        if (str.equals(temp)) {
            System.out.println("String Palindrom " + temp);
        } else {
            System.out.println("String not pallindrom " + temp);
        }
        // System.out.println("String reverse " +temp);

        String input = "This is pune city";
        String split[] = input.split(" ");
        int s1 = split.length;
        System.out.println(s1);
        int count = 0;
        for (String s : split) {
           count++;
            String output = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                output = output + s.charAt(i);
            }
            if(split.length == count){
                System.out.print(output);
            }else{
                System.out.print(output + " ");
            }


        }


        List<Employee> employees = Arrays.asList(
                new Employee("Vijay Reddy", 30000, 1),
                new Employee("Amit Shah", 60000, 2),
                new Employee("Sara Khan", 50000, 3),
                new Employee("Amit Shah", 40000, 4)
        );

        List<Employee> employeesForDuplicate = Arrays.asList(
                new Employee("Vijay Reddy", 30000, 1),
                new Employee("Amit Shah", 60000, 2),
                new Employee("Sara Khan", 50000, 3),
                new Employee("Amit Shah", 40000, 4),
                new Employee("Amit Shah", 80000, 5)
        );
        // Sorting with name and sallary

        List<Employee> sortedEmpl = employees.stream().sorted(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getSalary)).collect(Collectors.toList());

        sortedEmpl.forEach(System.out::println);

        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder())
                        .thenComparing(Employee::getSalary, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        sortedEmployees.forEach(System.out::println);

        //Convert list into map
        Map<Integer, String> map = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println(map);

        // Convert list into map but remove duplicate
        Map<String, Double> duplicateRecord = employeesForDuplicate.stream()
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary, (oldValue, newValue) -> newValue));
        System.out.println(duplicateRecord);
       Main main = new Main();
        main.nullEmptyCheck();

        List<String> colors = Arrays.asList("fssff","dsseee");
        List<String> uppercase = colors.stream().map(String :: toUpperCase).collect(Collectors.toList());
        System.out.println(uppercase);

    }

    void nullEmptyCheck(){

        String str = "";
        String str2 = null;

        if(str.isEmpty()){
            System.out.println("Empty");
        }else{
            System.out.println("Not empty");
        }

        if(str2 == null){
            System.out.println("Null");
        }else{
            System.out.println("Not null ");
        }

    }

}