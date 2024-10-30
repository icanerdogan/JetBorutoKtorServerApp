# JetBoruto Ktor Server App

JetBorutoKtorServerApp is a server-side Kotlin application that leverages the Ktor framework to provide RESTful APIs for Boruto, a sample project. The application includes routes to manage data related to Boruto characters and offers endpoints to facilitate CRUD operations on the server.


Dark - Home            |  Dark - Detail Collapsed |  Dark - Detail Expanded |  Dark - Search
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------: 
![jetboruto-dark-1](https://github.com/user-attachments/assets/288710eb-98aa-456d-9bb0-ce4bb184b310) | ![jetboruto-dark-2](https://github.com/user-attachments/assets/e6246325-2b57-46cc-9ecb-fa868143133a) | ![jetboruto-dark-3](https://github.com/user-attachments/assets/2d0fb3e9-5733-476e-9326-ba27d072d7af) | ![jetboruto-dark-4](https://github.com/user-attachments/assets/a3305a1d-3867-4daf-a763-f9469cc91578)

Light - Home            |  Light - Detail Collapsed |  Light - Detail Expanded |  Light - Search
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------: 
![jetboruto-light-1](https://github.com/user-attachments/assets/878cc5ab-ae6b-407e-bff9-eb6b6f192e47) | ![jetboruto-light-2](https://github.com/user-attachments/assets/8f0f636b-4cc9-477e-a95e-acb09cee00b1) | ![jetboruto-light-3](https://github.com/user-attachments/assets/7b54c3dc-dd16-4703-a355-f4aa9bca5d1e) | ![jetboruto-light-4](https://github.com/user-attachments/assets/f36c17ef-d07d-4b1d-9216-762c12e6dd53)


## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features

- **RESTful API:** Provides easy-to-use endpoints for CRUD operations on Boruto character data.
- **Data Storage:** Supports data persistence and retrieval.
- **Ktor Framework:** Uses Ktor for asynchronous server capabilities.
- **Dependency Injection:** Implemented with Koin for scalable dependency management.
- **Exception Handling:** Includes error handling and responses for invalid requests.
- **Unit Tests:** Tests for core functionalities to ensure reliable operations.

## Technologies

- **Kotlin** - Primary programming language
- **Ktor** - Server framework for Kotlin
- **Koin** - Dependency injection framework for Kotlin
- **Exposed** - SQL library for data access
- **SQLite** - Database for local data persistence
- **JUnit** - Testing framework for unit tests

## Installation

To set up and run the JetBorutoKtorServerApp locally, follow these steps:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/icanerdogan/JetBorutoKtorServerApp.git
   ```
   
2. **Navigate to the project directory:**
   ```bash
   cd JetBorutoKtorServerApp
   ```
   
3. **Build the project:**
   ```bash
   ./gradlew build
   ```

4. **Run the server:**
   ```bash
   ./gradlew run
   ```

The server will start running at `http://localhost:8080`.

## Usage

Once the server is running, you can access the API through HTTP requests using tools like `curl`, `Postman`, or directly through your application.

## API Endpoints

| Method | Endpoint            | Description                      |
|--------|----------------------|----------------------------------|
| GET    | `/characters`       | Fetches a list of all characters |
| GET    | `/characters/{id}`  | Fetches a character by ID        |
| POST   | `/characters`       | Adds a new character             |
| PUT    | `/characters/{id}`  | Updates an existing character    |
| DELETE | `/characters/{id}`  | Deletes a character by ID        |

Each endpoint returns a JSON response containing the status and data or an error message.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch: `git checkout -b feature-name`.
3. Make your changes and commit them: `git commit -m 'Add some feature'`.
4. Push the branch: `git push origin feature-name`.
5. Open a pull request.

## License

This project is open-source and available under the MIT License. See the `LICENSE` file for more details.


