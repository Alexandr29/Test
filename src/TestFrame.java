import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends JFrame  {

    private JTextField jTextField = new JTextField(10);
    private JButton jButton1 = new JButton("Start");
    private JButton jButton2 = new JButton("Stop");
    private int counter = 0;


    public TestFrame(String title) throws HeadlessException  {
        super(title);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 1000);
        jButton1.addActionListener(new MyActionListener());
        MyPanel northPanel = new MyPanel();
        MyPanel2 centerPanel = new MyPanel2();

        add(northPanel,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);

        northPanel.add(jTextField);
        northPanel.add(jButton1);
        northPanel.add(jButton2);

        setVisible(true);
    }



    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String count = jTextField.getText();
            counter = Integer.parseInt(count);
            new BarChart_AWT("Arrays","Random Array", counter);

        }

    }

    class MyPanel extends JPanel{
        MyPanel(){
            setVisible(true);
            setBackground(Color.red);
            setSize(800,200);
            setLayout(new FlowLayout());
        }
    }

    class MyPanel2 extends JPanel {
        MyPanel2() {
            setVisible(true);
            setBackground(Color.green);
            setSize(800, 800);
            setLayout(new FlowLayout());
        }
    }

}




