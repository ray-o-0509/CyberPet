package CyberPet;

import java.util.Scanner;

import CyberPet.ExceptionsList.InvalidInputException;
import CyberPet.Interface.TextUI;

public class Main {
    public static void main(String[] args) {
        PetController petController = new PetController();

        TextUI ui = new TextUI(petController);

        boolean gameIsActive = true;
        Scanner scanner = new Scanner(System.in);

        while (gameIsActive) {
            System.out.println(
                    "\nHome:\n1) Display Pets\n2) Control a Pet\n3) Add a Pet\n4) Remove a Pet\n5) Exit");
            System.out.print("Choose an option: ");

            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> ui.displayPets();
                    case 2 -> {
                        System.out.println("Enter the name of the pet:");
                        String name = scanner.next();
                        ui.controlPet(name);
                    }
                    case 3 -> ui.addPet();
                    case 4 -> ui.removePet();
                    case 5 -> gameIsActive = false;
                    default -> throw new InvalidInputException("Invalid menu option: " + input);
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Please input a number. Input: " + e.getMessage());
                scanner.nextLine();
            }
        }

        System.out.println("Bye!");
    }
}