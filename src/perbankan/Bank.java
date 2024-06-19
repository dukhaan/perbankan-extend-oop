/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package perbankan;

/**
 *
 * @author Dukhaan
 */
public class Bank {

    private Nasabah[] nasabah;
    private int jumlahNasabah;

    public Bank() {
        nasabah = new Nasabah[100];
    }

    public void tambahNasabah(String namaAwal, String namaAkhir) {
        nasabah[jumlahNasabah] = new Nasabah(namaAwal, namaAkhir);
        nasabah[jumlahNasabah].setTabungan(new Tabungan(0));
        this.jumlahNasabah++;
    }

    public int getJumlahNasabah() {
        return this.jumlahNasabah;
    }

    public Nasabah getNasabah(int indeks) {
        return this.nasabah[indeks];
    }

    public Nasabah getNasabahByIndex(int index) {
        if (index >= 0 && index < jumlahNasabah) {
            return nasabah[index];
        }
        return null;
    }
}
