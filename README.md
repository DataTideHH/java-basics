# Java Basics

A small Java 21 setup and learning repository for my local developer environment.

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
│   ├── HelloWorld.java
│   └── Main.java
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

Open the project in IntelliJ IDEA and run `HelloWorld.main()` or `Main.main()`.

Expected output:

```text
Java 21 läuft sauber in IntelliJ.
```

## Run from Terminal

Compile the source files:

```zsh
javac -d out src/*.java
```

Run `HelloWorld`:

```zsh
java -cp out HelloWorld
```

## What This Demonstrates

This repository demonstrates a working Java 21 baseline setup using:

- Eclipse Temurin 21 LTS as the project JDK
- IntelliJ IDEA as the primary Java IDE
- a simple `src/` based project structure
- local build output excluded from Git
- Git and GitHub for version control

## Next Steps

Possible future additions:

- basic Java class and object examples
- small command-line exercises
- simple file input/output examples
- a small CSV parser
- basic unit tests later on

## Notes

This repository is intentionally small. Its purpose is to document and verify a clean Java 21 development setup before building larger Java exercises or tools.

No IDE metadata, build output, or machine-specific files are committed.
