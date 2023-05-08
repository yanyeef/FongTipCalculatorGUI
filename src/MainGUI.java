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
        textArea2.setText(15+"");
        textArea5.setText(1+"");
        double one = Double.parseDouble(textArea1.getText());
        int two = Integer.parseInt(textArea2.getText());
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
                if(button == button2){
                    int add = Integer.parseInt(textArea2.getText())+1;
                    textArea2.setText(add + "");
                } else if( button == button4){
                    int add2 = Integer.parseInt(textArea5.getText())+1;
                    textArea5.setText(add2 + "");
                }
            }
            else if(text.equals("-")){
                int sub = Integer.parseInt(textArea2.getText());
                int sub2 =  Integer.parseInt(textArea5.getText());
                if(button == button1 && sub >0){
                    textArea2.setText(sub-1+"");
                } else if (button == button3 && sub2>0) {
                    textArea5.setText(sub2-1+"");
                }
            }
            tipCalculator.setBill(Double.parseDouble(textArea1.getText()));
            tipCalculator.setTipPercentage(Integer.parseInt(textArea2.getText()));
            tipCalculator.setNumberOfPeople(Integer.parseInt(textArea5.getText()));
            double tips = Math.round((tipCalculator.calculateTip()) * 100.0) / 100.0;
            textArea3.setText(tips +"");
            double bill = Math.round((tipCalculator.totalBill()) * 100.0) / 100.0;
            textArea4.setText(bill+"");
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
