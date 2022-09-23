/*
 * Created by JFormDesigner on Wed Sep 21 22:03:42 CST 2022
 */

package view;

import model.School;
import utils.SearchUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class SchoolMsg extends JPanel {
    public SchoolMsg() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        SearchUtils searchUtils = new SearchUtils();

        //======== this ========
//        setSize(700,620);
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- label1 ----
            label1.setText("\u5b66\u6821\u540d\u79f0");
            panel1.add(label1);

            //---- textField1 ----
            textField1.setPreferredSize(new Dimension(103, 30));
            panel1.add(textField1);

            //---- button1 ----
            //单独搜索某一个学校
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = textField1.getText();
                        DefaultTableModel tableModel = searchUtils.getMsg(text,1);
                        if(tableModel != null) {
                            table1.setModel(tableModel);
                        }

                }
            });
            button1.setText("\u641c\u7d22");
            panel1.add(button1);

            //---- button2 ----
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Dialog dialog = new Dialog(null, "学校添加", null, null);
                    AddMsg addMsg = new AddMsg(dialog);
                    addMsg.setVisible(true);
                }
            });
            button2.setText("\u6dfb\u52a0");
            panel1.add(button2);
        }
        add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {

            //---- table1 ----


            DefaultTableModel tableModel = null;

            tableModel = searchUtils.getMsg(null,1);

            table1.setModel(tableModel);
            table1.setShowVerticalLines(true);
            scrollPane1.setViewportView(table1);
        }
        setSize(700,630);
        add(scrollPane1, BorderLayout.CENTER);

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    public JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
