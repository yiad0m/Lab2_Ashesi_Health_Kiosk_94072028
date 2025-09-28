import java.util.Scanner;

public class HealthKiosk{
    public static void main(String[] args){
        //Task 1
        //Creation of scanner object and declaration of variables.
        Scanner input = new Scanner(System.in);
        char route;
        int healthMetric;
        double weight=0;
        double bmi=0;
        double height=0;
        double dosage = 0;
        double tablets = 0;
        double degrees = 0;
        double sinDegrees = 0;
        double cosDegrees = 0;
        char alphId;
        int alphCode;
        int randomNum1;
        int randomNum2;
        int randomNum3;
        int randomNum4;
        String id;
        String name;
        char nameAlph0;
        String twoChars;
        char shifted;
        String dispCode;
        int roundedBmi= 0;
        int roundedMetric = 0;

        //Welcome note
        System.out.println("Welcome to the java health kiosk!");

        //Service Router code
        System.out.println("Please enter a service code (P/L/T/C):");
         route = input.next().charAt(0);
         route = Character.toUpperCase(route);

        //service code routing
        switch(route){
            case 'P':
            System.out.println("Go to Pharmacy Desk");
            break;

            case 'L':
            System.out.println("Go to Lab Desk");
            break;

            case 'T':
            System.out.println("Go to Triage Desk");
            break;

            case 'C':
            System.out.println("Go to counseling Desk");
            break;

            default:
            System.out.println("Invalid service code");

        }

        //Task2
        //Mini Health Metric
        if (route == 'T'){
            System.out.println("Welcome to the triage desk");
        }
        if (route == 't'||route == 'T'){
            System.out.println("Please enter your desired health metric (1/2/3):");
            healthMetric = input.nextInt();

            //Metric selection
            switch(healthMetric){

                case 1://BMI calculation
                System.out.println("Please enter your weight(kg):");
                weight = input.nextDouble();
                System.out.println("Please enter your height(m):");
                height = input.nextDouble();
                bmi = weight / Math.pow(height,2);
                roundedBmi = (int)Math.round(bmi);
                System.out.println("Your BMI is: " + Math.round(bmi * 10)/10.0 );
                
                if (bmi < 18.5){
                    System.out.println("Underweight");
                }else if (bmi>=18.5 && bmi<= 24.9){
                    System.out.println("Normal");
                }else if(bmi>=25.0 && bmi<= 29.9){
                    System.out.println("Overweight");
                }else{
                    System.out.println("Obese");
                }
                break;


                case 2://Dosage roundup
                System.out.println("Please enter the required dosage(mg): ");
                dosage = input.nextDouble();
                tablets = (int) Math.ceil(dosage /250);
                System.out.println("The number of tablets you must take are : "+ tablets);
                break;
                
                case 3://trig helper
                System.out.println("Please enter an angle in degrees: ");
                degrees = (input.nextDouble()/180)* Math.PI;
                sinDegrees = Math.sin(degrees);
                cosDegrees = Math.cos(degrees);
                System.out.println("The sin of the angle entered is: " + sinDegrees );
                System.out.println("The cos of the angle entered is: " + cosDegrees );


            }

        }

        
        //Task 3
        //Random number generator for alphabets unicode
        alphCode = (int)(Math.random()* 26) + 65; //Only produces random number between 65 to 90 inclusive
        alphId = (char) alphCode;

        //Generates random numbers between 3 and 9 inclusive.
        randomNum1 =(int)(Math.random()* 7) + 3;
        randomNum2= (int)(Math.random()* 7) + 3;
        randomNum3=(int)(Math.random()* 7) + 3;
        randomNum4=(int)(Math.random()* 7) + 3;

        //Displays student ID
        System.out.println("Your student ID is: ");
        id = Character.toString(alphId) + randomNum1 + randomNum2 + randomNum3 + randomNum4;
        System.out.println(id);

        //validation of ID generated
        if( id.length() == 5 && Character.isLetter(id.charAt(0)) && Character.isDigit(id.charAt(1)) && Character.isDigit(id.charAt(2)) && Character.isDigit(id.charAt(3)) && Character.isDigit(id.charAt(4))){
            System.out.print("ID OK \n");
        }else{
            System.out.println("Invalid: first char must be a letter, Invalid: last 4 must be digits, or Invalid length");
        }
   
        //Task 4
        //"Secure" Display Code
        //Take student name
        System.out.println("Please enter you name: ");
        input.nextLine();
        name = input.nextLine();
        nameAlph0 = Character.toUpperCase(name.charAt(0));
        shifted = (char)('A' + (nameAlph0 - 'A' + 2) % 26);
        twoChars = Integer.toString(randomNum3) + Integer.toString(randomNum4);
        dispCode = shifted + twoChars + Integer.toString(roundedBmi);
        System.out.println("Your display code is: ");
        System.out.println(dispCode);

        //Task5
        //Human friendly summary
        String serviceType = "";
        switch (route) {
            case 'P': serviceType = "PHARMACY"; break;
            case 'L': serviceType = "LAB"; break;
            case 'T': serviceType = "TRIAGE"; break;
            case 'C': serviceType = "COUNSELING"; break;
        }

        if (route == 'T') {
            System.out.println(serviceType + " | ID=" + id + " | Metric=" + roundedMetric + " | Code=" + dispCode);
        } else {
            System.out.println(serviceType + " | ID=" + id + " | Code=" + dispCode);
        }


    }
}