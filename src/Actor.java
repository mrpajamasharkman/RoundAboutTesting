import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by Lucas on 8/18/2017.
 *
 * An actor doesn't need to display any information other than name, initiative,
 * and any sustained effects - all other stats are outside the scope of this tiny
 * project.
 */

public class Actor {
    private static Logger LOGGER = Logger.getLogger(Actor.class.getName());

    private String name;
    private int actorInit;
    private ArrayList<Effect> effects = new ArrayList<>();
    private boolean active;

    public Actor() { }

    public Actor(String name, int actorInit) {
        this.name = name;
        this.actorInit = actorInit;
        active = true;
    }

    public void change(int change, int currentInit) {
        for (int i = 0; i < effects.size(); i++) {
            effects.get(i).change(change);
        }
        // Must find how to use currentInit to properly check whether an effect's duration should change
    }
    
    public void addEffect(String description, int duration, int initCount) {
    	Effect effect = new Effect(description, duration, initCount);
    	effects.add(effect);
    }
    
    public Effect findEffect(String description) {
    	for (int i = 0; i < effects.size(); i++) {
    		if (effects.get(i).getDescription().equals(description))
    			return effects.get(i);
    	}
    	return new Effect();
    }

    public String getName() { return name; }

    public int getActorInit() { return actorInit; }

    public String getEffects() {
        String printEffects = "";

        for (int i = 0; i < effects.size(); i++)
        	if (effects.get(i).isActive())
        		printEffects += "\t" + effects.get(i).toString() + "\n";

        return printEffects;
    }
    
    public boolean isActive() { return active; }

    public void setName(String name) { this.name = name; }

    public void setActorInit(int actorInit) { this.actorInit = actorInit; }
    
    public void setActive(boolean active) { this.active = active; }

    public void addEffect(String description, int duration) {
        Effect temp = new Effect(description, duration, 0);
        effects.add(temp);
    }

    public String toString() {
        return  "Name:\t\t" + getName() +
                "\nInitiative:\t" + getActorInit() +
                getEffects();
    }
}
