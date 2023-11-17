package UAS.view;

import UAS.controller.Controller;
import UAS.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class login {
    JFrame frame;
    ArrayList<Users> Users;

    public login() {
        frame = new JFrame("Login");
        frame.setSize(400, 400);
        frame.setLayout(null);

        JLabel loginMenu = new JLabel("masukan data berikut");
        loginMenu.setBounds(130, 20, 200, 20);
        loginMenu.setFont(new Font(null, Font.BOLD, 14));
        frame.add(loginMenu);

        JLabel email = new JLabel("Email: ");
        email.setBounds(25, 55, 200, 25);
        frame.add(email);
        JTextField cekEmail = new JTextField();
        cekEmail.setBounds(120, 56, 200, 25);
        frame.add(cekEmail);

        JLabel password = new JLabel("Password: ");
        password.setBounds(25, 100, 200, 25);
        frame.add(password);
        JPasswordField cekPassword = new JPasswordField();
        cekPassword.setBounds(120, 101, 200, 25);
        frame.add(cekPassword);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(200, 170, 100, 25);
        frame.add(loginButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Users = new ArrayList<>();
                String isiEmail = cekEmail.getText();
                String isiPassword = new String(cekPassword.getPassword());
                Users data = Controller.loginUser(isiEmail,isiPassword);
                Users.add(data);
                if (data.getId() != 0) {
                    JOptionPane.showMessageDialog(null, "Anda berhasil login");
                    new Game_list(data.getId());
                } else {
                    JOptionPane.showMessageDialog(null, "Email/password Anda salah. silahkan masukan ulang.");
                }
                 frame.setVisible(false);
            }
        });
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }
}
