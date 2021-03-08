/*
                                                ****************************
                                                *       SUBMITTED BY       *
                                                *      SHIAM PRODHAN       *
                                                *        181014123         *
                                                *       SECTION-01         *
                                                * **************************


*/
import java.util.Scanner;
public class HeightConverter_Using_String
{
    static Scanner input = new Scanner(System.in);
    static double feet2cm;
    static double inch2cm;
    static double centimeter;
    static double feet;
    static double inches;
    static double inchesandfeet;
    static double remainder,round;

    public static void main(String[] args) {
        System.out.println("********************************************************************************************");
        boolean success;
        int counter1 = 0, counter2 = 0, counter4 = 0;
        String str;
        success = false;

        do {
            try
            {
                System.out.print("Give Your Input Here (Your Height) : ");
                String Input = input.nextLine();
                String sub = "";
                String sub1 = "";
                boolean isfound = Input.indexOf("cm") != -1 ? true : false;
                boolean isfound1 = Input.indexOf("\"") != -1 ? true : false;
                boolean isfound2 = Input.indexOf("'") != -1 ? true : false;
                if (isfound == true)
                {
                    sub = Input.substring(0, (Input.length() - 2));
                    //System.out.println("Result : " + sub);
                    centimeter = Double.parseDouble(sub);
                    if (centimeter <= 0) {
                        throw new InputException();
                    } else if (isfound == false) {
                        throw new InputException();
                    }
                    success = true;
                    inchesandfeet = centimeter / 30.48;
                    remainder = (centimeter * 0.3937008) % 12;
                    round = Math.round(remainder * 100) / 100.0;
                    System.out.println("\n" + "Your OutPut Is (In Feet & Inches) : " + (int) inchesandfeet + "'" + round + "\"" + "  (" + (int) inchesandfeet + " feet " + round + " inches)");

                }
                else if (isfound1 == true || isfound2 == true)
                {


                    for (int i = 0; i < Input.length(); i++) {
                        char a = Input.charAt(i);
                        if (a == '\'') {
                            break;
                        } else if (a == '"') {
                            break;
                        } else {
                            counter1++;
                        }
                    }
                    sub = Input.substring(0, counter1);
                    feet = Double.parseDouble(sub);
                    feet2cm = feet * 30.48;
                    if (isfound1 == true && isfound2 == false)
                    {
                        inches = Double.parseDouble(sub);
                        inch2cm = inches * 2.54;
                        counter4++;
                        feet2cm = 0;
                        if(feet<0)
                        {
                            inches=0;
                        }
                    }
                    if (Input.length() > (counter1 + 1)) {
                        sub1 = Input.substring((counter1 + 1), (Input.length() - 1));
                        inches = Double.parseDouble(sub1);
                        inch2cm = inches * 2.54;
                        counter4++;
                    }
                    if (feet <= 0 && inches <= 0||(feet<=0 || inches<=0)) {
                        throw new InputException();
                    }
                    success = true;

                    if (counter4 == 1) {
                        System.out.println("\n"+ "Your OutPut Is (In Centimeter) : " + (feet2cm + inch2cm) + " cm");
                    } else {
                        System.out.println("\n" + "Your OutPut Is (In Centimeter) : " + (feet2cm) + "cm");
                    }
                } else {
                    throw new InputException();
                }
            } catch (InputException e) {
                counter1=0;
                counter2=0;
                counter4=0;
                System.out.println("****Exception Handeled! You have entered eithe a Negative \nNumber or Zero or a Wrong Input! Please enter correct input!****");
            }
        }
        while (!success);
        System.out.println("********************************************************************************************");
    }
}
class InputException extends Exception
{

}