package lesson8;

import javax.swing.*;
import java.awt.*;

public class GridLayoutWindow extends JFrame {
    public GridLayoutWindow() {
        setBounds(300, 200, 400, 300);
        setTitle("GridLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            add(new JButton(String.valueOf(i + 1)));
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutWindow();
    }
}
