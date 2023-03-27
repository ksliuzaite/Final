package lt.viko.eif.ksliuzaite.system.model;


import javax.persistence.*;
@Entity
@Table(name = "allergen")

public class Allergen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String nameofallergen;

    public Allergen(int id, String nameofallergen) {
        this.id = id;
        this.nameofallergen = nameofallergen;
    }

    public Allergen(String nameofallergen) {
        this.nameofallergen = nameofallergen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameofallergen() {
        return nameofallergen;
    }

    public void setNameofallergen(String nameofallergen) {
        this.nameofallergen = nameofallergen;
    }

    public Allergen(){
    }
    @Override
    public String toString() {
        return String.format("\n\t\t\t\t\t\t\t\tName_of_allergen : %s\n\t\t\t",
                this.nameofallergen);
    }
}

