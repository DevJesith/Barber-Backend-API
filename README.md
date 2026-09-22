# 💈 Barbershop API - Backend Service

A robust RESTful backend API designed to handle barbershop operations including client booking, barber scheduling, catalog service management, and role-based authentication. Built with **Java 21**, **Spring Boot**, and **Hexagonal Architecture (Ports and Adapters)**.

---

## 🎯 Project Overview & Objectives

The goal of this project is to provide a clean, scalable, and fully decoupled backend service for a barbershop system (prepared for integration with a **Flutter** mobile application).

---

## 📐 Hexagonal Architecture Layout

This application strictly separates domain business rules from external technologies, frameworks, and database persistence.

```text
src/main/java/com/portafolio/barbershopapi/
├── 🧠 domain/
│   ├── model/                  # Pure Domain Entities & Enums
│   └── port/
│       ├── in/                 # Input Ports (Use Cases / Drivers)
│       └── out/                # Output Ports (Repository Interfaces)
├── ⚙️ application/
│   ├── service/                # Use Case Implementations (Business Logic)
│   └── dto/                    # Data Transfer Objects (Requests/Responses)
└── 🔌 infrastructure/
    ├── adapter/
    │   ├── in/web/             # REST Controllers & Endpoints
    │   └── out/persistence/    # JPA Entities, Spring Data Repositories & Adapters
    └── config/                 # Security (JWT), Beans & Database Config