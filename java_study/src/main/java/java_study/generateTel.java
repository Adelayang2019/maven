package java_study;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class generateTel {
    public static int randomAB(int a,int b) {
        return (int)((Math.random()*Math.abs(a-b))+Math.min(a, b));
    }

    //生成手机号
    private static List<String> genTel(){
        List<String> result = new ArrayList<String>(1000);
        //int n=0;
        String regex = "^1([38]\\d|5[0-35-9]|7[3678])\\d{8}$";
        for(int i=0;i<1000;i++) {
            String tel="1";
            Random random = new Random();
            for(int k=0;k<10;k++) {
                tel+=random.nextInt(9);
            }
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(tel);
            if(m.matches()==true) {
                //System.out.println(tel);
                String[] str = tel.split("\\s+");
                result.addAll(Arrays.asList(str));
                //n+=1;
            }
        }
        //System.out.println(n);
        return result;
    }
    private static String telNum() throws IOException {
        List<String> tel = genTel();
        return tel.get(randomAB(0,tel.size()));
    }
    public String[] telephoneG() throws IOException {
        String[] tel = new String[10000];
        for(int i=0;i<1000;i++) {
            tel[i] = telNum();
        }
        return tel;

    }
	/*
	public static void main(String[] args) throws IOException {
		for(int i=0;i<1000;i++) {
			String tel = telNum();
			System.out.println(tel);
		}
	*/
}
