public class FurnitureShipping {
    public static void main(String[] args) {
        // Create furniture items
        Furniture chair = new Chair("Ergonomic Office Chair", 15.5, 0.5);
        Furniture table = new Table("Dining Table", 45.0, 2.0, true);
        Furniture sofa = new Sofa("Sectional Sofa", 85.0, 4.5, "leather");
        
        // Create a shopping cart
        Furniture[] shoppingCart = {chair, table, sofa};
        
        // Standard shipping
        System.out.println("\n====================== Standard Shipping ======================");
        ShippingCostVisitor standardShipping = new StandardShippingVisitor();
        for (Furniture item : shoppingCart) {
            item.accept(standardShipping);
        }
        System.out.println("\nTotal standard shipping cost: $" + standardShipping.getTotalCost());
        
        // Express shipping
        System.out.println("\n====================== Express Shipping ======================");
        ShippingCostVisitor expressShipping = new ExpressShippingVisitor();
        for (Furniture item : shoppingCart) {
            item.accept(expressShipping);
        }
        System.out.println("\nTotal express shipping cost: $" + expressShipping.getTotalCost());
        
        // Distance-based shipping (300 miles)
        System.out.println("\n====================== Distance-Based Shipping ======================");
        ShippingCostVisitor distanceShipping = new DistanceBasedShippingVisitor(300);
        for (Furniture item : shoppingCart) {
            item.accept(distanceShipping);
        }
        System.out.println("\nTotal distance-based shipping cost: $" + distanceShipping.getTotalCost());
    }
}