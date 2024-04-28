"use strict";
/*
 * Get to know interfaces. They actually do not exist in javascript. It is prefered to use class instead of interfaces
 */
Object.defineProperty(exports, "__esModule", { value: true });
let user = { name: "John", age: 30, id: 1, email: "asdf@asd.com" };
user.name;
user.email;
// different ways of accessing User params
let { name: userName, email } = { name: "John", age: 30, id: 1, email: "asdf@asd.com" }; // "userName" is the new alias of "name"
console.log(userName);
console.log(email);
let employee = { name: "John", id: 1, email: "", salary: 1000 };
let users = [{ name: "João", id: 1, email: "" },
    { name: "Joana", id: 2, email: "" },
    { name: "Jose", id: 3, email: "" }];
let [user1, user2, ...restUsers] = [{ name: "João", id: 1, email: "" },
    { name: "Joana", id: 2, email: "" },
    { name: "Jose", id: 3, email: "" },
    { name: "Paulo", id: 4, email: "" },
    { name: "Rosa", id: 5, email: "" }];
console.log(user1);
console.log(user2);
console.log(restUsers);
//# sourceMappingURL=interface.js.map