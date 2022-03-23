// capture the elements on the index.html
const startAddMovieButton =  document.querySelector('header button');
const addMovieModal = document.getElementById('add-modal');

// define a function to toggle the backdrop

// define a function to occur when we click it
const toggleMovieModal = () => {

    // toggle the movieModal's class list to become visible
    addMovieModal.classList.toggle('visible');
    // https://www.w3schools.com/jsref/prop_element_classlist.asp

    // CHALLENGE == set the backdrop to darken 
    // call the function down here
}

// Add event listener to the movie buttons
startAddMovieButton.addEventListener('click', toggleMovieModal);
