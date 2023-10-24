package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entitiesEnum.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Util {
        // Criacão de métodos static para auxiliar nos métodos do código inteiro
        public static Scanner sc =  new Scanner(System.in);
        public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        public static DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MM/yyyy");

        // Método para retornar um novo funcionario
    public static Worker userInfo() {
        System.out.print("Enter department's name: ");
        String department = sc.next();
        sc.nextLine();

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Level: ");
        WorkerLevel workerLevel = WorkerLevel.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Base salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        return new Worker(name, workerLevel, salary, new Department(department));
    }

    // Método para pedirmos informacões de um contrato e referente a um worker como parametro
    // adicionar ao mesmo um contrato.
    public static void contractsInfo(Worker cnpjoto) {
        System.out.print("How many contracts to this worker? ");
        int quantidade = sc.nextInt();
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Enter contract #" + (i + 1) + " data: ");
            sc.nextLine();
            System.out.print("Date (DD/MM/YYYY): ");
            LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
            System.out.print("Value per Hour: ");
            double contractSalary = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int duration = sc.nextInt();
            HourContract contract = new HourContract(date, contractSalary, duration);
            cnpjoto.addContract(contract);
        }
    }

    // Método para realizar um calculo referente ao quanto um Worker parametral
    // recebeu em X mes, levando em conta seu salario atual e contratos do mes.
    public static void calcByThe(Worker cnpjoto) {
        sc.nextLine();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        YearMonth yearMonth = YearMonth.parse(sc.nextLine(), dtf2);
        int monthValue = yearMonth.getMonthValue();
        int year = yearMonth.getYear();

        System.out.println("Name: " + cnpjoto.getName());
        System.out.println("Department: " + cnpjoto.getDepartament().getName());
        System.out.println("Income for (" + yearMonth.format(dtf2) + "): " + String.format("%.2f", cnpjoto.income(year, monthValue)));
    }
}
