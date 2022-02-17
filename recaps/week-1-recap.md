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
- Variable Scopes
    - [image](./week-1-images/variable-scopes.JPG)
    - [global/static scope](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/variable-scopes/src/com/revature/main/Person.java#L7-L8)
    - [instance scope](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/variable-scopes/src/com/revature/main/Person.java#L10-L15)
    - [method scope](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/variable-scopes/src/com/revature/main/Person.java#L30-L31)
    - [block scope (2 examples)](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/variable-scopes/src/com/revature/main/Person.java#L35-L41)
- Access Modifiers
    - [image](./week-1-images/access-modifiers.JPG)
    - [demo](https://github.com/220214-Enterprise-Angular/demos/tree/main/week-1/access-modifier-demo)
- Scanner Class
    - Often used for console input from the user
    - [demo](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/scanner-demo/src/com/revature/main/Driver.java#L11-L25)
- Arrays
    - [image](./week-1-images/arrays.JPG)
    - [instantiating an array w/ no predefined values](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/array-demo/src/com/revature/main/Driver.java#L15-L19)
    - [assigning values 1 by 1 and iterating over the array](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/array-demo/src/com/revature/main/Driver.java#L29-L37)
    - [using for-each loop w/ array](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/array-demo/src/com/revature/main/Driver.java#L39-L42)
    - [instantiate an array w/ PREDEFINED values](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/array-demo/src/com/revature/main/Driver.java#L45)
    - [multi-dimensional array](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/array-demo/src/com/revature/main/Driver.java#L54-L80)
- Var-args
    - [demo](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/array-demo/src/com/revature/main/Driver.java#L87-L101)
    - [using var-args](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/array-demo/src/com/revature/main/Driver.java#L83-L84)
- Encapsulation
    - [image](./week-1-images/encapsulation.JPG)
    - [private fields](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/encapsulation-demo/src/com/revature/model/Person.java#L11-L13)
    - [getters and setters](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/encapsulation-demo/src/com/revature/model/Person.java#L24-L53)

# Day 3
- [Analysis of reversing string algorithms](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/reverse-string-implementations/src/com/revature/Driver.java#L283-L325)
- Inheritance
    - [image](./week-1-images/inheritance.JPG)
    - [superclass / parent class](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/inheritance-demo/src/com/revature/model/Animal.java#L3-L38)
    - [subclass / child class](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/inheritance-demo/src/com/revature/model/Dog.java#L5-L36)
- Polymorphism
    - [image](./week-1-images/polymorphism.JPG)
    - [runtime polymorphism](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/polymorphism-demo/src/com/revature/main/Driver.java#L17-L39)
    - [compile time polymorphism](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/polymorphism-demo/src/com/revature/main/Driver.java#L41-L52)
    - [method overriding](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/polymorphism-demo/src/com/revature/model/Dog.java#L5-L21)
    - [method overloading](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/polymorphism-demo/src/com/revature/model/Calculator.java#L8-L43)
- Object class
    - [image (overview)](./week-1-images/object-class.JPG)
    - [image (hashCode and equals)](./week-1-images/hashcode-and-equals.JPG)
    - [image (conceptual hashmap)](./week-1-images/hashcode-and-hashmap.JPG)
    - [overriding toString(), equals(), and hashCode()](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/object-class-demo/src/com/revature/model/Person.java#L26-L53)
    - [toString()](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/object-class-demo/src/com/revature/main/Driver.java#L13-L16)
    - [== v. .equals()](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/object-class-demo/src/com/revature/main/Driver.java#L20-L24)
- Throwable Hierarchy
    - [image](./week-1-images/throwable-hierarchy.JPG)
- Reading a stack trace
    - [image](./week-1-images/stack-trace.JPG)
- Handling Exceptions
    - [image](./week-1-images/handling-exceptions.JPG)
- throw v. throws v. Throwable
    - [image](./week-1-images/throw-throws-throwable.JPG)
- Exception demo
    - [declaring an exception using throws keyword](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/exception-demo/src/com/revature/main/Driver.java#L37)
    - [propagating an exception using throw keyword](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/exception-demo/src/com/revature/main/Driver.java#L40)
    - [handling exception using catch block](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/exception-demo/src/com/revature/main/Driver.java#L27-L28)
- Cracking the Coding Interview Problem 1.1
    - [problem statement](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/ctci-1-1/src/com/revature/Driver.java#L9-L10)
    - [bruteforce O(n^2)](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/ctci-1-1/src/com/revature/Driver.java#L61-L70)
    - [using sorting without additional data structure to achieve O(n log n)](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/ctci-1-1/src/com/revature/Driver.java#L38-L59)
    - [using a data structure to achieve O(n)](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/ctci-1-1/src/com/revature/Driver.java#L22-L35)
- Asymptotic Notation
    - [image](./week-1-images/asymptotic-notation.JPG)
- List
    - [image](./week-1-images/list.JPG)
- Implement a custom ArrayList
    - [demo](https://github.com/220214-Enterprise-Angular/demos/blob/main/week-1/arraylist-implementation/src/com/revature/main/MyIntegerArrayList.java)

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
---
* What is Git?
* What is the difference between Git and GitHub?
* What commands do you use in a typical Git workflow?
* What is a commit?
* How do you "upload" the latest commits on your local repository to the remote repository?
* If there is a remote repository that you would like to copy to your computer, what command allows you to do that?
* What are some of the common linux commands you may use?
* Where are variables declared inside of a method stored?
* Where are objects that are instantiated stored?
* What is the String pool?
* Are all Strings stored in the String pool? If not, what Strings are actually stored in the String pool?
* What are some of the common methods you might use when working with Strings?
* How might you iterate through a String's characters?
* What is StringBuilder and StringBuffer? What is the difference between the two?
* Why is String concatenation not efficient?
* What is a wrapper class? What are some examples?
* What is the purpose of a wrapper class?
* What 4 variable scopes exist in Java?
* What are the 4 access modifiers from most restrictive to least restrictive?
* What is a common purpose of the Scanner class?
* What is an array?
* How are the elements of an array stored in memory?
* Why is accessing an element by its index O(1)? (constant regardless of the size of the array?)
* How do you iterate over all of the elements in an array?
* Syntax for instantiating an array with pre-defined values?
* Syntax for instantiating an array WITHOUT pre-defined values?
* What are var-args?
* What is Encapsulation? Describe getters/setters?
