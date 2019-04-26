package operate_xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;


public class Dom4joPerXML {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("java_study/src/main/java/operate_xml/aa.xml"));
            System.out.println(document.getRootElement());
//			dom4jList(document.getRootElement());
            Element el = document.getRootElement();
            List element = el.elements();
            for(int i=0;i<element.size();i++) {

            }
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void dom4jList(Element element) {
        System.out.println(element.getName()+":"+element.getTextTrim());

        Iterator iterator = element.elementIterator();
        while(iterator.hasNext()) {
            Element e = (Element) iterator.next();
            dom4jList(e);
        }

    }

}
