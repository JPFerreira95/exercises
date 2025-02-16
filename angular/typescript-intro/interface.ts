/*
 * Get to know interfaces. They actually do not exist in javascript. It is prefered to use class instead of interfaces
 */

// We can define and interface with parameters
export interface User { // The export keywork means that this particular interface can be used outside of this class
    name: string;
    age?: number; // The "?"" makes age an optional property
    id: number;
    email: string;
}

let user: User = { name: "John", age: 30, id: 1, email: "asdf@asd.com" };
user.name;
user.email;

// different ways of accessing User params
let { name: userName, email }: User = { name: "John", age: 30, id: 1, email: "asdf@asd.com" }; // "userName" is the new alias of "name"
console.log(userName);
console.log(email);

interface Employees extends User {
    salary: number;
}

let employee: Employees = { name: "John", id: 1, email: "", salary: 1000 };


export interface Login {
    login(): User;
}


let users: User[] = [{ name: "João", id: 1, email: "" },
{ name: "Joana", id: 2, email: "" },
{ name: "Jose", id: 3, email: "" }];

let [user1, user2, ...restUsers]: User[] = [{ name: "João", id: 1, email: "" },
{ name: "Joana", id: 2, email: "" },
{ name: "Jose", id: 3, email: "" },
{ name: "Paulo", id: 4, email: "" },
{ name: "Rosa", id: 5, email: "" }];

console.log(user1);
console.log(user2);
console.log(restUsers);

