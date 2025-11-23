package pinjam_buku;

import java.util.Scanner;

public class program_jalan {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan NIM   : ");
        String nim = input.nextLine();

        System.out.print("Masukkan Nama  : ");
        String nama = input.nextLine();

        MHS mhs = new MHS(nim, nama);

        System.out.print("Berapa buku yang ingin dipinjam? ");
        int jumlah = input.nextInt();
        input.nextLine();
        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Buku ke-" + (i + 1));
            System.out.print("No ISBN  : ");
            String isbn = input.nextLine();

            System.out.print("Judul    : ");
            String judul = input.nextLine();

            Buku buku = new Buku(isbn, judul);
            mhs.pinjam(buku);
        }

        System.out.println("\n======================================================");
        System.out.println("NIM  : " + mhs.getNim());
        System.out.println("Nama : " + mhs.getNama());
        System.out.println("------------------------------------------------------");
        System.out.printf("| %-3s | %-25s | %-45s |\n", "No", "ISBN", "Judul");
        System.out.println("------------------------------------------------------");

        int no = 1;
        for (Buku b : mhs.getDaftarPinjaman()) {
            System.out.printf("| %-3d | %-25s | %-45s |\n",
                    no++, b.getIsbn(), b.getJudul());
        }

        System.out.println("------------------------------------------------------");

        input.close();
    }
}

