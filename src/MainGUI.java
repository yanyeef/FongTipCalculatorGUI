import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

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

    public MainGUI(){
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
                textArea2.append("1");
            } else {
                myTextArea.append("button 2 clicked! ");
            }
        }
    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//        // KeyListener interface requires this method be added, even if unimplemented
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        myTextArea.append("key pressed! ");
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        // KeyListener interface requires this method be added, even if unimplemented
//    }
}
