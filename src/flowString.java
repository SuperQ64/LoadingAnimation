import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class flowString extends JPanel implements ActionListener {
    private final int DELAY = 33;
    private final int FONT_SIZE = 80;
    private final int SHADOW = 2;
    private int moveX;
    private String message;
    private FontMetrics fm;
    private Timer timer;
    private Font font;
    private Color stringColor;
    private File fontFile;
    private String fontName;

    public flowString(String message){
        timer = new Timer(DELAY,this);
        font = new Font("メイリオ",Font.BOLD,FONT_SIZE);
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
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        fm = g2.getFontMetrics(font);
        g2.setFont(font);
        g2.setColor(Color.BLACK);
        /*
        g2.drawString(message,Window.WIDTH + moveX + SHADOW,FONT_SIZE - SHADOW);
        g2.drawString(message,Window.WIDTH + moveX ,FONT_SIZE - SHADOW);
        g2.drawString(message,Window.WIDTH + moveX - SHADOW,FONT_SIZE - SHADOW);
        g2.drawString(message,Window.WIDTH + moveX - SHADOW,FONT_SIZE + SHADOW);
        g2.drawString(message,Window.WIDTH + moveX - SHADOW,FONT_SIZE);
        */
        g2.drawString(message,Window.WIDTH + moveX + SHADOW,FONT_SIZE);
        g2.drawString(message,Window.WIDTH + moveX + SHADOW,FONT_SIZE + SHADOW);
        g2.drawString(message,Window.WIDTH + moveX,FONT_SIZE + SHADOW);

        g2.setColor(stringColor);
        g2.drawString(message,Window.WIDTH + moveX,FONT_SIZE);
        update_X(fm.stringWidth(message));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


}
