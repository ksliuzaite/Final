package lt.viko.eif.ksliuzaite.system;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.ksliuzaite.system.model.Menu;
import lt.viko.eif.ksliuzaite.system.model.Dish;
import lt.viko.eif.ksliuzaite.system.model.Ingredient;
import lt.viko.eif.ksliuzaite.system.model.Allergen;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
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
        System.out.println(menu);
        JAXBContext context = JAXBContext.newInstance(Menu.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        OutputStream os = new FileOutputStream("generated.xml");
        marshaller.marshal(menu, System.out);
        marshaller.marshal(menu, os);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Path path = Path.of("generated.xml");

        String xmlContent = Files.readString(path);
        System.out.print(xmlContent);

        StringReader reader = new StringReader(xmlContent);

        Menu menu1 = (Menu) unmarshaller.unmarshal(reader);

        System.out.println(menu1);
    }
}
