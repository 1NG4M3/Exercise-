package stage1.lesson1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickWindow extends JFrame {
    int counter;

    public ButtonClickWindow() {
        setBounds(300, 200, 300, 120);
        setTitle("Simple Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("Press me!");
        add(button, BorderLayout.CENTER);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                counter++;
                button.setText("Нажал:  " + counter);
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonClickWindow();
    }
}

