
# ✈️ Flight Management System – Java

A modular and object-oriented **flight management system** developed in Java. The system supports managing airlines, airports, employees, and flights with extensible search strategies and notification mechanisms.

---

## 🚀 Features

- 🛫 **Airline & Flight Management** – Create and manage airlines, airports, and employees  
- 📅 **Dynamic Flight Scheduling** – Add flights with times, durations, prices, and passenger counts  
- 🔍 **Flexible Search Strategies** – Sort and filter flights by:
  - Departure Time  
  - Duration  
  - Price  
  - Number of Passengers  
- 🔔 **Notification System** – Implements the **Observer pattern** to notify users of flight updates  
- 🧩 **Scalable Architecture** – Uses key OOP design patterns for flexibility and clarity

---

## 🧠 Design Patterns Used

| Pattern      | Purpose |
|--------------|---------|
| **Strategy** | Enables interchangeable flight sorting mechanisms  
| **Observer** | Implements real-time update notifications for interested parties  
| **Composite** | Manages nested or grouped airport-related structures efficiently  

---

## 📦 Technologies Used

- Java 11+  
- Java Collections Framework  
- Object-Oriented Programming  
- Custom Interfaces and Enums  
- Design Patterns (Strategy, Observer, Composite)

---

## 📁 Project Structure

```
├── models/
│   ├── Airline.java
│   ├── Airport.java
│   ├── Flight.java
│   ├── Employee.java
│
├── search/
│   ├── SearchStrategy.java
│   ├── ByPriceSearchStrategy.java
│   ├── ByDurationSearchStrategy.java
│   ├── ...
│
├── notifications/
│   ├── Observer.java
│   ├── Subject.java
│   └── NotificationManager.java
│
└── main/
    └── Context.java
```

---

## 📷 Demo (Optional)

> *(You can include screenshots or console examples here if you have any!)*

---

## 📌 Future Improvements

- Integrate persistence with file or database storage  
- Add authentication layer for user roles (Admin / Viewer)  
- Build a basic GUI with JavaFX or Swing  
- Extend to support round-trip or multi-leg flights

---

## 🧑‍💻 Author

Aharon Bassous  
[LinkedIn](https://www.linkedin.com/in/aharon-bassous) • [GitHub](https://github.com/Aharonba)
