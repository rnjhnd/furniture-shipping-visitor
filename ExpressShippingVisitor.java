class ExpressShippingVisitor implements ShippingCostVisitor {
    private double totalCost = 0;
    
    @Override
    public void visit(Chair chair) {
        // Express shipping for chairs
        double cost = 25.0 + (chair.getWeight() * 0.8);
        totalCost += cost;
        System.out.println("Express shipping cost for " + chair.getName() + ": $" + cost);
    }
    
    @Override
    public void visit(Table table) {
        // Express shipping for tables
        double cost = table.getWeight() * 1.2;
        if (table.isAssembled()) {
            cost += 40.0; // Additional cost for assembled tables
        }
        totalCost += cost;
        System.out.println("Express shipping cost for " + table.getName() + ": $" + cost);
    }
    
    @Override
    public void visit(Sofa sofa) {
        // Express shipping for sofas
        double cost = sofa.getVolume() * 0.1 + sofa.getWeight() * 1.0;
        if (sofa.getMaterial().equalsIgnoreCase("leather")) {
            cost += 75.0; // Premium for leather sofas
        }
        totalCost += cost;
        System.out.println("Express shipping cost for " + sofa.getName() + ": $" + cost);
    }
    
    @Override
    public double getTotalCost() {
        return totalCost;
    }
}