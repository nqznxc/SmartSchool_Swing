package utils;


import com.sun.org.apache.xpath.internal.operations.Bool;
import model.School;
import model.subject;

import java.sql.*;
import java.util.ArrayList;

public class JDBCUtils {
    private static JDBCUtils instance;
    private static String mysqlName = "com.mysql.jdbc.Driver";
    private static String DName = "root";
    private static String DPassword = "123456";
    private static String DUrl = "jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=UTF8";
    private JDBCUtils(){};
    ResultSet resultSet = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    public static synchronized JDBCUtils getInstance(){
        if(instance ==null) {
            instance = new JDBCUtils();
            instance.initDb();
        }
        return instance;
    }
    public void initDb(){
        try {
            Class.forName(mysqlName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList searchDatabase (String sql , int b){

        ArrayList<Object> list = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DUrl, DName, DPassword);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(b == 1){
                resultSet.next();
                String password = resultSet.getString("password");
                list.add(password);
            }else if (b ==2 ){
                if(resultSet != null) {
                    try {
                        while (resultSet.next()) {
                            School school = new School();
                            school.setId(resultSet.getInt("id"));
                            school.setName(resultSet.getString("name"));
                            school.setWebsite(resultSet.getString("website"));
                            school.setAddress(resultSet.getString("address"));
                            school.setStatus(resultSet.getString("status"));
                            list.add(school);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }else if (b == 3){
                while (resultSet.next()){
                    subject subject = new subject();
                    subject.setId(resultSet.getInt("id"));
                    subject.setSubject(resultSet.getString("subject"));
                    list.add(subject);
                }
            }
            return list;
        } catch ( SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,preparedStatement,resultSet);
        }
        return list;
    }


    public boolean insertMsg(Object object,String tbName){
        boolean sqlStatus=false;

        String sql = null;
            try {
                connection = DriverManager.getConnection(DUrl, DName, DPassword);
                if(object.getClass() == School.class && tbName.equals("school")) {
                    School s = (School) object;
                    sql = "insert into tb_school(name,website,address,status) values(?,?,?,?)";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, s.getName());
                    preparedStatement.setString(2, s.getWebsite());
                    preparedStatement.setString(3, s.getAddress());
                    preparedStatement.setString(4, s.getStatus());
                    int i = preparedStatement.executeUpdate();
                    if (i==1) {
                        sqlStatus = true;
                    }
                }else if(object.getClass() == subject.class&& tbName.equals("subject")){
                    subject s = (subject)object;
                    sql = "insert into tb_subject(subject) values(?)";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, s.getSubject());
                    int i = preparedStatement.executeUpdate();
                    if (i==1) {
                        sqlStatus = true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeAll(connection,preparedStatement,null);
            }
        return sqlStatus;
    }
    public void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)  {

        try {
            if(resultSet != null){
                resultSet.close();
                resultSet=null;
            }
            if(preparedStatement != null){
                preparedStatement.close();
                preparedStatement =null;
            }
            if(connection != null){
                connection.close();
                connection=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
