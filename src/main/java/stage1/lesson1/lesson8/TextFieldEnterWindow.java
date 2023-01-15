package stage1.lesson1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldEnterWindow extends JFrame {
    public TextFieldEnterWindow() {
        setBounds(300, 200, 300,120);
        setTitle("Simple Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        add(textField, BorderLayout.CENTER);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new TextFieldEnterWindow();
    }
}
