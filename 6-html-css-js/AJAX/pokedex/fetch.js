/**
 * Fetch API is a modern browser API that fulfills the same
 * duties as AJAX, just much more succinctly and it looks cleaner
 */

// grab all the elemetns from the page to work with
const pokeId = document.getElementById('poke-id') // input space
const respId = document.getElementById('resp-id')
const pokeName =  document.getElementById('resp-name')
const pokeImg = document.getElementById('resp-sprite')
const button = document.getElementById('btn')

// add an eventListener to our button to invoke the ajaxCall function when it's clicked
button.addEventListener("click", fetchCall);

// after entering input, you can press enter and  it will make the call
pokeId.addEventListener("keyup", function(event) {

    if (event.keyCode === 13) {
        event.preventDefault();
        button.click();
    }
// https://www.w3schools.com/howto/howto_js_trigger_button_enter.asp
})

// build a function called AJAXCall - this gets the data from the server
function fetchCall() {

    // Capture input from the document, send it to the pokeApi
    let idNum = pokeId.value; // capture the input the user enters

    // by DEFAULT it makes a GET request (if we just provide 1 param)
    // otherwise you can add a second param
    fetch(`https://pokeapi.co/api/v2/pokemon/${idNum}`)
        .then(response => response.json()) // .json can only be called on a promise
                                           // it parse the body of the HTTP response into a JavaScript object
        .then(renderPokemon); // pass through a CALLBACK function (function passed as a param without ())
}

function renderPokemon(data) {
    // data representts he json that's returned from the server via API

    // harvest the .sprite property and name and id
    pokeName.innerHTML = `Name: ${data.name}`;
    respId.innerHTML = `Id: ${data.id}`;

    pokeImg.setAttribute("src", data.sprites.front_default);
    pokeImg.setAttribute("height", 300);
}