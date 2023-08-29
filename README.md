# EEECS-4413-Final-Project
The Vibez - Online Clothing Store
Welcome to The Vibez, an interactive online clothing store developed by the team "404 Not Found". This README provides an overview of the project's architecture, design decisions, implementation details, strengths, challenges, and key takeaways.

Table of Contents
Introduction
Architecture Description
Design Description
MVC and DAO Patterns
Database Schema
Main Design Decisions and Trade-offs
Advanced Features
Implementation
Front-End
Back-End
Database Schema
Conclusion
Contributors
Introduction
"The Vibez" is an online clothing store project developed by the team "404 Not Found". The goal was to create an interactive and user-friendly e-commerce platform for selling tops and pants. This README covers the architecture, design, implementation, strengths, challenges, and takeaways from the project.

Architecture Description
The project follows a multi-tier architecture that separates the front-end and back-end components. The front-end includes views such as catalog, account registration, login, shopping cart, checkout, payment information, and administrator pages. The back-end focuses on data access, catalog and ordering services, identity management, and shopping cart functionality. The architecture promotes modularity and scalability.

Design Description
MVC and DAO Patterns
The Model-View-Controller (MVC) design pattern is employed for the back-end, separating data and logic from the visual representation. The DAO pattern is used to abstract data access logic, ensuring separation of concerns. The project's architecture is organized into three main components: Model (data structures and logic), View (presentation), and Controller (mediates between models and views). The separation of concerns enhances code modularity and maintainability.

Database Schema
The database schema, created using MySQL Workbench, comprises tables for items, customers, addresses, purchase orders, and payments. Items table includes product information, customers table holds user details, and purchase orders table tracks order information. The schema design ensures efficient storage and retrieval of data.

Main Design Decisions and Trade-offs
The decision to use Java Servlets and JSP for the back-end enables efficient request handling and dynamic content generation. Incorporating custom CSS and a CSS framework strikes a balance between visual aesthetics and responsive design. The use of SQLite as the database system provides a lightweight solution for data management, though scalability might be a concern as the application grows.

Advanced Features
The platform boasts customer-centric features like product images, enhancing the online shopping experience. For administrators, advanced functionalities include sales reports for data-driven decisions and comprehensive customer management tools.

Implementation
Front-End
The front-end design was created using Figma, providing a visual representation of web pages. Custom CSS and CSS framework were combined for styling, with Figma-exported CSS as a starting point. The collaboration in Figma streamlined design updates and expedited CSS development.

Back-End
Java Servlets and JSP were chosen for the back-end. These technologies handle HTTP requests, generate HTML responses, and separate logic from presentation. The back-end architecture supports data access, catalog service, ordering service, identity management, and shopping cart functionality.

Database Schema
SQLite was employed as the database system due to its lightweight nature and relational capabilities. While suitable for small to medium-sized applications, scalability might be a concern in the long term.

Conclusion
In conclusion, the team's collaboration led to the successful development of "The Vibez" online clothing store. Employing architecture, design patterns, and technologies like MVC, DAO, Servlets, JSP, and SQLite, we achieved a modular and user-friendly platform. The project highlighted strengths in effective teamwork, communication, and innovative design choices. Challenges included coordinating code integration and addressing scalability concerns. Valuable takeaways encompassed the significance of planning, scalability considerations, and soft skills development. Team projects offer advantages in skills diversity, collaboration, and faster progress, albeit with potential conflicts and quality consistency challenges.

Contributors
Shahaan Khan
Mehdiya Kermali
Chunxin Zhang
Jovana Babin
