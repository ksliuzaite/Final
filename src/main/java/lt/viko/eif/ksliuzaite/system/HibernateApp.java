package lt.viko.eif.ksliuzaite.system;

import lt.viko.eif.ksliuzaite.system.model.Menu;
import lt.viko.eif.ksliuzaite.system.model.Dish;
import lt.viko.eif.ksliuzaite.system.model.Ingredient;
import lt.viko.eif.ksliuzaite.system.model.Allergen;
import lt.viko.eif.ksliuzaite.system.util.HibernateUtil;
import lt.viko.eif.ksliuzaite.system.util.JaxbUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class HibernateApp {
    public static void main(String[] args){
        Allergen allergen = new Allergen("Gluten");
        Allergen allergen1 = new Allergen("Lactose");
        Allergen allergen2 = new Allergen("Mustard and their products");
        Allergen allergen3 = new Allergen("Eggs and their products");
        Ingredient ingredient = new Ingredient("Mozzarella");
        Ingredient ingredient1 = new Ingredient("Tomato sauce");
        Ingredient ingredient2 = new Ingredient("pineapples");
        Ingredient ingredient3 = new Ingredient("Chicken fillet");
        Ingredient ingredient4 = new Ingredient("Pork ribs");
        Ingredient ingredient5 = new Ingredient("Chipotle - mustard sauce");
        Ingredient ingredient6 = new Ingredient("Coleslaw salad");
        Ingredient ingredient7 = new Ingredient("Potato wedges");
        Ingredient ingredient8 = new Ingredient("Crispy onion rings");
        Dish dish = new Dish("Hawaiian pizza", 9, List.of(ingredient, ingredient1,ingredient2,ingredient3),List.of(allergen,allergen1));
        Dish dish1 = new Dish("Pork ribs with homemade chipotle - mustard sauce", 12, List.of(ingredient4, ingredient5,ingredient6,ingredient7,ingredient8),List.of(allergen,allergen1,allergen2,allergen3));
        Menu menu = new Menu("Restaurant menu",List.of(dish,dish1));

        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.save(menu);
            transaction.commit();
        }catch(Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Menu> menus = session.createQuery( "from Menu", Menu.class).list();
            menus.forEach(menu1 -> System.out.println(menu1));
            System.out.println("--------------------");
            menus.forEach(menu1 -> JaxbUtil.convertToXML(menu1));

            System.in.read();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {

        }
    }

}
