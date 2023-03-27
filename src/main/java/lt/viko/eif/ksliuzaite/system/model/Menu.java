package lt.viko.eif.ksliuzaite.system.model;

import jakarta.xml.bind.annotation.*;
import javax.persistence.*;
import java.util.List;

/**
 * Holds student's data.
 * @author Kornelija
 * @since 1.0
 */
@XmlRootElement(name = "Menu")
@XmlType(propOrder = {"id","title","dishes"})
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private int id;
    private String title;
    @XmlElementWrapper(name = "dishes")
    @XmlElement(name = "dish")
    @OneToMany(targetEntity = Dish.class,cascade = CascadeType.ALL)
    private List<Dish> dishes;
    public Menu(int id, String title, List<Dish> dishes) {
        this.id = id;
        this.dishes = dishes;
        this.title = title;
    }

    public Menu(String title, List<Dish> dishes) {
        this.dishes = dishes;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    public Menu() {

    }

    @Override
    public String toString() {
        return String.format("Menu:\n\t" +
                        "title: %s\n\t" +
                        "\tDishes: \n\t%s\n",
                this.title,
                constructDishString());

    }
    private String constructDishString(){
        String result = "";
        for (Dish dish : this.dishes){
            result += dish.toString();
        }
        return result;
    }

}