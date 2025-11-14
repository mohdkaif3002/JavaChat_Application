# Mohd's MultiUser Chat Application

A robust multi-user chat application built in Java, featuring public, private, and group messaging capabilities with an enhanced graphical user interface.

JavaChatBot is a small, classic Java socket-based chat application composed of a server and a client. It demonstrates a simple multi-client chat server and a GUI/text client built with plain Java (no external frameworks). The project includes compiled class files and source files for both server and client.

## Contents

- `ChatServer/` - Server implementation and source files.
   - `src/` - Java source (`*.java`) and compiled class files (`*.class`).
- `ChatClient/` - Client implementation and source files.
   - `src/` - Java source (`*.java`) and compiled class files (`*.class`).
- `index.html` - (optional) project landing page.

## Prerequisites

- Java JDK 8 or newer installed and `javac`/`java` available on your PATH.
- Basic familiarity with running Java programs from the command line.

## Quick build & run (command line)

This repository includes compiled `.class` files, but if you want to recompile the source follow these steps.

1. Build the server

    Open a terminal, go to the server source directory and compile all .java files:

    ```powershell
    cd ChatServer/src
    javac -d ../out *.java
    ```

    Run the server (the main class is either `ChatServer` or `Server` depending on which file contains `public static void main`):

    ```powershell
    cd ..\out
    java ChatServer
    # or
    java Server
    ```

2. Build the client

    In a new terminal, compile the client source:

    ```powershell
    cd ChatClient/src
    javac -d ../out *.java
    ```

    Run the client (the main class is typically `ChatClient` or `Client`):

    ```powershell
    cd ..\out
    java ChatClient
    # or
    java Client
    ```

Notes:
- If you get "Could not find or load main class" when running, check which class contains `public static void main(String[] args)` and run that class name instead.
- The code uses plain sockets; the server listens on a port (check the server source for the default port). If the server and client run on the same machine, use `localhost` or `127.0.0.1`.

## Project structure

High-level view:

```
ChatServer/
   src/        # server .java and .class files
ChatClient/
   src/        # client .java and .class files
index.html
README.md
```

## Development notes

- This is intended as an educational example — minimal error handling, no authentication, and plain-text messaging.
- You can modernize the project by:
   - Converting to a build tool (Maven/Gradle)
   - Adding unit tests and CI
   - Migrating to NIO or adding SSL/TLS for transport security

## License & Attribution

Feel free to use and modify this code for learning and non-commercial projects. Add a license file if you need a specific license.

## Contact

If you want help improving or packaging this project, open an issue or contact the repository owner.

---
Updated README to include build/run instructions and structure.

- **Public Chatting**: Broadcast messages to all connected users
- **Private Messaging**: Send direct messages using `@username message`
- **Group Messaging**: Send messages to multiple users using `@user1 user2 ...#message`
- **File Sharing**: Share text files with other users
- **Online Users List**: View and manage connected users
- **Enhanced GUI**: Modern layout with colors, fonts, and dedicated panels
- **Real-time Communication**: Instant message delivery with timestamps

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Basic understanding of running Java applications

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/mohdkaif3002/JavaChat_Application.git
   cd JavaChat_Application
   ```

2. Compile the server:
   ```bash
   cd ChatServer/src
   javac Server.java
   ```

3. Compile the client:
   ```bash
   cd ../../ChatClient/src
   javac ChatClient.java
   ```

## Usage

### Running the Server

1. Navigate to the server directory:
   ```bash
   cd ChatServer/src
   ```

2. Run the server:
   ```bash
   java Server
   ```

3. Enter the desired port number (e.g., 9000) when prompted.

### Running the Client

1. Open a new terminal and navigate to the client directory:
   ```bash
   cd ChatClient/src
   ```

2. Run the client:
   ```bash
   java ChatClient
   ```

3. Enter the server IP address (default: 127.0.0.1) and port number.

4. Enter your username and password (default password: 123).

## How to Use

- **Send Messages**: Type your message and click "Send" or press Enter
- **Private Messages**: Use `@username message` format
- **Group Messages**: Use `@user1 user2 ...#message` format
- **View Online Users**: Click "List Users" button
- **Send Files**: Click "Send File" and select a text file
- **Quit**: Type "QUIT" in the message field

## Screenshots

*Enhanced GUI with modern layout and user panel.*

## Technical Details

- **Maximum Connections**: 10 clients (configurable in Server.java)
- **Authentication**: Simple username/password system
- **Networking**: Socket-based communication
- **GUI Framework**: Java Swing

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is open source and available under the [MIT License](LICENSE).

## Author

**Mohd Kaif** - Customized and enhanced version

Original concept by Mohammad Kaif

## Acknowledgments

- Inspired by basic Java networking tutorials
- Enhanced with modern GUI practices
