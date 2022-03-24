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


// this function handles a promise - we imply that this function handles a promise with ASYNC
async function buttonClickHandler() {
    
    console.log('Getting position')

    const posData = await getPosition(); // await can ONLY be used within a asynchronous function
    const timerData = await setDelay(2000);

    console.log(timerData, posData);
}

button.addEventListener('click', buttonClickHandler);