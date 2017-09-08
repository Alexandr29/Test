import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends JFrame {
    JTextField jTextField = new JTextField(10);
    JButton jButton1 = new JButton("Start");
    JButton jButton2 = new JButton("Stop");
    double arr1[] = new double[100];


    public TestFrame(String title) throws HeadlessException {
        super(title);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 1000);

        add(jTextField);
        jTextField.addActionListener(new MyActionListener());
        add(jButton1);
        jButton1.addActionListener(new MyActionListener());
        add(jButton2);

        pack();

        setVisible(true);
    }


    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String count = jTextField.getText();
            int counter = Integer.parseInt(count);
            for (int i = 0; i < counter; i++) {
                int myRandom = (int) (Math.random() * 100);
                arr1[myRandom]++;
            }

            for (int i = 0; i < arr1.length; i++) {
                System.out.println(i+"ый: " + arr1[i]);
            }

        }
    }
}
