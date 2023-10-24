package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entitiesEnum.WorkerLevel;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Segue dicas para melhor leitura do código !!!
        // Oque tiver ao lado de elementos como "Enter department's name: " // Design
        // é uma sugestao sobre oque deve ser escrito para o teste do progama
        // Comentários que iniciarem com // e acabarem com \\ são descricões sobre os métodos a seguir

        // Formatacão de datas, para dia, mes e ano e somente para mes e ano \\
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MM/yyyy");

        // Inicio do progama: \\

        System.out.print("Enter department's name: "); // Design
        String departament = sc.next();
        sc.nextLine();

        System.out.println("Enter worker data: ");
        System.out.print("Name: "); // Alex
        String name = sc.nextLine();
        System.out.print("Level: "); // mid_level
        WorkerLevel workerLevel = WorkerLevel.valueOf(sc.nextLine().toUpperCase());
        System.out.print("Base salary: "); // 1200.00
        double salary = sc.nextDouble();
        sc.nextLine();
        // Cria um trabalhador chamado cnpjoto com tudo que foi respondido pelo progama \\
        Worker cnpjoto = new Worker(name, workerLevel, salary, new Department(departament));

        // Pede um valor de quantos contratos serão adicionados, e referente ao valor respondido percorra o mesmo valor
        // para adicionar contratos \\
        System.out.print("How many contracts to this worker? "); // 3
        int quantidade = sc.nextInt();
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Enter contract #" + (i + 1) + " data: ");
            sc.nextLine();
            System.out.print("Date (DD/MM/YYYY): "); // 1: 20/08/2018 // 2: 13/06/2018 // 3: 25/08/2018
            LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
            System.out.print("Value per Hour: "); // 1: 50.00 // 2: 30.00 // 3: 80.00
            double contractSalary = sc.nextDouble();
            System.out.print("Duration (hours): "); // 1: 20 // 2: 18.00 // 3: 10.00
            int duration = sc.nextInt();
            HourContract contract = new HourContract(date, contractSalary, duration);
            // Adiciona aos contratos de cnpojoto ( worker ) o " contrato[i] " \\
            cnpjoto.addContract(contract);
        }
        // Pede o mes que ele deseja saber seu faturamento, faturamento esse que é = salario base + salario de contratos
        // daquele mes em especifico \\
        sc.nextLine();
        System.out.print("Enter month and year to calculate income (MM/YYYY): "); // 08/2018
        // Recebe o mes e ano referentes e armazena cada um em uma variavel INT para mais precisão em outros métodos \\
        YearMonth yearMonth = YearMonth.parse(sc.nextLine(), dtf2);
        int monthValue = yearMonth.getMonthValue();
        int year = yearMonth.getYear();
        sc.close();

        // Printa o Nome, Departamento & o quanto ele faturou no mes pedido anteriormente \\
        System.out.println("Name: " + cnpjoto.getName());
        System.out.println("Department: " + cnpjoto.getDepartament().getName());
        System.out.println("Income for (" + yearMonth.format(dtf2) + "): " + String.format("%.2f", cnpjoto.income(year, monthValue)));
    }
}