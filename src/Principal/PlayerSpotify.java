package Principal;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.jar.JarException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayerSpotify {
	private FileInputStream FIS;
    private BufferedInputStream BIS;
    public Player player;
    public long pauseLocation;
    public long songTotalLength;
    public String fileLocation;

    public void play(String path) {

        try {
        	
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            songTotalLength = FIS.available();
            fileLocation = path + "";

        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (Exception e) {
                }
            }
        }.start();
    }

    public void resume() {

        try {

            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            FIS.skip(songTotalLength - pauseLocation);
        }
        catch (Exception e) {
        }

        new Thread() {

            @Override
            public void run() {
                try {
                    player.play();
                } 
                catch (Exception e) {
                }
            }
        }.start();
    }

    public void stop() {

        if (player != null) {
            player.close();
            pauseLocation = 0;
        }
    }

    public void pause() {

        if (player != null) {

            try {
                pauseLocation = FIS.available();
                player.close();
            }
            catch (Exception e) {
            }
        }
    }

    public long barraProgresso() {

        try {
            return (songTotalLength - FIS.available());
        }
        catch (IOException ex) {
            Logger.getLogger(PlayerSpotify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
