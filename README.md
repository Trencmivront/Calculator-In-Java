# Calculator-In-Java
Calculator made by using Java Swing library.
## Features
### 1. Clear Function
- You can use the 'C' for clearing the text written in text box. But it doesn't remove last function's signature and last taken number if you used math function before it.
### 2. Result Function
- Use result function when you are done with the calculating. After using it, numbers will go initial state and math functions will be used last time to use last number in calculation.
### 3. Add Function
- After pressing the '+' button a sum function will take the number written and set TextBoxt to null. The number will be added to  firstNumber which we make our calculations on. Each time you use add button the number you wrote will be added to firstNumber.
### 4. Substract Function
- This button doesn't actually have it's own function. For this button I use sum function again but inside of the sum function I check whether '-' or '+' is pressed. I needed an initial value in order to substract last number from first one so I created a substract function and inside of that function I called sum function. Then I set isSubstract boolean value to true after sum function is called. This way I could have a first value by adding number to firstNumber and I will have a substract section inside of sum function so I could substract them when I pressed another button. Hehe, no comma must be frustrating.
