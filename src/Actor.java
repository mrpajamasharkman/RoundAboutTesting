import java.util.ArrayList;

/**
 * @author Lucas
 * @since 2017-9-3
 * 
 * An actor doesn't need to display any information other than name, initiative,
 * and any sustained effects - all other stats are outside the scope of this tiny
 * project.
 */

public class Actor {

    private String name;
    private int actorInit;
    private ArrayList<Effect> effects = new ArrayList<>();
    private boolean active;

    public Actor() { }

    /**
     * @param name 			Name of the actor, only for display
     * @param actorInit		Initiative of the actor, determines actor order and helps
     * 						with precise effect duration changes
     */
    public Actor(String name, int actorInit) {
        this.name = name;
        this.actorInit = actorInit;
        active = true;
    }

    /**
     * @param change		Desired number of rounds from current round
     * @param currentRound	Actual current round number
     */
    public void change(int change, int currentRound) {
        for (int i = 0; i < effects.size(); i++)
            effects.get(i).change(change, currentRound);
    }
    
    /**
     * @param description
     * @param duration
     * @param initCount
     * @param startRound
     */
    public void addEffect(String description, int duration, int initCount, int startRound) {
    	Effect effect = new Effect(description, duration, initCount, startRound);
    	effects.add(effect);
    	System.out.println("EFFECT " + effects.get(0).getDescription() + " ADDED CORRECTLY");
    }
    
    /**
     * @param description
     * @return searched for Effect object
     */
    public Effect findEffect(String description) {
    	for (int i = 0; i < effects.size(); i++) {
    		if (effects.get(i).getDescription().equals(description))
    			return effects.get(i);
    	}
    	return new Effect();
    }

    //	Getters
    public String getName() { return name; }

    public int getActorInit() { return actorInit; }

    public String getEffectListString() {
        String effectList = "";

        for (int i = 0; i < effects.size(); i++)
        	if (effects.get(i).isActive())
        		effectList += "\t" + effects.get(i).toString() + "\n";

        return effectList;
    }
    
    public boolean isActive() { return active; }

    //	Setters
    public void setName(String name) { this.name = name; }

    public void setActorInit(int actorInit) { this.actorInit = actorInit; }
    
    public void setActive(boolean active) { this.active = active; }
    
    @Override
    //	toString
    public String toString() {
        return  "Name:\t\t" + getName() +
                "\nInitiative:\t" + getActorInit() +
                getEffectListString();
    }
}
