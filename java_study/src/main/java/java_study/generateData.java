package java_study;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class generateData {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=true&serverTimezone=GMT%2B8";

    static final String USER = "root";
    static final String PWD = "root_123";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        generateName gn = new generateName();
        generateTel gt = new generateTel();
        generateUUID gu = new generateUUID();
        Date dt = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Class.forName(JDBC_DRIVER);

            System.out.println("open connection");
            conn = DriverManager.getConnection(DB_URL, USER, PWD);

            stmt = conn.createStatement();
            String sql;
            for(int i=100;i<110;i++) {
                sql = "insert into employ values('"+i
                        +"','195','测试企业005','721b843e53874073acb75a2be2901572','','72','','"+gu.generateUU()
                        +"','','','"+gn.nameG()[i]
                        +"','','','男','','2','','','','','','','','','"+gt.telephoneG()[i]
                        +"','','','','1','123456','','','','','','','','','','','1','63','','"+f.format(dt)
                        +"','"+f.format(dt)
                        +"','1','0','','0','1','','','"+ft.format(dt)
                        +"','','','"+ft.format(dt)
                        +"','','','','1')";
                stmt.executeUpdate(sql);

            }
            System.out.println("OK");
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if(stmt!=null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}
