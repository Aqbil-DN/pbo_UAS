package UAS.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import UAS.model.*;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import UAS.controller.Controller;

public class Game_list {

    JFrame frame;
    public Game_list(int id){
        frame = new JFrame("Game List :)");
        frame.setSize(500, 500);
        frame.setLayout(null);
        Controller con = new Controller();

        JButton TransactionButton = new JButton("Transaction");
        TransactionButton.setBounds(100, 80, 100, 25);
        frame.add(TransactionButton);
        TransactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idUser  = id;
            }
        });

        JLabel labelName = new JLabel("Name: ");
        JTextField textName = new JTextField();
        labelName.setBounds(10, 100, 200, 20);
        textName.setBounds(200, 100, 200, 20);

        //Genre
        JLabel labelGenre = new JLabel("Genre: ");
        JTextField textGenre = new JTextField();
        labelGenre.setBounds(10, 130, 200, 20);
        textGenre.setBounds(200, 130, 200, 20);

        //Price
        JLabel labelPrice = new JLabel("Price: ");
        JTextField textPrice = new JTextField();
        labelPrice.setBounds(10, 160, 200, 20);
        textPrice.setBounds(200, 160, 200, 20);

        JLabel labelpoto = new JLabel("Foto: ");
        JButton potoChooser = new JButton("Choose File:");
        JLabel pathpoto = new JLabel("No file selected");
        labelpoto.setBounds(10, 190, 200, 20);
        potoChooser.setBounds(200, 190, 200, 20);
        pathpoto.setBounds(200, 210, 300, 20);
        potoChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                int returnValue = jf.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jf.getSelectedFile();
                    String pathFile = selectedFile.getAbsolutePath();
                    pathpoto.setText(pathFile);
                }
            }
        });




    }
}
