package Other;

import java.awt.*;
import java.awt.image.BufferedImage;

import Entities.GameDataSingleton;

/**
 * @author danielmason
 * ASCIIArt class involves creating the title of the game and out going 'game
 * over' message
 *
 */
public class ASCIIArt {

	/**
	 * Creation of the message string
	 * 
	 * @param string
	 */
	public static void drawString(String string) {

		int width = 150;
		int height = 40;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 17));

		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString(string, 10, 20);

		for (int y = 0; y < height; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < width; x++) {

				sb.append(image.getRGB(x, y) == -16777216 ? " " : "@");

			}

			if (sb.toString().trim().isEmpty()) {
				continue;
			}

			System.out.println(sb);
		}

	}

	/**
	 * Creation of the introduction
	 */
	public static void intro() {
		ASCIIArt.drawString("Back From ");
		System.out.println();
		ASCIIArt.drawString("The Brink");
	}

	/**
	 * Creation of the outro message
	 * 
	 * @param gameData
	 */
	public static void outro(GameDataSingleton gameData) {
		System.out.println(
				"\t\t\tThank you for playing Back From The Brink! \n\t\t\t\tWe hoped you enjoyed playing :)\n");
		ASCIIArt.drawString("Game Over");
		System.out.println();
		ASCIIArt.drawString(gameData.getPlayers().get(0).getName().toUpperCase() + " Won");
	}

}