// grab all the elemetns from the page to work with
const pokeId = document.getElementById('poke-id')
const respId = document.getElementById('resp-id')
const pokeName =  document.getElementById('resp-name')
const pokeImg = document.getElementById('resp-sprite')
const button = document.getElementById('btn')

// add an eventListener to our button to invoke the ajaxCall function when it's clicked
button.addEventListener("click", ajaxCall);

// build a function called AJAXCall - this gets the data from the server
function ajaxCall() {

    // Capture input from the document, send it to the pokeApi
    let idNum = pokeId.value; // capture the input the user enters

    // 1. Build an XMLHttpRequest Object
    let xhr = new XMLHttpRequest();

    /** Ready State Changes of the XMLHttpRequest Object
     * 0. UNSENT: open() method has not been called 
     * 1. OPENED: open() method has been called
     * 2. HEADERS_REQUEST: send() method has been called and the ehaders + status code of the HTTP response are available
     * 3. LOADING: downloading the full response from the server
     * 4. DONE: entire operation is complete and now we have a server response.
     */
    
    xhr.onreadystatechange = function() { // this function fires EVERY time the ready state changes on the xhr object
        // chech that the state is 4 and that the HTTP Status is 200 
        if (this.readyState == 4 && this.status == 200) {

            // JSON.parse() converts a JSON string into a JavaScript Object
            let respPokemon = JSON.parse(xhr.responseText); // this has all of our JSON data!

            console.log(respPokemon)

            // render it!
            renderPokemon(respPokemon); 

        }
    }
    // the VERB & the URL to make the request
    xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${idNum}`); // pokeApi

    xhr.send();
}

function renderPokemon(data) {

    // data representts he json that's returned from the server via API

    // harvest the .sprite property and name and id
    pokeName.innerHTML = `Name: ${data.name}`;
    respId.innerHTML = `Id: ${data.id}`;

    pokeImg.setAttribute("src", data.sprites.front_default);
    pokeImg.setAttribute("height", 300);
}