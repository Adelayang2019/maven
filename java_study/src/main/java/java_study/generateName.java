package java_study;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generateName {
    //随机读取两个数之间的数
    public static int randomAB(int a,int b) {

        return (int)((Math.random()*Math.abs(a-b))+Math.min(a, b));
    }

    //读取姓氏文件
    private static List<String> loadBaiJiaXing(String path) throws IOException {

       File file = new File(path);

       BufferedReader is = new BufferedReader(new FileReader(file));

        //BufferedReader is= new BufferedReader(new InputStreamReader(generateName.class.getResourceAsStream(path)));
        String line = null;
        List<String> result = new ArrayList<String>(200);
        while((line=is.readLine())!=null) {
            line = line.trim();
            String[] names = line.split("\\s+");
            result.addAll(Arrays.asList(names));
        }
        return result;
    }

    //生成姓氏
    private static String firstName() throws IOException {
        List<String> firstNames = loadBaiJiaXing("java_study/src/main/resources/baijiaxing.txt");
        return firstNames.get(randomAB(0,firstNames.size()));
    }

    //读取名字文件
    private static List<String> loadNmae(String path) throws IOException{
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        //BufferedReader br = new BufferedReader(new InputStreamReader(generateName.class.getResourceAsStream(path)));
        String line = null;
        List<String> result = new ArrayList<String>(200);
        while((line = br.readLine())!=null) {
            line = line.trim();
            String[] names = line.split("\\s+");
            result.addAll(Arrays.asList(names));
        }
        return result;

    }

    //生成名字

    private static String secondName() throws IOException {
        List<String> names = loadNmae("java_study/src/main/resources/name.txt");
        return names.get(randomAB(0,names.size()));
    }
    //生产姓名
    public String[] nameG() throws IOException {
        String[] str = new String[10000];
        for(int i = 1000;i>0;i--) {
            str[i] = firstName()+secondName();
        }
        return str;
    }
/*
	public static void main(String[] args) throws IOException {
		for(int i = 10;i>0;i--) {
			String name = firstName()+secondName();
			System.out.println(name);
		}
	}
*/
}
