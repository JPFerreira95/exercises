"use strict";
/*
 * Small file to play with typescript types
 */
// string
let lname;
lname = "João";
let upperName = lname.toUpperCase();
console.log(upperName);
// create number type. int and double are both number type
let age;
age = 25;
age = 25.6;
// Cast string to int
let dob = "25";
let result = parseInt(dob);
// boolean should always be initialized
let isValid = false;
console.log(isValid);
// arrays (2 ways to define an array)
let nameList;
let depList;
nameList = ["João", "Joana", "José"];
let numList;
numList = [1, 2, 3, 4, 5];
let greaterThanTwo = numList.filter((num) => num > 2);
console.log(greaterThanTwo);
let a = nameList.find((elem) => elem === "João");
let sum = numList.reduce((acc, num) => acc + num);
console.log(sum);
let c = 2 /* Color.Blue */;
// tuples
// let tupleNumber: [number, number];
let tupleNumber;
function swapNumbers(num1, num2) {
    return [num2, num1];
}
tupleNumber = swapNumbers(10, 20);
tupleNumber[0];
tupleNumber[1];
// any (do not use :D)
let department;
// let department;
department = "IT";
department = 10;
//
//# sourceMappingURL=datatypes.js.map