import java.util.Scanner;

public class RekapNilai {

    static final int SELESAI = -1;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int nilai;
        int nomor = 1;

        // do-while lebih pas karena nilai pertama harus diminta sebelum diperiksa.
        do {
            System.out.print("Nilai ke-" + nomor + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                break;
            }

            nomor++;

        } while (nilai != SELESAI);

        input.close();
    }
}