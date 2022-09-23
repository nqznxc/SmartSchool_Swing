import view.Login;

import javax.swing.*;
import java.awt.*;

public class main {

    public static void main(String[] args) {
        Login login = new Login();
        JFrame jFrame = new JFrame("登录界面");
        Container contentPane = jFrame.getContentPane();
        contentPane.add(login);

        jFrame.setBounds(700,500,500,400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
