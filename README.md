# PolymorphicCodeVault

A comprehensive collection of Object-Oriented Programming projects demonstrating fundamental to advanced OOP concepts in Java and C++. This repository serves as a learning journey through key programming paradigms, design patterns, and best practices in object-oriented software development.

## Repository Overview

This repository contains 11 projects completed during Fall 2023 semester as part of CSE1325 - Object-Oriented Programming at the University of Texas at Arlington. Each project builds upon previous concepts, progressively introducing more sophisticated OOP principles and techniques.

## Projects

### Java Projects (Foundational to Advanced)

#### 1. [BasicClasses](./BasicClasses)
**Concepts**: Basic class structure, static methods, user input
- Introduction to Java programming
- Simple class definitions and methods
- Console I/O operations

#### 2. [EnumsEncapsulation](./EnumsEncapsulation)
**Concepts**: Enumerations, encapsulation, private fields, getters/setters
- Using enum types for constants
- Data hiding with private fields
- Proper accessor and mutator methods
- ELIZA chatbot bonus implementation

#### 3. [ClassComposition](./ClassComposition)
**Concepts**: Object composition, "has-a" relationships, static fields
- Building complex objects from simpler ones
- Account and Message composition
- toString() method overriding

#### 4. [InheritancePolymorphism](./InheritancePolymorphism)
**Concepts**: Inheritance hierarchies, polymorphism, "is-a" relationships
- Message base class with Post and DirectMessage subclasses
- Polymorphic behavior through method overriding
- Group management and social network simulation
- Comprehensive JavaDoc documentation

#### 5. [InterfacesLambdas](./InterfacesLambdas)
**Concepts**: Interfaces (Runnable), lambda expressions, method references
- Interactive menu system using Runnable interface
- Functional programming with lambdas
- Observer pattern implementation
- Method reference syntax (::)

#### 6. [PolymorphicSerialization](./PolymorphicSerialization)
**Concepts**: Object serialization, file I/O, persistence
- Saving and loading application state
- Polymorphic object persistence
- Maintaining object relationships across sessions
- Error handling for file operations

#### 7. [FactoryPattern](./FactoryPattern)
**Concepts**: Factory design pattern, anonymous inner classes, Comparable interface
- Enigma machine simulation (WWII encryption)
- Factory methods for object creation
- Anonymous classes with method overriding
- Historical cryptography implementation

### C++ Projects (OOP in Systems Programming)

#### 8. [BasicCppIO](./BasicCppIO)
**Concepts**: C++ basics, STL vectors, algorithms, I/O streams
- Transition from Java to C++
- Standard Template Library introduction
- Vector container and sort algorithm
- Command-line argument processing

#### 9. [ClassesExceptions](./ClassesExceptions)
**Concepts**: C++ classes, constructors, destructors, exception handling
- Header and implementation file separation
- Object lifecycle management
- try-catch error handling
- Puzzle game with guess tracking

#### 10. [AbstractClassOperators](./AbstractClassOperators)
**Concepts**: Abstract classes, pure virtual functions, operator overloading, friend functions
- ANSI terminal color/font formatting system
- Abstract base class with pure virtual functions
- Comprehensive operator overloading (==, !=, <, >, <=, >=, +, <<)
- Friend functions for stream insertion
- Virtual destructors

#### 11. [STLContainers](./STLContainers)
**Concepts**: STL containers (std::set), algorithms, modern C++
- Using std::set for unique element storage
- Automatic sorting and duplicate prevention
- Enhanced puzzle game with set-based guess tracking
- File I/O for puzzle data

## Learning Path

This repository demonstrates a carefully structured learning progression:

1. **Basics**: Classes, methods, encapsulation
2. **Relationships**: Composition and inheritance
3. **Advanced OOP**: Interfaces, polymorphism, serialization
4. **Design Patterns**: Factory pattern, observer pattern
5. **C++ Fundamentals**: Syntax, STL, basic classes
6. **Advanced C++**: Abstract classes, operator overloading, templates

## Technologies Used

- **Java**: JDK 8+, Ant build tool, JUnit testing
- **C++**: C++11/14, g++ compiler, Make build system
- **Documentation**: JavaDoc, inline comments
- **Version Control**: Git

## Key OOP Principles Covered

- **Encapsulation**: Data hiding, access modifiers
- **Inheritance**: Class hierarchies, "is-a" relationships
- **Polymorphism**: Method overriding, dynamic binding
- **Abstraction**: Abstract classes, interfaces
- **Composition**: "has-a" relationships, object aggregation

## Design Patterns Implemented

- **Factory Pattern**: Object creation abstraction
- **Observer Pattern**: Event handling and callbacks
- **Strategy Pattern**: Behavior encapsulation (via lambdas)

## Build Instructions

### Java Projects
```bash
# Most Java projects use Ant
cd <project-directory>
ant build
ant test  # Run tests if available
ant javadoc  # Generate documentation

# Or compile manually
javac *.java
java MainClass
```

### C++ Projects
```bash
# Using Make
cd <project-directory>
make
./<executable-name>
make clean

# Or compile manually
g++ -o program source.cpp -std=c++11
./program
```

## Repository Statistics

- **Total Projects**: 11
- **Lines of Code**: 10,000+ (estimated)
- **Languages**: Java, C++
- **Commits**: 102
- **Time Period**: Fall 2023 Semester

## Author

**Meetkumar Saspara**
- University: University of Texas at Arlington
- Course: CSE1325 - Object-Oriented Programming
- Semester: Fall 2023
- Email: meetsaspara9@gmail.com

## Acknowledgments

Special thanks to Professor George F. Rice for excellent course structure, project guidelines, and inspiration for test implementations. The progressive complexity of assignments provided an ideal learning path for mastering object-oriented programming.

## License

This repository is licensed under the [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.en.html).

## Project Structure

```
PolymorphicCodeVault/
├── BasicClasses/              # Java basics
├── EnumsEncapsulation/        # Enums and data hiding
├── ClassComposition/          # Object composition
├── InheritancePolymorphism/   # Inheritance and polymorphism
├── InterfacesLambdas/         # Interfaces and functional programming
├── PolymorphicSerialization/  # Object persistence
├── FactoryPattern/            # Design patterns
├── BasicCppIO/                # C++ introduction
├── ClassesExceptions/         # C++ OOP basics
├── AbstractClassOperators/    # Advanced C++ OOP
├── STLContainers/             # STL and modern C++
├── LICENSE                    # GPL-3.0 License
└── README.md                  # This file
```

## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/meet114/PolymorphicCodeVault.git
   cd PolymorphicCodeVault
   ```

2. Navigate to any project directory:
   ```bash
   cd InheritancePolymorphism
   ```

3. Read the project-specific README.md for detailed instructions

4. Build and run following the project's build instructions

## Contributing

This repository represents coursework from Fall 2023. While direct contributions are not accepted, feel free to fork the repository for your own learning purposes.

## Contact

For questions or discussions about these projects:
- Email: meetsaspara9@gmail.com
- GitHub: [@meet114](https://github.com/meet114)

---

*This repository showcases the evolution of programming skills from basic Java classes to advanced C++ OOP concepts, demonstrating mastery of object-oriented programming principles and design patterns.*
