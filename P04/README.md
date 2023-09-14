# CSE1325: Social Network Simulation Project (P04)

This project simulates a simple social networking environment, implementing classes for user accounts, messaging, and groups. It covers key object-oriented programming concepts like inheritance, encapsulation, and polymorphism.

## Project Structure
```
CSE1325/P04/
├── account/
│   ├── Account.java
│   ├── AccountStatus.java
│   ├── DemoAccount.java
│   └── TestAccount.java
├── message/
│   ├── Message.java
│   ├── Post.java
│   ├── DirectMessage.java
│   ├── Group.java
│   ├── DemoMessage.java
│   ├── TestMessage.java
│   ├── TestPost.java
│   └── TestDirectMessage.java
├── build.xml
└── docs/api/  # Generated JavaDoc
```

## Features

- **Account Management:** Create accounts with varying statuses (Normal, Muted, Blocked).
- **Messaging System:** Send public posts in groups and direct messages to individuals.
- **Group Functionality:** Create groups, manage their status (active/inactive), and post messages.
- **Regression Tests:** Comprehensive tests for `Account`, `Message`, `Post`, `DirectMessage`, and `Group` classes.
- **JavaDoc Documentation:** Generated documentation for all major classes.

## Setup Instructions

### 1. Build the Project
Use the provided `build.xml` file for compilation:
```bash
ant build
```

### 2. Run Tests
Run regression tests for each module:
```bash
# Test Account functionality
java account.TestAccount

# Test basic messaging
java message.TestMessage

# Test group creation and management
java message.TestGroup

# Test post functionality
java message.TestPost

# Test direct message functionality
java message.TestDirectMessage
```

### 3. Generate JavaDoc
To generate JavaDoc documentation for all packages:
```bash
ant javadoc
```
The documentation will be available in the `docs/api/` directory.

### 4. Clean Build Files
To clean compiled `.class` files and generated JavaDocs:
```bash
ant clean
```

## Additional Work Done

- Added JavaDoc documentation to `AccountStatus`, `Account`, `Message`, `Post`, and `DirectMessage` classes.
- Created `TestPost` and `TestDirectMessage` regression tests to verify the `toString()` output.

## Author

Meetkumar Saspara  
CSE1325 - Object-Oriented Programming  
University of Texas at Arlington  

Inspired by Professor George F. Rice’s `TestMessage` structure and project guidelines. Developed in the vision of Professor George F. Rice.

## Commit History
- **stripDate method added** - Inspired by Professor Rice.
- **Created TestPost & TestDirectMessage**.
- **Generated ant javadoc for new changes**.
- **JavaDoc added to other classes**.
- **Added JavaDocs in Group and generated ant javadoc**.

## License

[MIT](https://choosealicense.com/licenses/mit/)
