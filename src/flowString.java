import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class flowString extends JPanel implements ActionListener {
    private final int DELAY = 33;
    private final int FONT_SIZE = 80;
    private int moveX;
    private String message;
    private FontMetrics fm;
    private Timer timer;
    private Font font;
    private Color stringColor;

    public flowString(String message){
        timer = new Timer(DELAY,this);
        font = new Font("Serif",Font.BOLD,FONT_SIZE);
        stringColor = Color.WHITE;
        this.message = message;
        setPreferredSize(new Dimension(Window.WIDTH,FONT_SIZE+20));
        setOpaque(false);
        timer.start();
    }

    public void update_X(int stringLength){
        moveX -= 5;
        if(Window.WIDTH + stringLength <= Math.abs(moveX)){
            moveX = 0;
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStringColor(Color stringColor) { this.stringColor = stringColor; }

    @Override
    public void paintComponent(Graphics g){
        fm = g.getFontMetrics(font);
        g.setFont(font);
        g.setColor(stringColor);
        g.drawString(message,Window.WIDTH+moveX,FONT_SIZE);
        update_X(fm.stringWidth(message));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


}
