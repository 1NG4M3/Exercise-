package GeekBrainsStage1.lesson1.lesson8;

import javax.swing.*;
import java.awt.*;

public class AppForm extends JFrame {

    public AppForm() {
        // Создаем окно:
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 200, 400, 400);

        // Добавляем две кнопки:
        JButton northButton = new JButton("Button #1 Noth");
        add(northButton, BorderLayout.NORTH);
        JButton southButton = new JButton("Button #2 South");
        add(southButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AppForm();
    }
}

