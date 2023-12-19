import java.util.Scanner;

public class AplikasiPerbankan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di Aplikasi Perbankan");

        System.out.print("Apakah Anda ingin menjadi Admin atau Nasabah? ");
        String jenisUser = scanner.nextLine().toLowerCase();

        if (jenisUser.equals("admin")) {
            // Input untuk Admin
            System.out.print("Masukkan username Admin: ");
            String adminUsername = scanner.nextLine();
            System.out.print("Masukkan email Admin: ");
            String adminEmail = scanner.nextLine();
            System.out.print("Masukkan password Admin: ");
            String adminPassword = scanner.nextLine();

            Akun admin = new Akun(adminUsername, adminEmail, adminPassword);
            DataBase.setAdminPassword(adminPassword);
            DataBase.tambahAkun(admin);

            System.out.println("Akun Admin berhasil dibuat dengan ID: " + admin.getIdNasabah());
        } else if (jenisUser.equals("nasabah")) {
            // Input untuk Nasabah
            System.out.print("Masukkan username Nasabah: ");
            String nasabahUsername = scanner.nextLine();
            System.out.print("Masukkan email Nasabah: ");
            String nasabahEmail = scanner.nextLine();
            System.out.print("Masukkan password Nasabah: ");
            String nasabahPassword = scanner.nextLine();

            Akun nasabah = new Akun(nasabahUsername, nasabahEmail, nasabahPassword);
            DataBase.tambahAkun(nasabah);

            System.out.println("Akun Nasabah berhasil dibuat dengan ID: " + nasabah.getIdNasabah());

            // Login sebagai Nasabah
            System.out.print("Apakah Anda ingin login sebagai Nasabah? (ya/tidak): ");
            String pilihanLogin = scanner.nextLine().toLowerCase();

            if (pilihanLogin.equals("ya")) {
                System.out.print("Masukkan ID Nasabah: ");
                String idNasabah = scanner.nextLine();

                Akun nasabahLogin = DataBase.getAkunById(idNasabah);

                if (nasabahLogin != null) {
                    nasabahLogin.login();

                    // Menampilkan opsi transaksi Nasabah
                    tampilkanMenuTransaksi(nasabahLogin);

                    // Menampilkan struk transaksi
                    nasabahLogin.tampilkanStrukTransaksi();
                } else {
                    System.out.println("Nasabah tidak ditemukan.");
                }
            }
        } else {
            System.out.println("Jenis pengguna tidak valid.");
        }

        scanner.close();
    }

    private static void tampilkanMenuTransaksi(Akun nasabah) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Transaksi:");
            System.out.println("1. Setoran");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Investasi");
            System.out.println("4. Top-up e-money");
            System.out.println("5. Keluar");

            System.out.print("Pilih transaksi (1-5): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    Transaksi.setoran(nasabah);
                    break;
                case 2:
                    Transaksi.tarikTunai(nasabah);
                    break;
                case 3:
                    Transaksi.investasi(nasabah);
                    break;
                case 4:
                    Transaksi.topUpEmoney(nasabah);
                    break;
                case 5:
                    // Menampilkan struk transaksi sebelum keluar
                    nasabah.tampilkanStrukTransaksi();

                    // Opsi untuk kembali melanjutkan transaksi atau keluar
                    System.out.print("Apakah Anda ingin kembali melanjutkan transaksi? (ya/tidak): ");
                    String pilihanKembali = scanner.next().toLowerCase();

                    if (pilihanKembali.equals("tidak")) {
                        System.out.println("Terimakasih, semoga harimu diberkahi.");
                        scanner.close();
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
