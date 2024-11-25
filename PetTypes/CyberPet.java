package CyberPet.PetTypes;

import java.util.HashMap;
import java.util.Map;

public abstract class CyberPet {
    protected String name;
    protected int hunger;
    protected int energy;
    protected int happiness;
    protected Map<Integer, Runnable> actions = new HashMap<>();
    protected Map<Integer, String> actionNames = new HashMap<>();

    public CyberPet(String name) {
        this.name = name;
        this.hunger = 50;
        this.energy = 50;
        this.happiness = 50;

        actions.put(1, this::play);
        actions.put(2, this::feed);
        actions.put(3, this::sleep);

        actionNames.put(1, "Play");
        actionNames.put(2, "Feed");
        actionNames.put(3, "Sleep");
        
    }

    public Map<Integer, Runnable> getActions() {
        return actions;
    }


    public String getName() {
        return name;
    }

    public abstract void play();
    public abstract void feed();
    public abstract void sleep();
    public String getStatus(){
        return "-----\n" + name + ":\n" + "Hunger: " + hunger + "/100\nEnergy: " + energy + "/100\nHappiness: " + happiness + "/100\n";
    }

    public Map<Integer, String> getActionNames(){
        return actionNames;
    };
}
