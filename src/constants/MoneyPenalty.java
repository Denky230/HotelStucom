
package constants;

public enum MoneyPenalty {
    
    UNASSIGNED_CUSTOMER(250),
    UNSATISFIED_CLIENT(100);
    
    private final int cost;

    private MoneyPenalty(int cost) {
        this.cost = cost;
    }
    
    public int getCost() {
        return this.cost;
    }
}