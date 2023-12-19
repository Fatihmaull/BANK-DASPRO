import java.util.Scanner;

public class Akun {
    private static int count = 1;
    private String idNasabah;
    private String username;
    private String email;
    private String password;
    private double totalSaldo;
    private String catatanTransaksi;

    public Akun(String username, String email, String password) {
        this.idNasabah = "N" + count++;
        this.username = username;
        this.email = email;
        this.password = password;
        this.totalSaldo = 0;
        this.catatanTransaksi = "";
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public double getTotalSaldo() {
        return totalSaldo;
    }

    public void setTotalSaldo(double totalSaldo) {
        this.totalSaldo = totalSaldo;
    }

    public String getCatatanTransaksi() {
        return catatanTransaksi;
    }

    public void setCatatanTransaksi(String catatanTransaksi) {
        this.catatanTransaksi = catatanTransaksi;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        if (inputPassword.equals(password)) {
            System.out.println("Login berhasil.");
        } else {
            System.out.println("Password salah. Login gagal.");
            System.exit(0);  // Keluar dari program jika login gagal
        }
    }

    public void tampilkanStrukTransaksi() {
        System.out.println("Struk Transaksi:");
        System.out.println("Username: " + username);
        System.out.println("ID Nasabah: " + idNasabah);
        System.out.println("Jenis Transaksi: " + catatanTransaksi);
        System.out.println("Jumlah Transaksi: " + getTotalSaldo());
        System.out.println("Total Saldo: " + totalSaldo);
        System.out.println("Terima kasih atas transaksi Anda.");
    }
}
