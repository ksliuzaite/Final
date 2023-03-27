package lt.viko.eif.ksliuzaite.system.model;

import javax.persistence.*;
@Entity
@Table(name = "ingredient")

public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String nameofingredient;

    public Ingredient(int id, String nameofingredient) {
        this.id = id;
        this.nameofingredient = nameofingredient;
    }

    public Ingredient(String nameofingredient) {
        this.nameofingredient = nameofingredient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameofingredient() {
        return nameofingredient;
    }

    public void setNameofingredient(String nameofingredient) {
        this.nameofingredient = nameofingredient;
    }

    public Ingredient(){
    }
    @Override
    public String toString() {
        return String.format("\n\t\t\t\t\t\tNameofingredient= %s\n\t\t\t",
                this.nameofingredient);
    }
}
