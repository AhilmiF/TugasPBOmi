import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;

//Class
//Inheritance
public class PengadaanMie extends ProdukMie {

    String url = "jdbc:mysql://localhost:3306/mieangek";
    Scanner input = new Scanner(System.in);
    int totalBayar, hargaDiskon, kodeKons2, jumlahProd;

    public String kode, namaMie, diskonMie;
    public int harga, no;

    // Constructor
    public PengadaanMie(String kodeBar, String namaBar, String diskonMie, int harga) {
        this.kode = kodeBar;
        this.namaMie = namaBar;
        this.harga = harga;
        this.diskonMie = diskonMie;
    }

    // Constructor
    public PengadaanMie() {
    }

    @Override
    public void diskonProduk() {
        // Percabangan
        // Proses Matematika
        if (noProduk == 1) {
            this.diskon = "2%";
            this.hargaDiskon = this.hargaAwal * 2 / 100;
        } else if (noProduk == 2) {
            this.diskon = "2%";
            this.hargaDiskon = this.hargaAwal * 2 / 100;
        } else if (noProduk == 3) {
            this.diskon = "-";
            this.hargaDiskon = 0;
        } else if (noProduk == 4) {
            this.diskon = "3%";
            this.hargaDiskon = this.hargaAwal * 3 / 100;
        } else if (noProduk == 5) {
            this.diskon = "3%";
            this.hargaDiskon = this.hargaAwal * 3 / 100;
        }
    }

    @Override
    public void totalBayar() {
        // Percabangan
        // Proses Matematika
        if (noProduk == 1) {
            this.totalBayar = this.hargaAwal - this.hargaDiskon;
        } else if (noProduk == 2) {
            this.totalBayar = this.hargaAwal - this.hargaDiskon;
        } else if (noProduk == 3) {
            this.totalBayar = this.hargaAwal - this.hargaDiskon;
        } else if (noProduk == 4) {
            this.totalBayar = this.hargaAwal - this.hargaDiskon;
        } else if (noProduk == 5) {
            this.totalBayar = this.hargaAwal - this.hargaDiskon;
        }
    }

    // Collection Framework
    @Override
    public void tabelProdukMie() {
        HashSet<PengadaanMie> data = new HashSet<PengadaanMie>();
        // Membuat daftar PengadaanMie
        PengadaanMie b1 = new PengadaanMie("   Aman    ", " LevelAman ", "  2%    ", 20000);
        PengadaanMie b2 = new PengadaanMie("   NgiluKuku    ", " LevelNgiluKuku ", "  2%    ", 50000);
        PengadaanMie b3 = new PengadaanMie("   Angek  ", " LevelAngek ", "  -     ", 90000);
        PengadaanMie b4 = new PengadaanMie("   Mandidiah  ", " LevelMandidiah ", "  3%    ", 150000);
        PengadaanMie b5 = new PengadaanMie("   Malapuah ", " LevelMalapuah ", "  3%    ", 300000);

        // Menambahkan PengadaanMie ke HashSet
        data.add(b1);
        data.add(b2);
        data.add(b3);
        data.add(b4);
        data.add(b5);

        System.out.println("\n\t\t\t###        DAFTAR TABEL PRODUK MIE        ###");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "   Kode Mie   |          Nama Mie          |      Diskon     |   Harga Satuan");
        System.out.println(
                "_______________________________________________________________________________________________________________________");

