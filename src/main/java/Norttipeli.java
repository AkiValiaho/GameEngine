import Tools.ImageTools;
import Tools.TimeTools;

import javax.swing.*;
import java.awt.*;
/**
 * Created by akivv on 15.5.2015.
 */
public class Norttipeli extends JPanel implements Runnable {
	private final int PWIDTH = 800, PHEIGHT = 600;
	private boolean running;
	private Graphics dbg;
	private Image dbImage = null;

	public void run() {
		running = true;
		//Piirrä ensimmäisen kartan kuva
		dbImage = ImageTools.makeColorTransparent(ImageTools.createImage(), Color.GREEN);
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
		
	}

}