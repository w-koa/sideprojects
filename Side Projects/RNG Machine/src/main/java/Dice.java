
public class Dice {

	//Attributes
	
	// Methods
	public void rollDice() {
		int rollResult = (int) (Math.random() * 6) + 1;
		System.out.println("\nDice Rolled: " + rollResult + "\n");
	}
	
}
