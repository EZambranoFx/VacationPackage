package tuviaje;

public class VacationPackage {
    private String destination;
    private int numberOfTravelers;
    private int duration;

    public VacationPackage(String destination, int numberOfTravelers, int duration) {
        this.destination = destination;
        this.numberOfTravelers = numberOfTravelers;
        this.duration = duration;
	}

	public int calculateTotalCost() {
        int baseCost = 1000;
        int totalCost = baseCost;

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
        if (numberOfTravelers > 4 && numberOfTravelers <= 10) {
            totalCost -= (totalCost * 0.10);
        } else if (numberOfTravelers > 10) {
            totalCost -= (totalCost * 0.20);
        }

        // Duration penalty fee
        if (duration < 7) {
            totalCost += 200;
        }

        // Promotion policy
        if (duration > 30 || numberOfTravelers == 2) {
            totalCost -= 200;
        }

        return totalCost;
    }
}