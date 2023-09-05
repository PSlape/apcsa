class easta {

    private static final int YEAR = 2023;

    private static final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    
    static double a = YEAR % 19;
    static double b = YEAR / 100;
    static double c = YEAR % 100;
    static double d = b / 4;
    static double e = b % 4;
    static double f = (b+8) / 25;
    static double g = (b - f + 1) / 3;
    static double h = (19 * a + b - d - g + 15) / 30;
    static double i = c / 4;
    static double k = c % 4;
    static double r = (32 + 2 * e + 2 * i - h - k) / 7;
    static double m = (a + 11 * h + 22 * r) / 451;
    static int n = (int) (h + r - 7 * m + 114) / 31;
    static int p = (int) (h + r - 7 * m + 114) % 31;

    public static void whenIsEasta() {
        
        if(months.length != 12) {
            System.out.println("Fix the months");
        }
        System.out.println("Year = " + YEAR);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        System.out.println("g = " + g);
        System.out.println("h = " + h);
        System.out.println("i = " + i);
        System.out.println("k = " + k);
        System.out.println("r = " + r);
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        System.out.println("p = " + p);
        
        p += 1;
        System.out.println("Easter in " + YEAR + " falls on " + months[n-1] + " " + p + ordinalEnding(p));
    }

    public static String ordinalEnding(int num) {
        int toCheck = num % 10;

        if(num == 11 || num == 12 || num == 13) {
            return "th";
        }

        if(toCheck == 1) {
            return "st";
        }
        if(toCheck == 2) {
            return "nd";
        }
        if(toCheck == 3) {
            return "rd";
        }

        return "th";
    }
}