---

# Hotel Management System

A Java Swing-based application for managing hotel operations, including room bookings, food ordering, and checking room availability. This system provides an interactive interface for hotel staff and guests to manage their reservations and services efficiently.

## Features

- **Room Details**: View detailed information about various room types, including amenities and charges.
- **Room Availability**: Check the availability of rooms based on current bookings.
- **Book Room**: Book a room by providing personal details, selecting room types, and specifying room numbers. Includes functionality for double rooms with additional guest information.
- **Order Food**: Place food orders for rooms, specifying items and quantities. Calculates total cost of orders.
- **Checkout**: Process checkouts by calculating and displaying the bill based on room charges and food orders. Updates room availability upon checkout.

## Getting Started

To run this project, you'll need Java Development Kit (JDK) installed on your machine. Follow these steps to get the application up and running:

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd Hotel-Management-System
   ```

2. **Compile the Code**
   ```bash
   javac -d bin src/*.java
   ```

3. **Run the Application**
   ```bash
   java -cp bin MainFrame
   ```

## Directory Structure

- `src/`: Contains all Java source files.
  - `MainFrame.java`: The main application frame and entry point.
  - `RoomDetailsPanel.java`: Displays room details.
  - `AvailabilityPanel.java`: Shows room availability.
  - `BookRoomPanel.java`: Handles room booking process.
  - `OrderFoodPanel.java`: Manages food ordering.
  - `CheckoutPanel.java`: Handles checkout and billing.
- `bin/`: Compiled class files (generated during compilation).

## Dependencies

- Java Development Kit (JDK) 8 or higher.

## Usage

Upon launching the application, you will be greeted with the main frame containing buttons to navigate to different panels. Each panel provides functionality as described in the features section.

- **Room Details**: Click the "Room Details" button to view information about different room types.
- **Room Availability**: Click the "Room Availability" button to check current room availability.
- **Book Room**: Click the "Book Room" button to start the booking process.
- **Order Food**: Click the "Order Food" button to place food orders for a room.
- **Checkout**: Click the "Checkout" button to process checkouts and view bills.

## Contact

For any questions or support, please contact saitejachintu821@gmail.com

---
