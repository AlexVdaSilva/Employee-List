package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		List <Employee> empData = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Employee #" + (i+1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			Employee emp = new Employee(id, name, salary);
			
			empData.add(emp);
			
		}
		
		System.out.println();
		System.out.print("Enter the employee id that will have a salary increase: ");
		int idSalary = sc.nextInt();
		
		Employee emp = empData.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		
		if (emp == null) {
			System.out.println("This id does not exist!");
		}
		else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		
		System.out.println();
		System.out.println("List of employees:");
		for (Employee e: empData) {
			System.out.print(e);
		}

		sc.close();
		
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
