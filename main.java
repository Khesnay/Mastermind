package main;
import java.util.*;
public class main {
	public String[] color = new String[]{"Black","Yellow","Red","Blue"};
	public String[] codeMaster = new String[4];
	public String[] codeBreaker = new String[4];
	
	public Random rand = new Random();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		main Mastermind = new main();
		int u = 0;
		boolean win = false;
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to MASTERMIND!\n");
		Mastermind.Rule();
		Mastermind.GenerateCode(); // Code is generated
		
		//Going through 5 rounds ! If you win validate conditions and allow you to end the game!
		System.out.println("Code generated! Try to guess it!");
		while(u<5) {
			System.out.println("-> Round: "+(u+1));
			Mastermind.Guess();
			Mastermind.Compare();
			if(Mastermind.GameOn()==true) {
				//win=true;
				u=99;
				System.out.println("\nCONGRATULATION YOU WON!");
				
			}else if(u>= 4) {
				System.out.println("\nSorry, you lost. :'( ");
				u=99;
				//win=true;
			}else {
				System.out.println("\nTRY AGAIN!");
			u++;	
			}
			
			
		}
		
	}
	
	//Create a code to guess
	private void GenerateCode() {
		for(int i = 0;i<color.length;i++) {
			int r = rand.nextInt(4); // Randomizing code color
			codeMaster[i] = color[r];
			
			//Check if it is randomizing
			//System.out.println(codeMaster[i]); 
		}
		
		//Checking CODEMASTER
		for(int j=0;j<codeMaster.length;j++) {
				System.out.print(codeMaster[j]+" ");
				
			}
		System.out.println();
	}
	
	//User input, in order to guess the Code Master 
	private void Guess() {
		System.out.println("\nPlease press: \n1 for Black\n2 for Yellow\n3 for Red\n4 for Blue");
		for(int i=0;i<color.length;i++) {
			
			Scanner in = new Scanner(System.in);
			
			try {
		    int input = in.nextInt();
			codeBreaker[i] = color[input-1]; // Have to remove one as arrays are indexed starting from 0. 
			System.out.println("You entered "+ color[input-1] + "!");
			
			//Check if the right value is entered
			System.out.println(codeBreaker[i]);
			
			//If unexpected value is entered it will display an error message
			}catch(Exception e){
				System.out.println("You entered an invalid value.");
				//System.out.println(codeBreaker[i]);
			}	
		}
		
		//display entered code 
		System.out.println("Your code: ");
		for(int j=0;j<codeBreaker.length;j++) {
			System.out.print(codeBreaker[j]+" ");
		}	
		
		
	}

	
	private void Compare() { // Compare the CodeMaster and Code Breaker 
		System.out.println();
		List<String> codeCheck = Arrays.asList(codeBreaker); // Change codeMaster as a List to check if codeBreaker contains any right value
		
		for(int i=0;i<codeMaster.length;i++) {
			
			if(codeMaster[i].equals(codeBreaker[i])){
				System.out.print("[✓]");
			}else if(codeCheck.contains(codeMaster[i])){
				System.out.print("[!]");
			}else {
				System.out.print("[x]");
			}
		}
	}
	
	private boolean GameOn() {
		if(codeMaster[0]==codeBreaker[0]&&codeMaster[1]==codeBreaker[1]&&codeMaster[2]==codeBreaker[2]&&codeMaster[3]==codeBreaker[3]){
			
			return true;
		}else{
			return false;
		}
	}
	
	
	private void Rule() {
		System.out.println(
				"<!>--RULES--<!>\n"
				+"MasterMind is a simple game where you have to guess your opponent code within 10 rounds.\n"
				+ "Every round, you enter a code based on 4 colors, BLACK, YELLOW, RED or BLUE.\n"
				+ "You need to match your opponent combination to win!\n"
				+ "If after 10 rounds, you did not find your opponent combination, you loose the game.\n"
				+ "Differents signs will be displaying allowing to find out the combination.\n"
				+ "Check mark - [✓] - It means that you guessed the RIGHT POSITION and COLOR.\n"
				+ "Exclamation mark - [!] - It means that you guessed the RIGHT COLOR ONLY.\n"
				+ "Cross mark - [x] - It means that you did NOT guess the right color and position. Try again!\n"
				+ "Enjoy and good luck!\n"
				);
	}
	
	
	
	private void codeSolution() { // Allow user to display Master's code
		
		for(int j=0;j<codeMaster.length;j++) {
		System.out.print(codeMaster[j]+" ");
		}	
	}
	
	
}
