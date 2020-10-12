// Imports
import java.util.Scanner;

// Description:

/* 
This is an complicated code made by Kwanyoung Kim on 10/12/2020, 12:49 AM. 
It is about a robot assistant that can do tasks, calculations, etc.

-- Usage

Type in help for a list of avaliable commands.

You can either write the commands seperatly like:
addtask
0
Do homework

Or you can put them all in one line like:
addtask 0 Do homework

*/












class Main {
  public static void main(String[] args) {

   // Setup Major Values
   // Get the scanner
   Scanner GetScanner = new Scanner(System.in);
   boolean TurnedOff = false;
   // Array for the list of tasks that will be stored
   String[] TaskList = {"","","","",""};

  
   // Start the Assistant
   System.out.println("Hello, what can I help you with? Say help if you do not know how to use me.");

   // Wait for first response
   String NextLine = GetScanner.next();








  // Start a infinite loop of communication until shutdown
while(true){

  // Add a switch statement (I know how to use it since I can code java/javascript) This is a effective way to make commands instead of using if statement.
  switch(NextLine.toLowerCase()){ //switch(given value) (The given value is what you put in the scanner.)

    // Cases are the values to compare with the given value.

    // Command: Say hello
    case "hello":
      System.out.println("Hello :)");
      break;

    // Command: View your tasks
    case "tasks":
      if (TaskList[0] == "" && TaskList[1] == "" && TaskList[2] == "" && TaskList[3] == "" && TaskList[4] == "") {
        System.out.println("You do not have any tasks yet! Add a task by typing in addtask");
      }
      else{
        System.out.println("Here are your tasks:");
        // Goes through the array and print it's contents
        for (int i = 0; i < TaskList.length; i++){
          System.out.println("[" + i + "] " + TaskList[i]);
        }
      }
      break;

    // Command: Add a new task
    case "addtask":
      System.out.println("Where do you want to put your new task? Putting it on a existing task location will overwrite it! Accepts locations between 0 - 4");
      // Prevents the code from turning off when it gets a error. Possibly due to someone putting a double value or a string as the location of the task.
      try{
      int GetLocation = GetScanner.nextInt();
      if (GetLocation > 4){
        System.out.println("You cannot add/overwrite a task in a location above 4.");
        break;
      }
      else if (GetLocation < 0){
        System.out.println("You cannot add/overwrite a task in a location below 0.");
        break;
      }
      System.out.println("What will be your content?");
      String GetContent = GetScanner.next() + GetScanner.nextLine();

      TaskList[GetLocation] = GetContent;
      System.out.println("Successfully added/overwritted '" + GetContent + "' into task list " + GetLocation);
      }
      // This bottom code executes when it catches a error.
      catch (Exception e){
        System.out.println("That is not a valid input. :(");
        break;
      }
      break;  

    // Command: Remove a task
    case "removetask":
      System.out.println("What task do you want to remove? Accepts locations between 0 - 4");
      // Prevents the code from turning off when it gets a error. Possibly due to someone putting a double value or a string as the location of the task.
      try{
      int GetLocation = GetScanner.nextInt();
      if (GetLocation > 4){
        System.out.println("You cannot remove a task in a location above 4.");
        break;
      }
      else if (GetLocation < 0){
        System.out.println("You cannot remove a task in a location below 0.");
        break;
      }
      String OldTask = TaskList[GetLocation];
      TaskList[GetLocation] = "";
      System.out.println("Successfully removed '" + OldTask + "' from task list " + GetLocation);
      }
      // This bottom code executes when it catches a error.
      catch (Exception e){
        System.out.println("That is not a valid input. :(");
        break;
      }
      break;  

    // Command: Start a guessing game
    case "guessgame":
      System.out.println("Guess this number between 1 - 100, Type in 0 to cancel the game.");
      int GetGuess = 0;
      try {
      GetGuess = GetScanner.nextInt(); 
      }
      catch (Exception e){
        System.out.println("Not a valid input :(.");
      }

      // Randomizer from 1 - 100 (Has to be double, but I can convert it to int once it prints the correct number)
      double CorrectGuess = Math.floor((Math.random()*100)+1);
        
      while(GetGuess != CorrectGuess){
        try {
        if (GetGuess == 0){
          System.out.println("Canceled Guessing Game");
          break;
        }

      
        if (GetGuess < CorrectGuess){
          System.out.println("The Number Is Too Low 🤔");
        }
        else if (GetGuess > CorrectGuess){
          System.out.println("The Number Is Too High 🤔");
        }
     
        GetGuess = GetScanner.nextInt();
      }
      catch (Exception e){
        System.out.println("Not a valid input :(.");
      }

      }
      try {
      if (GetGuess == CorrectGuess){
      int ToIntCorrectGuess = (int) CorrectGuess;
      System.out.println("Great Job! The Number Is " + ToIntCorrectGuess + " :D");
      }
      }
      catch (Exception e){
        System.out.println("An error occured :(.");
      }
      
      
      break;

    // Command: Calculate 2 numbers (Works with +, -, x, /, %)
    case "calculate":
      int Num1;
      int Num2;
      try{
      System.out.println("What is your first number (Has to be int)");
      Num1 = GetScanner.nextInt(); 
      System.out.println("What is your second number (Has to be int)");
      Num2 = GetScanner.nextInt();
      
      int Oper;
      System.out.println("What is your operator [1 = add, 2 = subtract, 3 = multiply, 4 = divide, 5 = modulus");
      Oper = GetScanner.nextInt();
      // Using || which means or in a code
      if (Oper == 1 || Oper == 2 || Oper == 3 || Oper == 4|| Oper == 5){
      if (Oper == 1){
      System.out.println("Result: " + (Num1 + Num2));
      }
      else if (Oper == 2){
      System.out.println("Result: " + (Num1 - Num2));
      }
      else if (Oper == 3){
      System.out.println("Result: " + (Num1 * Num2));
      }
      else if (Oper == 4){
      System.out.println("Result: " + (Num1 / Num2));
      }
      else if (Oper == 5){
      System.out.println("Result: " + (Num1 % Num2));
      }
      }
      else{
        System.out.println("That is not a valid operator");
      }
      }
      catch (Exception e){
        System.out.println("A error occured. Possibly a invalid input :(.");
        break;
      }
      break;

     // Command: Start a rock paper scissor game
    case "rps":
      System.out.println("What is your weapon? 1 = Rock, 2 = Paper, 3 = Scissor");
      int YourWeaponID = 1;
      try {
      YourWeaponID = GetScanner.nextInt(); 
      }
      catch (Exception e){
        System.out.println("Not a valid input :(. Canceled game.");
      }
 
      if (YourWeaponID < 0 || YourWeaponID > 3) {
        System.out.println("That is a invalid weapon ID! Game canceled :(.");
        break;
      }
       
      double AIWeaponID = Math.floor((Math.random()*3)+1);
      
      String YourGrabWeaponName = "Rock";
      String AIGrabWeaponName = "Rock";

      if (YourWeaponID == 1){
        YourGrabWeaponName = "Rock";
      }
      else if (YourWeaponID == 2){
        YourGrabWeaponName = "Paper";
      }
      else if (YourWeaponID == 3){
        YourGrabWeaponName = "Scissor";
      }

      if (AIWeaponID == 1){
        AIGrabWeaponName = "Rock";
      }
      else if (AIWeaponID == 2){
        AIGrabWeaponName = "Paper";
      }
      else if (AIWeaponID == 3){
        AIGrabWeaponName = "Scissor";
      }

      System.out.println("~~~ Results ~~~");
      System.out.println("Your weapon: " + YourGrabWeaponName);
      System.out.println("AI's weapon: " + AIGrabWeaponName);
      System.out.println("~~~ Battle ~~~");
 

      if (YourWeaponID == AIWeaponID){
        System.out.println("You and the AI both chose " + AIGrabWeaponName + " and both got eliminated! Its a tie!");
      }
      else if (YourWeaponID == 1 && AIWeaponID == 2){
        System.out.println("Your puny, small " + YourGrabWeaponName + " got wrapped by AI's huge " + AIGrabWeaponName + "!");
      }
      else if (YourWeaponID == 1 && AIWeaponID == 3){
        System.out.println("Your massive, and magical " + YourGrabWeaponName + " broke AI's " + AIGrabWeaponName + " into microscopic pieces!");
      }
      else if (YourWeaponID == 2 && AIWeaponID == 1){
        System.out.println("Your grand, " + YourGrabWeaponName + "destroyed AI's worthless " + AIGrabWeaponName + "!");
      }
      else if (YourWeaponID == 2 && AIWeaponID == 3){
        System.out.println("Your flimsy " + YourGrabWeaponName + " got cut off by AI's indestructable " + AIGrabWeaponName + "!");
      }
      else if (YourWeaponID == 3 && AIWeaponID == 1){
        System.out.println("Your tiny, " + YourGrabWeaponName + " got smashed by AI's master programmed " + AIGrabWeaponName + "!");
      }
      else if (YourWeaponID == 3 && AIWeaponID == 2){
        System.out.println("Your razor bladed, " + YourGrabWeaponName + " sheared through AI's fragile " + AIGrabWeaponName + "!");
      }
      


      break;




    // Command: Displays a list of commands
    case "help":
      System.out.println("[Here are the list of commands:]");
      System.out.println("[calculate]");
      System.out.println("[hello]");
      System.out.println("[shutdown]");
      System.out.println("[guessgame]");
      System.out.println("[tasks]");
      System.out.println("[addtask]");
      System.out.println("[removetask]");   
      System.out.println("[rps]");     
      break;

    // Command: Shuts down and closes the robot assistant.
    case "shutdown":
      System.out.println("Are you sure you want to shutdown? This will clear every data including tasks. This is irreversible! (true, false)");

      // try catch will handle errors and prevent the code from shutting down
      try {
      boolean yesno = GetScanner.nextBoolean();

      if (yesno == true){
      TurnedOff = true;
      System.out.println("Shutting down and clearing data...");
      System.out.println("Assistant is successfully shutdown.");
      }

      else{
      TurnedOff = false;
      System.out.println("Canceled shutdown.");
      }

      }
      catch (Exception e) {
      TurnedOff = false;
        System.out.println("That is a invalid input :(. Has to be a boolean. Canceled Shutdown.");
      }
      break;





    // When every case doesn't match with the given value, it will execute the script in default. This is like else in a if statement.
    default:
      //System.out.println("That is not a valid command");
  }

    // Breaks the code and closes the scanner when value TurnedOff is set to true. The only way to set that value to true is when you do the shutdown command.
    if (TurnedOff == true){
      // Close the scanner
      GetScanner.close();
      break;
    }
    // Else tries to get the next line of the scanner.
    else {
      NextLine = GetScanner.next();
    }   
}

    
  }
}