package BackFromTheBrink;

public class Priority extends Square {
	
	private String priorityName;
	private int priorityValue;
	private int priorityContributionCost;
	
	private boolean availableForPurchase;
	private Player owner;

	private ActionArea actionArea;

	private int priorityStepCost;
	private int stepsTaken;
	

	//private int pos;
	//static private int nextPos = 0;

	public Priority(String priorityName, int priorityValue, int priorityContributionCost, int priorityStepCost) {
		super();
		this.squareName = priorityName;
		this.priorityName = priorityName;
		this.priorityValue = priorityValue;
		this.priorityContributionCost = priorityContributionCost;
		this.availableForPurchase=true;
		this.priorityStepCost = priorityStepCost;
		
		this.stepsTaken =0;

		//this.pos = nextPos;
		//nextPos++;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public int getPriorityValue() {
		return priorityValue;
	}

	public int getPriorityContributionCost() {
		return priorityContributionCost;
	}

	public ActionArea getActionArea() {
		return actionArea;
	}

	public int getPriorityStepCost() {
		return priorityStepCost;
	}
	public int getStepsTaken() {
		return stepsTaken;
	}

	public int getPos() {
		return pos;
	}
	public boolean isAvailableForPurchase() {
		return availableForPurchase;
	}

//	public void tacklePriotity() {
//		int steps = Integer
//				.parseInt(Read.read("how many steps you want to take towards tackling the property \nOne Step = £"
//						+ getPriorityStepCost()));
//		stepsTaken = getStepsTaken() + steps;
//		priorityContributionCost += steps;// need to decide how steps will effect contribution
//	}


	public void toPrint() {
		System.out.println("Priority Name: " + getPriorityName() + "\tPriority Value = £" + getPriorityValue()
				+ "\tPriority Rent = £" + getPriorityContributionCost());
	}

	public void setAvailableForPurchase(boolean b) {
		this.availableForPurchase=b;
		
	}

	public void addStepsTaken(int i) {
		this.stepsTaken +=i;
		this.priorityContributionCost+=((priorityStepCost/5)*i);
		
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	

	

}