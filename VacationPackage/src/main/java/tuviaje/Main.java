package tuviaje;

import exceptions.InvalidInputException;

import java.util.Scanner;

final class Main {
    private  Main() {
    }
//CHECKSTYLE: OFF
     /**
     *
     * @param args
     */
     public static void main(final String[] args) {
//CHECKSTYLE: ON
        try (Scanner scanner = new Scanner(System.in)) {
System.out.println("Welcome to the Vacation Package Cost Calculator!");

System.out.print("Enter the destination (Paris or New York City): ");
            String destination = scanner.nextLine();

            if (!Destination.isValidDestination(destination)) {
                throw new InvalidInputException("Invalid destination.");
            }
            System.out.print("Enter the number of travelers: ");
            int numberOfTravelers = scanner.nextInt();

            System.out.print("Enter the duration of the vacation (in days): ");
            int duration = scanner.nextInt();

            VacationPackage vacationPackage = new VacationPackage(
                    destination,
                    numberOfTravelers,
                    duration);
            int totalCost = vacationPackage.calculateTotalCost();
            if (totalCost != -1) {
System.out.println("Total cost of the vacation package: $" + totalCost);
            } else {
System.out.println("Invalid input. Please check your data and try again.");
            }
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
