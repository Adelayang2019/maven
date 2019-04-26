package operate_xml;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class domOperXML {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder =factory.newDocumentBuilder();
            Document doc = builder.parse("java_study/src/main/java/operate_xml/aa.xml");
            NodeList node = doc.getElementsByTagName("student");
            for(int i=0;i<node.getLength();i++) {
                Element e = (Element) node.item(i);
                System.out.println("name:"+e.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
                System.out.println("age:"+e.getElementsByTagName("age").item(0).getFirstChild().getNodeValue());
                System.out.println("sex:"+e.getElementsByTagName("sex").item(0).getFirstChild().getNodeValue());
            }
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
