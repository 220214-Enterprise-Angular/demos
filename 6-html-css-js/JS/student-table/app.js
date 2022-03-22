console.log('app.js is working!')

// Goal: When we clkick the button take the input and add it below

// Capture the button, save it to a variable, add an Event Listener
let button = document.getElementById('add-student');  // querySelector('button') // returns the first button
button.addEventListener("click", addStudent); // 2 params: event to listen for, and what to do when it happens (callback function)

// when it's clicked, do some function


// define the function to add all values from the input fields to the table
function addStudent() {

    // 1. Grab the input element AND its field values from the student name & major
    let nameField = document.getElementById('student-name').value; // returns whatever the user entered
    let majorField = document.getElementById('student-major').value;

    // 2.check that they're truthy
    if (nameField && majorField) { // if () statement automatically checks for truthy/falsey so no need for !!

        // 3. if the are, create a row element
        let row = document.createElement('tr'); // 'tr' means <tr>
        
        // 4. Create a a table cell element for ID
        let idCell = document.createElement('td'); // represents individual cells in a table

        // 5. Create a a table cell element for Name
        let nameCell = document.createElement('td');

        // 6. Create a a table cell element for Major
        let majorCell = document.createElement('td');

        // 7. Append the cells to the newly created row
        row.appendChild(idCell);
        row.appendChild(nameCell);
        row.appendChild(majorCell);

        // 8. capture the pre-existing table and append the row to it
        document.getElementById('student-table-body').appendChild(row);

        // 9. set the inner text of each cell the information we captured from the input
        idCell.innerText = idGenerator().next().value; // add a function that returns a value that auot-increments
        nameCell.innerText = nameField;
        majorCell.innerText = majorField;

        // 10. set the input fields to '' every time we click the button
        document.getElementById('student-name').value='';
        document.getElementById('student-major').value='';
    }
}

let counter = 1;

// we need some function to increment the ID
function* idGenerator() {
    yield counter++;
} // generator functions introduced in ES6
