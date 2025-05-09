import java.util.Scanner;

public class AverageTemperatureCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of temps you are inputting: ");
        int numTemps = scanner.nextInt();

        double[] temps = new double[numTemps];
        double sum = 0;

        for (int i = 0; i < numTemps; i++) {
            System.out.println("Enter temperatures " + (i + 1) + ": ");
            temps[i] = scanner.nextDouble();
            sum += temps[i];
        }

        double average = sum / numTemps;
        System.out.println("Average temperature: " + average);

        int countAboveAverage = 0;

        for(double temp : temps) {
            if (temp > average) {
                countAboveAverage++;
            }
        }

        System.out.println("Number of days above average temperature: " + countAboveAverage);
    }
}