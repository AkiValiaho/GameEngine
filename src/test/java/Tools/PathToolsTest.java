package Tools;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by akivv on 9.6.2015.
 */
public class PathToolsTest {

	@Test
	public void testReturnPathToJarDirectory() throws Exception {
		String osoite = PathTools.returnPathToJarDirectory();
		if (osoite.contains("file")) {
			fail("Trailaava polku vaan kiitos");
		}
	}

	@Test
	public void testReturnPathToJarDirectoryOnWindows() throws Exception {
		//todo testaa Windowsilla tuleeko pathi oikein absoluuttisena! Jos ei, fixaa tilanne
	}
}