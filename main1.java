package main2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class main1 {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/notaid_database";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    public static void main(String[] args) {

        try {
            // register driver
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {
                mainMenu();
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void mainMenu() {
        System.out.println("\n========= MAIN MENU CATATAN PEMBELIAN =========");
        System.out.println("1. menu catatan");
        System.out.println("2. menu rencana");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    Menucatan();
                    break;
                case 2:
                    Menurencana();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void Menucatan() {
        System.out.println("\n========= MENU CATATAN PEMBELIAN =========");
        System.out.println("1. Insert Data");
        System.out.println("2. Show Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");
        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insertcatatan();
                    break;
                case 2:
                    showcatatan();
                    break;
                case 3:
                    updatecatatan();
                    break;
                case 4:
                    deletecatatan();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void showcatatan() {
        String sql = "SELECT * FROM cttn_pembelian";
        try {
            rs = stmt.executeQuery(sql);

            System.out.println("+--------------------------------+");
            System.out.println("|    DATA BUKU DI PERPUSTAKAAN   |");
            System.out.println("+--------------------------------+");

            while (rs.next()) {
                int idPembelian = rs.getInt("id_pembelian");
                String namabarang = rs.getString("nama_barang");
                int hargabarang = rs.getInt("harga_barang");
                int jumlahbarang = rs.getInt("jumlah_barang");
                int totalharga = rs.getInt("total_harga");

                System.out.println(String.format("%d. %s -- (%s) -- (%s) -- (%s)", idPembelian, namabarang, hargabarang, jumlahbarang, totalharga));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    static void insertcatatan() {
        try {

            System.out.print("nama barang: ");
            String namabarang = input.readLine().trim();
            System.out.print("harga barang: ");
            int hargabarang = Integer.parseInt(input.readLine());
            System.out.print("jumlah barang: ");
            int jumlahbarang = Integer.parseInt(input.readLine());
            int totalharga = jumlahbarang*hargabarang;

            String sql = "INSERT INTO cttn_pembelian (nama_barang, harga_barang, jumlah_barang, total_harga) VALUE('%s', '%s', '%s', '%s')";
            sql = String.format(sql, namabarang, hargabarang, jumlahbarang, totalharga);

            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void updatecatatan() {
        try {
            System.out.print("ID yang mau diedit: ");
            int idpembelian = Integer.parseInt(input.readLine());
            System.out.print("nama barang: ");
            String namabarang = input.readLine().trim();
            System.out.print("harga barang: ");
            int hargabarang = Integer.parseInt(input.readLine());
            System.out.print("jumlah barang: ");
            int jumlahbarang = Integer.parseInt(input.readLine());
            int totalharga = jumlahbarang*hargabarang;

            String sql = "UPDATE cttn_pembelian SET nama_barang='%s', harga_barang='%s', jumlah_barang='%s', total_harga='%s' WHERE id_pembelian=%d";
            sql = String.format(sql, namabarang, hargabarang, jumlahbarang, totalharga, idpembelian);

            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void deletecatatan() {
        try {

            System.out.print("ID yang mau dihapus: ");
            int idpembelian = Integer.parseInt(input.readLine());

            String sql = String.format("DELETE FROM cttn_pembelian WHERE id_pembelian=%d", idpembelian);

            stmt.execute(sql);

            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void Menurencana() {
        System.out.println("\n========= MENU RENCANA PEMBELIAN =========");
        System.out.println("1. Insert Data");
        System.out.println("2. Show Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insertrencana();
                    break;
                case 2:
                    showrencana();
                    break;
                case 3:
                    updaterencana();
                    break;
                case 4:
                    deleterencana();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void showrencana() {
        String sql = "SELECT * FROM rencana_belanja";

        try {
            rs = stmt.executeQuery(sql);

            System.out.println("+--------------------------------+");
            System.out.println("|    DATA RENCANA BELANJA        |");
            System.out.println("+--------------------------------+");

            while (rs.next()) {
                int idPembelian = rs.getInt("id_rencana");
                String namabarang = rs.getString("nama_barang");
                int jumlahbarang = rs.getInt("jumlah_barang");
                String tanggalbuat = rs.getString("tgl_buat");

                System.out.println(String.format("%d. %s -- %s -- %s", idPembelian, namabarang, jumlahbarang, tanggalbuat));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void insertrencana() {
        try {

            System.out.print("nama barang: ");
            String namabarang = input.readLine().trim();
            System.out.print("jumlah barang: ");
            int jumlahbarang = Integer.parseInt(input.readLine());
            System.out.print("tanggal (dd/mm/yyyy): ");
            String tanggal = input.readLine().trim();

            String sql = "INSERT INTO rencana_belanja (nama_barang, jumlah_barang, tgl_buat) VALUE('%s', '%s', '%s')";
            sql = String.format(sql, namabarang, jumlahbarang, tanggal);

            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void updaterencana() {
        try {
            System.out.print("ID yang mau diedit: ");
            int idrencana = Integer.parseInt(input.readLine());
            System.out.print("nama barang: ");
            String namabarang = input.readLine().trim();
            System.out.print("jumlah barang: ");
            int jumlahbarang = Integer.parseInt(input.readLine());
            System.out.print("tanggal (dd/mm/yyyy): ");
            String tanggal = input.readLine().trim();

            String sql = "UPDATE rencana_belanja SET nama_barang='%s', jumlah_barang='%s', tgl_buat='%s' WHERE id_rencana=%d";
            sql = String.format(sql, namabarang, jumlahbarang, tanggal, idrencana);

            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleterencana() {
        try {

            System.out.print("ID yang mau dihapus: ");
            int idrencana = Integer.parseInt(input.readLine());

            String sql = String.format("DELETE FROM rencana_belanja WHERE id_rencana=%d", idrencana);

            stmt.execute(sql);

            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}