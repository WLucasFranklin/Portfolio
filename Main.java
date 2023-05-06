import java.util.*;

public class Main {
    public static void main( String[] args ) {

        //Present user options, and make them choose.
        Scanner option = new Scanner( System.in );
        System.out.println( "Enter a Number\n" + ( "-" ).repeat( 15 ) );
        System.out.println( "1) Stack\n2) Class\n3) Recursion" );
        boolean badData = true;
        do {
            String choice = option.nextLine();

            //Ensure choice is valid.
            try {
                int uInput = Math.abs( Integer.parseInt( choice ) );
                if( uInput > 3 ){
                    uInput = ( uInput % 3 ) + 1;
                }

                System.out.println( "\nYou chose: " + uInput + "\n\n" );
                badData = false;

                //Utilizes stackTest()
                if( uInput == 1 ) {
                    System.out.println( "\nStack\n" + "-".repeat(5) );

                    String [] array = {"1", "2", "3" ,"4" ,"5" ,"6" ,"7"};
                    stackTest(array);

                //Utilizes Test.Java
                } else if( uInput == 2 ) {
                    System.out.println( "\nClass\n" + "-".repeat(5) );
                    Test parasite = new Test( "Anopheles", 430, "Falciparum" );

                    System.out.println( "Genus of Mosquito: " + parasite.getMosquito() );
                    System.out.println( "Number of Species: " + parasite.getSpecies() );
                    System.out.println( "Plasmodium type:   " + parasite.getPlasmodium() );

                //Utilizes factorial()
                } else if( uInput == 3 ) {
                    System.out.println( "\nRecursion\n" + "-".repeat(9) );
                    int number = 9;

                    System.out.println( "9! = " + factorial(number) );
                }

            } catch( Exception e ) {
                System.err.println( "Error: \"" + choice +"\" is not a number. You must enter a number." );
            }
        } while( badData==true );

    }

    /*
    Method that runs data through a stack.
    Shows what data looks like when going in vs. coming out.
     */
    public static String[] stackTest( String [] x ){

        Stack<String> stack = new Stack<>();
        int count = 0;

        System.out.print( "Data pushed: " );
        for( String i:x ){
            System.out.print( x[count] );
            stack.push( x[count] );
            count++;
        }

        String result = "";
        for( String i:x ){
            result += stack.pop();
        }
        System.out.print( "\nData popped: " );
        System.out.println( result );
        return x;
    }

    /*
    Method using recursion to calculate the factorial of an integer.
     */
    public static int factorial( int x ){
        if ( x > 0 ) {
            return x * factorial( x - 1 );
        } else {
            return 1;
        }
    }

}