package edu.bit.problemsolving.competitive.kiwi;

import java.util.Scanner;

public class KiwiVaccinationQSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long cities = scanner.nextLong();
        long vaccinations = scanner.nextLong();
        long totalPopulation = 0;
        for (int kits = 0; kits < cities; kits++) {
            totalPopulation += scanner.nextLong();
        }
        long maximumPeople = totalPopulation / vaccinations + totalPopulation % vaccinations;
        System.out.println(maximumPeople);
    }
}
