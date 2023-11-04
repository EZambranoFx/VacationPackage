// Copyright (C) 2020
// All rights reserved
package tuviaje;

public class VacationPackage {
    /**
    * El destino del Package de vacaciones.
    * */
    private String destination;
    /**
    * El número de viajeros en el paquete de vacaciones.
    */
    private int numberOfTravelers;
    /**
    * La duración del paquete de vacaciones en días.
    */
    private int duration;
    /**
     * Crea un paquete de vacaciones con los siguientes parámetros.
     *
     * @param packageDestination El destino del paquete de vacaciones.
     * @param travelers El number de viajeros.
     * @param durtion La duración del paquete de vacaciones en días.
     */
    public VacationPackage(final String packageDestination,
        final int travelers,
        final int durtion) {
        this.destination = packageDestination;
        this.numberOfTravelers = travelers;
        this.duration = durtion;
    }
    /**
    * 1000.
    */
    private static final int BASE_COST = 1000;
    /**
    * 4.
    */
    private static final int MIN_TRAVELERS_FOR_DISCOUNT = 4;
    /**
    * 10.
    */
    private static final int MAX_TRAVELERS_FOR_DISCOUNT = 10;
    /**
    * 0.10.
    */
    private static final double DISCOUNT_PERCENTAGE_10 = 0.10;
    /**
    * 0.20.
    */
    private static final double DISCOUNT_PERCENTAGE_20 = 0.20;
    /**
    * 7.
    */
    private static final int MIN_DURATION_FOR_PENALTY = 7;
    /**
    * 30.
    */
    private static final int MAX_DURATION_FOR_PROMOTION = 30;
    /**
    * 200.
    */
    private static final int PENALTY_AMOUNT = 200;
    /**
     * Calcula el costo total del paquete de vacaciones.
     *
     * @return El costo total del paquete de vacaciones.
     */
    public int calculateTotalCost() {
        int totalCost = BASE_COST;

     // Additional cost based on destination
        switch (Destination.valueOf(destination.toUpperCase())) {
            case PARIS:
                totalCost += Destination.PARIS.getAdditionalCost();
                break;
            case NEW_YORK_CITY:
                totalCost += Destination.NEW_YORK_CITY.getAdditionalCost();
                break;
            default:
                break;
        }

        // Group discount
        if (numberOfTravelers > MIN_TRAVELERS_FOR_DISCOUNT
            && numberOfTravelers <= MAX_TRAVELERS_FOR_DISCOUNT) {
            totalCost -= (totalCost * DISCOUNT_PERCENTAGE_10);
        } else if (numberOfTravelers > MAX_TRAVELERS_FOR_DISCOUNT) {
            totalCost -= (totalCost * DISCOUNT_PERCENTAGE_20);
        }

        // Promotion policy
        if (duration > MAX_DURATION_FOR_PROMOTION || numberOfTravelers == 2) {
            totalCost -= PENALTY_AMOUNT;
        }

        return totalCost;
    }
}
