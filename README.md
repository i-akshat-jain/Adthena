# Adthena Basket Pricing Application

This is a command-line application written in Scala that calculates the subtotal, discounts, and total price of a basket of items based on special offers. The application uses Git for version control.

## Prerequisites

Before running the application, ensure that you have the following minimum prerequisites installed on your system:

- Java (version 8 or higher)
- Scala (version 2.11 or higher)
- sbt (version 1.8 or higher)
- Git

## Installation

To install and run the application locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/i-akshat-jain/Adthena.git

   
2. Navigate to the project directory:
   ```bash
   cd Adthena
   
3. Run the Scala Build Tool shell by running:
   ```bash
   sbt

4. Running the Application
   Compile the application by using the following command in the shell:
   ```bash
   compile

### Running the Application. 
   
1. To run the application, use the command "run --item1 --item2 --item3 ..." for running the application.
   Replace --item1, --item2, --item3, etc., with the names of the items in your basket i.e. "Apples, Milk, Bread, Soup" in sbt shell.

   ```bash
   run Apples Soup Milk Bread Soup 

### Testing the Application
  
1. To run the test suite, use the following command. It will automatically run all the pre-structured test cases. 
   ```bash
   test

2. If you want to run a specific Test Case file, then run the following command in the sbt shell:
   ```bash
   Test / testOnly *BasketPricingTest


This command will run all the predefined test cases and display the results. 

By following these instructions, you can effectively use, test, and extend the Adthena Basket Pricing Application to suit your requirements.
