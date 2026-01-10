import java.util.Scanner;
public class Calculator
{
    double num,num1,num2;
    public void singleInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num : ");
        num= sc.nextDouble();
        
    }
    public void doubleInputs()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num1 : ");
        num1= sc.nextDouble();
        System.out.println("Enter num2 : ");
        num2 = sc.nextDouble();
    }
    public void addition()
    {
        doubleInputs();
        System.out.println("Addition is : "+(num1+num2));
    }
    public void subtraction()
    {
        doubleInputs();
        System.out.println("Subtraction is : "+(num1-num2));
    }
    public void multiplication()
    {
        doubleInputs();
        System.out.println("Multiplication is : "+(num1*num2));
    }
    public void division()
    {

        doubleInputs();
        if(num2!=0)
            System.out.println("Division is : "+(num1/num2));
        else
            System.out.println("Division by zero is not allowed.");
    }

    
    public void squareroot()
    {
        singleInput();
        if(num >= 0)
        System.out.println("Square root of " + num + " is : " + Math.sqrt(num));
        else
        System.out.println("Square root of negative number is not allowed.");
        
    }
    public void power()
    {
        doubleInputs();
        System.out.println(num1+" raised to "+num2+" is : "+Math.pow(num1,num2));
    }
    public void fahrenheitToCelsius()
    {
        singleInput();
        System.out.println(num+" Fahrenheit in Celsius is : "+((num-32)*5/9));
    }

}