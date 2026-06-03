# Java Basics

A small Java 21 learning project that verifies my local Java toolchain and includes a command-line IPv4 subnet calculator.

This repository verifies that a Java 21 workflow works correctly with IntelliJ IDEA, Eclipse Temurin, Git and GitHub on my Intel Mac and Windows ThinkPad setup.

## Purpose

This is not intended to be a large Java application.

It is a compact baseline project for:

- verifying the local Java toolchain
- practicing Java fundamentals
- testing IntelliJ IDEA with Eclipse Temurin 21 LTS
- keeping IDE metadata and build output out of Git
- maintaining a clean Git/GitHub workflow for Java projects
- documenting small command-line Java exercises

Java is a foundational programming skill in my current learning path. My main focus remains data and process analysis, SQL, Python, BI and Microsoft-oriented data tooling.

## Tested Environment

The project is used across my current developer setup:

- iMac Retina 4K, 21.5-inch, Late 2015
- Intel x86_64
- macOS Sonoma via OpenCore Legacy Patcher
- Lenovo ThinkPad X1 Carbon Gen 9
- Windows 11 Enterprise
- IntelliJ IDEA via JetBrains Toolbox
- Eclipse Temurin 21 LTS
- Java 21
- Git / GitHub
- Claude Code as an optional project assistant in the terminal

This repository also documents that the Java 21 workflow works on a legacy Intel Mac setup and on a Windows ThinkPad used as a mirrored learning and development machine.

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

Local IntelliJ IDEA files, build output and local assistant notes are intentionally excluded from Git:

```text
.idea/
out/
*.iml
*.class
CLAUDE.md
```

## Source Files

| File | Purpose |
|---|---|
| `src/Main.java` | Minimal Java 21 toolchain check and simple entry point |
| `src/SubnetCalculator.java` | Command-line IPv4 subnet calculator with explicit input validation |

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

```powershell
javac -d out src/*.java
```

Run `Main`:

```powershell
java -cp out Main
```

Run the IPv4 subnet calculator:

```powershell
java -cp out SubnetCalculator 192.168.10.42/24
```

The same commands also work in zsh on macOS.

## IPv4 Subnet Calculator

`SubnetCalculator` accepts input in this format:

```text
IPv4/CIDR
```

Examples:

```text
192.168.10.42/24
10.0.0.5/30
0.0.0.0/0
255.255.255.255/32
```

The calculator prints:

- normalized subnet mask
- wildcard mask
- network address
- broadcast address
- total address count
- usable host count
- first usable host
- last usable host
- a short note for special CIDR cases

The input validation rejects common invalid forms, for example:

- missing CIDR prefix
- more than one `/` separator
- empty IPv4 octets
- non-decimal characters
- leading zeros in IPv4 octets
- octets outside `0-255`
- prefixes outside `0-32`

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

## Development Workflow

Before working on the repository:

```powershell
git status -sb
git pull --ff-only
```

After making changes:

```powershell
git status -sb
git diff
```

Only intentional source or documentation changes should be committed.

## Next Steps

Possible future additions:

- package structure for a more realistic Java layout
- basic Java class and object examples
- additional small command-line exercises
- simple file input/output examples
- a small CSV parser
- basic unit tests later on

## Notes

This repository is intentionally small.

Its purpose is to document and verify a clean Java 21 development setup before building larger Java exercises or tools.

No IDE metadata, build output or machine-specific files are committed.
