package homework.lesson11.Employers;

public class Report {

    private static Employee[] employees = new Employee[3];


    public static void main(String[] args) {
        Employee employee1 = new Employee("asd", 2.5);
        Employee employee2 = new Employee("asd", 2.5);
        Employee employee3 = new Employee("asd", 2.5);

        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;

        generalReport(employees);
    }

    private static void generalReport(Employee... employees) {
        for (Employee d : employees) {
            System.out.println(d.toString());
        }
    }
}
