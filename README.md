
# MedBook

## Project Description
MedBook is a medical record management system designed to streamline the storage, retrieval, and management of patient medical records. This project aims to provide an efficient platform for handling medical data.

## Installation
To set up the MedBook project on your local machine, follow these steps:

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven
- MySQL or any other preferred SQL database

### Steps
1. Clone the repository:
   ```bash
   git clone <repository_url>
   ```
2. Navigate to the project directory:
   ```bash
   cd medbook
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Usage
After building the project, you can run the application using the following command:
```bash
mvn tomcat7:run
```

### Accessing the Application
Once the application is running, you can access it at `http://localhost:8080`.

## Database Setup
1. Create a new database in your SQL server.
2. Import the database schema provided in `medbook_db.sql`:
   ```bash
   mysql -u username -p medbook_db < medbook_db.sql
   ```
3. Update the database connection properties in `src/main/resources/application.properties` to match your database configuration.

## Contributing
We welcome contributions to improve MedBook. To contribute, follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bugfix:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Description of your changes"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-name
   ```
5. Create a pull request on GitHub.

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.
