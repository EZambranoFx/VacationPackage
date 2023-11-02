// Copyright (C) 2020
// All rights reserved
package tuviaje;

/**
 * Enumeración que aparenta destinos de viaje con costos adicionales asociados.
 */
public enum Destination {
    /**
     * París con un costo adicional de 500 unidades.
     */
    PARIS(500),

    /**
     * Ciudad de Nueva York con un costo adicional de 600 unidades.
     */
    NEW_YORK_CITY(600);
    /**
     * Costo adicional.
     */
    private final int additionalCost;

    /**
     * Constructor que establece el costo adicional del destino.
     *
     * @param cost El costo adicional del destino.
     */
    Destination(final int cost) {
        this.additionalCost = cost;
    }

    /**
     * Obtiene el costo adicional del destino.
     *
     * @return El costo adicional.
     */
    public int getAdditionalCost() {
        return additionalCost;
    }

    /**
     * Verifica si un destino dado es válido.
     *
     * @param destination El nombre del destino.
     * @return true si el destino es válido, false en caso contrario.
     */
    public static boolean isValidDestination(final String destination) {
        boolean isValid = false;
        for (final Destination dest : values()) {
            if (dest.name().equalsIgnoreCase(destination)) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }
}
