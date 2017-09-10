import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends JFrame  {

    private JProgressBar jProgressBar = new JProgressBar();
    private JTextField jTextField = new JTextField(10);
    private JButton jButton1 = new JButton("Start");
    private JButton jButton2 = new JButton("Stop");
    private int counter = 0;
    BarChart_AWT barChart_awt ;
    MyPanel northPanel;

    public TestFrame(String title) throws HeadlessException  {
        super(title);
        setLayout(new BorderLayout());
        setSize(1200, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        init(0);
        jButton1.addActionListener(new MyActionListener());
        add(northPanel,BorderLayout.NORTH);


        northPanel.add(jTextField);
        northPanel.add(jButton1);
        northPanel.add(jButton2);
        northPanel.add(jProgressBar);
        jProgressBar.setMinimum(0);




    }
    public void init(int x){


        northPanel = new MyPanel();
        barChart_awt = new BarChart_AWT("Random Array", x);
        jProgressBar.setStringPainted(true);
        jProgressBar.setMaximum(counter);
        jProgressBar.setValue((int) barChart_awt.tmp);


        add(barChart_awt,BorderLayout.CENTER);

        setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            remove(barChart_awt);
            //remove(jProgressBar);

            String count = jTextField.getText();
            counter = Integer.parseInt(count);
            init(counter);




        }

    }

    class MyPanel extends JPanel{
        MyPanel(){
            setVisible(true);
            setBackground(Color.red);
            setSize(900,900);
            setLayout(new FlowLayout());
        }
    }

}




