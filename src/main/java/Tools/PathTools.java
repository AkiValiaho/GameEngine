package Tools;

import java.net.URL;

/**
 * Created by akivv on 9.6.2015.
 */
public class PathTools {
	/**
	 * Hyödyllinen metodi joka palauttaa String-muotoisen
	 * osoitteen siihen kansioon missä Jar-tiedosto tällähetkellä pyörii
	 *
	 * @return String
	 */
	public static String returnPathToJarDirectory() {
		URL location = PathTools.class.getProtectionDomain().getCodeSource().getLocation();
		return location.getPath();
	}
}
