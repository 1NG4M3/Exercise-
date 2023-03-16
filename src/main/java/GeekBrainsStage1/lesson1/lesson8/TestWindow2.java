package GeekBrainsStage1.lesson1.lesson8;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class TestWindow2 extends JFrame{
    public TestWindow2() {
        setBounds(300, 300, 720, 300);
        setTitle("BoxLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        for (int i = 6; i > 0; i--) {
            add(new JButton("Вагон № " + i + " ]"));
        }
        add(new JButton("Локомотив"));

        setVisible(true);
    }

    public static void main(String[] args) {
        new TestWindow2();
    }
}
