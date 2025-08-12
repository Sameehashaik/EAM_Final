# HuskyAir Reservation System

A Spring Boot web application for managing flight reservations with two additional entities: **Customer** and **Payment**.  
Implements REST APIs (JSON with Jackson), tested with Postman, and a Thymeleaf-based UI for user-friendly reservation management.

---

## Features

### Backend (Spring Boot + MongoDB)
- **Entities**
  - `Reservation` – main entity
  - `Customer` – nested entity in Reservation
  - `Payment` – nested entity in Reservation
- **CRUD REST Endpoints** (Jackson for JSON serialization/deserialization)
  - `GET /api/reservations` – Get all reservations
  - `GET /api/reservations/{id}` – Get reservation by ID
  - `POST /api/reservations` – Create new reservation
  - `PUT /api/reservations/{id}` – Update an existing reservation
  - `GET /api/reservations/sample` – Returns a sample Reservation object in JSON
  - `GET /api/reservations/import/sample` – Imports the sample Reservation into MongoDB
- Uses **Spring Data MongoDB** for persistence

### Frontend (Thymeleaf + CSS)
- Create reservation form with validation
- Success page showing saved reservation as JSON
- Reservation list view with links to view JSON

---

## Technology Stack

- **Java**: 21
- **Spring Boot**: 3.5.4
- **MongoDB**: local instance (`mongodb://localhost:27017/huskyair`)
- **Thymeleaf**: HTML templating
- **Jackson**: JSON (de)serialization
- **Postman**: API testing

---

## Project Structure

```

src/main/java/com/huskyair
├── controller
│    ├── ReservationRestController.java
│    ├── ReservationViewController.java
├── model
│    ├── Reservation.java
│    ├── Customer.java
│    └── Payment.java
├── repository
│    └── ReservationRepository.java
├── service
│    └── ReservationService.java
└── HuskyAirApplication.java
src/main/resources
├── application.properties
├── static/css/app.css
└── templates
    ├── index.html
    ├── reservation-form.html
    ├── reservation-success.html
    └── reservations-list.html

````

---

## Prerequisites

1. **Java 21+**
2. **Maven 3.9+**
3. **MongoDB** running locally:
   ```bash
   mongod --dbpath /path/to/mongodb/data

4. Port `8080` available

---

## Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

Application will start at: [http://localhost:8080](http://localhost:8080)

---

## API Endpoints

| Method | Endpoint                          | Description                             |
| ------ | --------------------------------- | --------------------------------------- |
| GET    | `/api/reservations`               | Get all reservations                    |
| GET    | `/api/reservations/{id}`          | Get reservation by ID                   |
| POST   | `/api/reservations`               | Create a new reservation                |
| PUT    | `/api/reservations/{id}`          | Update reservation                      |
| GET    | `/api/reservations/sample`        | Returns sample Reservation JSON         |
| GET    | `/api/reservations/import/sample` | Imports sample Reservation into MongoDB |

---

## Client-Side (Thymeleaf) URLs

| URL |	Description |
| ------------------------------- | ----------------------------------------------------------- |
| `/`                             | Home page (index)                                           |
| `/client/reservations/new`      | Reservation creation form                                   |
| `/client/reservations`          | List of all saved reservations (table view with JSON links) |
| `/client/reservations/success`  | Reservation success page (shows saved data as JSON)         |

## Example JSON for POST/PUT

```json
{
  "reservationCode": "HA2025",
  "flightNo": "HA-101",
  "travelDate": "2025-08-20",
  "totalAmount": 350.00,
  "customer": {
    "name": "Ava Lee",
    "email": "ava@example.com",
    "phone": "555-0101"
  },
  "payment": {
    "method": "VISA",
    "amount": 350.00,
    "status": "PENDING"
  }
}
```

---


## Assessment Rubric Mapping

* **View/UI Design:** Thymeleaf templates with form validation and CSS ✅
* **Project Setup:** Latest dependencies in `pom.xml`, `application.properties` ✅
* **Postman + REST + Jackson:** API tested via Postman, JSON serialization/deserialization ✅
* **REST Controller Implementation:** GET, POST, PUT with Jackson ✅
* **Submission:** This README + GitHub + Video ✅

---

## Author

HuskyAir Reservation System – Final Exam Project

Sameeha Shaik - N01649346
