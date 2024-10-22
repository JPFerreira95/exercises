/*
 * In this file we will show how to operate classes.
 * One importante note is that in typescript we cannot have multiple different constructors. Which is why there are two different classes with the same parameters
 */

class Employee {
    id!: number; // If we put "id: number" appears an error because of no constructor. That's why there's a "!"".
    name!: string;
    address!: string;
}

class Employee1 {
    #id: number; // # is the native syntax to create private variables. Althogh "private" also works.
    name: string;
    address: string;

    // static method
    static getEmployeeCount(): number {
        return 50;
    }

    // constructor
    constructor(id: number, name: string, address: string) {
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
}

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

    constructor(id: number, name: string, address: string) {
        super(id, name, address);
    }

    getNameWithAddress(): string {
        return `${this.name} is a managet who stays at ${this.address}.`;
    }
}

let mike = new Manager(1, "Mike", "Cherise Drive");
console.log(mike.getNameWithAddress());
