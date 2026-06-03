# Java Basics

A small Java 21 learning project that verifies my local Java toolchain and includes a command-line IPv4 subnet calculator.

This repository verifies that a Java 21 workflow works correctly with IntelliJ IDEA, Eclipse Temurin, Git, and GitHub on my Intel Mac setup.

## Purpose

This is not intended to be a large Java application. It is a compact baseline project for:

- verifying the local Java toolchain
- practicing Java fundamentals
- testing IntelliJ IDEA with Eclipse Temurin 21 LTS
- keeping IDE metadata and build output out of Git
- maintaining a clean Git/GitHub workflow for Java projects

Java is a foundational programming skill in my current learning path. My main focus is data and process analysis, SQL, Python, BI, and Microsoft-oriented data tooling.

## Tested Environment

- iMac Retina 4K, 21.5-inch, Late 2015
- Intel x86_64
- macOS Sonoma 14.8.7 via OpenCore Legacy Patcher
- IntelliJ IDEA via JetBrains Toolbox
- Eclipse Temurin 21 LTS
- Java 21
- Git / GitHub

This repository also documents that the Java 21 workflow works on a legacy Intel Mac setup used as a stable learning and development machine.

## Repository Structure

```text
java-basics/
├── src/
│   ├── Main.java
│   └── SubnetCalculator.java
├── .gitignore
├── LICENSE
└── README.md
```

Local IntelliJ IDEA files and build output are intentionally excluded from Git:

```text
.idea/
out/
*.iml
```

## Run in IntelliJ IDEA

Open the project in IntelliJ IDEA and run one of the following entry points:

- `Main.main()`
- `SubnetCalculator.main()`

For `SubnetCalculator.main()`, use the following program argument:

```text
192.168.10.42/24
```

Expected output:

```text
Input IP:          192.168.10.42
CIDR prefix:       /24
Subnet mask:       255.255.255.0
Wildcard mask:     0.0.0.255
Network address:   192.168.10.0
Broadcast address: 192.168.10.255
Total addresses:   256
Usable hosts:      254
First usable host: 192.168.10.1
Last usable host:  192.168.10.254
Note:              Standard subnet with network and broadcast addresses excluded.
```

## Run from Terminal

Compile the source files:

```zsh
javac -d out src/*.java
```

Run `Main`:

```zsh
java -cp out Main
```

Run the IPv4 subnet calculator:

```zsh
java -cp out SubnetCalculator 192.168.10.42/24
```

Expected output:

```text
Input IP:          192.168.10.42
CIDR prefix:       /24
Subnet mask:       255.255.255.0
Wildcard mask:     0.0.0.255
Network address:   192.168.10.0
Broadcast address: 192.168.10.255
Total addresses:   256
Usable hosts:      254
First usable host: 192.168.10.1
Last usable host:  192.168.10.254
Note:              Standard subnet with network and broadcast addresses excluded.
```

## What This Demonstrates

This repository demonstrates a working Java 21 baseline setup using:

- Eclipse Temurin 21 LTS as the project JDK
- IntelliJ IDEA as the primary Java IDE
- a simple `src/` based project structure
- a small command-line IPv4 subnet calculator
- Java records for structured result data
- IPv4 parsing and validation
- CIDR prefix handling
- subnet mask and wildcard mask calculation
- network and broadcast address calculation
- basic bitwise operations in Java
- local build output excluded from Git
- Git and GitHub for version control

## Next Steps

Possible future additions:

- basic Java class and object examples
- additional small command-line exercises
- simple file input/output examples
- a small CSV parser
- basic unit tests later on

## Notes

This repository is intentionally small. Its purpose is to document and verify a clean Java 21 development setup before building larger Java exercises or tools.

No IDE metadata, build output, or machine-specific files are committed.