        // Transversing (lintas) PengadaanMie
        // Perulangan
        for (PengadaanMie b : data) {
            System.out.println(
                    b.kode + "\t|" + b.namaMie + "  \t|   " + b.diskonMie + "\t|    Rp." + b.harga + ",-");
        }
    }

    // Pengolahan Database (CRUD)
    public void database() throws SQLException {
        String sql = "INSERT INTO mie (kode_konsumen, nama_produk, harga_satuan, jumlah, diskon, total_bayar) VALUES ('"
                + kodeKons + "', '" + namaProduk + "', '" + hargaProduk + "','" + jumlah + "','" + diskon + "','"
                + totalBayar + "')";
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        statement.execute(sql);
        System.out.println("Berhasil input data!!!");
    }

    // Pengolahan Database (CRUD)
    public void tampilInfo() throws SQLException {

        System.out.print("Masukkan Kode Konsumen: ");
        kodeKons2 = input.nextInt();

        String sql = "SELECT * FROM mie WHERE kode_konsumen = " + kodeKons2;
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.println("\n**--------------------------------------------------------**");
            System.out.println("** \t INFORMASI KONSUMEN MIE\t  **");
            System.out.println("**--------------------------------------------------------**\n");
            System.out.print("Kode Konsumen   : ");
            System.out.println(result.getInt("kode_konsumen"));
            System.out.print("Nama Produk     : ");
            System.out.println(result.getString("nama_produk"));
            System.out.print("Harga Satuan    : Rp ");
            System.out.println(result.getInt("harga_satuan") + ",-");
            System.out.print("Jumlah          : ");
            System.out.println(result.getInt("jumlah") + " buah");
            System.out.print("Discount        : ");
            System.out.println(result.getString("diskon"));
            System.out.print("Total Bayar     : Rp ");
            System.out.println(result.getInt("total_bayar") + ",-\n");
        }
    }

    // Pengolahan Database (CRUD)
    public void tampilInfo1() throws SQLException {

        String sql = "SELECT * FROM mie WHERE kode_konsumen = " + kodeKons2;
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.println("\n**--------------------------------------------------------**");
            System.out.println("** \t INFORMASI KONSUMEN MIE\t  **");
            System.out.println("**--------------------------------------------------------**\n");
            System.out.print("Kode Konsumen   : ");
            System.out.println(result.getInt("kode_konsumen"));
            System.out.print("Nama Produk     : ");
            System.out.println(result.getString("nama_produk"));
            System.out.print("Harga Satuan    : Rp ");
            System.out.println(result.getInt("harga_satuan") + ",-");
            System.out.print("Jumlah          : ");
            System.out.println(result.getInt("jumlah") + " buah");
            System.out.print("Discount        : ");
            System.out.println(result.getString("diskon"));
            System.out.print("Total Bayar     : Rp ");
            System.out.println(result.getInt("total_bayar") + ",-\n");
        }
    }

    // Pengolahan Database (CRUD)
    public void ubahData() throws SQLException {
        String text3 = "\nPengubahan hisTory Konsumen";
        // Method String
        System.out.println(text3.toUpperCase());

        try {
            System.out.print("Masukkan kode konsumen yang akan di ubah : ");
            kodeKons2 = 0;
            kodeKons2 = input.nextInt();

            String sql = "SELECT * FROM mie WHERE kode_konsumen = " + kodeKons2;
            con = DriverManager.getConnection(url, "root", "");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {

                System.out.println("\n ***NAMA PRODUK MIE");
                System.out.println("1. Aman ");
                System.out.println("2. Ngilu Kuku ");
                System.out.println("3. Angek ");
                System.out.println("4. Mandidiah  ");
                System.out.println("5. Malapuah  ");

                System.out.println("\n Nama Produk [" + result.getString("nama_produk") + "]\t: ");
                this.noProduk = masukkan.nextInt();
                // Percabangan
                if (noProduk == 1) {
                    this.namaProduk = "Aman";
                } else if (noProduk == 2) {
                    this.namaProduk = "Ngilu Kuku";
                } else if (noProduk == 3) {
                    this.namaProduk = "Angek";
                } else if (noProduk == 4) {
                    this.namaProduk = "Mandidiah";
                } else if (noProduk == 5) {
                    this.namaProduk = "Malapuah";
                } else {
                    System.out.println("\nNomor yang dimasukkan SALAH, mohon DIULANG kembali");

                }

                System.out.print("Jumlah produk [" + result.getInt("jumlah") + "]\t: ");
                int jumlahBar = input.nextInt();

                System.out.println("\n Harga Satuan [" + result.getInt("harga_satuan")
                        + "] (masukkan dg nomor produk sesuai)\t: ");
                this.noProduk = masukkan.nextInt();
                // Percabangan
                // Proses Matematika
                if (noProduk == 1) {
                    this.hargaProduk = 10000;
                } else if (noProduk == 2) {
                    this.hargaProduk = 13000;
                } else if (noProduk == 3) {
                    this.hargaProduk = 15000;
                } else if (noProduk == 4) {
                    this.hargaProduk = 20000;
                } else if (noProduk == 5) {
                    this.hargaProduk = 25000;
                }

                System.out.println("\n Total Harga yang Dibayar [" + result.getInt("total_bayar")
                        + "] (masukkan dg nomor produk sesuai)\t: ");
                this.noProduk = masukkan.nextInt();
                // Percabangan
                // Proses Matematika
                if (noProduk == 1) {
                    this.totalBayar = (10000 * jumlahBar) - (10000 * jumlahBar * 2 / 100);
                } else if (noProduk == 2) {
                    this.totalBayar = (13000 * jumlahBar) - (13000 * jumlahBar * 2 / 100);
                } else if (noProduk == 3) {
                    this.totalBayar = (15000 * jumlahBar) - (15000 * jumlahBar * 0 / 100);
                } else if (noProduk == 4) {
                    this.totalBayar = (20000 * jumlahBar) - (20000 * jumlahBar * 3 / 100);
                } else if (noProduk == 5) {
                    this.totalBayar = (25000 * jumlahBar) - (25000 * jumlahBar * 3 / 100);
                } else {
                    // System.out.println("\nMaaf Sub total tidak valid");
                    // Exception
                    throw new IllegalArgumentException("\nERROR, Nomor yang dimasukkan SALAH\n");
                }

                diskonProduk();

                sql = "UPDATE mie SET nama_produk='" + namaProduk + "', harga_satuan= '"
                        + hargaProduk + "', jumlah= '" + jumlahBar + "', diskon ='" + diskon + "', total_bayar ='"
                        + totalBayar + "' WHERE kode_konsumen='" + kodeKons2 + "'";

                if (statement.executeUpdate(sql) > 0) {
                    System.out.println("Berhasil memperbaharui data produk mie (Kode Konsumen " + kodeKons2 + ")");
                }
            }
            statement.close();
        }
        // Exception
        catch (SQLException e) {
            System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }
    }

    // Pengolahan Database (CRUD)
    public void showdataBase() throws SQLException {
        String sql = "SELECT kode_konsumen, nama_produk FROM mie";
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nKode Konsumen\t  : ");
            System.out.print(result.getInt("kode_konsumen"));
            System.out.print("\nNama Produk\t : ");
            System.out.print(result.getString("nama_produk"));
            System.out.println("");
        }

    }

    // Pengolahan Database (CRUD)
    public void delete() {
        String text4 = "\nPenghapusan hisTory Konsumen";
        // Method String
        System.out.println(text4.toUpperCase());

        try {
            showdataBase();
            System.out.print("\nMasukan kode konsumen yang akan di Hapus : ");
            Integer kodeKons2 = Integer.parseInt(input.nextLine());

            String sql = "DELETE FROM mie WHERE kode_konsumen = " + kodeKons2;
            con = DriverManager.getConnection(url, "root", "");
            Statement statement = con.createStatement();

            if (statement.executeUpdate(sql) > 0) {
                System.out.println("Berhasil menghapus data pemesanan konsumen (kode konsumen " + kodeKons2 + ")");
            }
        }
        // Exception
        catch (SQLException e) {
            System.out.println("Terjadi kesalahan dalam menghapus data");
        } catch (Exception e) {
            System.out.println("masukan data yang benar");
        }
    }

    // Pengolahan Database (CRUD)
    public void historyDatabase() throws SQLException {
        String sql = "SELECT kode_konsumen, nama_produk, diskon, jumlah, total_bayar FROM mie";
        con = DriverManager.getConnection(url, "root", "");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            System.out.print("\nKode Konsumen\t\t  : ");
            System.out.print(result.getInt("kode_konsumen"));
            System.out.print("\nNama Produk\t\t  : ");
            System.out.print(result.getString("nama_produk"));
            System.out.print("\nJumlah\t\t\t  : ");
            System.out.print(result.getInt("jumlah"));
            System.out.print("\nDiscount\t\t  : ");
            System.out.print(result.getString("diskon"));
            System.out.print("\nTotal Bayar Konsumen\t  : ");
            System.out.print(result.getInt("total_bayar"));
            System.out.println("\n-----------------------------------------\n");
        }

    }

}
