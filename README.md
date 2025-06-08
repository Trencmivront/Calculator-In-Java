# Calculator-In-Java
Calculator made by using Java Swing library.
## Features
### 1. Clear Function
- You can use the 'C' for clearing the text written in text box. It will assing 0 to the firstNumber and all functions will be gone to initial. 
### 2. Result Function
- Use result function when you are done with the calculating. After using it, numbers will go initial state and math functions will be used last time to use last number in calculation. The result will be showen in textBox and you can continue calculating until you clear the textBox.
### 3. Add Function
- After pressing the '+' button the calculate function will take the number written and set TextBoxt to null. The number will be added to  firstNumber which we make our calculations on. Each time you use add button the number you wrote will be added to firstNumber.
### 4. Substract Function
- This button doesn't actually have it's own function. For this button I use calculate function again but inside of the calculate function, I check whether '-' or '+' is pressed. I needed an initial value in order to substract last number from first one so I created a substract function and inside of that function I called calculate function. Then I set isSubstract boolean value to true after calculate function is called. This way I could have a first value by adding number to firstNumber and I will have a substract section inside of calculate function so I could substract them when I pressed another button. Hehe, no comma must be frustrating.
### 5. Multiply Function
- Same like substract function it is an insect in calculate function. Works same as well.
### 6. Division Function
- Again again it's working like substract function. You know there is actually one function for all of the calculations. Because every one of them needs the sum at first.
