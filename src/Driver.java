import java.util.Scanner;

/**
 * @author Lucas
 * @since 2017-9-3
 */
public class Driver {
    public static void main (String[] args) {
        Round round = new Round();

        Scanner scanner = new Scanner(System.in);
        String input = "";
        
        round.addActor("Uncle Death", 27);
        round.getActor(0).addEffect("Blind", 110, 0, round.getRound());
        round.getActor(0).addEffect("Shaken", 4, 4, round.getRound());
        round.addActor("Archer", 21);
        round.getActor(1).addEffect("Energy Drain", 9, 17, round.getRound());
        round.addActor("Skellytone", 17);
        round.addActor("Riordan", 13);
        round.getActor(3).addEffect("Daze", 8, 1, round.getRound());
        round.addActor("Eridor", 12);
        round.getActor(4).addEffect("Blind", 110, 0, round.getRound());
        round.addActor("Zambambo", 6);
        
        do {
	        //	CURRENT INFORMATION BLOCK
        	System.out.println("ROUND NUMBER:\t" + round.getRound());
        	System.out.println("ACTUAL TIME:\t" + round.getTime());
        	System.out.println("CURRENT ACTOR:\t" + round.getCurrentActor().getName());
        	System.out.println("INITIATIVE:\t" + round.getCurrentActor().getActorInit());
        	System.out.println("INIT\tNAME\n=====================");
	        System.out.print(round.getActorList());

	        System.out.print(">>\t");

	        switch (input = scanner.nextLine()) {
	        	case "nr"	:
	        		round.setRound(round.getRound() + 1);
	        		break;
	        	case "sr"	:
	        		System.out.print("How many rounds from now:\t");
	        		round.setRound(round.getRound() + scanner.nextInt());
	        		break;
	        	case "na"	:
	        		round.nextActor();
	        		break;
	        	case "aa"	:
	        		System.out.print("Name:\t");
	        		input = "";
	        		while (!scanner.hasNextInt())
	        			input += scanner.next() + " ";
	        		System.out.print("Init:\t");
	        		round.addActor(input, scanner.nextInt());
	        		break;
	        	case "ha"	:
	        		System.out.print("Name: \t");
	        		round.findActor(scanner.nextLine()).setActive(false);
	        		break;
	        	case "ae"	:
	        		System.out.print("Actor:\t");
	        		input = scanner.nextLine();
	        		System.out.print("Desc:\t");
	        		String description = "";
	        		description = scanner.nextLine();
	        		System.out.print("Dur:\t");
	        		round.findActor(input).addEffect(description, scanner.nextInt(), 0, round.getRound());
	        		break;
	        	case "he"	:
	        		System.out.print("Actor:\t");
	        		input = scanner.nextLine();
	        		System.out.print("Desc:\t");
	        		description = scanner.nextLine();
	        		round.findActor(input).findEffect(description).setInactive(round.getRound());
	        		break;
	        	default		:
	        		break;
	        }
        } while(!input.equals("exit"));
        
        scanner.close();
    }
}
