# Furniture Shipping Cost Calculator

A Java implementation of the Visitor Design Pattern for calculating shipping costs of different furniture types in an e-commerce platform.

## 📋 Overview

This project demonstrates how to use the Visitor Pattern to calculate shipping costs for various furniture items (chairs, tables, sofas) without tightly coupling the shipping logic to the furniture classes. The solution provides three different shipping strategies:

- **Standard Shipping**: Basic cost calculation based on weight and volume
- **Express Shipping**: Premium shipping with higher rates
- **Distance-Based Shipping**: Cost calculation based on distance and furniture characteristics

## 🏗️ Architecture

The project follows the Visitor Design Pattern with the following components:

### Core Interfaces
- `Furniture`: Defines the accept method for visitor pattern
- `ShippingCostVisitor`: Defines visit methods for each furniture type

### Furniture Types
- `Chair`: Lightweight furniture with basic shipping requirements
- `Table`: Medium-weight furniture with assembly considerations
- `Sofa`: Heavy furniture with material-specific handling

### Shipping Visitors
- `StandardShippingVisitor`: Basic shipping cost calculation
- `ExpressShippingVisitor`: Premium shipping with higher rates
- `DistanceBasedShippingVisitor`: Distance-based cost calculation

## 📁 Project Structure

```
furniture-shipping-visitor/
├── Furniture.java                    # Furniture interface
├── Chair.java                        # Chair implementation
├── Table.java                        # Table implementation
├── Sofa.java                         # Sofa implementation
├── ShippingCostVisitor.java          # Visitor interface
├── StandardShippingVisitor.java      # Standard shipping logic
├── ExpressShippingVisitor.java       # Express shipping logic
├── DistanceBasedShippingVisitor.java # Distance-based shipping logic
├── FurnitureShipping.java            # Main client code
├── README.md                         # This file
└── UML Class Diagram.png             # Architecture diagram
```

## 🚀 Usage

### Running the Application

```bash
# Compile all Java files
javac *.java

# Run the main application
java FurnitureShipping
```

### Example Output

```
====================== Standard Shipping ======================
Standard shipping cost for Ergonomic Office Chair: $22.75
Standard shipping cost for Dining Table: $56.5
Standard shipping cost for Sectional Sofa: $127.25

Total standard shipping cost: $206.5

====================== Express Shipping ======================
Express shipping cost for Ergonomic Office Chair: $34.125
Express shipping cost for Dining Table: $84.75
Express shipping cost for Sectional Sofa: $190.875

Total express shipping cost: $309.75

============================ Distance-Based Shipping ============================
Distance-based shipping cost for Ergonomic Office Chair: $45.5
Distance-based shipping cost for Dining Table: $113.0
Distance-based shipping cost for Sectional Sofa: $254.5

Total distance-based shipping cost: $413.0
```

## 💡 Design Pattern Benefits

### Visitor Pattern Advantages
1. **Separation of Concerns**: Shipping logic is separated from furniture classes
2. **Extensibility**: Easy to add new shipping strategies without modifying furniture classes
3. **Type Safety**: Compile-time type checking for different furniture types
4. **Single Responsibility**: Each visitor handles one specific shipping strategy

### Key Features
- **No Abstract Classes**: Uses interfaces as required
- **Type-Specific Logic**: Each furniture type can have custom shipping calculations
- **Flexible Pricing**: Different pricing strategies for different shipping methods
- **Easy Testing**: Each component can be tested independently

## 🔧 Implementation Details

### Furniture Interface
```java
interface Furniture {
    void accept(ShippingCostVisitor visitor);
    String getName();
    double getWeight();
    double getVolume();
}
```

### Visitor Interface
```java
interface ShippingCostVisitor {
    void visit(Chair chair);
    void visit(Table table);
    void visit(Sofa sofa);
    double getTotalCost();
}
```

### Shipping Cost Calculations

#### Standard Shipping
- **Chair**: Base cost ($15) + weight × $0.5
- **Table**: Weight × $0.7 + assembly fee ($25 if assembled)
- **Sofa**: Volume × $0.05 + weight × $0.6 + material fee ($50 for leather)

#### Express Shipping
- 1.5x multiplier on standard shipping costs

#### Distance-Based Shipping
- 2x multiplier on standard shipping costs (for 300-mile distance)

## 🎯 Use Cases

This implementation is ideal for:
- E-commerce platforms with diverse product catalogs
- Systems requiring multiple pricing strategies
- Applications where business logic needs to be separated from data models
- Scenarios requiring easy addition of new product types or pricing rules

## 🔮 Future Enhancements

Potential improvements could include:
- Database integration for storing pricing rules
- REST API for web service integration
- Additional furniture types (beds, cabinets, etc.)
- More sophisticated pricing algorithms
- Geographic pricing zones
- Seasonal pricing adjustments

## 📊 UML Class Diagram
<img width="2700" height="1060" alt="UML Class Diagram" src="https://github.com/user-attachments/assets/a81def47-124e-4ce7-a47c-93a34882a2c9" />

The diagram shows the relationships between the Furniture interface, concrete furniture classes, and the visitor implementations.

## 🤝 Contributing

Feel free to contribute to this project by:
- Adding new furniture types
- Implementing additional shipping strategies
- Improving the documentation
- Adding unit tests

## 📄 License

This project is open source and available under the MIT License.

---

**Note**: This implementation demonstrates clean code principles and design patterns best practices. The Visitor pattern is particularly useful when you need to perform operations on a set of objects with different types without modifying their classes, and when the operations are likely to change or new operations need to be added frequently.
