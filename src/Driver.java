import java.util.Scanner;

/**
 * Created by Lucas on 8/30/2017.
 */
public class Driver {
    public static void main (String[] args) {
        Round round = new Round();

        Scanner scanner = new Scanner(System.in);
        String input = "";
        
        round.addActor("Uncle Death", 27);
        round.getActor(0).addEffect("Blind", 110, 0);
        round.getActor(0).addEffect("Shaken", 4, 4);
        round.addActor("Archer", 21);
        round.getActor(1).addEffect("Bleed", 9, 17);
        round.addActor("Skellytone", 17);
        round.addActor("Riordan", 13);
        round.getActor(3).addEffect("Daze", 8, 1);
        round.addActor("Eridor", 12);
        round.getActor(4).addEffect("Blind", 110, 0);
        round.addActor("Zambambo", 6);
        
        do {
        	//	CURRENT INFORMATION BLOCK
        	System.out.println("ROUND NUMBER:\t" + round.getRound());
        	System.out.println("CURRENT ACTOR:\t" + round.getCurrentActor().getName());
        	System.out.println("INIT\tNAME\n=====================");
	        System.out.print(round.getActorList());
	        
	        switch (input = scanner.nextLine()) {
	        	case "next round"	:
	        		round.setRound(round.getRound() + 1);
	        		break;
	        	case "set round"	:
	        		System.out.print("How many rounds from now:\t");
	        		round.setRound(round.getRound() + scanner.nextInt());
	        		break;
	        	case "next actor"	:
	        		round.nextActor();
	        		break;
	        	case "add actor"	:
	        		System.out.print("Name:\t");
	        		input = "";
	        		while (!scanner.hasNextInt())
	        			input += scanner.next() + " ";
	        		System.out.print("Init:\t");
	        		round.addActor(input, scanner.nextInt());
	        		break;
	        	case "hide actor"	:
	        		System.out.print("Name: \t");
	        		round.findActor(scanner.nextLine()).setActive(false);
	        		break;
	        	case "add effect"	:
	        		System.out.print("Actor:\t");
	        		input = scanner.nextLine();
	        		System.out.print("Desc:\t");
	        		String description = "";
	        		while (!scanner.hasNextInt())	//	Pulls tokens until an integer is read
	        			description += scanner.next() + " ";
	        		System.out.print("Dur:\t");
	        		round.findActor(input).addEffect(description, scanner.nextInt());
	        		break;
	        	case "hide effect"	:
	        		System.out.print("Actor:\t");
	        		input = scanner.nextLine();
	        		System.out.print("Desc:\t");
	        		description = scanner.nextLine();
	        		round.findActor(input).findEffect(description).setActive(false);
	        		break;
	        	default				:
	        		break;
	        }
        } while(!input.equals("EXIT"));
        
        scanner.close();
    }
}
