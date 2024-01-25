import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
 
//Class
public class ProdukMie implements UserInterface{
    int kodeKons, noProduk, hargaProduk, jumlah, hargaAwal, totalHarga;
    String namaProduk, diskon, kemasan;


    static Connection con;

    Scanner masukkan = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/mieangek";

    @Override
    public void kodeKonsumen() throws SQLException{
        System.out.print("Masukkan Kode Konsumen: ");
        this.kodeKons = masukkan.nextInt();
        
    }

    @Override
    public void namaProduk() {
        System.out.println("\n ***NAMA PRODUK Mie");
        System.out.println("1. Aman ");
        System.out.println("2. Ngilu Kuku ");
        System.out.println("3. Angek ");
        System.out.println("4. Mandidiah ");
        System.out.println("5. Malapuah ");
  


        System.out.print(" \t--->Pilih nomor produk: ");
        this.noProduk = masukkan.nextInt();
//Percabangan
            if (noProduk == 1) { 
                this.namaProduk = "Aman";
            }
            else if (noProduk == 2) {
                this.namaProduk = "Ngilu Kuku";
            }
            else if (noProduk == 3) {
                this.namaProduk = "Angek";
            }
            else if (noProduk == 4) {
                this.namaProduk = "Mandidiah";
            }
            else if (noProduk == 5) {
                this.namaProduk = "Malapuah";
            }
            else {
                System.out.println("\nNomor yang dimasukkan SALAH, mohon DIULANG kembali");
                
            }
        
    }

    @Override
    public void hargaSatuan() {
//Percabangan
            if (noProduk == 1) { 
                this.hargaProduk = 10000;
            }
            else if (noProduk == 2) {
                this.hargaProduk = 13000;
            }
            else if (noProduk == 3) {
                this.hargaProduk = 15000;
            }
            else if (noProduk == 4) {
                this.hargaProduk = 20000;
            }
            else if (noProduk == 5) {
                this.hargaProduk = 25000;
            }
            else {
                //System.out.println("\nMohon DIULANG kembali dengan cara Discard sistem ini !!!");
//Exception
                throw new IllegalAccessError("\nERROR, Nomor yang dimasukkan SALAH\n");
            }
        
    }

    @Override
    public void jumlah() {
        System.out.print("\nMasukkan jumlah produk mie yang ingin dibeli: ");
        this.jumlah = masukkan.nextInt();
        
    }


    @Override
    public void hargaAwal() {
//Percabangan
//Proses Matematika
        if (noProduk == 1) {
            this.hargaAwal = 10000 * this.jumlah;
        }
        else if (noProduk == 2) {
            this.hargaAwal = 13000 * this.jumlah;
        }
        else if (noProduk == 3) {
            this.hargaAwal = 15000 * this.jumlah;
        }
        else if (noProduk == 4) {
            this.hargaAwal = 20000 * this.jumlah;
        }
        else if (noProduk == 5) {
            this.hargaAwal = 25000 * this.jumlah;
        }
        else {
            //System.out.println("\nMaaf Sub total tidak valid");
           throw new IllegalArgumentException( "\nERROR, Nomor yang dimasukkan SALAH\n" );
        }
        
    }

    @Override
    public void diskonProduk() {
        
    }

    @Override
    public void totalBayar() {
        
    }

    @Override
    public void tabelProdukMie() {
        
    }
    

}
