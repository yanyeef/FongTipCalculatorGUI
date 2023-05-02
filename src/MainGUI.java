import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MainGUI extends JFrame implements ActionListener, KeyListener {

    private JPanel mainPanel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JButton button2;
    private JButton button1;
    private JButton button4;
    private JButton button3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private TipCalculator tipCalculator;

    public MainGUI(){
        textArea1.setText("0");
        textArea2.setText(0+"%");
        textArea5.setText(0+"");
        int one = Integer.parseInt(textArea1.getText());
        int two = Integer.parseInt(textArea2.getText().substring(0, textArea2.getText().indexOf("%")));
        int three = Integer.parseInt(textArea5.getText());
        tipCalculator = new TipCalculator(one, two, three);

        textArea3.setText(tipCalculator.calculateTip() +"");
        textArea4.setText(tipCalculator.totalBill()+"");
        createUIComponents();
    }

    private void createUIComponents() {
        setContentPane(mainPanel);
        setTitle("Tip calculator");
        setSize(300,400);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        button2.addActionListener(this);
        button1.addActionListener(this);
        button4.addActionListener(this);
        button3.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton button = (JButton) source;
            String text = button.getText();
            if (text.equals("+")) {
                int add = Integer.parseInt(textArea2.getText().substring(0, textArea2.getText().indexOf("%")))+1;
                textArea2.setText(add + "%");
                textArea3.setText(tipCalculator.calculateTip() +"");
                textArea4.setText(tipCalculator.totalBill()+"");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // KeyListener interface requires this method be added, even if unimplemented
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        myTextArea.append("key pressed! ");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // KeyListener interface requires this method be added, even if unimplemented
    }
}
