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
        init(0);
    }
    public void init(int x){
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 1000);
        jButton1.addActionListener(new MyActionListener());
        northPanel = new MyPanel();
        barChart_awt = new BarChart_AWT("Random Array", x);



        add(northPanel,BorderLayout.NORTH);
        add(barChart_awt,BorderLayout.CENTER);
        jProgressBar.setStringPainted(true);
        jProgressBar.setMinimum(0);
        jProgressBar.setMaximum(counter);
        northPanel.add(jTextField);
        northPanel.add(jButton1);
        northPanel.add(jButton2);
        northPanel.add(jProgressBar);

        setVisible(true);
    }
        public void upd(){
        repaint();
        jProgressBar.setValue((int) barChart_awt.tmp);
        }


    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            remove(barChart_awt);
            remove(northPanel);
            remove(jProgressBar);
            String count = jTextField.getText();
            counter = Integer.parseInt(count);
            init(counter);


            upd();

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




