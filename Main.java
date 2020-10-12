import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner GetScanner = new Scanner(System.in);


  
  
   System.out.println("Hello, what can I help you with? Say help if you do not know how to use me.");

  
   String NextLine = GetScanner.next();
   boolean SaidBye = false;









    while(true){

    switch(NextLine.toLowerCase()){

      case "hello":
      System.out.println("Hello");
      break;











      case "calculate":
      int Num1;
      int Num2;

      System.out.println("What is your first number");
      Num1 = GetScanner.nextInt(); 
      System.out.println("What is your second number");
      Num2 = GetScanner.nextInt();
      
      int Oper;
      System.out.println("What is your operator [1 = add, 2 = subtract, 3 = multiply, 4 = divide, 5 = modulus");
      Oper = GetScanner.nextInt();
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
      break;

      case "help":
      System.out.println("Here are the list of commands:");
      System.out.println("calculate");
      System.out.println("hello");
      System.out.println("bye");


      break;

      case "bye":
      SaidBye = true;
      System.out.println("Goodbye");
      break;
      default:
      System.out.println("That is not a valid command");
    }

    NextLine = GetScanner.next();
    if (SaidBye == true){
      break;
    }
    }





























  }
}