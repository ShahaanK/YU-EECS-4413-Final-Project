# The Vibez — Online Clothing Store

**Team:** 404 Not Found  
**Contributors:** Shahaan Khan, Mehdiya Kermali, Chunxin Zhang, Jovana Babin

---

## Project Overview

**The Vibez** is an interactive online clothing store developed as the final project for **EECS 4413**.  
The goal was to build a **user-friendly e-commerce platform** focused on selling **tops and pants**, while also showcasing strong architectural design, scalable implementation, and collaborative teamwork.

This README covers the project’s **architecture, design decisions, implementation details, strengths, challenges, and key takeaways**.

---

## Architecture

The project follows a **multi-tier architecture** that separates **front-end** and **back-end** components:

- **Front-End:**  
  - Catalog (browse products)  
  - Account registration & login  
  - Shopping cart  
  - Checkout & payment information  
  - Administrator pages  

- **Back-End:**  
  - Data access layer  
  - Catalog and ordering services  
  - Identity management  
  - Shopping cart functionality  

This separation promotes **modularity**, **maintainability**, and **scalability**.

---

## Design

### MVC & DAO Patterns
- **MVC (Model-View-Controller):**  
  Separates **data/logic (Model)** from **presentation (View)**, with **Controllers** mediating between them.  
- **DAO (Data Access Object):**  
  Encapsulates database logic, ensuring clean separation of concerns and making the code more modular and testable.  

### Database Schema
Designed in **MySQL Workbench** and implemented in **SQLite**, with the following main tables:
- **Items:** product catalog (tops, pants, prices, descriptions, images)  
- **Customers:** user accounts and login credentials  
- **Addresses:** billing & shipping info  
- **PurchaseOrders:** customer orders with line items  
- **Payments:** order payment details  

The schema ensures **efficient storage and retrieval** of relational data.

### Main Design Decisions & Trade-offs
- **Java Servlets & JSP** → efficient request handling & dynamic content generation.  
- **Custom CSS + Framework** → balance between responsive design & unique branding.  
- **SQLite Database** → lightweight and simple for prototyping, but scalability may be limited in production.

---

## Features

### Customer Features
- Browse catalog of products with **images and details**  
- Register/login for personalized accounts  
- Add items to **shopping cart**  
- Complete **checkout** with payment info  

### Admin Features
- Generate **sales reports** for data-driven insights  
- Manage **customer accounts and orders**  

---

## Implementation Details

### Front-End
- Designed in **Figma** for layout and prototyping.  
- Figma-exported CSS + custom CSS + framework for responsive styling.  
- Collaborative design process improved speed and consistency.  

### Back-End
- **Java Servlets & JSP**: handle HTTP requests, generate dynamic HTML, and separate presentation from logic.  
- Services included:
  - Catalog service  
  - Ordering service  
  - Identity management  
  - Shopping cart service  

### Database
- **SQLite**: chosen for simplicity and embedded relational features.  
- Provides smooth prototyping but scalability challenges anticipated for larger deployments.  

---

## Strengths, Challenges & Takeaways

### Strengths
- Effective use of **design patterns** (MVC, DAO)  
- **Collaborative teamwork** and communication  
- Integration of UI/UX with back-end logic  
- Lightweight, functional e-commerce prototype  

### Challenges
- Coordinating integration across multiple contributors  
- **SQLite scalability limitations** for concurrent/multi-user access  
- Managing feature completeness vs. time constraints  

### Key Takeaways
- **Planning and architecture** are critical for smooth development  
- **Scalability** must be considered early in design  
- **Soft skills** (communication, teamwork) are as vital as technical skills  
- Team projects benefit from skill diversity and faster progress, but risk conflicts and inconsistencies  

---

## Getting Started

### Prerequisites
- **Java JDK 8+**  
- **Apache Tomcat** (or other servlet container)  
- **SQLite** (or replace with MySQL/PostgreSQL for production)  

### Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/ShahaanK/YU-EECS-4413-Final-Project.git
   cd YU-EECS-4413-Final-Project
   ```

2. Initialize the database schema (in SQLite or your chosen DBMS).  

3. Deploy the project to your servlet container (e.g., copy `.war` file to `Tomcat/webapps/`).  

4. Open the app in your browser:
   ```
   http://localhost:8080/YU-EECS-4413-Final-Project/
   ```

---

## Roadmap

- Transition from **SQLite → MySQL/PostgreSQL** for scalability  
- Add **unit & integration tests**  
- Implement **secure payment gateways**  
- Improve **mobile responsiveness** and accessibility  
- Cloud deployment for real-world availability  
---

*(Add a license here, e.g., MIT or Apache 2.0, if making the project open source.)*
