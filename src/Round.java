import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Lucas
 * @since 2017-9-3
 * 
 */

public class Round {
	
    private int round;
    public List<Actor> actors = new ArrayList<>();
    private Actor currentActor;
    private int nextActorIndex;

    public Round() {
        setRound(0);
        setCurrentActor(null);
        setNextActorIndex(0);
    }

    public void nextActor() {

    	if (actors.isEmpty()) return;
    	
//    	Here is where changing effect durations based off of initiative count should begin
    	for (int i = 0; i < actors.size(); i++)
    		actors.get(i).change(0, getRound());
    	
        if (nextActorIndex >= actors.size()) {
            nextActorIndex = 0;
            setRound(getRound() + 1);
        }

        setCurrentActor(actors.get(getNextActorIndex()));
        setNextActorIndex(nextActorIndex + 1);
    }
    
    /**
     * @param name
     * @param actorInit
     */
    public void addActor(String name, int actorInit) {
    	Actor actor = new Actor (name, actorInit);
    	
    	if (actors.isEmpty())
    		setCurrentActor(actor);
    	
    	actors.add(actor);
    	if (actors.size() == 1)
    		setNextActorIndex(1);
    	
    	//	Sorting actors
    	Collections.sort(actors, new Comparator<Actor>() {
    	    @Override public int compare(Actor a1, Actor a2) {
    	        return a2.getActorInit()- a1.getActorInit();	//	Descending
    	    }
    	});
    }
    
    /**
     * @param name
     * @return searched for Actor object
     */
    public Actor findActor(String name) {
    	for (int i = 0; i < actors.size(); i++) {
    		if (actors.get(i).getName().equals(name))
    			return actors.get(i);
    	}
    	return new Actor();
    }

    //	Getters
    public int getRound() { return round; }

    public String getTime() {
        int seconds = getRound() * 6;
        int minutes = seconds / 60;
        int hours = seconds / 3600;
        seconds %= 60;
        
        //	Formats time string as HH:MM:SS (e.g. "14:33:48") - seconds should always be a multiple of 6
        return String.format("%1$02d:%2$02d:%3$02d", hours, minutes, seconds);
    }
    
    public Actor getActor(int index) { return actors.get(index); }

    public String getActorListString() {
    	String actorList = "";
    	
    	for (int i = 0; i < actors.size(); i++)
    		if (actors.get(i).isActive()) {
	    		actorList += actors.get(i).getActorInit() + "\t";
	    		actorList += actors.get(i).getName() + "\n";
	    		actorList += actors.get(i).getEffectListString();
    		}
    	
    	return actorList;
    }
    
    public Actor getCurrentActor() { return currentActor; }

    public int getNextActorIndex() { return nextActorIndex; }
    
    //	Setters
    public void setRound (int round) {
        int change = round - this.round;
        
        this.round = round;
        
        for (int i = 0; i < actors.size(); i++)
            actors.get(i).change(change, getRound());

        if (!actors.isEmpty())
        	currentActor = actors.get(0);
    }

    public void setCurrentActor(Actor actor) { currentActor = actor; }
    
    public void setNextActorIndex(int nextActorIndex) { this.nextActorIndex = nextActorIndex; }
}
