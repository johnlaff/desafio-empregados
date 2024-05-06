package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String departmentName = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        Integer departmentPayDay = sc.nextInt();
        System.out.print("Email: ");
        sc.nextLine();
        String addressEmail = sc.nextLine();
        System.out.print("Telefone: ");
        String addressPhone = sc.nextLine();

        Address address = new Address(addressEmail, addressPhone);
        Department department = new Department(address, departmentPayDay, departmentName);

        System.out.print("Quantos funcionários tem o departamento? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.printf("Dados do funcionário %d:\n", i+1);
            sc.nextLine();
            System.out.print("Nome: ");
            String employeeName = sc.nextLine();
            System.out.print("Salário: ");
            Double employeeSalary = sc.nextDouble();
            Employee employee = new Employee(employeeName, employeeSalary);
            department.addEmployee(employee);
        }

        showReport(department);

        sc.close();
    }

    public static void showReport(Department dept) {
        System.out.println("\nFOLHA DE PAGAMENTO:");
        System.out.printf("Departamento %s = R$ %.2f\n", dept.getName() ,dept.payroll());
        System.out.printf("Pagamento realizado no dia %d\n", dept.getPayDay());
        System.out.println("Funcionários:");
        for (Employee funcionario : dept.getEmployees()){
            System.out.println(funcionario);
        }
        System.out.printf("Para dúvidas favor entrar em contato: %s", dept.getAddress().getEmail());
    }
}
