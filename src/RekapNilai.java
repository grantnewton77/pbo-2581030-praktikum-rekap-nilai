import java.util.Scanner;

public class RekapNilai {

    static final int SELESAI = -1;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double total = 0;
        int jumlahSah = 0;

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

            if (nilai < 0 || nilai > 100) {
                System.out.println("  ditolak - nilai harus 0..100");
                continue;
            }

            char grade;

            if (nilai >= 90) {
                grade = 'A';
            } else if (nilai >= 80) {
                grade = 'B';
            } else if (nilai >= 70) {
                grade = 'C';
            } else if (nilai >= 60) {
                grade = 'D';
            } else {
                grade = 'E';
            }

            String keterangan = switch (grade) {
                case 'A' -> "Sangat Baik";
                case 'B' -> "Baik";
                case 'C' -> "Cukup";
                case 'D' -> "Kurang";
                default -> "Tidak Lulus";
            };

            System.out.println("  Grade " + grade + " - " + keterangan);

            total += nilai;
            jumlahSah++;
            nomor++;


        } while (nilai != SELESAI);

        double rata = (jumlahSah > 0) ? total / jumlahSah : 0.0;

        String status = rata >= 60 ? "LULUS" : "TIDAK LULUS";

        System.out.println();
        System.out.println("Nilai sah   : " + jumlahSah);
        System.out.println("Rata-rata   : " + String.format("%.2f", rata));
        System.out.println("Status      : " + status);

        /*
         * Jika urutan kondisi dibalik dan >= 60 diletakkan paling atas,
         * nilai 85 akan mendapat grade D karena kondisi >= 60 sudah benar,
         * sehingga kondisi >= 70, >= 80, dan >= 90 tidak diperiksa.
         */

        input.close();
    }
}