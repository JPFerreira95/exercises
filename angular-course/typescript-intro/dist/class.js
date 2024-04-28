"use strict";
/*
 * In this file we will show how to operate classes.
 * One importante note is that in typescript we cannot have multiple different constructors. Which is why there are two different classes with the same parameters
 */
var __classPrivateFieldSet = (this && this.__classPrivateFieldSet) || function (receiver, state, value, kind, f) {
    if (kind === "m") throw new TypeError("Private method is not writable");
    if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a setter");
    if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot write private member to an object whose class did not declare it");
    return (kind === "a" ? f.call(receiver, value) : f ? f.value = value : state.set(receiver, value)), value;
};
var __classPrivateFieldGet = (this && this.__classPrivateFieldGet) || function (receiver, state, kind, f) {
    if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
    if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
    return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
};
var _Employee1_id;
class Employee {
}
class Employee1 {
    // static method
    static getEmployeeCount() {
        return 50;
    }
    // constructor
    constructor(id, name, address) {
        _Employee1_id.set(this, void 0); // # is the native syntax to create private variables. Althogh "private" also works.
        __classPrivateFieldSet(this, _Employee1_id, id, "f");
        this.name = name;
        this.address = address;
    }
    // Getter and setter for id
    get empId() { return __classPrivateFieldGet(this, _Employee1_id, "f"); }
    set empId(id) { __classPrivateFieldSet(this, _Employee1_id, id, "f"); }
    // new function
    getNameWithAddress() {
        //return this.name + " " + this.address; // this might not work everytime to concat strings
        return `${this.name} stays at ${this.address}.`;
    }
}
_Employee1_id = new WeakMap();
let john = new Employee();
john.id = 1;
john.name = 'John';
john.address = "Highway 71";
let jose = new Employee1(2, "José", "Braga");
console.log(john);
console.log(jose);
console.log(jose.empId);
jose.empId = 100; // This will call the set method
console.log(jose.empId);
console.log(jose.getNameWithAddress());
// for static methods we acess the method like this
Employee1.getEmployeeCount();
// New sub-class
class Manager extends Employee1 {
    constructor(id, name, address) {
        super(id, name, address);
    }
    getNameWithAddress() {
        return `${this.name} is a managet who stays at ${this.address}.`;
    }
}
let mike = new Manager(1, "Mike", "Cherise Drive");
console.log(mike.getNameWithAddress());
//# sourceMappingURL=class.js.map