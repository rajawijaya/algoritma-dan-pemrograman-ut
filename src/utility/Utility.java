package utility;

import java.util.Scanner;

public class Utility {

    
    private static final char[] GOLONGAN = {
        'A',
        'B',
        'C'
    };

    private static final int[] GAJI_POKOK = {
        5_000_000,
        6_500_000,
        9_500_000
    };

    private static final double[] PERSEN_LEMBUR = {
        0.00,
        0.30,
        0.32,
        0.34,
        0.36
    };

    
    public static char inputGolongan(Scanner input) {
        while (true) {
            System.out.print("Masukkan golongan (A/B/C): ");

            String nilai = input.nextLine().trim();

            if (nilai.isEmpty()) {
                System.out.println("ERROR: Input tidak boleh kosong.");
                continue;
            }

            if (nilai.length() != 1) {
                System.out.println("ERROR: Masukkan hanya satu huruf (A/B/C).");
                continue;
            }

            char golongan = Character.toUpperCase(nilai.charAt(0));

            for (char g : GOLONGAN) {

                if (golongan == g) {
                    return golongan;
                }
            }

            System.out.println(
                    "ERROR: Golongan hanya boleh A, B, atau C.");
        }
    }

   
    public static int inputJamLembur(Scanner input) {

        while (true) {

            System.out.print("Masukkan jam lembur: ");

            String nilai = input.nextLine().trim();

            if (nilai.isEmpty()) {

                System.out.println(
                        "ERROR: Input tidak boleh kosong.");

                continue;
            }

            try {
                int jamLembur = Integer.parseInt(nilai);

                if (jamLembur < 0) {
                    System.out.println("ERROR: Jam lembur tidak boleh negatif.");
                    continue;
                }

                return jamLembur;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Jam lembur harus berupa angka.");
            }
        }
    }

    
    public static int getGajiPokok(char golongan) {
        for (int i = 0; i < GOLONGAN.length; i++) {
            if (golongan == GOLONGAN[i]) {
                return GAJI_POKOK[i];
            }
        }

        return 0;
    }

    
    public static double getPersenLembur(int jamLembur) {
        if (jamLembur >= 0
                && jamLembur < PERSEN_LEMBUR.length) {

            return PERSEN_LEMBUR[jamLembur];
        }

        return 0.38;
    }

    
    public static int hitungGajiLembur(int gajiPokok, double persenLembur) {
        return (int) (gajiPokok * persenLembur);
    }

  
    public static int hitungTotalPenghasilan(int gajiPokok, int gajiLembur) {
        return gajiPokok + gajiLembur;
    }


    public static boolean konfirmasiUlang(Scanner input) {

        while (true) {

            System.out.print("\nApakah anda mau mengulangi program lagi? (Y/N): ");

            String pilihan = input.nextLine().trim();

            if (pilihan.equalsIgnoreCase("Y")) {
                return true;
            } else if (pilihan.isEmpty() || pilihan.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println(
                    "ERROR: Pilihan hanya boleh Y atau N.");
        }
    }
}