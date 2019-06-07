package homework.lesson11.Employers;

import java.util.Arrays;
import java.util.Objects;

public class Employee {
    private String fullname;
    private double salary;
    private Employee[] employees;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Employee(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(fullname, employee.fullname) &&
                Arrays.equals(employees, employee.employees);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fullname, salary);
        result = 31 * result + Arrays.hashCode(employees);
        return result;
    }

    @Override
    public String toString() {
        System.out.printf("Employee's " +
                "fullname='%s" + '\'' +
                ", salary= %.2f", fullname, salary);
        return new String();
    }
}
