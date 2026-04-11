"use strict";// tral all code as newer version

//alert 3 + 3; // we are using node.js, not browser

console.log(3 + 3); //code readability high
console.log("Kushal");

let name="Kushal" //String
let age=18//number
let isLoggedIn=true//boolean
let state;
state = null;

// Primitive
//  number => 2 to power 53
//  binint 
//  string => ""
//  boolean => true/false
//  null => standalone value
//  undefined => value not assigned
//  symbol => uniqueness

//Object

console.log(typeof null); //object
console.log(typeof undefined);


// --------------DATA TYPE CONVERSION--------------
let score = "33";

// const {score} = request.body; //does not guarantee string or number

console.log(typeof score);
console.log(typeof(score))

let valueInNumber = Number(score);
console.log(typeof valueInNumber);//number
console.log(valueInNumber);//number  = NaN, can use isNaN() to check


score  = undefined;
valueInNumber = Number(score);
console.log(valueInNumber)
console.log(typeof valueInNumber)


score  = true;
valueInNumber = Number(score);
console.log(valueInNumber)
console.log(typeof valueInNumber)


//  "33" -> 33
//  "33abs" -> NaN = Number => chk isNaN()
//  true -> 1 flase -> 0
//  null -> 0
//  undefined -> NaN

isLoggedIn = "1";

let booleanIsLoggedIn = Boolean(isLoggedIn)

console.log(booleanIsLoggedIn)

//  1 -> true 0 -> false Boolean
//  "" -> false
//  "K" -> true

let someNumber = 33;

let stringNumber = String(someNumber);
console.log(stringNumber);
console.log(typeof stringNumber);