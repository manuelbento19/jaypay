# JayPay - A Simple Wallet System
JayPay é um sistema de carteira digital simples desenvolvido com Java e o framework Spring. Ele oferece uma API para gerenciar saldos de usuários, realizar transferências e consultar transações de forma prática e eficiente, utilizando PostgreSQL como banco de dados.

## Funcionalidades
- **Gerenciamento de usuários**: Criação de contas e consulta de saldos.
- **Transferências**: Realização de transferências entre usuários.
- **Histórico de transações**: Visualização do histórico de transações realizadas pelos usuários.
- **Segurança**: Autenticação e autorização via JWT.

## Tecnologias utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL** 
- **Spring Security**
- **JUnit e Mockito**

## Como rodar o projeto
1. **Clone o repositório:**
    ```bash
    git clone https://github.com/manuelbento19/jaypay.git
    cd jaypay
    ```

2. **Compile e execute o projeto usando o Maven:**
    ```bash
    ./mvnw spring-boot:run
    ```
    - O servidor será iniciado em `http://localhost:8080`.

3. **Testes**
    ```bash
    ./mvnw test
    ```
## Contribuindo
1. Faça o **fork** do repositório.
2. Crie uma nova **branch** (`git checkout -b feature/nova-feature`).
3. Realize suas alterações e faça **commit** (`git commit -am 'feat: nova feature'`).
4. Faça o **push** para sua branch (`git push origin feature/nova-feature`).
5. Abra um **Pull Request**.

## Licença
Este projeto está licenciado sob a [MIT License](LICENSE).
