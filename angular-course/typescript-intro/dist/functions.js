"use strict";
/*
 * Multiple ways of building functions
 */
// declaring the function
function add(num1, num2) {
    return num1 + num2;
}
console.log(add(2, 3));
// contant with lambda expression
const sub = (num1, num2) => num1 - num2;
console.log(sub(2, 3));
// constant with function
const mult = function (num1, num2) {
    return num1 * num2;
};
console.log(mult(2, 3));
// function with optional parameter
function add1(num1, num2, num3) {
    return num3 ? num1 + num2 + num3 : num1 + num2;
}
console.log(add1(1, 2, 3));
console.log(add1(1, 2));
// function with required parameter. If num3 is not filled, the default value will be 10
const sub1 = (num1, num2, num3 = 10) => num1 - num2 - num3;
console.log(sub1(2, 3));
console.log(sub1(2, 3, 1));
// Rest parameters
function add2(num1, num2, ...num3) {
    return num1 + num2 + num3.reduce((a, b) => a + b, 0);
}
let numbers = [3, 4, 5, 6, 7];
console.log(add2(1, 2, ...numbers));
console.log(add2(1, 2, 3, 4, 5, 6, 7));
// function to concat generic types. In other languages like Java the "Type" is the same as "T"
function getItems(items) {
    return new Array().concat(items);
}
let concatResult = getItems([1, 2, 3, 4, 5]);
let concatString = getItems(["a", "b", "c", "d", "e"]); // getItems<string>(["a","b","c","d","e"])
//# sourceMappingURL=functions.js.map