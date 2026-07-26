# Java Basics — Historical Baseline

> **Archived learning snapshot.** Active development of the IPv4 subnet calculator has moved to [IPv4 Subnet Calculator Multilang](https://datatidehh.github.io/ipv4-subnet-calculator-multilang/).

This repository is retained as a historical record of the initial Java 21 toolchain setup and the first standalone Java version of the calculator.

## Why this repository is archived

The calculator was consolidated into one stronger portfolio repository that now provides:

- aligned Java 21, C++20 and Python 3.12 implementations
- one normative behavior specification
- interactive, direct and help modes
- shared fachliche contract cases
- language-specific tests
- GitHub Actions
- a dedicated project page

Keeping the original copy active would duplicate the same small application and weaken the portfolio structure.

## Preserved historical scope

This snapshot documents:

- Java 21 with Eclipse Temurin
- IntelliJ IDEA workflow
- a minimal `src/` project layout
- record-based result data
- IPv4/CIDR parsing and validation
- bitwise subnet calculation
- local Java build output excluded from Git
- cross-platform learning use on an Intel iMac and Windows ThinkPad

## Historical commands

Compile:

```text
javac -d out src/*.java
```

Run the calculator:

```text
java -cp out SubnetCalculator 192.168.10.42/24
```

## Canonical successor

Use the maintained project for current code, tests and documentation:

- Project page: https://datatidehh.github.io/ipv4-subnet-calculator-multilang/
- Repository: https://github.com/DataTideHH/ipv4-subnet-calculator-multilang

## Status

Historical snapshot. No further feature development is planned in this repository.
