# Corporate Talent Hub - AI Agent Guide

## Project Overview
Corporate Talent Hub is a **Java 21 Maven-based HR management system** split across two modules (`corporate-talent-hub` and `hu1`). It demonstrates modern Java features (records, switch expressions, text blocks) while building employee and salary management functionality. The project is organized by "user stories" (historia_user_X) representing different feature domains.

## Architecture & Key Components

### Core Package Structure
```
org.riwi/
├── models/                    # Data models and utilities
│   ├── Company (record)       # Company metadata (immutable)
│   ├── Employee              # Employee data with demo values
│   ├── Salary                # Salary calculations and bonuses
│   └── Dinamy_storage        # Placeholder for future storage
└── user_history_4/           # Employee reporting features
    ├── Employees             # Employee wrapper class
    ├── DesempeñoReport       # Performance reports (record with validation)
    └── Persona               # Additional persona model
```

### Critical Design Patterns

1. **Records for Immutability**: `Company` and `DesempeñoReport` use Java records. Understand that:
   - Records auto-generate constructors, getters (name(), nit()), equals(), hashCode(), toString()
   - `DesempeñoReport` includes a compact constructor for validating performance scores (0-5 range)
   - New models should use records unless mutability is explicitly needed

2. **Menu-Driven CLI**: `Menu.java` is the primary entry point showcasing:
   - Switch expressions (Java 17+) over traditional switch
   - Ternary operators for logic (`salary > 3000000 ? "high" : ...`)
   - Exception handling for Scanner input validation
   - 2D arrays for quarterly grade analysis

3. **Salary Calculations**: `Salary` class applies business rules:
   - Base formula: `(baseSalary + monthlyBonus * 1.10) - (baseSalary * 0.05)` (5% deduction)
   - Bonus eligibility tied to even employee IDs
   - Complex validation combining multiple conditions with AND/OR

## Developer Workflows

### Build & Compile
```bash
# Maven compile (Java 21 target)
mvn clean compile

# Run main application
mvn exec:java -Dexec.mainClass="org.riwi.Main"

# Package to JAR
mvn package
```

### File Organization Notes
- Compiled classes in `target/classes/` (auto-generated)
- Project structure is split: primary logic in `corporate-talent-hub/`, alternative module in `hu1/`
- Both modules are independent—maintain separate dependency chains

## Project-Specific Conventions

### Naming Conventions
- **Spanish naming**: Methods use Spanish (e.g., `motrarInfo()`, `actualizarBono()`, `DesempeñoReport`)
- **Type safety**: Explicit primitive types chosen for memory efficiency:
  - `long` for large budgets (900000000L)
  - `short` for zip codes (12345)
  - `byte` for ages
  - `float` for standard salary values

### Code Comments & Documentation
- Complex logic includes inline comments explaining Java features (see `Menu.java`)
- Comments document which Java version features are used (Java 11+, 15+, 17+, 21)
- Validation logic in records is explained with compact constructor syntax

### Validation & Error Handling
- Numeric validation (age 18-65, performance 0-5) uses conditional logic with informative messages
- `InputMismatchException` handling clears Scanner buffer with `keyboard.next()`
- `NullPointerException` catching is used for null reference safety (see `hu1/Main.java`)

## Integration Points & Dependencies

### Maven Configuration
- **Java Target**: 21 (source and compile target)
- **Encoding**: UTF-8
- **GroupId**: org.riwi
- **No external dependencies** currently declared (pure Java stdlib)

### Cross-Module Communication
- `Menu` imports from both `models` and `user_history_4` packages
- `Main.java` orchestrates initialization: Salary → Employee → Menu → Employees → Reports
- User Story 4 (`user_history_4/`) builds on base Employee/Salary models for reporting

### Known Issues to Watch
- `Main.java` line 27: `List<DesempeñoReport>` syntax error—should be `ArrayList<DesempeñoReport>`
- `Dinamy_storage.java` is empty—reserved for collection/persistence logic
- Mixed module imports (both `corporate-talent-hub` and `hu1` Main classes exist)

## Guidelines for AI Agents

1. **When extending models**: Use records if data is immutable; otherwise extend Employee/Employees
2. **When adding menu options**: Follow switch expression pattern in `Menu.getSalaryCategory()` and main loop
3. **When validating input**: Use compound conditions (&&, ||) for complex eligibility checks, similar to `Salary.validateEligibility()`
4. **When reporting data**: Create record types in `user_history_4/` with compact constructors for validation
5. **Compilation target**: Always compile for Java 21; use modern features (records, switch expressions, text blocks)
6. **Spanish conventions**: Maintain Spanish method/package naming for consistency with existing code

