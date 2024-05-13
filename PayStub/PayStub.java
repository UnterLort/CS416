import java.util.Scanner;

/**
 * 
 * @author Kyle Stewart
 * @version 1
 */
public class PayStub {
    private String name;
    private int anniversaryMonth;
    private int anniversaryYear;
    private int hoursWorked;
    private String jobTitle;
    private double payRate;
    private int currentMonth;
    private int currentYear;

    /**
     * 
     * Makes 'Paystub' object.
     */
    public PayStub() {
    }

    /**
     * 
     * @param name             name of employee
     * @param anniversaryMonth month worked
     * @param anniversaryYear  year worked
     * @param hoursWorked      hours worked
     * @param jobTitle         job position title
     * @param payRate          payrate
     */
    public PayStub(String name, int anniversaryMonth, int anniversaryYear, int hoursWorked, String jobTitle,
            double payRate) {
        this.name = name;
        this.anniversaryMonth = anniversaryMonth;
        this.anniversaryYear = anniversaryYear;
        this.hoursWorked = hoursWorked;
        this.jobTitle = jobTitle;
        this.payRate = payRate;
        this.currentMonth = 1;
        this.currentYear = 2019;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return month
     */
    public int getMonth() {
        return anniversaryMonth;
    }

    /**
     * 
     * @return year
     */
    public int getYear() {
        return anniversaryYear;
    }

    /**
     * 
     * @return hours worked
     */
    public int getHours() {
        return hoursWorked;
    }

    /**
     * 
     * @return job title
     */
    public String getTitle() {
        return jobTitle;
    }

    /**
     * 
     * @return payrate
     */
    public double getPayRate() {
        return payRate;
    }

    /**
     * 
     * @return months worked
     */
    public int numMonthsWorked() {
        int monthsWorked = (currentYear - anniversaryYear) * 12 + (currentMonth - anniversaryMonth);
        return monthsWorked;
    }

    /**
     * 
     * @return vacation rate
     */
    public double vacationHours() {
        double vacationRate = 8.25;
        double vacationHours = numMonthsWorked() * vacationRate;
        return Math.round(vacationHours * 100.0) / 100.0;
    }

    /**
     * 
     * @return gross pay
     */
    public double grossPay() {
        double grossPay = hoursWorked * payRate;
        return Math.round(grossPay * 100.0) / 100.0;
    }

    /**
     * 
     * @return retirement rate
     */
    public double retHold() {
        double retirementRate = 5.2;
        double retirementWithholding = grossPay() * (retirementRate / 100);
        return Math.round(retirementWithholding * 100.0) / 100.0;
    }

    /**
     * 
     * @return tax rate
     */
    public double tax() {
        double taxRate = 28.0;
        double taxableIncome = grossPay() - retHold();
        double taxWithholding = taxableIncome * (taxRate / 100);
        return Math.round(taxWithholding * 100.0) / 100.0;
    }

    /**
     * 
     * @return net pay, total income
     */
    public double netPay() {
        double netPay = grossPay() - retHold() - tax();
        return Math.floor(netPay * 100.0) / 100.0;
    }


    /**
     * 
     * Displays the company logo.
     */
    public void drawLogo() {
        System.out.println("==========================================");
        System.out.println("      Gekko & Co.\n");
        System.out.println("          \"$\"");
        System.out.println("          ~~~");
        System.out.println("         /  \\ `.");
        System.out.println("        /    \\  /");
        System.out.println("       /_ _ _ \\/");
        System.out.println();
    }


    /**
     * 
     * Prints the pay stub info.
     */
    public void printInfo() {
        System.out.println("------------------------------------------");
        System.out.println("Pay Period:     " + currentMonth + "/" + currentYear);
        System.out.println("Name:           " + name);
        System.out.println("Title:          " + jobTitle);
        System.out.println("Anniversary:    " + anniversaryMonth + "/" + anniversaryYear);
        System.out.println("Months Worked:  " + numMonthsWorked() + " months");
        System.out.printf("Vacation hours: %.2f\n", vacationHours());
        System.out.println("------------------------------------------");
        System.out.printf("Gross Pay:     $%7.2f\n", grossPay());
        System.out.printf("Retirement:    $%7.2f\n", retHold());
        System.out.printf("Tax:           $%7.2f\n", tax());
        System.out.println("------------------------");
        System.out.printf("Net Pay:       $%7.2f\n", netPay());
        System.out.println("==========================================");
    }

    /**
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your Fullname: ");
        String name = scanner.nextLine();

        System.out.print("Enter your Anniversary Month(1-12): ");
        int anniversaryMonth = scanner.nextInt();

        System.out.print("Enter your Anniversary Year: ");
        int anniversaryYear = scanner.nextInt();

        System.out.print("Enter your hours worked this pay period(0-350): ");
        int hoursWorked = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter your Job Title: ");
        String jobTitle = scanner.nextLine();

        System.out.print("Enter your pay rate: ");
        double payRate = scanner.nextDouble();

        PayStub payStub = new PayStub(name, anniversaryMonth, anniversaryYear, hoursWorked, jobTitle, payRate);
        payStub.drawLogo();
        payStub.printInfo();

        scanner.close();
    }
}