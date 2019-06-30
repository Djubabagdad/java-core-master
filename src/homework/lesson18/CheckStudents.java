package homework.lesson18;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CheckStudents {

    private static int course;
    private static LinkedList<Student> students = new LinkedList<>();


    public static void main(String[] args) {
        students.add(new Student("Vasya", "fk10", 1, 2));
        students.add(new Student("Petya", "fk10", 1, 5));
        students.add(new Student("Yulia", "fk10", 1, 3));

        Iterator<Student> iterator = students.iterator();

       while(iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getScore() < 3) {
                iterator.remove();
            } else if (student.getScore() >= 3) {
                course = student.getCourse();
                course++;
                student.setCourse(course);
            }
        }
        printStudents(students, course);
    }

    private static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            System.out.println(student.getName() + " " + course);
        }
    }
}
