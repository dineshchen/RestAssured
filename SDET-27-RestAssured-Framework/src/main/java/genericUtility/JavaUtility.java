package genericUtility;

import java.util.Random;

/**
 * This class contains java specific generic methods
 * @author Dinesh
 *
 */
public class JavaUtility {

	/**
	 * this method will generate a random value for every run
	 * @return
	 */
	public int getRandomNum() {
		Random ran = new Random();
		int value = ran.nextInt(100);
		return value;
	}
}
