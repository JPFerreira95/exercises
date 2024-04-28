"use strict";
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
var _Employee2_id;
Object.defineProperty(exports, "__esModule", { value: true });
class Employee2 {
    // static method
    static getEmployeeCount() {
        return 50;
    }
    // constructor
    constructor(id, name, address) {
        _Employee2_id.set(this, void 0); // # is the native syntax to create private variables. Althogh "private" also works.
        __classPrivateFieldSet(this, _Employee2_id, id, "f");
        this.name = name;
        this.address = address;
    }
    // Getter and setter for id
    get empId() { return __classPrivateFieldGet(this, _Employee2_id, "f"); }
    set empId(id) { __classPrivateFieldSet(this, _Employee2_id, id, "f"); }
    // new function
    getNameWithAddress() {
        //return this.name + " " + this.address; // this might not work everytime to concat strings
        return `${this.name} stays at ${this.address}.`;
    }
    login() {
        return { name: "John", age: 30, id: 1, email: "" };
    }
}
_Employee2_id = new WeakMap();
let jose1 = new Employee2(2, "José", { street: "ABC", city: "Bagalore", state: "Karnataka", pin: "560076" });
//# sourceMappingURL=class_advanced.js.map