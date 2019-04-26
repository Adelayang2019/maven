package operate_xml;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;


public class studentsDom4j {
    //	dom4j遍历student.xml
    public void students() {

        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read("java_study/src/main/java/operate_xml/aa.xml");
            Element element = doc.getRootElement();
            List<Element> li = element.elements();
            for(int i=0;i<li.size();i++) {
                System.out.print(li.get(i).getName()+"'s number is "+li.get(i).attributeValue("number")+"\n");
                System.out.println("name:"+li.get(i).elementText("name"));
                System.out.println("age:"+li.get(i).elementText("age"));
                System.out.println("sex:"+li.get(i).elementText("sex"));

            }

        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //	 给学生元素添加<score>子元素
    public void addScore() {
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read("java_study/src/main/java/operate_xml/aa.xml");
            Element root = doc.getRootElement();
            List<Element> element = root.elements();
            for(int i=0;i<element.size();i++) {
                element.get(i).addElement("score");
                element.get(i).setText("90");
            }
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        studentsDom4j sd = new studentsDom4j();
        sd.addScore();
        sd.students();
    }
}
