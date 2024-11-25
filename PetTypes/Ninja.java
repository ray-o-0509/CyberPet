package CyberPet.PetTypes;

public class Ninja extends CyberPet {
    public Ninja(String name) {
        super(name);
        actions.put(4, this::hide);
        actionNames.put(4, "Hide");
    }

    @Override
    public void play() {
        hunger += 15;
        energy -= 15;
        happiness += 25;
        System.out.println(name + " is practicing assassination!");
    }

    @Override
    public void feed() {
        hunger -= 30;
        happiness += 20;
        System.out.println(name + " enjoyed some sushi.");
    }

    @Override
    public void sleep() {
        energy += 15;
        happiness += 5;
        System.out.println(name + " is sleeping while standing");
    }

    public void hide(){
        energy -= 20;
        happiness -= 20;
        hunger += 10;
        System.out.println(name + " is hiding.");
    }
}