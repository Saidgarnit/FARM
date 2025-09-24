# FARM Management System

## Project Description

FARM Management System is a comprehensive desktop application built with JavaFX for managing agricultural operations. The system provides tools for tracking production, managing employees, suppliers, and sales operations with an intuitive graphical user interface.

## Features

### Core Functionality
- **User Authentication**: Secure login/signup system for admin users
- **Production Management**: Track farm production with detailed records including:
  - Crop types and quantities
  - Pricing and dates
  - Employee assignments
  - Supplier information
- **Employee Management**: Manage farm workforce and track employee activities
- **Supplier Management**: Maintain supplier relationships and records
- **Sales Operations**: Handle sales transactions and tracking
- **Production Monitoring**: Daily production tracking and consumption monitoring
- **Dashboard**: Visual analytics with charts and real-time counters
- **Profile Management**: User profile and account management

### Technical Features
- **Secure Database Operations**: SQL injection prevention with parameterized queries
- **Connection Pooling**: Efficient database connection management
- **Input Validation**: Comprehensive form validation and sanitization
- **Error Handling**: User-friendly error messages and exception handling
- **Configuration Management**: Centralized configuration system

## Technology Stack

- **Frontend**: JavaFX 17 for desktop GUI
- **Backend**: Java 17
- **Database**: MySQL 8.0
- **Build Tool**: Maven 3.6+
- **Architecture**: Model-View-Controller (MVC) pattern

## Database Schema

The system uses three main tables:

### `admin` Table
- User authentication and profile information
- Fields: id, email, password, full_name, NTele, DateBird, Age, image_path

### `production` Table
- Production records and tracking
- Fields: id, metrage, Nom_de_race, Quantite, Qantite_Finale, Prix, Date_dentre, Nom_de_lemploye, nom_de_fournisseur, origine

### `suivi_production` Table
- Daily production monitoring
- Fields: id, quantite_par_jour, date, consomation, emploiyee

## Installation and Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher

### Database Setup
1. Install and start MySQL server
2. Create a database named `myprojectjavafx`
3. Import the provided SQL file:
   ```bash
   mysql -u root -p myprojectjavafx < myprojectjavafx.sql
   ```

### Application Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/Saidgarnit/FARM.git
   cd FARM
   ```

2. Configure database connection in `src/main/resources/config.properties`:
   ```properties
   db.url=jdbc:mysql://localhost:3306/myprojectjavafx
   db.username=root
   db.password=your_password
   ```

3. Build the project:
   ```bash
   mvn clean compile
   ```

4. Run the application:
   ```bash
   mvn javafx:run
   ```

## Configuration

The application uses a configuration file located at `src/main/resources/config.properties`. Key settings include:

- Database connection parameters
- Connection pool settings
- Application metadata
- Session timeout settings

## Security Features

### Implemented Security Measures
- **SQL Injection Prevention**: All database queries use parameterized statements
- **Input Sanitization**: User inputs are sanitized before processing
- **Password Security**: Secure password hashing with salt (for new implementations)
- **Connection Security**: Secure database connection management
- **Session Management**: Proper session handling and timeout

### Recommended Security Enhancements
- Implement password hashing for existing user accounts
- Add role-based access control (RBAC)
- Implement audit logging
- Add data encryption for sensitive information
- Enable HTTPS for any future web components

## Development

### Project Structure
```
src/
├── main/
│   ├── java/com/example/login/
│   │   ├── Controllers/          # UI Controllers
│   │   │   └── Farmer/          # Farm-specific controllers
│   │   ├── Models/              # Data models
│   │   ├── Views/               # View management
│   │   ├── ConfigManager.java   # Configuration management
│   │   ├── DatabaseManager.java # Database operations
│   │   ├── SecurityUtils.java   # Security utilities
│   │   └── App.java            # Main application class
│   └── resources/
│       ├── Fxml/                # FXML layout files
│       ├── Images/              # Application images
│       ├── Styles/              # CSS stylesheets
│       └── config.properties    # Configuration file
```

### Code Quality Guidelines
- Follow Java naming conventions
- Use parameterized queries for database operations
- Implement proper exception handling
- Add input validation for all user inputs
- Use the provided utility classes for security operations

## Testing

### Running Tests
```bash
mvn test
```

### Manual Testing
1. Start the application
2. Test user authentication
3. Verify CRUD operations for production records
4. Test search and filtering functionality
5. Validate input validation and error handling

## Recent Improvements

### Build and Configuration
- ✅ Fixed Maven build configuration (Java 17 compatibility)
- ✅ Removed duplicate JavaFX dependencies
- ✅ Added proper MySQL connector dependency
- ✅ Updated to stable JavaFX versions
- ✅ Added configuration management system

### Security Enhancements
- ✅ Fixed SQL injection vulnerabilities
- ✅ Added input validation and sanitization
- ✅ Implemented proper database connection pooling
- ✅ Added comprehensive error handling
- ✅ Created security utilities for password management

### Code Quality
- ✅ Improved database connection management
- ✅ Added proper resource cleanup
- ✅ Enhanced user feedback with alerts
- ✅ Implemented validation for user inputs
- ✅ Added confirmation dialogs for destructive operations

## Future Enhancements

### Planned Features
- [ ] Implement proper password hashing for existing accounts
- [ ] Add role-based access control
- [ ] Create comprehensive unit tests
- [ ] Add internationalization support
- [ ] Implement data export/import functionality
- [ ] Add reporting and analytics features
- [ ] Create mobile-responsive web interface
- [ ] Implement real-time notifications

### Technical Improvements
- [ ] Add logging framework (SLF4J + Logback)
- [ ] Implement dependency injection
- [ ] Add caching mechanisms
- [ ] Create REST API endpoints
- [ ] Add automated testing pipeline
- [ ] Implement continuous integration/deployment

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support and questions, please:
1. Check the documentation above
2. Search existing issues on GitHub
3. Create a new issue with detailed information about your problem

## Authors

- **Said** - Initial work and development
- **Contributors** - See GitHub contributors list

## Acknowledgments

- JavaFX community for excellent desktop application framework
- MySQL team for robust database system
- Maven community for build automation tools