package lt.viko.eif.ksliuzaite.system.model;

import jakarta.xml.bind.annotation.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private int id;
    private String nameofdish;
    private int price;
    @XmlElementWrapper(name = "ingredients")
    @XmlElement(name = "ingredient")
    @OneToMany(targetEntity = Ingredient.class,cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    @XmlElementWrapper(name = "allergens")
    @XmlElement(name = "allergen")
    @OneToMany(targetEntity = Allergen.class,cascade = CascadeType.ALL)
    private List<Allergen> allergens;


    public Dish(int id, String nameofdish, int price, List<Ingredient> ingredients,List<Allergen> allergens) {
        this.id = id;
        this.nameofdish = nameofdish;
        this.price = price;
        this.ingredients = ingredients;
        this.allergens = allergens;
    }

    public Dish(String nameofdish, int price, List<Ingredient> ingredients,List<Allergen> allergens) {
        this.nameofdish = nameofdish;
        this.price = price;
        this.ingredients = ingredients;
        this.allergens = allergens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameofdish() {
        return nameofdish;
    }

    public void setNameofdish(String nameofdish) {
        this.nameofdish = nameofdish;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Allergen> getAllergens() {
        return allergens;
    }

    public void setAllergens(List<Allergen> allergens) {
        this.allergens = allergens;
    }

    public Dish(){
    }

    @Override
    public String toString() {
        return String.format("\t\tDish : \n\t\t\t" +
                        "\tName_of_dish : %s\n\t\t\t" +
                        "\t\tPrice = %d\n\t\t\t" +
                        "\t\tIngredients : %s\n\t\t\t" +
                        "\t\t\t\tAllergens : %s\n\t\t\t",
                this.nameofdish,
                this.price,
                constructIngredientString(),
                constructAllergenString());
    }
    private String constructIngredientString(){
        String result = "";
        for (Ingredient ingredient : this.ingredients){
            result += ingredient.toString();
        }
        return result;
    }

    private String constructAllergenString(){
        String result = "";
        for (Allergen allergen : this.allergens){
            result += allergen.toString();
        }
        return result;
    }
}
