# Quotes Application

The Quotes Application is a simple Java program that displays random popular book quotes. The application reads quotes from a JSON file and uses GSON to parse the content. When the application is run, it selects a random quote and displays the quote and author.

To understand the design and implementation process of this application, please refer to the [whiteboard explanation](resources%2Flab8wb_1.jpg)
## 
Application Overview

The application consists of the following main components:

1. `Quote` class: Represents a quote object with the author and text properties.
2. `QuotesReader` class: Handles reading and parsing the JSON file using GSON, and getting random quotes.
3. `App` class: Uses the `QuotesReader` class to display the quote and author when run.

The `App` class uses the `QuotesReader` class to get a random quote and display it. The `QuotesReader` class reads and parses the JSON file to create a list of `Quote` objects. The `Quote` class represents the quote with its author and text properties.

## Getting Started

These instructions will help you get the project up and running on your local machine for development and testing purposes.

### Prerequisites

Make sure you have the following software installed:

- Java JDK 8 or later
- Gradle

### Installing

1. Clone the repository:

    ```git
    git clone https://github.com/AlexBCarr/quotes
    cd quotes
    ```

2. Build the project:

`$ gradle build`

## Running the Application

After building the project, you can run the application using the following command:

`$ gradle run`

The application will display a random quote and its author.

## Running the Tests

To run the tests for the application, use the following command:

`$ gradle test`


## Built With

- [Java](https://www.oracle.com/java/) - The programming language used
- [Gradle](https://gradle.org/) - Build tool and dependency management
- [GSON](https://github.com/google/gson) - JSON library to parse JSON data

## Authors

- Cameron Griffin - [CodrCam](https://github.com/CodrCam)

- Alex Carr - [AlexBCarr](https://github.com/AlexBCarr)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
