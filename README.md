# 🎵 Music Library Management System

## 📌 Project Overview

The Music Library Management System is a full-stack microservices-based web application developed using Spring Boot, Spring Cloud, MySQL, HTML, CSS, and JavaScript.

The application allows users to browse songs, create playlists, manage profiles, and interact with a centralized music library. Administrators can manage songs and users through dedicated administrative functionalities.

The project follows a Microservices Architecture to improve scalability, maintainability, and separation of concerns.

---

## 🏗️ Project Structure

MusicLibraryProject
│
├── CapstoneBackend
│   ├── EurekaServer
│   ├── APIGateway
│   ├── AdminService
│   ├── UserService
│   ├── AuthService
│   └── NotificationService
│
├── Frontend
│   ├── HTML Files
│   ├── CSS Files
│   ├── JavaScript Files
│   └── Assets
│
└── README.md

---

## 🚀 Technologies Used

### Backend

* Java 17
* Spring Boot
* Spring Cloud
* Spring MVC
* Spring Data JPA
* Hibernate
* MySQL
* REST APIs
* Maven

### Microservices Components

* Eureka Service Registry
* API Gateway
* Service Discovery
* Inter-Service Communication using RestTemplate

### Frontend

* HTML5
* CSS3
* Bootstrap 5
* JavaScript (ES6)

### Database

* MySQL

---

## 🔧 Backend Services

### 1. Eureka Server

Acts as a Service Registry.

**Features**

* Service Registration
* Service Discovery
* Centralized Microservice Management

### 2. API Gateway

Acts as a Single Entry Point for all client requests.

**Features**

* Route Management
* Request Forwarding
* Centralized Access Point

### 3. Auth Service

Responsible for Authentication and Authorization.

**Features**

* User Registration
* User Login
* Role-Based Access

**Roles**

* ADMIN
* USER

### 4. User Service

Handles all user-related operations.

**Features**

* View Available Songs
* Create Playlists
* Update Playlists
* Delete Playlists
* Add Songs to Playlist
* Remove Songs from Playlist
* View User Profile

### 5. Admin Service

Handles administrative operations.

**Features**

* Add New Songs
* Update Song Details
* Delete Songs
* View All Songs
* Manage Users
* Control Song Visibility

---

## 🎨 Frontend Features

### User Dashboard

Users can:

* Browse Songs
* Search Songs
* Filter Songs by Genre
* View Song Details
* Create Playlists
* Manage Playlists
* View Profile Information

### Admin Dashboard

Administrators can:

* Add Songs
* Update Songs
* Delete Songs
* View All Users
* Manage Music Library

---

## 📚 Playlist Management

### Features

* Create Playlist
* Add Songs to Playlist
* Remove Songs from Playlist
* View Playlist Details
* Delete Playlist

---

## 🎵 Song Management

### Features

* Add Song
* Update Song
* Delete Song
* Fetch Song by ID
* View All Songs
* Visibility Control

---

## 👤 User Management

### Features

* User Registration
* User Login
* Profile Management
* Role-Based Access Control

---

## 🔄 Microservices Communication

```text
Frontend
    ↓
API Gateway
    ↓
---------------------------------
|       |        |             |
Auth   User    Admin       Other
Service Service Service   Services
---------------------------------
    ↓
 MySQL Database
```

---

## 📱 Responsive Design

The frontend is fully responsive and supports:

* Desktop Devices
* Laptops
* Tablets
* Mobile Devices

Implemented using:

* Bootstrap Grid System
* Flexbox Layout
* Responsive Navigation

---

## 📖 Learning Outcomes

### Spring Boot

* REST API Development
* Dependency Injection
* Exception Handling
* Layered Architecture

### Spring Cloud

* Eureka Server
* API Gateway
* Service Discovery

### JPA & Hibernate

* Entity Mapping
* Relationships
* CRUD Operations
* Database Integration

### Frontend

* HTML5
* CSS3
* Bootstrap
* JavaScript DOM Manipulation
* API Integration

### Software Architecture

* Microservices Design
* Service Communication
* Modular Development
* Scalable Application Structure

---

## 🔮 Future Enhancements

* JWT Authentication
* OAuth2 Integration
* Docker Containerization
* Kubernetes Deployment
* CI/CD Pipeline using Jenkins
* AWS Cloud Deployment
* Song Recommendation System
* Music Streaming Support

---

## 👨‍💻 Developed By

**Rahul Koppula**

Java Full Stack Developer

### Skills

* Java
* Spring Boot
* Spring Cloud
* Hibernate
* JPA
* MySQL
* Microservices
* HTML
* CSS
* JavaScript
* Bootstrap

---

## 🎯 Repository Purpose

This repository serves as a complete learning and demonstration project for:

* Microservices Architecture
* Spring Boot Development
* Frontend-Backend Integration
* REST API Design
* Database Management
* Enterprise Application Development

It can be used for study, practice, interviews, portfolio demonstrations, and understanding real-world microservice application development.
