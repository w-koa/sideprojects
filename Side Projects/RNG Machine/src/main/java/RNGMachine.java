import java.util.Scanner;

public class RNGMachine {

	public static void main(String[] args) {

		// Get User Input, sets strings to be used in RNG demo.
		Scanner input = new Scanner(System.in);

		String choice = "";
		String coin = "C";
		String dice = "D";
		String rng = "R";
		String exit = "";

		// Print RNG Machine title. Start infinite loop for RNG choice input.
		// Re-prompts user if input is invalid or until the program is exited.
		// User can create a RNG by setting min and max range (only outputs integers).
		System.out.println("\t\t\tThe RNG Machine Demo");
		while (!choice.equals(coin) || !choice.equals(dice) || !choice.equals(rng) || !choice.equals(exit)) {

			System.out.println("-------------------------------------------------------------------");
			System.out.print("Flip [C]oin or Roll [D]ice or Create [R]NG (Press enter to exit): ");
			choice = input.nextLine();

			if (choice.equals(coin)) {
				int flipResult = (int) (Math.random() * 2) + 1;
				if (flipResult == 1) {
					System.out.println("\nCoin landed: Heads\n");
				} else
					System.out.println("\nCoin landed: Tails\n");
			}

			if (choice.equals(dice)) {
				int rollResult = (int) (Math.random() * 6) + 1;
				System.out.println("\nDice Rolled: " + rollResult + "\n");
			}

			if (choice.equals(rng)) {
				System.out.print("Set a minimum number: ");
				String minNumberString = input.nextLine();
				int minNumberInt = Integer.parseInt(minNumberString);

				System.out.print("Set a maximum number: ");
				String maxNumberString = input.nextLine();
				int maxNumberInt = Integer.parseInt(maxNumberString);

				int rngRange = maxNumberInt - minNumberInt + 1;

				System.out.println("\nYour range: " + minNumberInt + " - " + maxNumberInt);
				System.out.println("RNG Result: " + ((int) (Math.random() * rngRange) + minNumberInt) + "\n");

				// New Menu for selection. Reroll, Set, back, or exit program.
				String set = "S";
				String goBack = "B";

				while (!choice.equals(rng) || !choice.equals(set) || !choice.equals(goBack) || !choice.equals(exit)) {
					System.out.println("-----------------------------------------------------------------------");
					System.out.print("[R]eroll, [S]et new range, go [B]ack or (Press enter to exit program): ");
					choice = input.nextLine();

					if (choice.equals(rng)) {
						System.out.println("\nYour range: " + minNumberInt + " - " + maxNumberInt);
						System.out.println("RNG Result: " + ((int) (Math.random() * rngRange) + minNumberInt) + "\n");
					}
					if (choice.equals(set)) {
						System.out.print("Set a minimum number: ");
						minNumberString = input.nextLine();
						minNumberInt = Integer.parseInt(minNumberString);

						System.out.print("Set a maximum number: ");
						maxNumberString = input.nextLine();
						maxNumberInt = Integer.parseInt(maxNumberString);

						rngRange = maxNumberInt - minNumberInt + 1;

						System.out.println("\nYour range: " + minNumberInt + " - " + maxNumberInt);
						System.out.println("RNG Result: " + ((int) (Math.random() * rngRange) + minNumberInt) + "\n");
					}
					if (choice.equals(goBack)) {
						break;
					}
					if (choice.equals(exit)) {
						break;
					}

				}
			}
			if (choice.equals(exit)) {
				System.out.println("\nThank you for using the RNG machine!");
				System.out.println("Successfully exited program");
				break;
			}

		}
		input.close();
//		if (choice.equals(flip)) {
//			int flipResult = (int) (Math.random() * 2) + 1;
//			if (flipResult == 1) {
//				System.out.println("Coin landed: Heads");			
//			} System.out.println("Coin landed: Tails");
//		}
//		
//		if (choice.equals(roll)) {
//			int rollResult = (int) (Math.random() * 6) + 1;
//			System.out.println("Dice Rolled: " + rollResult);
//		}

	}

}
