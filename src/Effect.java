import java.util.logging.Logger;

/**
 * @author Lucas
 * @since 2017-9-3
 * 
 * An effect doesn't actually need to say what it is - it just serves as a reminder of
 * what's going on with the actor. All other stats are outside the scope of this tiny
 * project.
 */

public class Effect {
    private static Logger LOGGER = Logger.getLogger(Effect.class.getName());

    private String description;
    private int duration, initCount, startRound, endRound = -1;
    private boolean active, ticked;

    public Effect() { }

    /**
     * @param description
     * @param duration
     * @param initCount
     * @param startRound
     */
    public Effect(String description, int duration, int initCount, int startRound) {
        this.description = description;
        this.duration = duration;
        this.initCount = initCount;
        this.startRound = startRound;
        active = true;
    }
    
    /**
     * @param change			Number of rounds difference between desired round and current round
     * @param currentRound		
     */
    
    public void change(int change, int currentRound) {
    	duration -= change;
    	
    	if (duration <= 0)
    		setInactive(currentRound);
    	if ((duration > 0) || (endRound == -1))
    		setActive();
    }

    //	Getters
    public String getDescription() { return description; }

    public int getDuration() { return duration; }
    
    public int getInitCount() { return initCount; }
    
    public int getStartRound() { return startRound; }
    
    public int getEndRound() { return endRound; }
    
    public boolean isActive() { return active; }

    //	Setters
    public void setDescription(String description) { this.description = description; }

    public void setDuration(int duration) { this.duration = duration; }
    
    public void setInitCount(int initCount) { this.initCount = initCount; }
    
    public void setStartRound(int startRound) { this.startRound = startRound; }
    
    public void setEndRound(int endRound) {this.endRound = endRound; }
    
    public void setActive() { this.active = true; }
    
    public void setInactive(int endRound) { this.active = false; this.endRound = endRound; }

    @Override
    //	toString
    public String toString() { return description + "\t\t" + duration; }
}
