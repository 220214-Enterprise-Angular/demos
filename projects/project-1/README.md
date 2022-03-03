# Project 1 - Custom Object Relational Mapping Framework
>***:clock2: Due Friday March 18th, 2022***

## Description

This project will be to create a custom object relational mapping (ORM) framework. This framework will allow for a simplified and SQL-free interaction with the relational data source. The requirements of the project are purposefully vague, the intention is to allow for you to be creative in your implementation of this framework. There are many ways that this task can be approached, and you are encouraged to explore existing Java ORM implementations in order to get some inspiration. Some suggested features that your ORM can provide are:

1. A public API that can be added as a Maven dependency in other projects

2. File-based or programmatic configuration of entities
     - think of programmatic configuration as the usage of a COnfiguration class [like this in Hibernate](https://subscription.packtpub.com/book/application-development/9781784391904/1/ch01lvl1sec16/configuring-hibernate-programmatically).
     - think of file-based configuration as a separate file that defines which classed should be mapped as [like this in Hibernate](https://stackoverflow.com/questions/32824823/hibernate-mapping-classes-from-hibernate-cfg-xml).

3. Programmatic persistence of entities (basic CRUD support)
     - Think of the `save()` and `get()` metthod's from Hibernate's `Session` interface.

4. Basic transaction management (begin, commit, savepoint, rollback)

5. Connection pooling
    - You are welcome to use an external library like Apache DBCP2 like in [these examples](https://www.baeldung.com/java-connection-pooling).

6. Lightweight session creation
    - A session is a connection to the database

7. Session-based caching to minimize calls to the database
    - By "Session-based caching" think of a hashmap or some data struture that you would store previously retrieved objects in. 
    - Evey time you retrieve or add an object to an from the DB, you store it in this data structure in your Java program.
    - That way, when you try to query it a second time, you check the data structure *first* (your hashmap, for example) and if the object exists you can quickly retrieve it without spending time connecting to the DB and executing the same query.

It is encouraged that you provide clear documentation on how to use your framework in the form of a `README.md` file example [here](https://github.com/220214-Enterprise-Angular/demos/blob/main/projects/project-1/sample-readme.md).

<br>

## Tech Stack
- [ ] Java 8
- [ ] JUnit
- [ ] Apache Maven
- [ ] PostGreSQL deployed on AWS RDS
- [ ] Git VCS (on GitHub)

### Stretch Goals
- [ ] For presentation, add a web layer with servlets, and a simple user interface to demonstrate CRUD operations.
- [ ] Deploy your demo on an EC2
- [ ] Monitor code quality with SonarCloud CI

<br>

## Init Instructions
- A team lead (or whoever is most comfortable with Git) should create a new repository on their own GitHub (naming convention: `orm_name_p1`; with `orm_name` being replaced by the name of your custom framework)

- Every team member should be added as a member.  Clone the repo onto your machine and create your own branch to work on with `git checkout -b my-branch-name`

- When you are ready to merge your code onto the `main` branch, discuss it with your teammates, and [create a Pull Request](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request) from your branch to the `main` branch. 

<br>

## Presentation
- [ ] Finalized version of framework must be pushed to your team repository by the presentation date (March 18th, 2022)
- [ ] 10-15 minute live demonstration of the implemented features using a **simple demo application** to showcase the ORM's functionality
- [ ] *You will be presenting **Friday March 18th, 2022***

<br>

## Workflow Tips
- [ ] Use a [kanban board](https://www.atlassian.com/agile/kanban/boards) like [Trello](https://trello.com/en-US) for task management.
- [ ] ⭐ Get started on designing your reasearch tasks and setting up your repository *immediately*.
- [ ] Every day hold (at least) a 15 min standup meeting.  Each person should speak on:
    - What did you do yesterday?
    - What will you accomplish today?
    - What are your blockers?
- [ ] Research popular ORM's like [these](https://en.wikipedia.org/wiki/List_of_object%E2%80%93relational_mapping_software)
