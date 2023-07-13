# Miranum Connect Basic Template

Simplified, beginner-friendly GitHub template for initiating new projects with Miranum. This template is focused on the key features of Miranum Connect - Worker creation, Message correlation, and Process start.

## Features

This template provides the following features:

- **Worker Creation**: Implement the `doSomething` method in the `MyWorker` class to perform actions on received commands.
- **Message Correlation**: Implement the `correlateMessage` method in the `MyMessageCorrelation` class to correlate messages with process instances.
- **Process Start**: Implement the `startProcess` method in the `MyProcessStart` class to initiate a process instance.

## Prerequisites

Before using this template, make sure you have a running instance of Camunda Platform 7 or Camunda Platform 8 set up.
This template includes the necessary dependencies for both versions of Camunda. To switch between Camunda Platform 7
and Camunda Platform 8, you can update the application.yaml file as described below.

## Getting Started

To use this template, follow these steps:

1. Clone or download this repository to your local machine.
2. Update the necessary resources to match the name and description of your project:
    - [README](./README.md) (title, description)
    - [POM](./pom.xml) (artifact name, id, description)
    - [Worker](src/main/java/io/miragon/example/MyWorker.java) (rename, implement)
    - [Message Correlation](src/main/java/io/miragon/example/MyMessageCorrelation.java) (rename, implement)
    - [Process Start](src/main/java/io/miragon/example/MyProcessStart.java) (rename, implement)
3. Ensure that you have a running instance of Camunda Platform 7 or Camunda Platform 8.
4. Build the project using the following command:

   ```bash
   mvn clean package
   ```

5. Run the project by executing the generated JAR file.
6. Interact with the project's features, such as creating workers, correlating messages, and starting processes.
 
## Run Tests
To run the tests for this project, execute the following command:

```bash
mvn clean test
```
This command will execute all the unit tests in the project and provide the test results.


## Configuration

The project's configuration is defined in the `application.yaml` file. By default, the configuration is set up for
Camunda Platform 7. If you want to switch to Camunda Platform 8, you can uncomment the relevant properties in the
`application.yaml` file and comment out the Camunda Platform 7 configuration. 
Additionally, you have to uncomment the Miranum Connect dependency for Camunda Platform 8 in the `pom.xml` file.

## Documentation

For more detailed information and advanced usage of Miranum Connect, please refer to the [Miranum Documentation](https://miranum.com/).

To see an example of Miranum Connect in action, you can visit the
[Miranum Connect GitHub Repository](https://github.com/Miragon/miranum-connect) or the
[Miranum Consulting Repository](https://github.com/Miragon/miranum-consulting) and explore the provided examples.

## Contributions

Contributions to this GitHub template are welcome! If you have any improvements or new features to suggest, please create a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

---

For more information on Miranum and its features, please visit the [Miranum Documentation](https://miranum.com/).