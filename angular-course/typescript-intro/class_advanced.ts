import { Login, User } from "./interface";

// we can also use the import bellow, althogh we are using UserLogin as an alias so everything that comes from this import should have UserLogin.<something>
// import * as UserLogin from './interface'; 

// Let's use the same idea of Employee class in the class.ts file to try new things using interface
interface Address {
    street: string;
    city: string;
    state: string;
    pin: string;
}

class Employee2 implements Login {
    #id: number; // # is the native syntax to create private variables. Althogh "private" also works.
    name: string;
    address: Address;

    // static method
    static getEmployeeCount(): number {
        return 50;
    }

    // constructor
    constructor(id: number, name: string, address: Address) {
        this.#id = id;
        this.name = name;
        this.address = address;
    }

    // Getter and setter for id
    get empId(): number { return this.#id; }
    set empId(id: number) { this.#id = id; }

    // new function
    getNameWithAddress(): string {
        //return this.name + " " + this.address; // this might not work everytime to concat strings
        return `${this.name} stays at ${this.address}.`;
    }

    login(): User {
        return {name: "John", age: 30, id: 1, email: ""};
    }
}

let jose1 = new Employee2(2, "José", { street: "ABC", city: "Bagalore", state: "Karnataka", pin: "560076" });

