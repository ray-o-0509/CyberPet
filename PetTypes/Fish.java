package CyberPet.PetTypes;

public class Fish extends CyberPet {
    public Fish(String name) {
        super(name);
        actions.put(4, this::swim);
        actionNames.put(4, "Swim");
    }

    @Override
    public void play() {
        hunger += 10;
        energy -= 15;
        happiness += 20;
        System.out.println(name + " is hanging out with other fish!");
    }

    @Override
    public void feed() {
        hunger -= 20;
        happiness += 15;
        System.out.println(name + " ate different fish.");
    }

    @Override
    public void sleep() {
        energy += 30;
        happiness += 5;
        System.out.println(name + "is sleeping.");
    }

    public void swim() {
        energy -= 20;
        happiness -= 2;
        System.out.println(name + "is swiming.");
    }
}