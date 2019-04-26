package operate_xml;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class dom_study {
    //	获取元素的所有子元素，然后循环遍历
//	获取元素的第一个子元素，然后在获取子元素的下一个兄弟元素
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder =factory.newDocumentBuilder();
            Document doc = (Document) builder.parse("java_study/src/main/java/operate_xml/aa.xml");

            Element ele = doc.getDocumentElement();
            NodeList nl = ele.getChildNodes();
            for(int i=0;i<nl.getLength();i++) {
                System.out.println("childnodename:"+nl.item(i).getNodeName());
                NodeList nn = nl.item(i).getChildNodes();
                for(int j=0;j<nn.getLength();j++) {
                    System.out.println(nn.item(j).getNodeName()+":"+nn.item(j).getNodeValue());
                }
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
