package utils;


import model.School;
import model.subject;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SearchUtils {
    public DefaultTableModel getMsg(String colum,int status){

        String sql = null;
        DefaultTableModel tableModel = null;
        if(status == 1) {
            if (colum == null) {
                sql = "select * from tb_school";
            } else {
                sql = "select * from tb_school where name =" + "'"+colum+"'";
            }
            List<School> schools = JDBCUtils.getInstance().searchDatabase(sql, 2);
            Object[] str = {"编号", "学校名称", "学校官网", "地址", "学校类型"};
            if (schools.size() != 0) {
                tableModel = new DefaultTableModel();
                for (Object num : str) {
                    tableModel.addColumn(num);
                }
                for (School s : schools) {
                    Vector<String> v = new Vector<>();
                    v.add(s.getId().toString());
                    v.add(s.getName());
                    v.add(s.getWebsite());
                    v.add(s.getAddress());
                    v.add(s.getStatus());
                    tableModel.addRow(v);
                }
            }
        }else if(status == 2){
            if (colum == null) {
                sql = "select * from tb_subject";
            } else {
                sql = "select * from tb_subject where subject =" + colum;
            }
            List<subject> subjects = JDBCUtils.getInstance().searchDatabase(sql, 3);
            Object[] str = {"编号", "学科名称"};
            if (subjects.size() != 0) {
                tableModel = new DefaultTableModel();
                for (Object num : str) {
                    tableModel.addColumn(num);
                }
                for (subject s : subjects) {
                    Vector<String> v = new Vector<>();
                    v.add(s.getId().toString());
                    v.add(s.getSubject());
                    tableModel.addRow(v);
                }
            }
        }

        return tableModel;
    }
}
