import java.util.Scanner;
import utility.Utility;
import view.View;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {

            View.showHeader();
            View.showGolonganMenu();

            char golongan = Utility.inputGolongan(input);

            View.showLemburMenu();

            int jamLembur = Utility.inputJamLembur(input);

            int gajiPokok = Utility.getGajiPokok(golongan);
            double persenLembur = Utility.getPersenLembur(jamLembur);

            int gajiLembur = Utility.hitungGajiLembur(
                    gajiPokok,
                    persenLembur);

            int totalPenghasilan = Utility.hitungTotalPenghasilan(
                    gajiPokok,
                    gajiLembur);

            View.showRingkasan(
                    golongan,
                    gajiPokok,
                    jamLembur,
                    persenLembur,
                    gajiLembur,
                    totalPenghasilan);


            if (!Utility.konfirmasiUlang(input)) {
                break;
            }
        }

        input.close();
    }
}
