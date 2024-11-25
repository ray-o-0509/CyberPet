package CyberPet;

import java.util.ArrayList;
import java.util.List;

import CyberPet.PetTypes.CyberPet;

public class PetController {
    private List<CyberPet> pets = new ArrayList<>();

    public void addPet(CyberPet pet) {
        pets.add(pet);
        System.out.println("Added new pet: " + pet.getName());
    }
    public void removePet(String name) {
        CyberPet pet = getPet(name);
        if (pet != null) {
            pets.remove(pet);
            System.out.println("Removed pet: " + name);
        } else {
            System.out.println("Not found: " + name);
        }
    }

    public CyberPet getPet(String name) {
        for (CyberPet pet : pets) {
            if (pet.getName().equals(name)) {
                return pet;
            }
        }
        return null;
    }

    public List<CyberPet> getAllPets() {
        return pets;
    }
}