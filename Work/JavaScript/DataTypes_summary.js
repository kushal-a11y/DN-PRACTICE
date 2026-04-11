//  Primitive vs Non-Primititve or Reference
//  How to store and access data

// Primititve 7: string, number, boolean, null, undefined, symbol, BigInt



//  Dynamically typed
const score = 100;
const scoreVal = 100.3;

const isLoggedIn = false;
const outSideTemp = null;
let userEmail = undefined;

const id = Symbol('123')
const anotherId = Symbol('123')

console.log(id==anotherId);//false not same

const bigNumber = 4798434785784854n

//  Reference (Non Primitive)

//  Array, Objects, Functions

const heroes = ["shaktiman", "naagraj", "doga"];
const x = {
    name:"kushal",
    age:22,
};
const myfunc = function(){
    console.log("Hello world");
}

console.log(typeof scoreVal);
