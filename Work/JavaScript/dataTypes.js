// // //  ===============DATA TYPES===============

// "use strict";// tral all code as newer version

// //alert 3 + 3; // we are using node.js, not browser

// console.log(3 + 3); //code readability high
// console.log("Kushal");

// let name="Kushal" //String
// let age=18//number
// let isLoggedIn=true//boolean
// let state;
// state = null;

// // Primitive
// //  number => 2 to power 53
// //  binint 
// //  string => ""
// //  boolean => true/false
// //  null => standalone value
// //  undefined => value not assigned
// //  symbol => uniqueness

// //Object

// console.log(typeof null); //object
// console.log(typeof undefined);


// // ===============DATA TYPE CONVERSION===============
// let score = "33";

// // const {score} = request.body; //does not guarantee string or number

// console.log(typeof score);
// console.log(typeof(score))

// let valueInNumber = Number(score);
// console.log(typeof valueInNumber);//number
// console.log(valueInNumber);//number  = NaN, can use isNaN() to check


// score  = undefined;
// valueInNumber = Number(score);
// console.log(valueInNumber)
// console.log(typeof valueInNumber)


// score  = true;
// valueInNumber = Number(score);
// console.log(valueInNumber)
// console.log(typeof valueInNumber)


// //  "33" -> 33
// //  "33abs" -> NaN = Number => chk isNaN()
// //  true -> 1 flase -> 0
// //  null -> 0
// //  undefined -> NaN

// isLoggedIn = "1";

// let booleanIsLoggedIn = Boolean(isLoggedIn)

// console.log(booleanIsLoggedIn)

// //  1 -> true 0 -> false Boolean
// //  "" -> false
// //  "K" -> true

// let someNumber = 33;

// let stringNumber = String(someNumber);
// console.log(stringNumber);
// console.log(typeof stringNumber);


// //   ========================Operations========================

// let value = 3;
// let negValue = -value;

// // console.log(negValue);

// // console.log(2 + 2);
// // console.log(2 ** 2);
// // console.log(2 ** 3);
// // "*", "**", "+,-,/,%"

// let str1 = "hello"
// let str2 = " kushal"
// let str3 = str1 + str2
// console.log(str3)

// console.log("1" + 2);
// console.log(1 + "2");
// console.log("1" + 2 + 2); // Not 14 but 122
// console.log(1 + 2 + "2"); // Not 122 but 32

// // first primitive string type becomes type of all the following

// // console.log(+true)
// // console.log(+"")

// let num1, num2, num3;

// num1 = nums2 = num3 = 5 + 5;

// let gameCounter = 100
// gameCounter++;
// ++gameCounter;
// console.log(gameCounter);

// //   Link to study: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Increment


//  ======================Comparisons======================

//  console.log(2 > 1)
//  Comparing diff datatypes
console.log("2" > 1);
console.log("02" > 1);


console.log(null > 0);
console.log(null == 0);
console.log(null >= 0);
//  "==" is diff from other comparison 
//  other comparison opr converts null to number


console.log(undefined == 0);
console.log(undefined > 0);
console.log(undefined < 0);

//  "Strict" check === operator

console.log("2" == 2); //ok
console.log("2" === 2); //ok