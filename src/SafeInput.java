import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SafeInput {

    /**
     * Get a non-zero length String
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

        }
        while (retString.length() == 0);
        return retString;
    }

    /**
     * Get any integer value with validation
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retValue = 0;
        boolean validInput = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retValue = pipe.nextInt();
                validInput = true;
            }
            else
            {
                System.out.println("Invalid input. Please enter an integer.");
            }
            pipe.nextLine(); // clear buffer
        }
        while (!validInput);
        return retValue;
    }

    /**
     * Get any double value with validation
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retValue = 0;
        boolean validInput = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                validInput = true;
            }
            else
            {
                System.out.println("Invalid input. Please enter a number.");
            }
            pipe.nextLine(); // clear buffer
        }
        while (!validInput);
        return retValue;
    }

    /**
     * Get an integer within an inclusive range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retValue = 0;
        boolean validInput = false;
        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retValue = pipe.nextInt();
                if (retValue >= low && retValue <= high)
                {
                    validInput = true;
                }
                else
                {
                    System.out.println("Input out of range. Try again.");
                }
            }
            else
            {
                System.out.println("Invalid input. Please enter an integer.");
            }
            pipe.nextLine(); // clear buffer
        }
        while (!validInput);
        return retValue;
    }

    /**
     * Get a double within an inclusive range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retValue = 0;
        boolean validInput = false;
        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retValue = pipe.nextDouble();
                if (retValue >= low && retValue <= high)
                {
                    validInput = true;
                }
                else
                {
                    System.out.println("Input out of range. Try again.");
                }
            }
            else
            {
                System.out.println("Invalid input. Please enter a number.");
            }
            pipe.nextLine(); // clear buffer
        }
        while (!validInput);
        return retValue;
    }

    /**
     * Get Yes/No confirmation
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response;
        boolean valid = false;
        boolean result = false;
        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
            if (response.equals("Y"))
            {
                result = true;
                valid = true;
            }
            else if (response.equals("N"))
            {
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
        while (!valid);
        return result;
    }

    /**
     * Get a String matching a RegEx pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String input = "";
        boolean valid = false;
        Pattern pattern = Pattern.compile(regEx);
        do
        {
            System.out.print("\n" + prompt + ": ");
            input = pipe.nextLine();
            Matcher match = pattern.matcher(input);
            if (match.matches())
            {
                valid = true;
            }
            else
            {
                System.out.println("Input does not match pattern. Try again.");
            }
        }
        while (!valid);
        return input;
    }

    /**
     * Print a centered pretty header message
     */
    public static void prettyHeader(String msg)
    {
        final int totalWidth = 60;
        int msgLen = msg.length();
        int totalPadding = totalWidth - msgLen - 6; // minus 6 for stars and spaces
        int padLeft = totalPadding / 2;
        int padRight = totalPadding - padLeft;

        // Top border
        for (int i = 0; i < totalWidth; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        // Center line
        System.out.print("***");
        for (int i = 0; i < padLeft; i++) System.out.print(" ");
        System.out.print(msg);
        for (int i = 0; i < padRight; i++) System.out.print(" ");
        System.out.println("***");

        // Bottom border
        for (int i = 0; i < totalWidth; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}
