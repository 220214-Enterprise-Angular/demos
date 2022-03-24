const button = document.querySelector('button');

const setDelay = (duration) => {
    const promise = new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('Done'); 
        }, duration)
    });
    return promise;
}

// opts == options (typically information about a server)
const getPosition = (opts) => {

    const promise = new Promise((resolve, reject) => {
        navigator.geolocation.getCurrentPosition(
            // (success rep)
            (success) =>{
                resolve(success);
            },
            (error) => {
                reject(error);
            },
            opts
        );
    });

    return promise;
}



function buttonClickHandler() {
    
    let positionData;

    getPosition().then((posData) => {
        positionData = posData;
        return setDelay(2000); // this too reutrns a promise which is why we need to add another .then() statement
    })
    .catch(err => {
        console.log(err)
    })
    .then(data => {
        console.log(data, positionData);
    })

    console.log('Getting position'); 
}

button.addEventListener('click', buttonClickHandler);