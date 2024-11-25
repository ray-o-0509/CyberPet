package CyberPet.Interface;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import CyberPet.PetController;
import CyberPet.ExceptionsList.InvalidInputException;
import CyberPet.ExceptionsList.NoPetException;
import CyberPet.ExceptionsList.NotFoundException;
import CyberPet.PetTypes.CyberPet;
import CyberPet.PetTypes.Dog;
import CyberPet.PetTypes.Fish;
import CyberPet.PetTypes.Ninja;

public class TextUI implements UserInterface {
    private PetController petController;
    private Scanner scanner = new Scanner(System.in);

    public TextUI(PetController petController) {
        this.petController = petController;
    }

    @Override
    public void displayPets() {
        try {
            List<CyberPet> pets = petController.getAllPets();
            if (pets.isEmpty()) {
                throw new NoPetException("No pet!");
            }

            System.out.println("\n\n\nCurrent Pets:");
            for (CyberPet pet : pets) {
                System.out.println(pet.getStatus());
            }
        } catch (NoPetException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void controlPet(String name) {
        try {
            CyberPet pet = petController.getPet(name);
            if (pet == null) {
                throw new NotFoundException("No pet found: " + name);
            }

            Map<Integer, String> actionNames = pet.getActionNames();
            Map<Integer, Runnable> actions = pet.getActions();

            for (Map.Entry<Integer, String> item : actionNames.entrySet()) {
                System.out.println(item.getKey() + ") " + item.getValue());
            }

            int input = scanner.nextInt();
            if (!actions.containsKey(input)) {
                throw new InvalidInputException("Invalid action selected: " + name);
            }
            actions.get(input).run(); // 選択されたアクションを実行
        } catch (NotFoundException | InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addPet() {
        System.out.println("Enter pet type (Dog, Fish, Ninja):");
        try {
            String type = scanner.next();
            System.out.println("Enter pet name:");
            String name = scanner.next();

            CyberPet pet;
            switch (type.toLowerCase()) {
                case "dog" -> pet = new Dog(name);
                case "fish" -> pet = new Fish(name);
                case "ninja" -> pet = new Ninja(name);
                default -> throw new InvalidInputException("Invalied pet type: " + type);
            }
            petController.addPet(pet);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void removePet() {
        try {
            System.out.println("Enter the name of the pet to remove:");
            String name = scanner.next();
            CyberPet pet = petController.getPet(name);

            if (pet == null) {
                throw new NotFoundException("No pet found: " + name);
            }

            petController.removePet(name);
            System.out.println("Pet removed: " + name);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}