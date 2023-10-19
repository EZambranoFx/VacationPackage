package tuviaje;
public enum Destination {
    PARIS(500),
    NEW_YORK_CITY(600);

    private int additionalCost;

    Destination(int additionalCost) {
        this.additionalCost = additionalCost;
    }

    public int getAdditionalCost() {
        return additionalCost;
    }

	public static boolean isValidDestination(String destination) {
        for (Destination dest : Destination.values()) {
            if (dest.name().equalsIgnoreCase(destination)) {
                return true;
            }
        }
        return false;
	}
}
