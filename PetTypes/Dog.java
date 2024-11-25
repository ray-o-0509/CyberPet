package CyberPet.PetTypes;

public class Dog extends CyberPet {
    public Dog(String name){
        super(name);
    }

    @Override
    public void play(){
        hunger += 20;
        energy -= 20;
        happiness += 20;
        System.out.println(name + " is running!\n\n");
    }
    @Override
    public void feed() {
        hunger -= 30;
        happiness += 20;
        System.out.println(name + "ate dog food!");
    }

    @Override
    public void sleep() {
        energy += 40;
        happiness += 5;
        System.out.println(name + " is taking nap.");
    }
}
