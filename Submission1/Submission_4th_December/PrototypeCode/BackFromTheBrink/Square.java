package BackFromTheBrink;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Square  {

	public static final AtomicInteger squareCount = new AtomicInteger(0);
	
	public int pos;
	protected String squareName;
	protected List<Actions> actions = new ArrayList<Actions>();
	
	
	public Square() {
		this.pos = squareCount.incrementAndGet();
	}


	public String getSquareName() {
		// TODO Auto-generated method stub
		return squareName;
	}
	
}
