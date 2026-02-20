package id.ac.polban.employee.service;

import java.util.HashMap;
import java.util.Map;
import id.ac.polban.employee.model.*;

public class EmployeeService {
    private Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void raiseSalary(int id, double percent) {
        Employee emp = employees.get(id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() * (1 + percent / 100));
        }
    }

    public static void printEmployeeInfo(Employee emp) {
        System.out.println("ID       : " + emp.getId());
        System.out.println("Nama     : " + emp.getName());
        System.out.println("Dept     : " + emp.getDepartment().getName());
        System.out.println("Tipe     : " + emp.getType().getType());
        System.out.println("Gaji     : Rp. " + emp.getSalary());
        System.out.println("----------------------------------------");
    }

    public void printAllEmployees() {
        System.out.println("========== DAFTAR EMPLOYEE ==========");
        for (Employee emp : employees.values()) {
            printEmployeeInfo(emp);
        }
        System.out.println("Total Employee  : " + Employee.getTotalEmployee());
        System.out.println("Total Department: " + Department.getTotalDepartment());
    }
}