import java.util.Scanner;

public class SafeInput
{
    //static method definitions go here
    //are called with SafeInput.METHODNAME

    /**
     * a method that prompts for and returns a string response with at least one character
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt a prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't

        do
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();

            if (retString.isEmpty())
            {
                System.out.println("Please enter at least one character");
            }
        }while(retString.isEmpty());

        return retString;

    }

    /**
     * a method that prompts the user for and returns an integer value
     * @param pipe the Scanner used for input
     * @param prompt the prompt displayed to the user
     * @return any integer
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash  = pipe.nextLine();
                System.out.println("Please enter a valid number");
            }
        } while (!done);

        return retInt;
    }

    /**
     * a method that prompts the user for and returns a double value
     * @param pipe the Scanner used for input
     * @param prompt the prompt displayed to the user
     * @return any double value
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash  = pipe.nextLine();
                System.out.println("Please enter a valid number");
            }
        } while (!done);

        return retDouble;
    }

    /**
     * a method that prompts the user for and returns an integer value within a specified range
     * @param pipe the Scanner used for input
     * @param prompt the prompt displayed to the user
     * @param low the lowest acceptable integer (inclusive)
     * @param high the highest acceptable iteger (inclusive)
     * @return any integer value within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                if (retInt < low || retInt > high)
                {
                    System.out.println("You must enter an integer between " + low + " and " + high + ", not: " + retInt);
                }
                else
                {
                    done = true;
                }
            }
            else
            {
                trash  = pipe.nextLine();
                System.out.println("Please enter a valid number");
            }
        } while (!done);

        return retInt;
    }

    /**
     * a method that prompts the user for and returns a double within a given range
     * @param pipe the Scanner used for input
     * @param prompt the prompt displayed to the user
     * @param low the lowest acceptable double (inclusive)
     * @param high the highest acceptable double (inclusive)
     * @return any double within the given range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retDouble = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                if (retDouble < low || retDouble > high)
                {
                    System.out.println("You must enter a number between " + low + " and " + high + ", not: " + retDouble);
                }
                else
                {
                    done = true;
                }
            }
            else
            {
                trash  = pipe.nextLine();
                System.out.println("Please enter a valid number");
            }
        } while (!done);

        return retDouble;
    }

    /**
     * a method that prompts the user for y/n and returns true or false
     * @param pipe the Scanner used for input
     * @param prompt the prompt displayed to the user
     * @return true or false
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";
        boolean done = false;
        boolean retVal = false;

        do {
            System.out.print("\n" + prompt + "? [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase(); //trim removes any leading/trailing spaces

            if (response.equals("Y"))
            {
                retVal = true;
                done = true;
            } else if (response.equals("N"))
            {
                retVal = false;
                done = true;
            }
            else
            {
                done = false;
                System.out.println("Please enter a valid response [Y/N], not: " + response);
            }
        } while (!done);

        return  retVal;
    }

    /**
     * a method that prompts fror and returns a string that matches the provided expression
     * @param pipe the Scanner used for input
     * @param prompt the prompt displayed to the user
     * @param regEx
     * @return any value which matches the pattern provided by regEx
     */

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retVal = "";

        do {
            System.out.print("\n" + prompt + "[" + regEx + "]: ");
            retVal = pipe.nextLine();

            if (!retVal.matches(regEx))
            {
                System.out.println("You must enter a string that matches the pattern: " + regEx);
            }

        } while (!retVal.matches(regEx)); //this is where the problem is - watch the video back to see

        return retVal;

    }

    /**
     * a method that formats a pretty header when given a message
     * @param msg the message for within the header
     * @return the fully formatted header
     */
    public static String prettyHeader(String msg)
    {
        for (int a = 1; a <= 60; a++)
        {
            System.out.print("*");
        }

        int length =  msg.length();

        // 60 characters wide but there are 3 * on each end so 54 characters for the message

        int space = (54 - length)/2;

        System.out.printf("\n***");

        for (int b = 1; b <= space; b++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int c = 1; c <= space; c++)
        {
            System.out.print(" ");
        }

        System.out.printf("***\n");

        for (int a = 1; a <= 60; a++)
        {
            System.out.print("*");
        }

        return msg;
    }



}
