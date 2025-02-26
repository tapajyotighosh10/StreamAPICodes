package com.java.stream.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Top25Questions {
    public static void main(String[] args) {
        System.out.println("Top 25 java 8 interview questions...");
        List<Integer> nums= Arrays.asList(10,12,22,12,5,100,13,53,55);

        System.out.println("1. Find first element..");

        nums.stream().findFirst().ifPresent(System.out::println);

        System.out.println("2. Find the total number of elements present in the list..");
        System.out.println(nums.stream().count());
        System.out.println("3. find the all even integer in the given list...");

        List<Integer> evenList= nums.stream().filter(n->n%2==0).collect(Collectors.toList());
        System.out.println(evenList);
        System.out.println("4. find the all odd integer in the given list...");
        List<Integer> oddList= nums.stream().filter(n->n%2!=0).collect(Collectors.toList());
        System.out.println(oddList);
        System.out.println("5. Find out numbers starting with 5...");
        nums.stream().filter(n-> n.toString().startsWith("5")).forEach(System.out::println);
        System.out.println("6. Find duplicate element in the list...");

        Set<Integer> temp=new HashSet<>();
        nums.stream().filter(n->!temp.add(n)).forEach(System.out::println);

        System.out.println("7. Find the maximum and minimum value element present in it using stream api...");
        nums.stream().max(Integer::compareTo).ifPresent(maxVal -> System.out.println("Maximum value: " + maxVal));
        nums.stream().min(Integer::compareTo).ifPresent(maxVal -> System.out.println("Minimum value: " + maxVal));

        System.out.println("8. Sort all the values in accending present in it using stream api...");
        nums.stream().sorted().forEach(System.out::println);
        System.out.println("9. Sort all the values in descending present in it using stream api...");
        nums.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("10. Check array contains duplicate values or not...");
        int arr[]={1,2,4,5,3,4};
        if(Arrays.stream(arr).distinct().count()!=arr.length){
            System.out.println("It contain duplicate value");
        } else {
            System.out.println("It contains unique value");
        }

        System.out.println("11. Java 8 program to perform square on list elements and filter numbers greater than 50...");
        nums.stream().map(x->x*x).filter(n->n>50).forEach(System.out::println);

        System.out.println("12. Java program to sort an array and convert array into stream...");
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("13. How to use map to convert words in uppercase...");
        List<String> words= Arrays.asList("Dev","Byte","School","College","Byte");
        words.stream().map(e->e.toUpperCase()).forEach(System.out::println);

        System.out.println("14.Maximum element present in an array..");
        Arrays.stream(arr).max().ifPresent(System.out::println);

        System.out.println("15.write a program to concatenate two streams...");
        Stream<Integer> s1=Stream.of(1,2,3,4);
        Stream<Integer> s2=Stream.of(5,6,7,8,4);

        Stream.concat(s1,s2).distinct().forEach(System.out::println);

        System.out.println("16.write a program in stream to print 10 random numbers...");
        Random random=new Random();
        Stream.generate(random::nextInt).limit(10).forEach(System.out::println);

        System.out.println("17. Print date and time using java 8...");
        LocalDateTime localDateTime= LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println("18. Then format it in dd-MM-YYYY format...");
        DateTimeFormatter localDateTimeFormat= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(localDateTimeFormat.format(localDateTime));
        System.out.println("19. How to check if list is empty in java 8 using Optional, "+
                "if not null iterate through the list and print the objects....");
        List<String> list=null;
        Optional<List<String>> optionalList=Optional.ofNullable(list);
        optionalList.ifPresentOrElse(e->e.stream().forEach(System.out::println),()-> System.out.println("this list is empty."));

        System.out.println("20. Given an array {10, 1,20,2,100,100,100}, write a java codes"+
                "using java stream to determine the number of occurrences of a particular value.");
        int[] values={10, 1,20,2,100,100,100};
        int number=100;
        long result = Arrays.stream(values).filter(v->v==number).count();
        System.out.println("count of number:"+result);


        System.out.println("21. Finds only duplicate elements with its count from from the string ArrayList");
        Map<String,Long> map = words.stream().collect(Collectors.groupingBy(s->s,Collectors.counting()));
        map.entrySet().stream().filter(m->m.getValue()>1).forEach(m -> System.out.println(m.getKey()+": "+m.getValue()));

        System.out.println("22. Odd even using groupingBy");
        List<Integer> numbers = Arrays.asList(10, 21, 32, 45, 56, 67, 78, 89, 90);
        Map<String, List<Integer>> groupedNumbers = numbers.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd"));
        System.out.println(groupedNumbers);

        System.out.println("23. Sum of salary of all employees");
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 70000),
                new Employee("Charlie", "IT", 80000),
                new Employee("David", "Finance", 60000),
                new Employee("Eve", "HR", 55000)
        );
        System.out.println(employees.stream().mapToDouble(Employee::getSalary).sum());


        System.out.println("24. program to print the count of each character in a string using stream");
        String str= "tapajyoti";
        Map<Character, Long> charCount = str.chars()  // Convert to IntStream
                .mapToObj(c -> (char) c)  // Convert int to Character
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCount);
    }
}
