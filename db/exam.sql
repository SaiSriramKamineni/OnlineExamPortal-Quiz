CREATE DATABASE exam;

USE exam;

CREATE TABLE questions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question VARCHAR(255),
    option1 VARCHAR(100),
    option2 VARCHAR(100),
    option3 VARCHAR(100),
    option4 VARCHAR(100),
    answer VARCHAR(100)
);

INSERT INTO questions (question, option1, option2, option3, option4, answer) VALUES
('Java is a ___ language.', 'Compiled', 'Interpreted', 'Both', 'None', 'Both'),
('Which data structure uses FIFO?', 'Stack', 'Queue', 'Tree', 'Graph', 'Queue'),
('Which keyword is used to inherit a class in Java?', 'inherits', 'extends', 'implements', 'super', 'extends'),
('What is method overloading?', 'Same name, different parameters', 'Same name, same parameters', 'Different name', 'None', 'Same name, different parameters'),
('What is method overriding?', 'Same name in same class', 'Same method in child class', 'No relation to inheritance', 'None', 'Same method in child class'),
('Which of these is not an OOP principle?', 'Encapsulation', 'Abstraction', 'Recursion', 'Polymorphism', 'Recursion'),
('Which keyword prevents method overriding?', 'final', 'static', 'super', 'private', 'final'),
('Which access modifier is the most restrictive?', 'private', 'public', 'protected', 'default', 'private'),
('Which concept binds data and functions together?', 'Encapsulation', 'Polymorphism', 'Inheritance', 'Abstraction', 'Encapsulation'),
('Which class can be subclassed?', 'final class', 'static class', 'abstract class', 'none', 'abstract class'),
('Interfaces can have:', 'Only abstract methods', 'Only static methods', 'Static and default methods', 'Only private methods', 'Static and default methods'),
('Which keyword is used to implement an interface?', 'extends', 'inherits', 'implements', 'instanceof', 'implements'),
('Java does not support:', 'Multiple inheritance using classes', 'Multilevel inheritance', 'Single inheritance', 'Hierarchical inheritance', 'Multiple inheritance using classes'),
('What is JVM?', 'Java Virtual Method', 'Java Virtual Machine', 'Java Verified Method', 'Java Virtual Model', 'Java Virtual Machine'),
('What is the default value of a boolean?', 'true', 'false', '0', 'null', 'false'),
('Which exception is unchecked?', 'IOException', 'SQLException', 'NullPointerException', 'FileNotFoundException', 'NullPointerException'),
('Which class is the superclass of all classes?', 'Object', 'String', 'Class', 'Root', 'Object'),
('How many times is a constructor called during object creation?', '0', '1', '2', 'Depends', '1'),
('What is the use of super keyword?', 'To call parent constructor', 'To call private method', 'To create object', 'None', 'To call parent constructor'),
('Which loop is guaranteed to execute at least once?', 'for', 'while', 'do-while', 'None', 'do-while'),
('Which of these is used to define a package?', 'define', 'package', 'include', 'import', 'package'),
('Which keyword is used to handle exceptions?', 'try', 'throw', 'catch', 'All of the above', 'All of the above'),
('Which interface provides no methods?', 'Cloneable', 'Runnable', 'Serializable', 'Comparable', 'Serializable'),
('Which collection does not allow duplicates?', 'List', 'Set', 'Queue', 'Map', 'Set'),
('What is the base interface for all collections?', 'List', 'Collection', 'Map', 'Iterable', 'Collection'),
('Which data type is used to create a variable that should store text?', 'string', 'String', 'char', 'Character', 'String'),
('Which class is used to take input in Java?', 'Scanner', 'BufferReader', 'Console', 'InputReader', 'Scanner'),
('Which keyword is used to create an object?', 'new', 'class', 'create', 'object', 'new'),
('Which operator is used to compare two values?', '=', '==', '!=', 'equals()', '==');
