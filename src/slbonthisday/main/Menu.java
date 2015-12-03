package slbonthisday.main;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Calendar;

public class Menu {

    public void run() {

        try {
            
            String mes = Calendar.getInstance().get(Calendar.MONTH)+1+"";
            String dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"";
            
            
            
            File fXmlFile = new File("xml/"+mes+"-"+dia+".xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("evento");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Em : " + eElement.getElementsByTagName("ano").item(0).getTextContent());
                    System.out.println("aoonteceu : " + eElement.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Detalhes : " + eElement.getElementsByTagName("descricao").item(0).getTextContent());
                    System.out.println("Imagem : " + eElement.getElementsByTagName("imagem").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
