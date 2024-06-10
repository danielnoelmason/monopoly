package Other;

import java.util.ArrayList;
import java.util.List;

import Entities.ActionArea;
import Entities.EventSquare;
import Entities.NullSquare;
import Entities.Priority;
import Entities.Square;
import Events.SupriseCostTransaction;
import Events.SupriseDonateToTransaction;
import Events.SupriseIncomeTransaction;
import Events.SupriseMoveTransaction;

/**
 * @author niamhmclarnon 
 * registers the squares on the board and the action areas
 * 
 * @return board
 *
 */
public class RegisterBoard {

	public static List<Square> registerBoard() {

		List<Square> board = new ArrayList<Square>();

		ActionArea a1 = new ActionArea("Rainforest");
		ActionArea a2 = new ActionArea("Marine");
		ActionArea a3 = new ActionArea("Grasslands");
		ActionArea a4 = new ActionArea("Polar Region");
		ActionArea a5 = new ActionArea("Mountains");
		ActionArea a6 = new ActionArea("Desert");

		board.add(new NullSquare("The Edge of the World"));
		board.add(new Priority("Jaguar Protection Centre", 60, 2, 30, a1));
		board.add(new Priority("Tapir Foundation", 60, 4, 30, a1));
		board.add(new Priority("Tamarin Trust", 100, 6, 50, a1));
		board.add(new Priority("Save the Crocodiles", 100, 6, 50, a2));
		board.add(new Priority("Turtle Research Centre", 120, 8, 60, a2));
		board.add(new Priority("Seahorse Conservation Centre", 140, 10, 70, a2));
		board.add(new Priority("Reserve the Rhinos", 160, 12, 80, a3));
		board.add(new Priority("Wolves Trust", 180, 14, 90, a3));
		board.add(new Priority("Habitats for Giraffes", 180, 14, 90, a3));
		board.add(new Priority("Save the Penguins", 200, 16, 100, a4));
		board.add(new Priority("Seal Foundation", 220, 18, 110, a4));
		board.add(new Priority("Protection of Polar Bears", 220, 18, 110, a4));
		board.add(new Priority("Bear Foundation", 240, 20, 120, a5));
		board.add(new Priority("Lynx Research Centre", 260, 22, 130, a5));
		board.add(new Priority("Leopard Trust", 280, 24, 140, a5));
		board.add(new Priority("Save the Gazelles", 280, 24, 140, a6));
		board.add(new Priority("Cheetah Research", 280, 24, 140, a6));
		board.add(new Priority("Protection for Turtles", 300, 26, 150, a6));

		board.add(new EventSquare("Adopting a bunch of sick penguins!", new SupriseCostTransaction()));
		board.add(new EventSquare("You have received a donation from an anonymous source",
				new SupriseIncomeTransaction()));
		board.add(new EventSquare("You are needed for a charity event", new SupriseMoveTransaction()));
		board.add(new EventSquare("You are feeling charitable", new SupriseDonateToTransaction()));
		board.add(new EventSquare("Natural disaster has destroyed one of your habitats", new SupriseCostTransaction()));

		return board;
	}

}
