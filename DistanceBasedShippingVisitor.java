class DistanceBasedShippingVisitor implements ShippingCostVisitor {
    private double totalCost = 0;
    private double distance;
    
    public DistanceBasedShippingVisitor(double distance) {
        this.distance = distance;
    }
    
    @Override
    public void visit(Chair chair) {
        // Distance-based shipping for chairs
        double cost = 10.0 + (chair.getWeight() * 0.3 * (distance / 100.0));
        totalCost += cost;
        System.out.println("Distance-based shipping cost for " + chair.getName() + " (" + distance + " miles): $" + cost);
    }
    
    @Override
    public void visit(Table table) {
        // Distance-based shipping for tables
        double cost = table.getWeight() * 0.5 * (distance / 100.0);
        if (table.isAssembled()) {
            cost += 20.0 * (distance / 100.0); // Additional cost for assembled tables
        }
        totalCost += cost;
        System.out.println("Distance-based shipping cost for " + table.getName() + " (" + distance + " miles): $" + cost);
    }
    
    @Override
    public void visit(Sofa sofa) {
        // Distance-based shipping for sofas
        double cost = sofa.getVolume() * 0.03 * (distance / 100.0) + sofa.getWeight() * 0.4 * (distance / 100.0);
        if (sofa.getMaterial().equalsIgnoreCase("leather")) {
            cost += 30.0; // Premium for leather sofas
        }
        totalCost += cost;
        System.out.println("Distance-based shipping cost for " + sofa.getName() + " (" + distance + " miles): $" + cost);
    }
    
    @Override
    public double getTotalCost() {
        return totalCost;
    }
}