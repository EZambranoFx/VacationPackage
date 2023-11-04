// Copyright (C) 2020
// All rights reserved
package tuviaje;

import exceptions.InvalidInputException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.Scanner;

/**
 * Main.
 */
final class VacationPackageApplication {
    // CHECKSTYLE: OFF
    private static final Logger logger = Logger.getLogger(VacationPackage.class.getName());
    // CHECKSTYLE: ON
    private VacationPackageApplication() {
    }

//CHECKSTYLE: OFF
     /**
     *
     * @param args
     */
    
    public static void main(final String[] args) {
//CHECKSTYLE: ON
    	@SuppressWarnings("PMD.ExceptionAsFlowControl")// DELETE IF YOU DO NOT COMPIRE THE CODE PLEASE
        try (Scanner scanner = new Scanner(System.in)) {
            logger.info("Enter destination (Paris or New York City):");
            final String destination = scanner.nextLine();

            if (!Destination.isValidDestination(destination)) {
                throw new InvalidInputException(
                    "Invalid destination."
                    );
            }
            logger.info("Enter the number of travelers: ");
            final int numberOfTravelers = scanner.nextInt();

            logger.info("Enter the duration of the vacation (in days): ");
            final int duration = scanner.nextInt();

            final VacationPackage vacationPackage = new VacationPackage(
                    destination, numberOfTravelers, duration
                );
            final int totalCost = vacationPackage.calculateTotalCost();
            if (totalCost != -1) {
                if (logger.isLoggable(Level.INFO)) {
                logger.info("Total cost: $" + totalCost);
                }
            } else {
                logger.info("Invalid input");
            }
            logger.info("add the All-Inclusive Package? (yes/no): ");
            final String addAllInclusive = scanner.next().toLowerCase();
            if (addAllInclusive.equals("yes")) {
                vacationPackage.addAllInclusivePackage();
            }

            logger.info("add the Adventure Activities Packg? (yes/no): ");
            String addAdventureActivities = scanner.next().toLowerCase();
            if (addAdventureActivities.equals("yes")) {
                vacationPackage.addAdventureActivitiesPackage();
            }

            logger.info("add the Spa and Wellness Package? (yes/no): ");
            final String addSpaAndWellness = scanner.next().toLowerCase();
            if (addSpaAndWellness.equals("yes")) {
                vacationPackage.addSpaAndWellnessPackage();
            }
            if (totalCost != -1) {
                if (logger.isLoggable(Level.INFO)) {
                    logger.info("Total cost of the vacation: $" + totalCost);
                }
            } else {
                logger.info("Invalid input. try again.");
            }
        } catch (InvalidInputException e) {
            if (logger.isLoggable(Level.INFO)) {
               logger.info("Error: " + e.getMessage());
            }
        }
    }
}
