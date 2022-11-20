document.getElementById("btn").addEventListener("click", () => {main()});

function main() {
    let input = inputManager();

    let timer = new Timer();
    timer.start();
    let out = input.sortingAlgorithm(input.array);
    let delta = timer.stop();
    console.log(delta);

    if(document.getElementById("down").checked) out = flip(out);

    output(out);

    document.getElementById("dauer").innerHTML = `Dauer: ${delta}ms`;
}

function inputManager() {
    let input = {};

    input.array = getArray();
    input.sortingAlgorithm = getSortingAlgorithm();
    input.direction = getDir();

    //console.log(input);
    return input;
}

function output(array) {
    //console.log("output");
    //console.log(array);
    document.getElementById("output").innerHTML = array.join(",");
}

function getArray() {
    let input = document.getElementById("input").value;

    if(!input.includes(",")) return input.split(" ").filter((str) => str != "").map((str)=>Number(str));

    return input.split(" ").join("").split(",").filter((str) => {return str != ""}).map((str)=>Number(str));
}

function getSortingAlgorithm() {
    if(document.getElementById("insertion").checked == true) return insertionsort;
    if(document.getElementById("selection").checked == true) return selectionsort;
    if(document.getElementById("quick").checked == true) return quicksort;
    return bubblesort;
}

function getDir() {
    if(document.getElementById("down").checked == true) return -1;
    return 1;
}



//array operations

function flip(array) {
    let newArr = [];

    for(let i = 0; i < array.length; i++) {
        newArr.unshift(array[i]);
    }

    return newArr;
}

function generateRandomArray(n,range = 100) {
    let array = [];
    for(let i = 0; i < n; i++) {
        array.push(Math.round(range * (2 * Math.random() - 1)));
    }
    return array;
}



//Timer

class Timer{
    constructor() {}

    start() {
        this.timeStarted = Date.now();
    }

    stop() {
        this.timeStopped = Date.now();
        this.delta = this.timeStopped - this.timeStarted;
        return this.delta;
    }
}



//algorithms

function bubblesort(array) {
    let changed;

    do{

        changed = false;

        for(let i = 1; i < array.length; i++) {
            if(array[i] < array[i-1]) {
                let s = array[i];
                array[i] = array[i-1];
                array[i-1] = s;
                changed = true;
            }
        }

    }while(changed)

    return array;

}

function insertionsort(array) {
    for(let i = 1; i < array.length; i++) {
        let val = array[i];
        let j = i;
        while(val < array[j-1] && j > 0) {
            array[j] = array[j-1];
            j--;
        }
        array[j] = val;
    }

    return array;
}

function selectionsort(array) {
    for(let i = 0; i < array.length; i++) {
        let indexSmallestNb = i;

        for(let j = i; j < array.length; j++) {
            if(array[j] < array[indexSmallestNb]){
                indexSmallestNb = j;
            }
        }

        let s = array[i];
        array[i] = array[indexSmallestNb];
        array[indexSmallestNb] = s;
    }

    return array;
}

function quicksort() {}