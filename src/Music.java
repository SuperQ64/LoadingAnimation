import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Music {
    private Clip clip;
    /*public Music(String title){
        clip = createClip(new File(title));
    }*/

    public Music(String filename){
        clip = createClip(new File("./music/"+filename+".wav"));
    }


    public static Clip createClip(File file) {
        try(AudioInputStream ais = AudioSystem.getAudioInputStream(file)){
            AudioFormat af = ais.getFormat();
            DataLine.Info dataLine = new DataLine.Info(Clip.class,af);
            Clip c = (Clip)AudioSystem.getLine(dataLine);
            c.open(ais);
            return c;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void start(Clip clip){
        clip.start();
    }
    public static void loop(Clip clip){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public static void stop(Clip clip){
        clip.stop();
    }
    public static void balanceLoop(Clip clip,double rate){
        FloatControl control = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        controlByLinearScalar(control,rate);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public static void controlByLinearScalar(FloatControl control,double linearScalar){
        control.setValue((float)Math.log10(linearScalar)*20);
    }

    public Clip getClip() {
        return clip;
    }
}
