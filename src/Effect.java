import java.util.logging.Logger;

/**
 * Created by Lucas on 8/18/2017.
 *
 * An effect doesn't actually need to say what it is - it just serves as a reminder of
 * what's going on with the actor. All other stats are outside the scope of this tiny
 * project.
 */

public class Effect {
    private static Logger LOGGER = Logger.getLogger(Effect.class.getName());

    private String description;
    private int duration;
    private int initCount;
    private boolean active;

    public Effect() { }

    public Effect(String description, int duration, int initCount) {
        this.description = description;
        this.duration = duration;
        this.initCount = initCount;
        active = true;
    }
    
    public void change(int change) {
    	duration -= change;
    	
    	if (duration <= 0)
    		setActive(false);
    	if (duration > 0)
    		setActive(true);
    }

    public String getDescription() { return description; }

    public int getDuration() { return duration; }
    
    public int getInitCount() { return initCount; }
    
    public boolean isActive() { return active; }

    public void setDescription(String description) { this.description = description; }

    public void setDuration(int duration) { this.duration = duration; }
    
    public void setInitCount(int initCount) { this.initCount = initCount; }
    
    public void setActive(boolean active) { this.active = active; }

    public String toString() { return description + "\t\t" + duration; }
}
