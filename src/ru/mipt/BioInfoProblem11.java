package ru.mipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BioInfoProblem11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        List<String> kMers = new ArrayList<>();
        String genome;
        scanner.nextLine();
        String s1 = "SomeString";
        int j = 0;
        while (scanner.hasNextLine()) {
            kMers.add(scanner.nextLine());
            s1 = kMers.get(j);
            j++;
            if (s1.equals("exit")) {
                kMers.remove("exit");
                System.out.println(kMers);
                break;
            }
        }
        int counter = 0;
        genome = kMers.get(0);
        while (genome.length() != (k + kMers.size() - 1)) {
            for (String kMer : kMers) {
                String mer = kMer.substring(0, k - 1);
                if (genome.substring(genome.length() - k + 1, genome.length()).equals(mer)) {
                    genome += kMer.charAt(k - 1);
                }
                mer = kMer.substring(1, k - 1 );
                if (genome.substring(0, k - 2).equals(mer)) {
                    genome = kMer.charAt(0) + genome;
                }
            }
        }
        System.out.println(genome);
    }
}