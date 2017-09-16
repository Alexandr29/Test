import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends JFrame  {

    private JProgressBar jProgressBar = new JProgressBar();
    private JTextField jTextField = new JTextField(10);
    private JButton jButton1 = new JButton("Start");
    private JButton jButton2 = new JButton("Stop");
    private long counter = 0;
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
        jButton2.addActionListener(new StopActionListener());

        jProgressBar.setValue(0);
        jProgressBar.setMinimum(0);
        jProgressBar.setMaximum(100);


        northPanel.add(jTextField);
        northPanel.add(jButton1);
        northPanel.add(jButton2);
        northPanel.add(jProgressBar);


    }

    public void init(long x){
        northPanel = new MyPanel();
        barChart_awt = new BarChart_AWT("Random Array", x);


        add(barChart_awt,BorderLayout.CENTER);

        jProgressBar.setStringPainted(true);
        jProgressBar.setMaximum((int) counter);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                while (jProgressBar.getValue()<counter){
                    invalidate();
                    validate();
                    repaint();
                    jProgressBar.setValue((int) barChart_awt.getTmp());
                    System.out.println(jProgressBar.getValue());

                }
            }
        });

        setVisible(true);


    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            remove(barChart_awt);
            barChart_awt.validate();
            barChart_awt.repaint();
            String count = jTextField.getText();
            counter = Long.parseLong(count);
            init(counter);

        }

    }

    private  class  StopActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hello");
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




