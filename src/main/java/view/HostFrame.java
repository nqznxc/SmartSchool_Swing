/*
 * Created by JFormDesigner on Thu Sep 22 15:38:42 CST 2022
 */

package view;

import model.School;
import utils.JDBCUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class HostFrame extends JFrame {
    public HostFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(140, 370));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //后续添加实现jpanel到jframe里
        JPanel jPanel = new JPanel();
        jPanel.setBounds(20,20,730,550);
        contentPane.add(jPanel);
        CardLayout cardLayout = new CardLayout();
        jPanel.setLayout(cardLayout);


        //---- button1 ----
        button1.setText("\u5b66\u6821\u4fe1\u606f");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SchoolMsg schoolMsg = new SchoolMsg();
                jPanel.add(schoolMsg,"p1");
                cardLayout.show(jPanel,"p1");
                setTitle("学校页面");
            }
        });
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(275, 600), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u5b66\u79d1\u4fe1\u606f");

        contentPane.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubjectMsg subjectMsg = new SubjectMsg();
                jPanel.add(subjectMsg,"p2");
                cardLayout.show(jPanel,"p2");
                setTitle("学科页面");
            }
        });
        button2.setBounds(new Rectangle(new Point(460, 600), button2.getPreferredSize()));


        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(800, 700);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
