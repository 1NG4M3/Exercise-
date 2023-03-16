package GeekBrainsStage1.lesson1.lesson8;

import javax.swing.*;
import java.awt.*;

public class TestWindow extends JFrame {

    public TestWindow() {
        // Создаем окно:
        setTitle("Dmitry Gusev");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(250, 100, 700, 700);

        // Создаем кнопки про помощи Layout Manager:
        JButton northButton = new JButton("North button");
        JButton eastButton = new JButton("East button");
        JButton centerButton = new JButton("Center button");
        JButton westButton = new JButton("Wext button");
        JButton southButton = new JButton("South button");

        add(northButton, BorderLayout.NORTH);
        add(eastButton, BorderLayout.EAST);
        add(centerButton, BorderLayout.CENTER);
        add(westButton, BorderLayout.WEST);
        add(southButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TestWindow();
    }
}
