/*
 * Created by JFormDesigner on Wed Sep 21 17:03:47 CST 2022
 */

package view;

import utils.LoginUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Brainrain
 */
public class Login extends JPanel {
    public Login() {

        initComponents();
        setVisible(true);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        comboBox1 = new JComboBox();
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(500, 400));
        setLayout(new BorderLayout());


        //---- label1 ----
        label1.setText("\u667a\u6167\u6821\u56ed\u7ba1\u7406\u7cfb\u7edf");
        label1.setMaximumSize(new Dimension(200, 170));
        label1.setMinimumSize(new Dimension(200, 170));
        label1.setPreferredSize(new Dimension(22, 70));
        label1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 28));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1, BorderLayout.PAGE_START);

        //======== panel1 ========
        {
            panel1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
            panel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

            //---- label2 ----
            label2.setText("\u7528\u6237\u540d\uff1a");
            label2.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label3 ----
            label3.setText("\u5bc6\u7801\uff1a");
            label3.setHorizontalAlignment(SwingConstants.CENTER);

            //---- label4 ----
            label4.setText("\u89d2\u8272\uff1a");
            label4.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(71, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3))
                        .addGap(23, 23, 23)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(47, Short.MAX_VALUE))
            );
        }
        add(panel1, BorderLayout.CENTER);
        //combox

        comboBox1.addItem("管理员");
        comboBox1.addItem("用户");
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (String) comboBox1.getSelectedItem();
                if (item != null && item.equals("用户")) {
                    flag = false;
                }
            }
        });
        //======== panel2 ========
        {
            panel2.setPreferredSize(new Dimension(234, 50));
            panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));

            //---- button1 ----
            button1.setText("\u767b\u5f55");
            panel2.add(button1);

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = textField1.getText();
                    String password = textField2.getText();
                    LoginUtils loginUtils = new LoginUtils();
                    if(name != null && password != null){
                        if (!name.equals("") && !password.equals("")) {
                            if (flag) {
                                status = loginUtils.login(1, name, password);
                            } else {
                                status = loginUtils.login(2, name, password);
                            }
                        }
                    }
                    if (status){

                        HostFrame hostFrame = new HostFrame();
                        hostFrame.setVisible(true);
                        JComponent comp = (JComponent) e.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();
                        setVisible(false);
                    }
                }
            });

            //---- button2 ----
            button2.setText("\u6ce8\u518c");
            panel2.add(button2);

            //---- button3 ----
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField1.setText("");
                    textField2.setText("");
                }
            });
            button3.setText("\u91cd\u7f6e");
            panel2.add(button3);
        }
        setVisible(true);
        add(panel2, BorderLayout.PAGE_END);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JPanel panel1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JComboBox<String> comboBox1;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private Boolean flag = true;
    private Boolean status;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
