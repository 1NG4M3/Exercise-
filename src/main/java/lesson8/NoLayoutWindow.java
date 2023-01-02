package lesson8;

import javax.swing.*;

public class NoLayoutWindow extends JFrame {
    public NoLayoutWindow() {
        setBounds(300, 200, 400, 300);
        setTitle("NoLayoutWindow");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Отключаем Лэйаут Мэнеджер, если хотим сделать все сами
        setLayout(null);

        // Добавляем тексфилд
        JTextField field = new JTextField();
        field.setBounds(20, 20, 120, 32);
        add(field);

        // Добавляем кнопку
        JButton button = new JButton("Press me!");
        button.setBounds(20, 60, 120, 32);
        add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        new NoLayoutWindow();
    }
}

