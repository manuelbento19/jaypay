# JayPay - A Simple Wallet System
JayPay is a simple digital wallet system developed with Java and the Spring framework. It offers an API to manage user balances, make transfers and query transactions in a practical and efficient way, using PostgreSQL as the database.

## Features
- **User management**: Creating accounts and checking balances.
- **Transfers**: Carrying out transfers between users.
- **Transaction history**: View the history of transactions carried out by users.
- **Security**: Authentication and authorization via JWT.

## Technologies
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Spring Security**
- **JUnit and Mockito**

## How to run
1. **Clone the repository:**
 ```bash
 git clone https://github.com/manuelbento19/jaypay.git
 jaypay cd
 ```

2. **Compile and run the project using Maven:**
 ```bash
 ./mvnw spring-boot:run
 ```
- The server will be started at `http://localhost:8080`.

3. **Tests**
    ```bash
    ./mvnw test
    ```

## Contributing
1. Fork the repository.
2. Create a new **branch** (`git checkout -b feature/nova-feature`).
3. Make your changes and do **commit** (`git commit -am 'feat: new feature'`).
4. **push** to your branch (`git push origin feature/nova-feature`).
5. Open a **Pull Request**.

## License
This project is licensed under the [MIT License](LICENSE).