import java.util.Scanner;

// Elevate Labs Task 1: Calculator Implementation   
class calculator {

    // Addition method that sums all numbers
    public void addition(int... a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        System.out.println(sum);
    }

    // Subtraction method that subtracts all subsequent numbers from the first
    public void subtraction(int... a) {
        int result = a[0];
        for (int i = 1; i < a.length; i++) {
            result -= a[i];
        }
        System.out.println(result);
    }

    // Multiplication method that multiplies all numbers together
    public void multiplication(int... a) {
        int product = 1;
        for (int i : a) {
            product *= i;
        }
        System.out.println(product);
    }

    // Division method with error handling for division by zero
    public void division(int... a) {
        if (a.length == 0) {
            System.out.println("No numbers provided for division.");
            return;
        }
        double result = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 0) {
                System.out.println("Division by zero is not allowed.");
                return;
            }
            result /= a[i];
        }
        System.out.println(result);
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        calculator obj = new calculator();
        System.err.println("enter how many numbers you want to add, subtract, multiply or divide");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        System.err.println("enter the numbers");
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.err.println("Addition:");
        obj.addition(numbers);
        System.err.println("Subtraction:");
        obj.subtraction(numbers);
        System.err.println("Multiplication:");
        obj.multiplication(numbers);
        System.err.println("Division:");
        obj.division(numbers);
        scanner.close();
    }
}
