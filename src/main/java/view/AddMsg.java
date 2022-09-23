/*
 * Created by JFormDesigner on Wed Sep 21 22:16:59 CST 2022
 */

package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import info.clearthought.layout.*;
import model.School;
import utils.JDBCUtils;

/**
 * @author Brainrain
 */
public class AddMsg extends JDialog {
    public AddMsg(Frame owner) {
        super(owner);
        initComponents();
    }

    public AddMsg(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField5 = new JTextField();
        button2 = new JButton();
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new TableLayout(new double[][] {
            {TableLayout.FILL},
            {188, TableLayout.PREFERRED}}));
        ((TableLayout)contentPane.getLayout()).setVGap(5);

        //======== contentPanel ========
        {
            contentPanel.setAlignmentY(9.5F);
            contentPanel.setLayout(new TableLayout(new double[][] {
                {170, 149, 65},
                {26, 29, 29, 26, 58}}));
            ((TableLayout)contentPanel.getLayout()).setHGap(5);
            ((TableLayout)contentPanel.getLayout()).setVGap(5);

            //---- label1 ----
            label1.setText("\u5b66\u6821\u540d\u79f0");
            label1.setHorizontalTextPosition(SwingConstants.CENTER);
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(label1, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            contentPanel.add(textField1, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label2 ----
            label2.setText("\u5b66\u6821\u5b98\u7f51");
            label2.setHorizontalTextPosition(SwingConstants.CENTER);
            label2.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(label2, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            contentPanel.add(textField2, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label3 ----
            label3.setText("\u5b66\u6821\u5730\u5740");
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(label3, new TableLayoutConstraints(0, 2, 0, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            contentPanel.add(textField3, new TableLayoutConstraints(1, 2, 1, 2, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label4 ----
            label4.setText("\u5b66\u6821\u7c7b\u578b");
            label4.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(label4, new TableLayoutConstraints(0, 3, 0, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            contentPanel.add(textField4, new TableLayoutConstraints(1, 3, 1, 3, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- label5 ----
            label5.setText("logo");
            label5.setHorizontalAlignment(SwingConstants.CENTER);
            contentPanel.add(label5, new TableLayoutConstraints(0, 4, 0, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- textField5 ----
            textField5.setForeground(Color.black);
            textField5.setHorizontalAlignment(SwingConstants.LEFT);
            textField5.setPreferredSize(new Dimension(30, 30));
            contentPanel.add(textField5, new TableLayoutConstraints(1, 4, 1, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

            //---- button2 ----
            button2.setText("\u4e0a\u4f20\u56fe\u7247");
            contentPanel.add(button2, new TableLayoutConstraints(2, 4, 2, 4, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        }
        contentPane.add(contentPanel, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new TableLayout(new double[][] {
                    {135, TableLayout.PREFERRED, TableLayout.PREFERRED},
                    {TableLayout.PREFERRED}}));
                ((TableLayout)buttonBar.getLayout()).setHGap(5);
                ((TableLayout)buttonBar.getLayout()).setVGap(5);

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        School school = new School();
                        school.setName(textField1.getText());
                        school.setWebsite(textField2.getText());
                        school.setAddress(textField3.getText());
                        school.setStatus(textField4.getText());
                        boolean b = JDBCUtils.getInstance().insertMsg(school, "school");
                        if(b){
                            dispose();
                        }else {
                            setTitle("导入失败！！！");
                        }
                    }
                });
                okButton.setHorizontalTextPosition(SwingConstants.CENTER);
                buttonBar.add(okButton, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.CENTER));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                buttonBar.add(cancelButton, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.CENTER));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JTextField textField5;
    private JButton button2;
    private JPanel dialogPane;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
