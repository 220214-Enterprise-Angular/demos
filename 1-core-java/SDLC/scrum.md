# Scrum

## Background
![scrum diagram](https://github.com/211018jwa/training/raw/main/week-1/day-4/scrum-diagram.png)

Scrum is an agile framework. In other words, it is a defined process with actionable steps. Borrowing terminology from OOP, Agile is an abstraction, while Scrum is a concrete implementation.

The organization that developed the Scrum methodology created a guide known a the Scrum Guide that contains information on Scrum found [here](https://scrumguides.org/scrum-guide.html)

They define Scrum as a "lightweight framework that helps people, teams, and organizations generate value through adaptive solutions for complex problems".

To understand Scrum, it is important to understand what a **sprint** is. Additionally, there are three different high level ideas to be aware of. These are the Scrum
- Artifacts
- Roles
- Ceremonies

# Sprint
A Sprint is fundamentally the most important part of Scrum. It is where ideas are transformed into actual value in the form of a **potentially shippable increment** (working software)

Sprint characteristics:
- Should be fixed in length ranging from 1 to 4 weeks
    - The typical time is 2 weeks
- The product backlog is the input to a Sprint
- A potentially shippable increment is the output for a Sprint

# Scrum Artifacts
Scrum artifacts are used to manage work and progress that needs to be made. There are three artifacts:
- Product backlog
    - An ordered list of everything that is currently part of the vision for the product
    - The product backlog is always changing and is never completed
    - The product owner is responsible for creating items and maintaining the product backlog
        - Job title: PRODUCT MANAGER
- Sprint Backlog
    - List of everything that the Scrum team decides upon to achieve for a particular Sprint
    - It's what they want to accomplish during those 1 - 4 weeks
    - Once planned and decided upon, only the development team can choose to add more items to it (if they think they can take on additional work)
    - If the development team wants to remove an item from the Sprint backlog, they must negotiate with the product owner to do so
- Potentially Shippable Increment
    - The actual product at the end of the Sprint
    - It must be "potentially releasable"
    - All completed items should meet the team's "definition of done"

# Scrum Roles
1. Scrum Master
    - Responsible for facilitating proper Scrum practices within both the Scrum team and the wider organization
    - Help to clarify questions team members may have about Scrum
    - Assist in the removal of impediments/blocker in whatever way they can
    - Facilitate the **Scrum ceremonies**
    - Is basically a coach
2. Product Owner
    - Creates and orders the product backlog items
    - Explicitly communicate the **product goal**
    - Serves as the point of contact between the client and the Scrum team
3. Development Team
    - Software engineers + testers
    - Responsible for developing potentially shippable increments in each Sprint
    - Creating a plan for the Sprint
    - Adapting their plan towards the **sprint goal**
    - Holding each other accountable

# Scrum Team
Consists of
- One Scrum Master
- One Product Owner (especially important)
- Many developers/testers

Scrum teams should ideally
- Have 10 or fewer people
- Have no hierarchies
- Be cross-functional
- Be self-managing

# Scrum Ceremonies
The Scrum ceremonies are the "official" Scrum meetings. Ceremonies are designed to enable the transparency required for adapting and improving.

These ceremonies are of course not the only meetings that will realistically happen of course, but they should help to minimize meetings not defined within the Scrum framework. It is important to make the most of the Scrum ceremonies/meetings in order to maximize shared understanding and reduce ambiguity.

The ceremonies corresponding to a particular Sprint are as follows:

1. Sprint planning meeting
    - Lays out work for the entire Sprint
    - The entire Scrum team
        - The product owner facilitates discussion about the most important product backlog items and how they relate to the product goal
        - The developers plan work that is necessary to accomplish each user story
    - No more than 8 hours
2. Daily Standup Meeting (Daily Scrum)
    - Occurs every day, usually at the start of the working day
    - Progress towards the Sprint goal and completion of the Sprint backlog is inspected
    - 15 minutes are allocated (no more than 15 minutes)
    - Normally, each team member will provide an update
        - a. What did you do yesterday?
        - b. What will you do today?
        - c. Are there any impediments/blockers?
3. Sprint Review Meeting
    - Happens at the end of the Sprint
    - Inspect the outcome of the Sprint
    - Determine future adaptation to be made to the product
    - Present results of work to stakeholders
    - Discuss progress towards the product goal
4. Sprint Retrospective
    - Occurs after the Sprint Review meeting
    - The purpose is to see how to improve for the next Sprint
    - Identify the most useful changes to improve effectiveness

# User Story
User stories are items contained in the product backlog and sprint backlog. They are the features to be developed, written from the perspective of a user of the software.

Benefits of user stories:
- Keeps the focus on the user
- Stories enable collaboration
- Stories drive creative solutions
- Stories create momentum

Reference: [Atlassian](https://www.atlassian.com/agile/project-management/user-stories)

User story format:
- "As a"
- "I want to"

Example: Calculator Application

Feature: Add Numbers
- As a user
- I want to be able to input two numbers and click the add button
- So that I can find the sum of those two numbers

There are a couple of considerations when writing user stories:
- Acceptance criteria
- Definition of Done
- Story pointing
- Burndown charts

## Acceptance Criteria
Acceptance criteria help to define when the functionality of a user story has actually been implemented. From the perspective of a user, the criteria being met is what they would perceive as "acceptable" for that particular user story (feature).

Follows the pattern of "Given/When/Then"

Feature: Add Numbers
- As a user
- I want to be able to input two numbers and click the add button
- So that I can find the sum of those two numbers

Acceptance Criteria 1:
- Given that I am at the add numbers page of the website
- When I type in 10
- And I type in 25
- And click add
- Then I should see the result of 35

Acceptance Criteria 2:
- Given that I am at the add numbers page of the website
- When I do not type in anything for the first input of a number
- But I do type in 20 for the second input of a number
- And I click add
- Then I should receive a message that says "No number found for first input"

Acceptance Criteria 3:
- Given that I am at the add numbers page of the website
- When I do type in 20 for the first number input
- But I do not in anything for the second input
- And I click add
- Then I should receive a message that says "No number found for second input"

Acceptance Criteria 4:
- Given that I am at the add numbers page of the website
- When I do not type in anything for the first input
- And I do not type in anything for the second input
- And I click add
- Then I should receive a message that says "No number found for both inputs"

## Definition of Done
The definition of done is decided upon by the Scrum team. It specifies what needs to be fulfilled for a user story to be considered complete.

For example:
1. Acceptance criteria must be met
2. All code has been peer reviewed
3. Unit tests are all passing
4. Integration tests area all passing
5. Automated E2E tests are all passing
6. Product owner approves of the feature that has been built

## Story Pointing
Story pointing is all about estimating the amount of effort to complete a particular user story. This is accomplished by assigning a value to a user story. Rather than producing a concrete estimate (days, weeks), we use story points instead.

Story points could be
- Fibonacci numbers (1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...)
- T-shirt sizes (XS, S, M, L, XL)
- etc.

## Burndown chart
![burndown chart](https://github.com/211018jwa/training/raw/main/week-1/day-4/burndown-chart.png)

- Used to track progress of a Sprint
- All of the user stories' story points are added up in the Sprint backlog
- As user stories are completed, the number of story points remaining can be visualized
- Should ideally go to 0 by the end of the Sprint