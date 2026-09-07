# 🚀 TaskFlow — DSA Final Project

> A console-based Task Management System built with **Pure Java** to demonstrate
> Data Structures, Algorithms, Object-Oriented Programming, and File Handling.

![Java](https://img.shields.io/badge/Java-21-orange)
![DSA](https://img.shields.io/badge/Project-DSA-blue)
![OOP](https://img.shields.io/badge/OOP-Java-green)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

## 📌 About The Project

**TaskFlow** is a Task Management System developed as a **Data Structures & Algorithms Final Project**.

The goal of this project is not only to build a task manager, but to understand how fundamental **DSA concepts work together inside a real application**.

TaskFlow implements custom data structures including:

- 🔗 Singly Linked List
- 📚 Stack
- 🚶 Queue
- 🔍 Searching
- 🔃 Sorting
- 💾 File Handling

The project also demonstrates important **Java OOP concepts** such as:

- Encapsulation
- Classes & Objects
- Constructors
- Generics
- Abstraction
- Separation of responsibilities

---

# ✨ Features

| # | Feature |
|---|---|
| 1 | ➕ Add Task |
| 2 | 📋 View All Tasks |
| 3 | 🔍 Search Task |
| 4 | ✏️ Update Task |
| 5 | 🗑️ Delete Task |
| 6 | ✅ Complete Task |
| 7 | 🔃 Sort Tasks |
| 8 | ↩️ Undo |
| 9 | 📥 Add Task to Queue |
| 10 | ⚙️ Process Next Task |
| 11 | 🚪 Exit |

---

# 🧠 Data Structures Used

## 🔗 Linked List

Tasks are stored using a custom Linked List implementation.

```text
HEAD
 ↓
[Task 1] → [Task 2] → [Task 3] → NULL
```
## 🏗️ Project Structure

```bash
taskflow--DSA_Final_Project/
│
├── src/
│   └── taskflow/
│       │
│       ├── ds/
│       │   ├── MyLinkedList.java
│       │   ├── MyStack.java
│       │   ├── MyQueue.java
│       │   └── Node.java
│       │
│       ├── model/
│       │   └── Task.java
│       │
│       ├── service/
│       │   └── TaskManager.java
│       │
│       └── Main.java
│
├── data/
│   └── tasks.txt
│
└── README.md
```

---

## ⚙️ Prerequisites

Before running TaskFlow, ensure the Java Development Kit (JDK) is installed on your system.

### Check Java Version
```bash
java --version
Check Java Compiler
```


```Bash
javac --version
Expected output:
```

Plaintext
```bash
java 21.x.x or greater
javac 21.x.x or greater
```
✅ If both commands return valid version numbers, you are ready to build and run TaskFlow.

🚀 Getting Started
---

## ⚙️ Prerequisites


1️⃣ Clone the Repository
Open your terminal and clone the repository:

```bash
git clone [https://github.com/HassanBalach/taskflow--DSA_Final_Project.git]
```

2️⃣ Enter the Project Directory

```bash
cd taskflow--DSA_Final_Project
```
📌 Note: Ensure you navigate into taskflow--DSA_Final_Project (and not cd src/taskflow), as compilation commands rely on the root folder structure.

3️⃣ Compile the Project
Compile all Java source files into the out directory:

```Bash
javac -d out src/taskflow/*.java src/taskflow/ds/*.java src/taskflow/model/*.java src/taskflow/service/*.java
```

4️⃣ Run the Application

Launch the application from the compiled classes:

```Bash
java -cp out taskflow.Main
```


🖥️ Application Interface
When launched, TaskFlow presents the following console menu:

Plaintext
==============================
          TASKFLOW
==============================

 1. Add Task
 2. View All Tasks
 3. Search Task
 4. Update Task
 5. Delete Task
 6. Complete Task
 7. Sort Tasks
 8. Undo
 9. Add Task to Queue
10. Process Next Task
11. Exit

==============================

# 👨‍💻 Author
### Hassan Balach and His Team

BS Computer Science Student

This project was built as a DSA Final Project to strengthen practical understanding of:

Java + OOP + Data Structures + Algorithms
