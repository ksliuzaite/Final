package lt.viko.eif.ksliuzaite.system.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lt.viko.eif.ksliuzaite.system.model.Menu;

import java.io.FileNotFoundException;

public class JaxbUtil {

    public static void convertToXML (Menu menu){
        try {
            JAXBContext context = JAXBContext.newInstance(Menu.class);

            Marshaller marshaller = null;

            marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formated.output",Boolean.TRUE);
            //OutputStream os = new FileOutputStream("generated.xml");
            marshaller.marshal(menu, System.out);
        }catch (/*FileNotFoundException | */JAXBException e){
            throw new RuntimeException(e);
        }
    }
}
