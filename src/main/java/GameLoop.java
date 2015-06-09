import Tools.ImageTools;
import Tools.TimeTools;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by akivv on 15.5.2015.
 */
public class GameLoop extends JPanel implements Runnable {
	private final int PWIDTH = 800, PHEIGHT = 600;
	private boolean running;
	private Graphics dbg;
	private Image dbImage = null;
	private ClassLoader loader;

	public GameLoop() {
		//TODO alusta pelaajahahmo
		loader = getClass().getClassLoader();
		//TODO alusta vihollishahmot ensimm�iseen kentt��n
	}

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("xPeli");
		mainFrame.setSize(new Dimension(800, 600));
		GameLoop paneeli = new GameLoop();
		mainFrame.add(paneeli);
		mainFrame.setVisible(true);
		Thread asdf = new Thread(paneeli);
		asdf.start();
	}
	public void run() {
		running = true;
		//Piirrä ensimmäisen kartan kuva
		try {

			dbImage = ImageTools.imageFromClassPath("Kartat.Level1", "joystick-23234_1280.png");
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		while (running) {
			long beforeTime, timeDiff, sleepTime;
			beforeTime = TimeTools.getCurrentTimeInMillisUsingNanoTime();
			gameUpdate();
			gameRender();
			paintScreen();
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleepTime = 10 - timeDiff;   // time left in this loop
			if (sleepTime <= 0) { // update/render took longer than period      sleepTime = 5;    // sleep a bit anyway
				sleepTime = 5;
			}
			try {
				Thread.sleep(sleepTime);  // in ms    }    catch(InterruptedException ex){}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			beforeTime = TimeTools.getCurrentTimeInMillisUsingNanoTime();
		}
	}
	private void gameUpdate() {
		//Update game-tiedot
		//todo Kehitä kartanvaihtologiikka tähän riippuen hahmon sijainnista
	}

	private void gameRender() {
		if (dbImage == null) {
			//Piirrä levelin taustakuva!
			dbg = dbImage.getGraphics();
			paivitadbImageScrollaten();
		}
		dbg = dbImage.getGraphics();
		//Piirrä dbg:hen hahmot niiden draw-menetelmillä
	}

	private void paintScreen() {
		Graphics graphics;
		graphics = this.getGraphics();
		if (graphics != null && dbImage != null) {
			graphics.drawImage(dbImage, 0, 0, null);
		}
		Toolkit.getDefaultToolkit().sync();
		graphics.dispose();
	}
	private void paivitadbImageScrollaten() {
		//todo siirrä kartan dbImage-kuvaa hahmon sijainnista riippuen oikeaan asentoon tai ole siirtämättä
	}
}
