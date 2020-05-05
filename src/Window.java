import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    public static final int WIDTH = 960;
    public static final int HEIGHT = 540;
    private Container contentPane;
    private flowString fs;
    private JButton musicOn,musicOff,sendSentence,colorButton;
    private JTextField textField;
    private JColorChooser chooser;
    private Panel panel;
    private Music bgm;


    public Window(String title){
        super(title);

        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        init();

        setVisible(true);
    }

    public void init(){
        fs = new flowString("Java研開始まで今しばらく");
        panel = new Panel();
        contentPane = getContentPane();
        musicOn = new JButton("♪〇");
        musicOff = new JButton("♪×");
        sendSentence = new JButton("send");
        colorButton = new JButton("change color!!");
        textField = new JTextField(15);
        chooser = new JColorChooser();
        bgm = new Music("spring");
        contentPane.setBackground(Color.GREEN);
        sendSentence.addActionListener(this);
        musicOn.addActionListener(this);
        musicOff.addActionListener(this);
        colorButton.addActionListener(this);
        contentPane.add(panel);
        panel.add(textField);
        panel.add(sendSentence);
        panel.add(musicOn);
        panel.add(musicOff);
        panel.add(chooser);
        panel.add(colorButton);
        contentPane.add(fs,BorderLayout.SOUTH);
        Music.balanceLoop(bgm.getClip(),0.1);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sendSentence){
            String message = textField.getText();
            fs.setMessage(message);
            repaint();
        }

        if(e.getSource() == musicOn)
            Music.balanceLoop(bgm.getClip(),0.1);

        if(e.getSource() == musicOff)
            Music.stop(bgm.getClip());

        if(e.getSource() == colorButton)
            fs.setStringColor(chooser.getColor());
    }
}
