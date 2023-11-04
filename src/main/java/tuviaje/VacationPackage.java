// Copyright (C) 2020
// All rights reserved
package tuviaje;

import java.util.Locale;

/**
 * . Vacation Package
 *
 * @author Enrique Zambrano
 * @version 1.0
 * @since 2023-11-01
 */
public class VacationPackage {
    /**
     * 1000.
     */
    private static final int BASE_COST = 1000;
    /**
     * 4.
     */
    private static final int MN_DISCOUNT = 4;
    /**
     * 10.
     */
    private static final int MX_DISCOUNT = 10;
    /**
     * 0.10.
     */
    private static final double D_P_10 = 0.10;
    /**
     * 30.
     */
    private static final double D_P_20 = 0.20;
    /**
     * 30.
     */
    private static final int MX_D_FOR_PRTN = 30;
    /**
     * 200.
     */
    private static final int PENALTY_AMOUNT = 200;
    /**
     * 200.
     */
    private static final int ALL_COST_TVR = 200;
    /**
     * 150.
     */
    private static final int ADV_COST_TVR = 150;
    /**
     * 100.
     */
    private static final int SPA_COST_TVR = 100;
    /**
     * destination.
     */
    private final String dstn;
    /**
     * El número de viajeros en el paquete de vacaciones.
     */
    private final int nbrOfTrls;
    /**
     * La duración del paquete de vacaciones en días.
     */
    private final int duration;
    /**
     * allInclusive.
     */
    private boolean allInclusivePckg;
    /**
     * adventureActivities.
     */
    private boolean advtActPckg;
    /**
     * spaAndWellness.
     */
    private boolean spaWellPckg;
    /**
     * addAllInclusivePackage.
     */
    public void addAllInclusivePackage() {
             allInclusivePckg = true;
    }
    /**
     * addAdventureActivitiesPackage.
     */
    public void addAdventureActivitiesPackage() {
        advtActPckg = true;
    }

    /**
     * addSpaAndWellnessPackage.
     */
    public void addSpaAndWellnessPackage() {
        spaWellPckg = true;
    }

    /**
     * Crea un paquete de vacaciones con los siguientes parámetros.
     *
     * @param pckgDtn El destino del paquete de vacaciones.
     * @param travelers          El number de viajeros.
     * @param durtion            La duración del paquete de vacaciones.
     */
    public VacationPackage(
            final String pckgDtn,
            final int travelers,
            final int durtion
        ) {
        this.dstn = pckgDtn;
        this.nbrOfTrls = travelers;
        this.duration = durtion;
    }
    /**
     * Calcula el costo total del paquete de vacaciones.
     *
     * @return El costo total del paquete de vacaciones.
     */
    @SuppressWarnings("PMD.NPathComplexity")
    public int calculateTotalCost() {
        int totC = BASE_COST;

        // Additional cost based on destination
        switch (Destination.valueOf(dstn.toUpperCase(Locale.ROOT))) {
        case PARIS:
            totC += Destination.PARIS.getAdditionalCost();
            break;
        case NEW_YORK_CITY:
            totC += Destination.NEW_YORK_CITY.getAdditionalCost();
            break;
        default:
            break;
        }

        // Group discount
        if (nbrOfTrls > MN_DISCOUNT) {
            if (nbrOfTrls <= MX_DISCOUNT) {
                totC -= (totC * D_P_10);
            }
        } else if (nbrOfTrls > MX_DISCOUNT) {
            totC -= (totC * D_P_20);
        }
        // Promotion policy
        if (duration > MX_D_FOR_PRTN || nbrOfTrls == 2) {
            totC -= PENALTY_AMOUNT;
        }

        // Add-ons
        if (allInclusivePckg) {
            totC += ALL_COST_TVR * nbrOfTrls;
        }
        if (advtActPckg) {
            totC += ADV_COST_TVR * nbrOfTrls;
        }
        if (spaWellPckg) {
            totC += SPA_COST_TVR * nbrOfTrls;
        }
        return totC;
    }
}
