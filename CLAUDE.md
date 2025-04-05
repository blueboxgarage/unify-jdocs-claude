# Unify-JDocs: Development Guide for AI Tools

## Build & Test Commands
```bash
# Build project
mvn clean install

# Run all tests 
mvn test

# Run single test class
mvn test -Dtest=DocumentTest

# Run single test method
mvn test -Dtest=DocumentTest#testMethodName
```

## Code Style Guidelines
- **Naming**: PascalCase for classes, camelCase for methods/variables, UPPER_SNAKE_CASE for constants
- **Formatting**: 2-space indentation, braces on same line as declaration
- **Imports**: Group by package, no wildcard imports
- **Documentation**: Javadoc for public classes/methods
- **Error Handling**: Use UnifyException with error codes from ERRORS_* classes
- **Testing**: JUnit 5 with descriptive method names, use appropriate assertions

This project is a JSON manipulation library that works directly with JSON documents without requiring POJO classes.