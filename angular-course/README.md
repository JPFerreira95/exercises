# Origin
This project was implemented by following this course in youtube: https://youtu.be/3qBXWUpoPHo?si=_2Lahi2yTxshZJF1

# Installation
 - Install Node (https://nodejs.org/en)
 - ```npm init``` to create a package.json
 - Install Typescript ```npm install -g typescript```
 - Initialize Typescript ```tsc --init```

# Typescript

In the typrescript-intro project, we have some examples on how to use typescript.

## Data Types:
 - string
 - number
 - boolean
 - array
 - enum
 - tuple
 - any
 - void
 - never

## How to run?
1. Compile while on the folder using ```tsc```. (This will create new .js files for the .ts files created)
2. Run file "datatypes.js" using command ```node <datatypes>```.


# hotel-inventory-app

In the folder hotel-inventory-app there's a project with our angular code.

## How to run?

To run it will have to run the following commands:

To compile:
```shell
tsc
```

To run and open browser:
```shell
ng serve -o
```

## Get to know angular

### Angular properties

In our angular.json we have our properties configured for angular.

If we take a closer look, the prefix was changed from ```app```to ```hinv``` which means "Hotel Inventory". After this change it was necessary to update the _app.component.ts_ file in ```selector: 'app-root'```to ```selector: 'hinv-root'```.
Not only that in the _index.html_ it was necessary to change ```<app-root></app-root>``` to ```<hinv-root></hinv-root>```.

### How to create our own component?

To create our _rooms_ component we had to run the command:
```shell
ng g c rooms
```
Which means:\
ng -> the command for angular\
g -> generate\
c -> component\
rooms -> the name of our component\

### Event Binding

In java script we write ```<button onClick = "functionName">``` in angular it changes to the _banana syntax_ ```<button (click)="functionName">```.
