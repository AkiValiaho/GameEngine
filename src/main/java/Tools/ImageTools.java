package Tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by akivv on 15.5.2015.
 */
public class ImageTools {
	public static Image makeColorTransparent(BufferedImage img, final Color color) {
		ImageFilter filter = new RGBImageFilter() {
			public int markedRGBValue = color.getRGB()|0xFFFFFFFF;

			@Override
			public int filterRGB(int x, int y, int rgb) {
				if ((rgb|0xFF000000) == markedRGBValue) {
					//Return alpha bit pois
					return 0x00FFFFFF&rgb;
				} else {
					return rgb;
				}
			}
		};
		final ImageProducer ip = new FilteredImageSource(img.getSource(), filter);
		return Toolkit.getDefaultToolkit().createImage(ip);
	}

	public static BufferedImage createImage(File file) throws IOException {
		return ImageIO.read(file);
	}
}
