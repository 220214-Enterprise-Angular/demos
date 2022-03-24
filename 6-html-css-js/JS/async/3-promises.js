const button = document.querySelector('button');

// this is kind of like what the inside of the fetch() method looks like
const setDelay = (duration) => {

    // an object in which we can specify what to do when a value is returned at a certain time./
    const promise = new Promise((resolve, reject) => {
        setTimeout(() => {
            // whatever function is passed to the promise to handle successful completion
            // will be passed this parameter
            resolve('Done'); // this is passed to the callback provided in .then()
        }, duration)
    });

    return promise;
}

function buttonClickHandler() {
    navigator.geolocation.getCurrentPosition(
        posData => {
            
            setDelay(2000)
                .then(data => {
                console.log(data, posData);
            })

        },
        error => {
            console.log(error);
        }
    ); 

    console.log('Getting position'); 
}

button.addEventListener('click', buttonClickHandler);