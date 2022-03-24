// capture the elements on the index.html
const startAddMovieButton =  document.querySelector('header button');
const addMovieModal = document.getElementById('add-modal');
const backdrop = document.getElementById('backdrop');
// capture the parent element and query the child element by its CSS selector
const cancelAddMovieButton = addMovieModal.querySelector('.btn--passive');
const confirmAddMovieButton = cancelAddMovieButton.nextElementSibling; // returns the sibling element which is the other button
// capture an ARRAY of the user inputs (a node is what's rendered by the browser and what comprises the DOM)
// an element is the JS object representation of a Node
const userInputs = addMovieModal.querySelectorAll('input'); // this build an array of elements
const banner = document.getElementById('entry-text');


// declare a movies array;
const movies = []; // arrays in JS are dynamic and can change in size

const updateUI = () => {

    // if the movies array is 0, keep the display as'block'
    if (movies.length === 0) {
        banner.style.display = 'block';
    }
    // otherwise set it to none
    banner.style.display = 'none';

}

const renderNewMovieElement = (title, imageUrl, rating) => {

    // create a list item element (<li>)
    const newMovieElement = document.createElement('li');

    // add a class name to the list element so that it adopts some styling properties
    newMovieElement.className= 'movie-element';

    // build the HTML template of the element and interpolate the values [passed as params]
    newMovieElement.innerHTML = `
        <div class="movie-element_image"> 
            <img src="${imageUrl}" alt="${title}">
        </div>

        <div class="movie-element_info">
            <h2>${title}</h2>
            <p>${rating}/5 stars</p>
        </div>
    `;
    // append it to the movie list
    const listRoot = document.getElementById('movie-list');
    listRoot.append(newMovieElement);
}

// define a function to toggle the backdrop
const toggleBackDropHandler = () => {
    backdrop.classList.toggle('visible');
}

// define a function to occur when we click it
const toggleMovieModal = () => {
    // toggle the movieModal's class list to become visible
    addMovieModal.classList.toggle('visible');
    // https://www.w3schools.com/jsref/prop_element_classlist.asp

    // CHALLENGE == set the backdrop to darken 
    toggleBackDropHandler();
}

const cancelAddMovieHandler = () => {
    toggleMovieModal();
    // later I'll need to provide a clearMovieInput() function
    clearMovieInput();
} 

const clearMovieInput = () => {
    // QC question what is the difference between for OF and for IN loops?
    for (let usrInput of userInputs) {
        usrInput.value = ''; // also add this function to cancelAddMovieHandler()
    }
}

const confirmAddMovieHandler = () => {
    // capture the values from the user input of the modal
    const titleValue = userInputs[0].value; // selecting the value of the first element in the array
    const imageUrlValue = userInputs[1].value;
    const ratingValue = userInputs[2].value;

    // trim any existing whitespace, maybe alert the user if there are errors
    if (
        titleValue.trim() === '' || // you can try testing for falsey values with !titleValue.trim() 
        imageUrlValue.trim() === '' ||
        ratingValue.trim() == '' ||
        +ratingValue < 1 || // + before a variable transforms its type to a number
        +ratingValue > 5
    ) {
        alert('Please enter valid values (rating must be between 1 & 5)')
        return;
    };

    // build a movie object
    const newMovie = {
        title: titleValue,
        image: imageUrlValue,
        rating: ratingValue
    };

    // push that movie object to array
    movies.push(newMovie);
    console.log(movies);

    // close the modal (toggleMovieModal())
    toggleMovieModal();
    // clear the movie input
    clearMovieInput();

    renderNewMovieElement(newMovie.title, newMovie.image, newMovie.rating)

    // update UI (this will probably be another function)
    updateUI();

}


// Add event listener to the movie buttons
startAddMovieButton.addEventListener('click', toggleMovieModal);
// add an event listener to the backdrop itself and toggle Movie modal
backdrop.addEventListener('click', toggleMovieModal);
// add the event listener to the cancelAddMovieButton
cancelAddMovieButton.addEventListener('click', cancelAddMovieHandler)
// add event listener to the confirmAddMovieButton
confirmAddMovieButton.addEventListener('click', confirmAddMovieHandler)

