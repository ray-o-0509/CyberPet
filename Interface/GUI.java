package CyberPet.Interface;

import CyberPet.PetController;

public class GUI implements UserInterface {
    private PetController petController;

    public GUI(PetController petController) {
        this.petController = petController;
    }

    public void displayPets() {
        // make GUI
    };

    public void controlPet(String name) {
        // make GUI
    };

    public void addPet() {
        // make GUI
    };

    public void removePet() {
        // make GUI
    };
}
