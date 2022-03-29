// capture the values from all of the fields in index.html

// declare the url to which we send the post request
const url = `http://localhost:5000/api`; // if this was running locally as a Spring Boot, it would be localhost or
                                                                                            // 127.0.0.1     54.80.202.134                                                                                       

// capture the button
let button = document.getElementById('btn');

// add an event listener to the button
button.addEventListener("click", addUser); // pass a callback function

// create a function to send a POST  request to http://localhost:5000/api/users/add
// using fetch

/**
 * - capture input values
 * - construct a JSON object
 * - send the object to the @PostMapping method in the API's controller
 */
function addUser() {

    console.log('clicked!');

    // edit the url to include the users request mapping and /add
    const postUrl = url + '/users/add'; 

    // Build a User object from the input fields by querying the DOM
    let ifirstName = document.getElementById('firstName').value;
    let ilastName = document.getElementById('lastName').value;
    let iusername = document.getElementById('username').value;
    let ipassword = document.getElementById('password').value;
    let iemail = document.getElementById('email').value;

    // build an object (this is called an object literal)
    let user =  {
        firstName:  ifirstName,
        lastName: ilastName,
        username: iusername,
        password: ipassword,
        email: iemail
    }

    console.log(user);

    // we need to transform the object into a json STRING with json.stringify();

    // request object (headers, method, body)
    const request = {

        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user) // transforms it to a JSON string

    }
    
    // params: url, request
    fetch(postUrl, request) // a promise is data may be returned at a point in the future
        .then(response => response.json())
        .then(response => console.log(response)) // print out the response after it has been transformed to JSON

}


// build a user object

// stringify the object (using JSON.stringify())

// then send it by way of the fetch request to our URL