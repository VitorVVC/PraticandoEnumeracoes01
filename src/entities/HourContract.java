package entities;

import java.time.LocalDate;
import static application.Util.dtf;

public class HourContract {

    // Criando classe hourContract que tem como dados, uma data, valor por hora e horas trabalhadas
    private LocalDate date;
    private Double valuePerHour;
    private Integer hours;

    // Construtor
    public HourContract(LocalDate date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    // Sobrescrita do método toString para uma melhoria em seu print
    @Override
    public String toString() {
        return String.format("Date: %s%nValuePerHour: %.2f%nHours: %d", dtf.format(date), valuePerHour, hours);
    }
    // Método para calcular um valor total de um contrato
    public double totalValue() {
        return valuePerHour * hours;
    }

    // Getters & Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }


}
