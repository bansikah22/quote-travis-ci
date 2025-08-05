# Quote Application (Backend + Frontend)

This project is a **full-stack quote application** built with:

- **Spring Boot (Java 21)** for the backend  
- **React + TypeScript** for the frontend  
- **Travis CI** for Continuous Integration  
- **Docker (distroless + minimal images)** for containerization  

---

## 📌 Features
- Fetches random quotes from [Quotable API](https://api.quotable.io/random)  
- Falls back to local quotes if the API is unreachable  
- Modern frontend UI with React + TypeScript  
- CI pipeline with Travis builds & Docker image creation  

---

## 🛠 Project Structure
```bash
quote-project/
├── .travis.yml                 # CI pipeline config
├── quote-service-travis-ci/    # Backend (Spring Boot)
│   └── pom.xml
└── quote-web/                  # Frontend (React + TS)
    └── package.json
```

---

## 🚀 Running Locally

### 1. Backend (Spring Boot)
```bash
cd quote-service-travis-ci
./mvnw spring-boot:run
```
Backend runs at: [http://localhost:8080/quote](http://localhost:8080/quote)

### 2. Frontend (React + TS)
```bash
cd quote-web
npm install
npm start
```
Frontend runs at: [http://localhost:3000](http://localhost:3000)

---

## 🧪 Tests

### Backend
```bash
cd quote-service-travis-ci
./mvnw test
```

### Frontend
```bash
cd quote-web
npm test
```

---

## 🐳 Docker Build

### Backend Image (Spring Boot with Distroless)
```bash
cd quote-service-travis-ci
docker build -t quote-backend .
docker run -p 8080:8080 quote-backend
```

### Frontend Image (React + Nginx Alpine)
```bash
cd quote-web
docker build -t quote-frontend .
docker run -p 3000:80 quote-frontend
```

---

## 🔄 CI/CD with Travis
- Builds & tests backend (Java 21 + Maven)  
- Builds & tests frontend (Node.js + React)  
- Builds Docker images for both services  
- Sends **email notifications on failure** to maintainers  

---

## 📧 Maintainer
**Tandap Noel Bansikah**  
