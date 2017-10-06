import javax.swing.*;
import java.awt.event.*;

public class Form extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea chat;
    private JTextField userInput;
    private static final Form instance = new Form();

    public static Form getInstance(){
        return instance;
    }

    private Form() {
        setContentPane(contentPane);
        setVisible(true);
        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.setEnabled(false);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String message = userInput.getText();
        if (!message.isEmpty()){
            ServerOutput.sendText(message);
        }
        userInput.setText("");
        userInput.grabFocus();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void enableSendButton(){
        buttonOK.setEnabled(true);
    }

    public void addChatMessage(String message){
        chat.setText(chat.getText() + message);
    }

}
