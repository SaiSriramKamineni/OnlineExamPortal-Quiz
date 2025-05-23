# 📝 Online Exam Portal

A Java-based GUI application for conducting MCQ-based online exams. Built using **Swing**, follows **OOP** principles, connects to a **MySQL database**, and includes a countdown **timer** for each session.

---

## 🚀 Features

- 🎯 Multiple Choice Questions (MCQs)
- 🕒 Countdown Timer (60 seconds)
- 📊 Auto Grading
- 📋 Randomized Questions
- 💾 Backend with MySQL (JDBC)
- 🖥️ Clean Swing UI

---

## 📸 Preview

![Exam Portal UI](A_2D_digital_screenshot_displays_an_"Online_Exam_P.png)

---

## 🧰 Tech Stack

| Layer         | Technology              |
|--------------|--------------------------|
| Language      | Java (JDK 17+)           |
| GUI Library   | Java Swing               |
| Backend DB    | MySQL                    |
| Connectivity  | JDBC + mysql-connector   |
| OOP           | Encapsulation, Classes   |

---

## 🏗️ Project Structure

```bash
OnlineExamPortal/
├── src/
│   └── OnlineExamPortal.java       # Main UI and logic
├── db/
│   └── exam.sql                    # Database setup file
├── lib/
│   └── mysql-connector-java.jar    # MySQL JDBC connector
├── README.md
```
## 📂 How It Works
- Connects to MySQL using JDBC.
- Fetches randomized questions from the `questions` table.
- Displays one question at a time using Java Swing.
- Tracks a 60-second countdown using a Swing Timer.
- Calculates and shows the final score upon submission or timeout.

## 💡 Ideas to Extend
- 🔐 Login authentication (Admin/Student)
- 📚 Quiz categories or difficulty levels
- ⏱️ Per-question timer
- 📄 Export results to PDF or CSV
- 🛠️ Admin dashboard to add/edit/delete questions




