import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataBase {
    private static Map<String, Akun> dataNasabah = new HashMap<>();
    private static String passwordAdmin;

    public static void tambahAkun(Akun akun) {
        dataNasabah.put(akun.getIdNasabah(), akun);
    }

    public static Akun getAkunById(String idNasabah) {
        return dataNasabah.get(idNasabah);
    }

    public static void setAdminPassword(String password) {
        passwordAdmin = password;
    }

    public static boolean validateAdminPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password Admin: ");
        String inputPassword = scanner.nextLine();
        return inputPassword.equals(passwordAdmin);
    }

    public static void tampilkanDataNasabah() {
        System.out.println("Data Nasabah:");
        for (Map.Entry<String, Akun> entry : dataNasabah.entrySet()) {
            Akun akun = entry.getValue();
            System.out.println("ID Nasabah: " + akun.getIdNasabah());
            System.out.println("Username: " + akun.getUsername());
            System.out.println("Email: " + akun.getEmail());
            System.out.println("Total Saldo: " + akun.getTotalSaldo());
            System.out.println("------------------------");
        }
    }

    public static void tampilkanDataNasabahById(String idNasabah) {
        Akun akun = dataNasabah.get(idNasabah);
        if (akun != null) {
            System.out.println("Data Nasabah:");
            System.out.println("ID Nasabah: " + akun.getIdNasabah());
            System.out.println("Username: " + akun.getUsername());
            System.out.println("Email: " + akun.getEmail());
            System.out.println("Total Saldo: " + akun.getTotalSaldo());
            System.out.println("------------------------");
        } else {
            System.out.println("Nasabah tidak ditemukan.");
        }
    }
}
