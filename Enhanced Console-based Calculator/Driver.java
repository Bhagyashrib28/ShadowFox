import java.util.*;
public class Driver 
{
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        Calculator cal = new Calculator();
        int ch ;
        do
        {
            System.out.println("------------ Menu ------------------ \n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Square Root\n6.Power\n7.Fahrenheit to Celsius\n8.Exit\nEnter your choice : ");
            ch =sc.nextInt();
            switch(ch)
            {
                
                case 1 :
                    cal.addition();
                    break;
                case 2 :
                    cal.subtraction();
                    break;
                case 3:
                    cal.multiplication();
                    break;
                case 4:
                    cal.division();
                    break;
                case 5:
                    cal.squareroot();
                    break;
                case 6:
                    cal.power();
                    break;
                case 7:
                    cal.fahrenheitToCelsius();
                    break;
                case 8:
                    System.out.println("Exit....");
                    break;
                default:
                    System.out.println("Invalid Choice ");


            }


        }while(ch<8);
    }

}
