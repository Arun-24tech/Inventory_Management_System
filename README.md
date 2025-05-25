# Inventory_Management_System
This is a Java-based Inventory Management System designed to help businesses efficiently track and manage their inventory. The application allows users to add, update, delete, and view inventory items with a user-friendly interface.
🚀 Features
Add new inventory items with details like name, quantity, and price

Update or delete existing items

View current inventory list

Built using the DAO (Data Access Object) pattern for clean separation of business logic and database operations

Simple, intuitive UI built with Java

🛠️ Technologies Used
Java
MySQL 
IntelliJ IDEA (for development)

📁 Project Structure
Inventory Management/
└── src/
            └── inventory/
                ├── dao/          # Interfaces and implementations for DB access
                ├── model/        # Data models (e.g., Item)
                ├── util/         # Utility classes (e.g., DBConnection)
                ├── ui/           # User interface code
                └── Main.java     # Application entry point
