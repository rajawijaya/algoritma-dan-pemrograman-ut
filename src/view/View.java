package view;

import java.text.NumberFormat;
import java.util.Locale;

public class View {

    private static final NumberFormat RUPIAH 
            = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));

    private static final String[] HEADER = {
        "===================================================",
        "||                SELAMAT DATANG DI              ||",
        "||       APLIKASI PERHITUNGAN GAJI KARYAWAN      ||",
        "||-----------------------------------------------||",
        "||               Dev By : Raja Wijaya            ||",
        "==================================================="
    };

    private static final String[] MENU_GOLONGAN = {
        "Pilihan Golongan:",
        "  A - Gaji pokok Rp 5.000.000",
        "  B - Gaji pokok Rp 6.500.000",
        "  C - Gaji pokok Rp 9.500.000",
        "-----------------------------------------------"
    };

    private static final String[] MENU_LEMBUR = {
        "",
        "Berapa jam karyawan lembur?:",
        "  0 jam   -> 0% dari gaji pokok",
        "  1 jam   -> 30% dari gaji pokok",
        "  2 jam   -> 32% dari gaji pokok",
        "  3 jam   -> 34% dari gaji pokok",
        "  4 jam   -> 36% dari gaji pokok",
        "  5+ jam  -> 38% dari gaji pokok",
        "-----------------------------------------------"
    };

    public static void showHeader() {

        printArray(HEADER);
    }

    public static void showGolonganMenu() {

        printArray(MENU_GOLONGAN);
    }

    public static void showLemburMenu() {

        printArray(MENU_LEMBUR);
    }

    public static void showRingkasan(
            char golongan,
            int gajiPokok,
            int jamLembur,
            double persenLembur,
            int gajiLembur,
            int totalPenghasilan) {

        String[] ringkasan = {
            "",
            "================= RINGKASAN GAJI ==================",
            "Golongan          : " + golongan,
            "Gaji Pokok        : " + RUPIAH.format(gajiPokok),
            "Jam Lembur        : " + jamLembur + " jam",
            "Persentase Lembur : "
            + (int) (persenLembur * 100) + "%",
            "Gaji Lembur       : "
            + RUPIAH.format(gajiLembur),
            "-----------------------------------------------",
            "Total Penghasilan : "
            + RUPIAH.format(totalPenghasilan),
            "===================================================",
            "Terima kasih telah menggunakan aplikasi ini."
        };

        printArray(ringkasan);
    }

    private static void printArray(String[] data) {

        for (String line : data) {
            System.out.println(line);
        }
    }
}
