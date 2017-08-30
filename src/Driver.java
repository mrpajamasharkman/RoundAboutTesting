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
        	System.out.println("INIT\tNAME\n=====================");
	        System.out.print(round.getActorList());
	        
	        switch (input = scanner.nextLine()) {
	        	case "next actor"	:
	        		break;
	        	case "set round"	:
	        		break;
	        	case "add actor"	:
	        		String actorName = "";
	        		while (!scanner.hasNextInt())
	        			actorName += scanner.next() + " ";
	        		round.addActor(actorName, scanner.nextInt());
	        		break;
	        	case "hide actor"	:
	        		break;
	        	case "add effect"	:
	        		String name = scanner.next();
	        		String description = "";
	        		while (!scanner.hasNextInt())	//	Pulls tokens until an integer is read
	        			description += scanner.next() + " ";
	        		round.findActor(name).addEffect(description, scanner.nextInt());
	        		break;
	        	case "hide effect"	:
	        		break;
	        	default				:
	        		break;
	        }
        } while(!input.equals("EXIT"));
        
        scanner.close();
    }
}
