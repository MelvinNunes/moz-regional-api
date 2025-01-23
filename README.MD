# 🇲🇿 Mozambique Provinces API 🌍

## What's This Magic? 🧙‍♂️

Ever wanted to know every single nook and cranny of Mozambique's administrative regions? Well, you're in luck! This Spring Boot API is your ultimate companion for diving deep into Mozambican geography faster than you can say "Maputo"!

## ✨ Features

- 🗺️ Fetch Provinces
- 🏘️ Get Districts
- 🏙️ Explore Municipalities
- 🏡 Discover Neighborhoods
- 🌴 Uncover Villages

## 🚀 Tech Stack

This API uses a DDD (Domain Driven Design), because why not hehe.

- Spring Boot (Because enterprise Java can be cool too!)
- H2 Database (Lightweight and in-memory, just how we like it)
- Flyway (Database migrations without the drama)
- SpringDoc OpenAPI (Swagger UI for the win!)

## 🛠️ Setup & Run

### Prerequisites
- Java 17 (Because we're not living in the stone age)
- Maven (Your build bestie)

### Getting Started
```bash
# Clone the repo
git clone https://github.com/MelvinNunes/moz-regional-api

# Navigate to project
cd moz-regional-api

# Build the magic
mvn clean install

# Launch 🚀
mvn spring-boot:run
```

## 📡 Endpoints

Once running, check out:
- Swagger UI: `http://localhost:8080/docs.html`
- API Docs: `http://localhost:8080/v1/docs`

## 🌈 Cool Features

- In-memory H2 Database (No database setup required!)
- Pre-seeded with country data
- Caching (Because we're all about that performance life)

## 🤓 Nerdy Details

- Initial data loaded via `country_data.sql`
- Uses Spring Cache for speedy responses
- OpenAPI 3.0 compliant documentation

## 🎉 Contributing

Got ideas? Pull requests are welcome! Just try not to break Mozambique in the process. 😄

## 📄 License

Probably MIT or Apache 2.0 - Check the LICENSE file.

**Disclaimer**: This API knows more about Mozambican geography than most geography teachers! 🌍🗺️