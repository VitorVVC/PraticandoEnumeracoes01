package entities;

import entitiesEnum.WorkerLevel;

import java.util.ArrayList;

public class Worker {

    // Atributos de Worker
    private String name;
    private WorkerLevel level;
    private Double baseSalary;


    // Atributos que associam-se a worker
    private ArrayList<HourContract> contracts = new ArrayList<>();
    private Department department;

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public double income(int year, int month) {
        double newSalary = baseSalary;
        for (HourContract contract : contracts) {
            int contractYear = contract.getDate().getYear();
            int contractMonth = contract.getDate().getMonthValue();
            if (year == contractYear && month == contractMonth) {
                newSalary += contract.totalValue();
            }
        }
        return newSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartament() {
        return department;
    }

    public void setDepartament(Department department) {
        this.department = department;
    }

    public ArrayList<HourContract> getContracts() {
        return contracts;
    }
}
