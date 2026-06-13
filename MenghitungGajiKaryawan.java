import static java.text.NumberFormat.getCurrencyInstance;
import static java.util.Locale.forLanguageTag;
import java.util.Scanner;

public class MenghitungGajiKaryawan {

    public static void main(String[] args) {
        // Inisialisasi Scanner dan NumberFormat untuk format mata uang Rupiah
        var input = new Scanner(System.in);
        var rupiah = getCurrencyInstance(forLanguageTag("id-ID"));

        // Deklarasi variabel
        char golongan;
        int gajiPokok;
        int jamLembur;
        double persenLembur;
        int gajiLembur;
        int totalPenghasilan;

        while (true) { 
            // Tampilan menu awal
            System.out.println("===================================================");
            System.out.println("||                SELAMAT DATANG DI              ||");
            System.out.println("||       APLIKASI PERHITUNGAN GAJI KARYAWAN      ||");
            System.out.println("||-----------------------------------------------||");
            System.out.println("||               Dev By : Raja Wijaya            ||");
            System.out.println("===================================================");
            System.out.println("Pilihan Golongan:");
            System.out.println("  A - Gaji pokok Rp 5.000.000");
            System.out.println("  B - Gaji pokok Rp 6.500.000");
            System.out.println("  C - Gaji pokok Rp 9.500.000");
            System.out.println("-----------------------------------------------");

            // Input golongan dan validasi
            while (true) {
                System.out.print("Masukkan golongan (A/B/C): ");
                golongan = Character.toUpperCase(input.next().charAt(0));

                if (golongan == 'A') {
                    gajiPokok = 5_000_000;
                } else if (golongan == 'B') {
                    gajiPokok = 6_500_000;
                } else if (golongan == 'C') {
                    gajiPokok = 9_500_000;
                } else {
                    System.out.println("ERROR: Golongan tidak valid. Silakan masukkan A, B, atau C.");
                    continue;
                }
                break;
            }

            // Tampilan menu lembur
            System.out.println();
            System.out.println("Berapa jam karyawan lembur?:");
            System.out.println("  0 jam   -> 0% dari gaji pokok");
            System.out.println("  1 jam   -> 30% dari gaji pokok");
            System.out.println("  2 jam   -> 32% dari gaji pokok");
            System.out.println("  3 jam   -> 34% dari gaji pokok");
            System.out.println("  4 jam   -> 36% dari gaji pokok");
            System.out.println("  5+ jam  -> 38% dari gaji pokok");
            System.out.println("-----------------------------------------------");

            // Input jam lembur dan validasi
            System.out.print("Masukkan jam lembur: ");
            jamLembur = input.nextInt();
            if (jamLembur < 0) {
                System.out.println("ERROR: Jam lembur tidak boleh negatif.");
                return;
            }

            // Menentukan persentase lembur berdasarkan jam lembur
            if (jamLembur == 0) {
                persenLembur = 0;
            } else if (jamLembur == 1) {
                persenLembur = 0.30;
            } else if (jamLembur == 2) {
                persenLembur = 0.32;
            } else if (jamLembur == 3) {
                persenLembur = 0.34;
            } else if (jamLembur == 4) {
                persenLembur = 0.36;
            } else if (jamLembur >= 5) {
                persenLembur = 0.38;
            } else {
                persenLembur = 0; // Default jika input tidak valid, meskipun sudah divalidasi sebelumnya
            }

            // Perhitungan gaji lembur dan total penghasilan
            gajiLembur = (int) (persenLembur * gajiPokok);
            totalPenghasilan = gajiPokok + gajiLembur;

            // Menampilkan ringkasan gaji dengan format rupiah
            System.out.println();
            System.out.println("================= RINGKASAN GAJI ==================");
            System.out.println("Golongan          : " + golongan);
            System.out.println("Gaji Pokok        : " + rupiah.format(gajiPokok));
            System.out.println("Jam Lembur        : " + jamLembur + " jam");
            System.out.println("Persentase Lembur : " + (int) (persenLembur * 100) + "%");
            System.out.println("Gaji Lembur       : " + rupiah.format(gajiLembur));
            System.out.println("-----------------------------------------------");
            System.out.println("Total Penghasilan : " + rupiah.format(totalPenghasilan));
            System.out.println("===================================================");
            System.out.println("Terima kasih telah menggunakan aplikasi ini.");

            // Menanyakan apakah pengguna ingin mengulangi program
            System.out.print("Apakah anda mau mengulangi program lagi? (y/N): ");
            if (input.next().equalsIgnoreCase("y")) {
                continue;
            }
            break;
        }
    }
}
