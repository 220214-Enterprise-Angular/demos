// Set up the functionality so that when a user clicks the button, 
// we console.log their geolocation

// grab the button element
const button = document.querySelector('button');


function buttonClickHandler() {

    // console.log the position of the user (using the navigator.geolocation.getCurrentPosition() method)
    navigator.geolocation.getCurrentPosition(

        // function to perform if everything goes well and position is returned
        posData => {
            //  add a callback inside of a callback
            setTimeout(() => {
                console.log(posData);
            }, 2000);
        },

        // function to perform if there's an error and we recieve an error back
        error => {
            console.log(error);
        }

    ); // 2 parameters (the function to execute upon success )

    console.log('Getting position'); // fires first!
}

button.addEventListener('click', buttonClickHandler);