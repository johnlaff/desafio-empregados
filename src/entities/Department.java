package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private Integer payDay;

    private List<Employee> employees = new ArrayList<>();
    private Address address;

    public Department(Address address, Integer payDay, String name) {
        this.address = address;
        this.payDay = payDay;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPayDay() {
        return payDay;
    }

    public void setPayDay(Integer payDay) {
        this.payDay = payDay;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        this.employees.remove(employee);
    }

    public Double payroll(){
        Double payroll = 0.0;
        for (Employee employee : employees){
            payroll += employee.getSalary();
        }
        return payroll;
    }

}
