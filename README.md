📋 Task Manager API

A Spring Boot REST API for managing tasks with CRUD operations and status-based filtering.

🚀 Features

- CRUD operations for tasks
- Filter tasks by status (PENDING, COMPLETED)
- ENUM usage for data consistency
- Validation and Exception Handling

🛠️ Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- REST API

📌 API Endpoints

| Method | Endpoint | Description |
|--------|--------- |------------|
| POST   | /tasks   | Create task |
| GET    | /tasks   | Get all tasks |
| GET    | /tasks/{id} | Get task by ID |
| PUT    | /tasks/{id} | Update task |
| DELETE | /tasks/{id} | Delete task |
| GET    | /tasks/status/{status} | Filter tasks |

 ⚙️ How to Run

1. Clone the repository
2. Open in IntelliJ
3. Run the application
4. Test using Postman

📷 Output

- API tested using Postman
- Supports status filtering

📈 Future Improvements

- Pagination & Sorting
- JWT Authentication
- Frontend integration

