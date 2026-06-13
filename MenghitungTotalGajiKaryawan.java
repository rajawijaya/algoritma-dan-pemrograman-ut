import java.util.Scanner;

public class MenghitungTotalGajiKaryawan {
    public static void main(String[] args) {
        
        try (Scanner input = new Scanner(System.in)) {

        // Deklarasi variabel
        char golongan;
        int jam_lembur;
        int gaji_golongan;
        double persen;
        int gaji_lembur;
        int jumlah_penghasilan;

        // Input dari user
        System.out.print("Masukkan golongan (A/B/C): ");
        golongan = input.next().charAt(0);

        System.out.print("Masukkan jam lembur: ");
        jam_lembur = input.nextInt();

        // Menentukan gaji pokok
        switch (golongan) {
            case 'A':
                gaji_golongan = 5000000;
                break;
            case 'B':
                gaji_golongan = 6500000;
                break;
            case 'C':
                gaji_golongan = 9500000;
                break;
            default:
                System.out.println("ERROR : Golongan tidak valid");
                return;
        }

        // Menentukan persentase lembur
        if (jam_lembur == 1) {
            persen = 0.30;
        } else if (jam_lembur == 2) {
            persen = 0.32;
        } else if (jam_lembur == 3) {
            persen = 0.34;
        } else if (jam_lembur == 4) {
            persen = 0.36;
        } else if (jam_lembur >= 5) {
            persen = 0.38;
        } else {
            persen = 0;
        }

        // Menghitung gaji lembur
        gaji_lembur = (int) (persen * gaji_golongan);

        // Menghitung total penghasilan
        jumlah_penghasilan = gaji_golongan + gaji_lembur;

        // Output
        System.out.println("Jumlah Penghasilan = " + jumlah_penghasilan);

        }
    }
}