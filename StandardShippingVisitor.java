class StandardShippingVisitor implements ShippingCostVisitor {
    private double totalCost = 0;
    
    @Override
    public void visit(Chair chair) {
        double cost = 15.0 + (chair.getWeight() * 0.5);
        totalCost += cost;
        System.out.println("Standard shipping cost for " + chair.getName() + ": $" + cost);
    }
    
    @Override
    public void visit(Table table) {
        double cost = table.getWeight() * 0.7;
        if (table.isAssembled()) {
            cost += 25.0; // Additional cost for assembled tables
        }
        totalCost += cost;
        System.out.println("Standard shipping cost for " + table.getName() + ": $" + cost);
    }
    
    @Override
    public void visit(Sofa sofa) {
        double cost = sofa.getVolume() * 0.05 + sofa.getWeight() * 0.6;
        if (sofa.getMaterial().equalsIgnoreCase("leather")) {
            cost += 50.0; // Premium for leather sofas
        }
        totalCost += cost;
        System.out.println("Standard shipping cost for " + sofa.getName() + ": $" + cost);
    }
    
    @Override
    public double getTotalCost() {
        return totalCost;
    }
}