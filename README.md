# JavaChatApp

JavaChatApp (a.k.a. JavaChatBot) is a small, classic Java socket-based chat application composed of a server and a client. It demonstrates a simple multi-client chat server and a GUI/text client built with plain Java (no external frameworks). The project includes source and compiled class files for both server and client.

## Highlights

- Public, private, and group messaging examples
- Simple file-sharing support (text files)
- GUI client built with Java Swing and a console-mode server

## Contents

- `ChatServer/` - Server implementation and source files.
	- `src/` - Java source (`*.java`) and compiled class files (`*.class`).
- `ChatClient/` - Client implementation and source files.
	- `src/` - Java source (`*.java`) and compiled class files (`*.class`).
- `index.html` - (optional) project landing page.
- `README.md` - this file.

## Prerequisites

- Java JDK 8 or newer installed and `javac`/`java` available on your PATH.

## Quick build & run (command line)

This repository includes compiled `.class` files, but if you want to recompile the source follow these steps.

1) Build and run the server

	 ```powershell
	 cd ChatServer/src
	 javac -d ../out *.java
	 cd ../out
	 java Server
	 ```

	 The server will prompt for a port; use `9000` or any available port.

2) Build and run the client (in a separate terminal)

	 ```powershell
	 cd ChatClient/src
	 javac -d ../out *.java
	 cd ../out
	 java ChatClient
	 ```

	 When prompted enter the server host (use `127.0.0.1` for local runs) and the port.

Notes:
- If you get "Could not find or load main class" when running, check which class contains `public static void main(String[] args)` and run that class name instead.
- The server and client use plain sockets; there's no authentication or encryption.

## Project structure (high level)

```
ChatServer/
	src/        # server .java and .class files
ChatClient/
	src/        # client .java and .class files
index.html
README.md
```

## Development notes

- Educational example: minimal error handling and security.
- To improve the project consider:
	- Adding a build tool (Maven/Gradle)
	- Adding unit tests and CI
	- Migrating to NIO or adding TLS for secure transport

## License

This repository does not contain a LICENSE file by default. If you plan to publish or reuse this code, add an appropriate license (for example MIT).

## Contact

If you want help improving or packaging this project, open an issue or contact the repository owner.

---
Merged README content from local and remote during merge.
