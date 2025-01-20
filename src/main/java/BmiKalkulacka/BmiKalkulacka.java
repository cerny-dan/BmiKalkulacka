package BmiKalkulacka;

import java.util.Scanner;

public class BmiKalkulacka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // V konzoli se vypíše uvítání uživatele
        System.out.println("Vítejte v kalkulačce BMI");

        // Toto je mezera v konzoli
        System.out.println();

        double vyska = 0;
        double vaha = 0;

        // Nyní je uživatel vyzván k zadání své výšky v centimetrech
        while (true) {
            try {
                System.out.println("Zadejte prosím svoji výšku v centimetrech: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) throw new IllegalArgumentException("Vstup nesmí být prázdný.");
                vyska = Double.parseDouble(input);
                if (vyska > 0) break;
                else System.out.println("Výška musí být větší než nula.");
            } catch (Exception e) {
                System.out.println("Neplatný vstup, zkuste to znovu.");
            }
        }

        // Nyní je uživatel vyzván k zadání své váhy v kilogramech
        while (true) {
            try {
                System.out.println("Zadejte prosím svoji váhu v kilogramech: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) throw new IllegalArgumentException("Vstup nesmí být prázdný.");
                vaha = Double.parseDouble(input);
                if (vaha > 0) break;
                else System.out.println("Váha musí být větší než nula.");
            } catch (Exception e) {
                System.out.println("Neplatný vstup, zkuste to znovu.");
            }
        }

        // Nyní aplikace provede převod centimetrů na metry
        double VyskaVMetrech = vyska / 100;

        // Nyní aplikace provede výpočet BMI za použití výšky a váhy zadaných uživatelem
        double VypocetBmi = (vaha / (Math.pow(VyskaVMetrech, 2)));

        /* Tyto řádky slouží pouze pro kontrolu, že vzoreček na výpočet výšky v metrech funguje
        System.out.println(VyskaVMetrech);
        */

        System.out.printf("Tvoje BMI je: %.2f - ", VypocetBmi);

        int kategorie = 0;

        if (VypocetBmi <= 18.49) {
            kategorie = 1;
        } else if ((VypocetBmi >= 18.5) && (VypocetBmi <= 24.9)) {
            kategorie = 2;

        } else if ((VypocetBmi >= 25) && (VypocetBmi <= 29.9)) {
            kategorie = 3;

        } else if ((VypocetBmi >= 30) && (VypocetBmi <= 34.9)) {
            kategorie = 4;

        } else if (VypocetBmi >= 35) {
            kategorie = 5;

        }

        switch (kategorie) {
            case 1:
                System.out.println("Jsi podvyživený");
                break;
            default:
                System.out.println("Nesprávný údaj");

            case 2:
                System.out.println("Máš normální váhu");
                break;

            case 3:
                System.out.println("Máš nadváhu");
                break;

            case 4:
                System.out.println("Máš obezitu 1. stupně!");
                break;

            case 5:
                System.out.println("Máš obezitu 2. stupně!");
                break;
        }

    }
}

