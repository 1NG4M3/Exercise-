package lesson8;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutWindow extends JFrame {
    public FlowLayoutWindow() {
        setBounds(400, 200, 500, 300);
        setTitle("FlowLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        for (int i = 1; i < 13; i++) {
            add(new JButton("#: " + i));
        }
        setVisible(true);

    }

    public static void main(String[] args) {
        new FlowLayoutWindow();
    }
}