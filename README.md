# 🛠️ Spring Boot Development Template (Scaffold)

> A robust, enterprise-level backend template integrating Spring Security, MyBatis Plus, Redis, and Hikvision SDK.
>
> 🚀 **Author**: [korozet1](https://github.com/korozet1) | **Java & CV Researcher**

## 🏗️ Architecture & Tech Stack

Based on `Spring Boot 2.3.9.RELEASE` and `JDK 1.8`, designed for rapid development of enterprise management systems.

| Component | Version | Description |
| :--- | :--- | :--- |
| **Java** | `1.8` | Core Language (Legacy & Stable) |
| **Spring Boot** | `2.3.9.RELEASE` | Application Framework |
| **ORM** | `MyBatis Plus 3.4.2` | Database Access |
| **Database** | `MySQL 8.0/5.7` | Relational Database |
| **Cache** | `Redis` | Caching & Session Management |
| **Security** | `Spring Security + OAuth2` | Auth & Permissions |
| **Tools** | `Hutool 5.5.8`, `Lombok` | Utilities & Boilerplate reduction |
| **IoT / Hardware** | `Hikvision Artemis SDK` | Camera & Device Integration |
| **API Doc** | `Swagger Bootstrap UI` | Enhanced API Documentation |

---

## 🚀 Quick Start (Running Guide)

### 1. Database Initialization (⚠️ Important)
Before running the project, you **MUST** initialize the database.

1.  Create a MySQL database named **`portal`** (as configured in `application-dev.yml`).
2.  Execute the SQL script located at:
    ```
    /src/db/korozet.sql
    ```
    *This script creates the necessary tables and initial data.*

### 2. Maven Dependencies
Load all dependencies to ensure the environment is ready.

1.  Open the project in **IntelliJ IDEA**.
2.  Right-click `pom.xml` -> **Maven** -> **Reload Project**.
3.  Wait for dependencies (especially `hikvision-artemis` and `spring-security`) to download completely.

### 3. Configuration Check
Check `src/main/resources/application-dev.yml` to match your local environment:

* **Server Port**: Defaults to `7777`
* **Context Path**: `/korozet`
* **MySQL**: `jdbc:mysql://127.0.0.1:3306/portal` (Default user/pass: `root`/`root`)
* **Redis**: Defaults to `192.168.1.233` (⚠️ **Change this to `127.0.0.1` or your Redis IP**)

### 4. Run Application
Run the main class. Upon successful startup, access the API documentation:

* **Swagger UI**: `http://localhost:7777/korozet/doc.html`

---

## 📦 Key Features

* **🔐 Secure Auth**: Integrated Spring Security with OAuth2 for token-based authentication.
* **📹 Hardware Integration**: Pre-configured with Hikvision Artemis SDK (`artemis-http-client`) for security camera management.
* **⚡ High Performance**: Redis integration for caching hot data.
* **📡 WebSocket**: Real-time communication support.
* **📄 Response Compression**: Enabled GZIP compression for text/json responses > 20 bytes (configured in yml).

---

## 🤝 Contributing
Feel free to fork and submit PRs!
