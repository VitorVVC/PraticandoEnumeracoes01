package entities;

public class Department {

    // Classe departament que possue apenas um Nome como parametro
    private String name;

    public Department(String name) {
        this.name= name;
    }


    // Get & Set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
