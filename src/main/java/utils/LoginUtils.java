package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginUtils {

    public boolean login(int status,String name,String password){

        String sql = null;
        String getPassword = null;
        switch (status){
            case 1:
                sql = "select * from tb_admin where name ="+"'"+name+"'";
                break;
            case 2:
                sql = "select * from tb_student where name ="+"'"+name+"'";
                break;
            default:
                System.out.println("状态码错误");
        }
        List list = JDBCUtils.getInstance().searchDatabase(sql,1);
        if (list == null){
            return false;
        }
        getPassword = (String) list.get(0);
        password = Md5.getMD5(password);
        if (password.equals(getPassword)) {
                return true;
        }
        return false;
    }


}
