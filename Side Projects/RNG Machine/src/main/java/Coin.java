
public class Coin {

	// Attributes	
	// Method
	public void flipCoin() {
		int flipResult = (int) (Math.random() * 2) + 1;
		if (flipResult == 1) {
			System.out.println("\nCoin Flipped: Heads\n");			
		} else System.out.println("\nCoin Flipped: Tails\n");
		
	}
	
	
}
