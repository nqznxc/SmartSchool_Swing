/*
 * Created by JFormDesigner on Thu Sep 22 15:24:35 CST 2022
 */

package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import info.clearthought.layout.*;
import model.subject;
import utils.JDBCUtils;

/**
 * @author Brainrain
 */
public class AddMsg2 extends JDialog {
    public AddMsg2(Frame owner) {
        super(owner);
        initComponents();
    }

    public AddMsg2(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new TableLayout(new double[][] {
                    {139, 216},
                    {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
                ((TableLayout)contentPanel.getLayout()).setHGap(5);
                ((TableLayout)contentPanel.getLayout()).setVGap(5);

                //---- label1 ----
                label1.setText("\u5b66\u79d1\u540d\u79f0");
                label1.setHorizontalAlignment(SwingConstants.CENTER);
                contentPanel.add(label1, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                contentPanel.add(textField1, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            }
            dialogPane.add(contentPanel, BorderLayout.EAST);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new TableLayout(new double[][] {
                    {101, TableLayout.PREFERRED, TableLayout.PREFERRED},
                    {TableLayout.PREFERRED}}));
                ((TableLayout)buttonBar.getLayout()).setHGap(5);
                ((TableLayout)buttonBar.getLayout()).setVGap(5);

                //---- okButton ----
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        subject subject = new subject();
                        subject.setSubject(textField1.getText());
                        boolean b = JDBCUtils.getInstance().insertMsg(subject, "subject");
                        if(b){
                            dispose();
                        }else {
                            setTitle("导入失败！！！");
                        }
                    }
                });
                okButton.setText("OK");
                okButton.setHorizontalTextPosition(SwingConstants.CENTER);
                buttonBar.add(okButton, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.CENTER));

                //---- cancelButton ----
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setText("Cancel");
                buttonBar.add(cancelButton, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField textField1;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
