import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public Panel(){
        setPreferredSize(new Dimension(Window.WIDTH,Window.HEIGHT));
        setBackground(Color.GREEN);
        setLayout(new FlowLayout());
    }
}
