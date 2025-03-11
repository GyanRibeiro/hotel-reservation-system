# Eclipse Hotel - API de Reservas

O Eclipse Hotel é uma **API REST** para gerenciamento de reservas em hotéis, permitindo operações de CRUD para clientes, quartos e reservas. Desenvolvido com Spring Boot, JPA/Hibernate e PostgreSQL, ele facilita a administração e consulta de informações sobre hospedagens

---

## 📋 Requisitos

- Java 8 ou superior
- Maven
- PostgreSQL (ou H2 para desenvolvimento local)
- Spring Boot
- JPA/Hibernate

---

## 🚀 Como Executar o Projeto

### 1️⃣ Clone o Repositório

```bash
git clone git@github.com:GyanRibeiro/hotel-reservation-system.git
cd hotel-reservation-system
```

### 2️⃣ Configure o Banco de Dados

#### PostgreSQL (Produção)
1. Crie um banco de dados chamado `hotel` no PostgreSQL.
2. Configure o arquivo `application.properties` com as credenciais do seu banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hotel
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

#### H2 (Banco em Memória - Desenvolvimento)
Para desenvolvimento local, configure o `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:hotel
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

### 3️⃣ Execute o Projeto

```bash
mvn spring-boot:run
```
O projeto estará disponível em: [http://localhost:8080](http://localhost:8080).

---

## 🛠️ Endpoints Disponíveis

### **Clientes (`/customers`)**
- `GET /customers` → Lista todos os clientes.
- `GET /customers/{id}` → Retorna um cliente específico pelo ID.
- `POST /customers` → Cria um novo cliente.
- `PUT /customers/{id}` → Atualiza um cliente existente.
- `DELETE /customers/{id}` → Remove um cliente.

### **Quartos (`/rooms`)**
- `GET /rooms` → Lista todos os quartos.
- `GET /rooms/{id}` → Retorna um quarto específico pelo ID.
- `POST /rooms` → Cria um novo quarto.
- `PUT /rooms/{id}` → Atualiza um quarto existente.
- `DELETE /rooms/{id}` → Remove um quarto.

### **Reservas (`/reservations`)**
- `POST /reservations` → Cria uma nova reserva.
  - Parâmetros:
    - `customerId`: ID do cliente.
    - `roomId`: ID do quarto.
    - `checkInDate`: Data de check-in (formato `yyyy-MM-dd`).
    - `checkOutDate`: Data de check-out (formato `yyyy-MM-dd`).
- `PUT /reservations/{id}/finish` → Finaliza uma reserva.
- `GET /reservations/by-date-range` → Retorna todas as reservas dentro de um intervalo de datas.
  - Parâmetros:
    - `startDate`: Data inicial (`yyyy-MM-dd`).
    - `endDate`: Data final (`yyyy-MM-dd`).
- `GET /reservations/occupied-rooms` → Retorna todos os quartos ocupados no momento.

---

## 📊 Exemplos de Requisições

### Criar um Cliente (`POST /customers`)
```json
{
    "name": "João Silva",
    "email": "joao@example.com",
    "phone": "11999999999"
}
```

### Criar um Quarto (`POST /rooms`)
```json
{
    "number": "101",
    "type": "Standard",
    "price": 200.0
}
```

### Criar uma Reserva (`POST /reservations`)
```json
{
    "customerId": 1,
    "roomId": 1,
    "checkInDate": "2023-10-15",
    "checkOutDate": "2023-10-20"
}
```

---
