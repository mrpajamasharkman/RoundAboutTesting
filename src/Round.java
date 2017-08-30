import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Lucas on 8/18/2017.
 */

public class Round {
    private static Logger LOGGER = Logger.getLogger(Round.class.getName());

    private int round;
    public List<Actor> actors = new ArrayList<>();
    private Actor currentActor;
    private int nextActorIndex;

    public Round() {
        setRound(0);

        setActor(null);
        setNextActorIndex(0);
    }

    //  Called by nextActor button
    public void nextActor() {

    	if (actors.isEmpty()) { return; }
    	
    	//	Checking the initiative of each effect for each actor and changing as necessary???
    	for (int i = 0; i < actors.size(); i++)
    		actors.get(i).change(0, currentActor.getActorInit());
    	
        if (nextActorIndex >= actors.size()) {
            nextActorIndex = 0;
            setRound(getRound() + 1);
        }

        setActor(actors.get(getNextActorIndex()));
        setNextActorIndex(nextActorIndex + 1);
    }
    
    public void addActor(String name, int actorInit) {
    	Actor actor = new Actor (name, actorInit);
    	actors.add(actor);
    	Collections.sort(actors, new Comparator<Actor>() {
    	    @Override public int compare(Actor a1, Actor a2) {
    	        return a2.getActorInit()- a1.getActorInit();	//	Descending
    	    }
    	});
    }
    
    public Actor findActor(String name) {
    	for (int i = 0; i < actors.size(); i++) {
    		if (actors.get(i).getName().equals(name))
    			return actors.get(i);
    	}
    	return new Actor();
    }

    //  Also called by roundLabel
    public int getRound() { return round; }

    //  Called by actualTime
    public String getTime() {
        int seconds = getRound() * 6;
        int minutes = seconds / 60;
        int hours = seconds / 3600;
        seconds %= 60;

        return hours + ":" + minutes + ":" + seconds;
    }
    
    public Actor getActor(int index) { return actors.get(index); }

    //  Called by actorList
    public String getActorList() {
    	String actorList = "";
    	
    	for (int i = 0; i < actors.size(); i++) {
    		actorList += actors.get(i).getActorInit() + "\t";
    		actorList += actors.get(i).getName() + "\n";
    		actorList += actors.get(i).getEffects(); 
    	}
    	
    	return actorList;
    }

    public int getNextActorIndex() { return nextActorIndex; }

    public void setRound (int round) {
        int change = round - this.round;

        for (int i = 0; i < actors.size(); i++)
            actors.get(i).change(change, 0);

        this.round = round;
    }

    public void setActor(Actor actor) { currentActor = actor; }

    public void setNextActorIndex(int nextActorIndex) { this.nextActorIndex = nextActorIndex; }
}
