import chn.util.ConsoleIO;

public class IRSsim {

    private static final double FEDTAX = 0.15;
    private static final double FICA = 0.0765;
    private static final double STATETAX = 0.04;

    public static void doMyTaxReturns() {
        ConsoleIO cons = new ConsoleIO();
        double hourly, gross, net;
        int hours;

        System.out.println("Enter hours worked per week");
        hours = cons.readInt();

        System.out.println("Enter hourly salary");
        hourly = cons.readDouble();

        gross = hours * hourly;

        System.out.println("Your gross salary is: " + gross);

        net = gross;
        
        net *= (1 - FEDTAX);
        System.out.println("After Federal Income Tax: " + net);

        net *= 1 - FICA;
        System.out.println("After FICA Tax: " + net);
        
        net *= 1 - STATETAX;
        System.out.println("Net Pay (After State Tax): " + net);

        
    }
}