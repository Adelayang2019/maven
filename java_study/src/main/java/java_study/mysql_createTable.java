package java_study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class mysql_createTable {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=true&serverTimezone=GMT%2B8";

    static final String USER = "root";
    static final String PWD = "root_123";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName(JDBC_DRIVER);

            System.out.println("open connection");
            conn = DriverManager.getConnection(DB_URL, USER, PWD);

            System.out.println("login sucessful");
            stmt = conn.createStatement();
			/*
			String sql;
			String sq;
			sq = "insert into websites values('9','JD','www.jd.com','11','cn')";
			stmt.executeUpdate(sq);
			System.out.println("insert OK");

			sql = "select * from websites;";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");

				System.out.println("ID:"+id);
				System.out.println("name:"+name);
				System.out.println("url:"+url);
			}
			rs.close();*/
            String sql;
            sql = "create table employ("+
                    "id int(11) not null AUTO_INCREMENT comment 'id',"+
                    "company_id int(11) DEFAULT NULL COMMENT '公司',"+
                    "company_name varchar(45) DEFAULT NULL COMMENT '公司名称',"+
                    "org_id varchar(45) DEFAULT NULL COMMENT '部门'," +
                    "position_type_id varchar(45) DEFAULT '' COMMENT '岗位类型'," +
                    "position_id int(11) DEFAULT NULL COMMENT '岗位'," +
                    "position_level_id varchar(45) DEFAULT NULL COMMENT '岗位职级'," +
                    "employ_id varchar(32) DEFAULT NULL COMMENT '员工ID'," +
                    "open_id varchar(32) DEFAULT NULL COMMENT '微信open_id'," +
                    "emp_id varchar(30) DEFAULT NULL COMMENT '工号'," +
                    "name varchar(45) DEFAULT NULL COMMENT '姓名'," +
                    "portrait varchar(200) DEFAULT NULL COMMENT '头像图片路径'," +
                    "birthday varchar(20) DEFAULT NULL COMMENT '生日'," +
                    "sex varchar(2) DEFAULT NULL COMMENT '性别'," +
                    "nation varchar(30) DEFAULT NULL COMMENT '民族'," +
                    "state int(1) DEFAULT '1' COMMENT '员工状态 1待入职、2试用、3正式、4待离职、5离职、6未入职 '," +
                    "nonentry_reason varchar(30) DEFAULT NULL COMMENT '未入职原因'," +
                    "nonentry_remark varchar(30) DEFAULT NULL COMMENT '未入职备注'," +
                    "firstworkdate varchar(20) DEFAULT NULL COMMENT '首次参加工作时间'," +
                    "political varchar(20) DEFAULT NULL COMMENT '政治面貌'," +
                    "degree varchar(50) DEFAULT NULL COMMENT '学历'," +
                    "is_pregnant varchar(10) DEFAULT NULL COMMENT '是否已育'," +
                    "marital varchar(10) DEFAULT NULL COMMENT '婚姻状况'," +
                    "household varchar(20) DEFAULT NULL COMMENT '户籍性质'," +
                    "mobile varchar(20) NOT NULL COMMENT '手机号码'," +
                    "email varchar(35) DEFAULT NULL COMMENT '个人邮箱'," +
                    "work_email varchar(35) DEFAULT NULL COMMENT '工作邮箱'," +
                    "current_address varchar(100) DEFAULT NULL COMMENT '现居住地址'," +
                    "certificate_id int(11) DEFAULT NULL COMMENT '证件类型'," +
                    "idnumber varchar(20) DEFAULT NULL COMMENT '证件号'," +
                    "idcard_number varchar(20) DEFAULT NULL COMMENT '身份证卡号'," +
                    "address varchar(100) DEFAULT NULL COMMENT '身份证地址'," +
                    "idcard_validity varchar(20) DEFAULT NULL COMMENT '身份证有效期'," +
                    "bank_card varchar(30) DEFAULT NULL COMMENT '银行卡号'," +
                    "branch varchar(50) DEFAULT NULL COMMENT '开户行'," +
                    "bank_name varchar(50) DEFAULT NULL COMMENT '银行名称'," +
                    "bank_city varchar(45) DEFAULT NULL COMMENT '开户行所属城市'," +
                    "social_place varchar(45) DEFAULT NULL COMMENT '社保参保地'," +
                    "social_number varchar(30) DEFAULT NULL COMMENT '社保卡号'," +
                    "provident_number varchar(30) DEFAULT NULL COMMENT '公积金账号'," +
                    "jobtype int(11) DEFAULT NULL COMMENT '工作类型'," +
                    "workplace int(11) DEFAULT NULL COMMENT '工作地点'," +
                    "bustype varchar(45) DEFAULT NULL COMMENT '商保类型'," +
                    "estimated_entry varchar(20) DEFAULT NULL COMMENT '预计入职时间'," +
                    "start_date varchar(20) DEFAULT NULL COMMENT '入职时间'," +
                    "entry_status tinyint(2) DEFAULT NULL COMMENT '入职登记状态1未发送2资料未上传3已上传'," +
                    "duration int(11) DEFAULT '0' COMMENT '试用期'," +
                    "leavejob_date varchar(20) DEFAULT NULL COMMENT '离职日期'," +
                    "contract_state tinyint(2) DEFAULT '0' COMMENT '合同状态0: 未签署, 1不签约已入职、2签约、3即将到期、4已到期'," +
                    "contract_company_id int(11) DEFAULT NULL COMMENT '合同公司'," +
                    "contract_start_time varchar(30) DEFAULT NULL COMMENT '合同开始时间'," +
                    "contract_end_time varchar(30) DEFAULT NULL COMMENT '合同结束时间'," +
                    "create_time timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'," +
                    "custom varchar(5000) DEFAULT '' COMMENT '自定义字段[{\"id\":1,\"type\": 1,\"key\": \"在职自定义1\",\"value\": \"在职1\"},{\"type\": 2, \"key\": \"个人信息自定义1\", \"value\": \"个人信息1\"},{ \"type\": 3,\"key\": \"联系信息自定义1\", \"value\": \"联系信息1\"}]'," +
                    "custom_register varchar(5000) DEFAULT NULL COMMENT '入职登记自定义字段[{\"type\": 1,\"key\": \"在职自定义1\",\"value\": \"在职1\"},{\"type\": 2, \"key\": \"个人信息自定义1\", \"value\": \"个人信息1\"},{ \"type\": 3,\"key\": \"联系信息自定义1\", \"value\": \"联系信息1\"}]'," +
                    "update_time timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'," +
                    "become_date varchar(20) DEFAULT NULL COMMENT '转正日期'," +
                    "become_plan_date varchar(20) DEFAULT NULL COMMENT '计划转正日期'," +
                    "become_remark varchar(100) DEFAULT NULL COMMENT '转正时的备注'," +
                    "is_auth tinyint(2) DEFAULT '1' COMMENT '是否实名认证1否2是'," +
                    "PRIMARY KEY (id)," +
                    "KEY fk_cust_idx (company_id) USING BTREE," +
                    "KEY org_id (org_id) USING BTREE" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=382 DEFAULT CHARSET=utf8 COMMENT='员工信息表' ";
            stmt.executeUpdate(sql);


            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if(stmt!=null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
}
