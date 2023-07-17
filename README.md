# Miranum Connect Hexagonal Template

GitHub template for initiating new projects with Miranum Connect, following the Hexagonal Architecture approach.
This template builds upon the Miranum Connect Basic Template and incorporates the recommended hexagonal architecture
design pattern.

The Hexagonal Architecture promotes a modular and flexible structure, enabling better separation of concerns and
improved testability. It emphasizes the core domain logic, with ports and adapters facilitating interactions with
external systems.

For a detailed introduction to the Hexagonal Architecture and its advantages compared to the traditional layered
approach, refer to the [Miranum Documentation](https://miranum.com/docs/guides/best-practices/hexagonal-architecture).

## Features

This template inherits the key features of the Miranum Connect Basic Template and adds the following:

- **Hexagonal Architecture**: Implements the hexagonal architecture design pattern for better modularity and testability.
- **Worker Creation**: Implement the `doSomething` method in the `MyWorker` class to perform actions on received commands.
- **Message Correlation**: Implement the `correlateMessage` method in the `MyMessageCorrelation` class to correlate messages with process instances.
- **Process Start**: Implement the `startProcess` method in the `MyProcessStart` class to initiate a process instance.

## Prerequisites

To run the engine-specific applications (`example-camunda7` and `example-camunda8`), you need to have a running
instance of Camunda Platform 7 or Camunda Platform 8 set up. This template includes the necessary dependencies for both
versions of Camunda.

## Getting Started

To use this template, follow these steps:

1. Clone or download this repository to your local machine.
2. Update the necessary resources to match the name and description of your project:
   - [README](./README.md) (title, description)
   - [POM](./pom.xml) (artifact name, id, description)
   - [Application Core](example/example-core/src/main/java/io/miragon/example/application) (implement)
      - [Worker](example/example-core/src/main/java/io/miragon/example/adapter/in/miranum/MiranumWorkerAdapter.java)
      - [Message Correlation](example/example-core/src/main/java/io/miragon/example/adapter/out/miranum/MiranumMessageAdapter.java)
      - [Process Start](example/example-core/src/main/java/io/miragon/example/adapter/out/miranum/MiranumInitiateProcessStartAdapter.java)
   - [Engine-specific Applications](example/example-camunda7) (rename)
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