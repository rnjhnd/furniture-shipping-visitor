# Furniture Shipping Cost Calculator

A Java implementation of the **Visitor Design Pattern** for calculating shipping costs of different furniture types in an e-commerce platform. This project demonstrates how to use visitor objects to perform operations on furniture items without tightly coupling the shipping logic to the furniture classes.

## 📋 Overview

The Furniture Shipping Visitor allows you to calculate shipping costs for various furniture items (chairs, tables, and sofas) using different shipping strategies. Instead of embedding shipping logic within each furniture class, the system uses visitor objects to perform cost calculations, making the code more maintainable and extensible.

## 🏗️ Architecture

This project implements the **Visitor Design Pattern** with the following components:

- **Furniture Interface**: Defines the contract for all furniture types with an accept method
- **Concrete Furniture Classes**: Chair, Table, and Sofa implementations
- **ShippingCostVisitor Interface**: Defines visit methods for each furniture type
- **Concrete Visitor Classes**: Standard, Express, and Distance-based shipping strategies
- **Main Application**: Demonstrates the visitor pattern in action

### Design Pattern Benefits

- **Separation of Concerns**: Shipping logic is separated from furniture classes
- **Extensibility**: Easy to add new shipping strategies without modifying furniture classes
- **Type Safety**: Compile-time type checking for different furniture types
- **Single Responsibility**: Each visitor handles one specific shipping strategy

## 📊 UML Class Diagram

![image](https://github.com/user-attachments/assets/a81def47-124e-4ce7-a47c-93a34882a2c9)

The following diagram illustrates:
- The architecture of the Furniture Shipping Visitor
- Relationships between the core components:
  - The `Furniture` interface
  - Concrete implementations: `Chair`, `Table`, `Sofa`
  - The `ShippingCostVisitor` interface
  - Concrete visitor implementations: `StandardShippingVisitor`, `ExpressShippingVisitor`, `DistanceBasedShippingVisitor`
  - The main application class
- How the Visitor design pattern is applied in this project

## 🚀 Features

- **Multiple Furniture Types**: Support for chairs, tables, and sofas
- **Flexible Shipping Strategies**: Standard, Express, and Distance-based shipping
- **Type-Safe Operations**: Strong typing for each furniture type
- **Extensible Design**: Easy to add new furniture types or shipping strategies
- **Clean Architecture**: Well-structured, maintainable code

## 📁 Project Structure

```
furniture-shipping-visitor/
├── src/
│   ├── Furniture.java                        # Furniture interface
│   ├── Chair.java                            # Chair implementation
│   ├── Table.java                            # Table implementation
│   ├── Sofa.java                             # Sofa implementation
│   ├── ShippingCostVisitor.java              # Visitor interface
│   ├── StandardShippingVisitor.java          # Standard shipping logic
│   ├── ExpressShippingVisitor.java           # Express shipping logic
│   ├── DistanceBasedShippingVisitor.java     # Distance-based shipping logic
│   └── FurnitureShipping.java                # Main application demo
└── README.md                                 # Project documentation
```

## 🛠️ Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Getting Started

1. **Clone or download** the project files
2. **Navigate** to the project directory
3. **Compile** the Java files:
   ```bash
   javac src/*.java
   ```
4. **Run** the application:
   ```bash
   java -cp src FurnitureShipping
   ```

## 📖 Usage

### Basic Usage

The main application (`FurnitureShipping.java`) demonstrates how to use the visitor pattern:

```java
// Create furniture items
Furniture chair = new Chair("Ergonomic Office Chair", 15.5, 0.5);
Furniture table = new Table("Dining Table", 45.0, 2.0, true);
Furniture sofa = new Sofa("Sectional Sofa", 85.0, 4.5, "leather");

Furniture[] shoppingCart = {chair, table, sofa};

// Calculate standard shipping costs
ShippingCostVisitor standardShipping = new StandardShippingVisitor();
for (Furniture item : shoppingCart) {
    item.accept(standardShipping);
}
System.out.println("Total standard shipping cost: $" + standardShipping.getTotalCost());

// Calculate express shipping costs
ShippingCostVisitor expressShipping = new ExpressShippingVisitor();
for (Furniture item : shoppingCart) {
    item.accept(expressShipping);
}
System.out.println("Total express shipping cost: $" + expressShipping.getTotalCost());
```

### Expected Output

When you run the application, you'll see:

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

## 🔧 Extending the Project

### Adding New Furniture Types

To add a new furniture type (e.g., `Bed`):

1. **Create** a new class implementing the `Furniture` interface
2. **Add** a visit method to the `ShippingCostVisitor` interface
3. **Implement** the visit method in all concrete visitor classes

Example:
```java
public class Bed implements Furniture {
    private String name;
    private double weight;
    private double volume;
    private String size; // twin, queen, king
    
    // Implementation details...
}
```

### Adding New Shipping Strategies

To add a new shipping strategy (e.g., `OvernightShippingVisitor`):

1. **Create** a new class implementing the `ShippingCostVisitor` interface
2. **Implement** visit methods for each furniture type
3. **Add** the new strategy to the main application

## 🎯 Design Patterns Used

### Visitor Pattern
- **Purpose**: Perform operations on objects with different types without modifying their classes
- **Benefits**: Separates algorithms from object structure and allows easy addition of new operations
- **Implementation**: Each furniture class has an `accept()` method that calls the appropriate `visit()` method

### Strategy Pattern (Implicit)
- **Purpose**: Encapsulate different shipping algorithms
- **Benefits**: Allows switching between different shipping strategies at runtime
- **Implementation**: Different visitor classes represent different shipping strategies

## 💡 Shipping Cost Calculations

### Standard Shipping
- **Chair**: Base cost ($15) + weight × $0.5
- **Table**: Weight × $0.7 + assembly fee ($25 if assembled)
- **Sofa**: Volume × $0.05 + weight × $0.6 + material fee ($50 for leather)

### Express Shipping
- 1.5x multiplier on standard shipping costs

### Distance-Based Shipping
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

## 🤝 Contributing

Feel free to contribute to this project by:
- Adding new furniture types
- Implementing additional shipping strategies
- Improving the documentation
- Adding unit tests

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

**Note**: This implementation demonstrates clean code principles and design patterns best practices. The Visitor pattern is particularly useful when you need to perform operations on a set of objects with different types without modifying their classes, and when the operations are likely to change or new operations need to be added frequently.
