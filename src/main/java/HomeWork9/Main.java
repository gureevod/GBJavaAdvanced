package HomeWork9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Stasik", Arrays.asList(new Course("Math"), new Course("Testing"),
                new Course("PE"))));
        students.add(new Student("Mark", Arrays.asList(new Course("QA"),
                new Course("Eng"), new Course("Math"), new Course("Physics"))));
        students.add(new Student("Olga", Arrays.asList(new Course("Literature"))));

        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .collect(Collectors.toSet()));


        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));

        
        Course course = new Course("Math");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
