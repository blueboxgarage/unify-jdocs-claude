#!/bin/bash

# Script to compile and run the JDocs tests

# Check for Java installation
if ! [ -x "$(command -v java)" ]; then
  echo "Error: Java is not installed or not in the PATH."
  echo "Please install Java 21 or higher and try again."
  exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
echo "Java version: $JAVA_VERSION"

# Check for Maven installation
if ! [ -x "$(command -v mvn)" ]; then
  echo "Error: Maven is not installed or not in the PATH."
  echo "Please install Maven and try again."
  exit 1
fi

# Print Maven version
echo "Maven version: $(mvn --version | head -n 1)"

# Compile the project
echo "Compiling project..."
mvn clean compile

if [ $? -ne 0 ]; then
  echo "Compilation failed. Please check the error messages above."
  exit 1
fi

# Run the tests
echo "Running tests..."
mvn test

if [ $? -ne 0 ]; then
  echo "Tests failed. Please check the error messages above."
  exit 1
else
  echo "All tests passed successfully!"
fi

# Build the package
echo "Building package..."
mvn package -DskipTests

if [ $? -ne 0 ]; then
  echo "Package build failed. Please check the error messages above."
  exit 1
else
  echo "Package built successfully!"
  echo "The JAR file can be found in the target directory."
fi

echo "Done!"