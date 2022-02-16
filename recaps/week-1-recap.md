# Week 1 Recap

# Day 1
- What is Java?
    - [image link](./week-1-images/what-is-java.JPG)
- JDK v. JRE v. JVM
    - [image link](./week-1-images/jdk-jre-jvm.JPG)
- Compilation Process
    - [image link](./week-1-images/compilation-process.JPG)
- Some characteristics of a programming language
    - [image link](./week-1-images/programming-language-characteristics.JPG)
- First Program
    - Use `javac SodaCan.java` to compile
    - Use `java SodaCan` to run
    - [link](https://github.com/220214-Enterprise-Angular/demos/tree/main/week-1/my-first-program)
- 8 Primitive Types
    - [link](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/datatypes/src/com/revature/main/Driver.java#L17-L27)
- Primitive Casting
    - Widening
    - Narrowing
    - [link](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/datatypes/src/com/revature/main/Driver.java#L46-L56)
- Constants
    - [link](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/datatypes/src/com/revature/main/Driver.java#L63-L74)
- Naming conventions
    - [link](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/datatypes/src/com/revature/main/Driver.java#L76-L90)
- Introduction to Classes and Objects
    - Class members
        - [properties/fields](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/classes-and-objects/src/com/revature/model/SportsCar.java#L10-L17)
        - [behaviors/methods](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/classes-and-objects/src/com/revature/model/SportsCar.java#L39-L52)
        - [constructors](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/classes-and-objects/src/com/revature/model/SportsCar.java#L19-L37)
    - [SportsCar example](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/classes-and-objects/src/com/revature/main/Driver.java#L15-L19)
    - [Calculator example](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/classes-and-objects/src/com/revature/main/Driver.java#L21-L27)
- Operator Types
    - [link](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/operators-and-control-flow/src/com/revature/main/Driver.java#L7-L13)
    - [ternary operator](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/operators-and-control-flow/src/com/revature/main/Driver.java#L18)
- Control Flow
    - [if](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/operators-and-control-flow/src/com/revature/main/Driver.java#L39-L41)
    - [if-else](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/operators-and-control-flow/src/com/revature/main/Driver.java#L43-L49)
    - [if-else if-else](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/operators-and-control-flow/src/com/revature/main/Driver.java#L51-L59)
    - [Switch statement](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/operators-and-control-flow/src/com/revature/main/Driver.java#L61-L87)
    - [For Loop](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/operators-and-control-flow/src/com/revature/main/Driver.java#L93-L98)
    - [While loop](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/operators-and-control-flow/src/com/revature/main/Driver.java#L101-L107)
    - [Do-while loop](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/operators-and-control-flow/src/com/revature/main/Driver.java#L110-L118)

# Day 2
- Git introduction
    - [image](./week-1-images/git-introduction.JPG)
- Common linux commands
    - [image](./week-1-images/common-linux-commands.JPG)
- Memory management
    - [stack v. heap](./week-1-images/memory-management.JPG)
    - [String pool](./week-1-images/string-pool.JPG)
- String Demo
    - [link](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/string-demo/src/com/revature/main/Driver.java)
    - [s referencing a String in String pool](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/string-demo/src/com/revature/main/Driver.java#L11-L14)
    - [String instantiated in the regular part of the heap](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/string-demo/src/com/revature/main/Driver.java#L19-L20)
    - [.concat(), .length(), .startsWith(), .endsWith()](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/string-demo/src/com/revature/main/Driver.java#L28-L39)
    - [Ways to iterate through the characters of a String](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/string-demo/src/com/revature/main/Driver.java#L41-L67)
- StringBuilder and StringBuffer
    - [image](./week-1-images/stringbuilder-stringbuffer.JPG)
    - [reversing String with StringBuilder](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/reverse-a-string/src/com/revature/main/Driver.java#L56-L66)
    - [reversing String with String concatenation (INEFFICIENT)](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/reverse-a-string/src/com/revature/main/Driver.java#L37-L49)
- Wrapper Classes
    - [link](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/wrapper-class-demo/src/com/revature/main/Driver.java#L25-L90)
    

# Questions
* What exactly makes Java "platform independent"?
* Why is Java both a compiled and interpreted language?
* What is source code? What is the extension for a file that contains Java source code?
* What does the compiler do?
* Where is the compiler contained? Is it contained in the JDK, JRE, or JVM?
* Can you run a Java program by only having a JRE installed?
* What is bytecode? What is the extension for the file that contains bytecode
* Explain the difference/relations between the JDK, JRE, and JVM
* What executes the bytecode?
* What is the method signature for the "main" method, and why is the main method important?
* What two types of variables exist in Java?
* What primitives does Java have?
* What variables can hold decimal numbers, and which one is the most precise?
* What are common operators in Java?
* What are the logical operators?
* What are the assignment operators?
* What are the comparison operators?
* What are the arithmetic operators?
* What are some characteristics of a programming language?
* What is control flow?
* How do if statements work?
* What is else if?
* What is else?
* What is a switch statement?
* What datatypes does switch support?
* What loops exist in Java?
* What is the syntax for a for loop?
* What is the syntax for a while loop?
* How is a while loop different than a do-while loop?
* What are the naming conventions for a class, variable, and method respectively? What about the naming convention for a constant?
* How do we declare a constant?
* What is primitive casting? What are the 2 types of primitive casting?
* Which type of primitive casting is implicit?
* What type of primitive casting is explicit?
* What is the difference between a class and object?
* What are the members of a class?
* What does a field represent in a class?
* What does a method represent in a class?
* How do you instantiate an object?
* What is a default constructor?
* If you define a constructor, what do you typically write inside of the constructor?
* If you define your own constructor, does the compiler still provide a default constructor?
* What is the structure of a method? (method signature)
* How do you use a ternary operator?
* What is a String?

