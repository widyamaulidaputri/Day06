package basic.aktivity.day06;

public class ItemModel {
    String nama;
    String harga;
    String merek;
    int image;


    public ItemModel(String nama, String harga,String merek, int image) {
        this.nama = nama;
        this.harga = harga;
        this.merek = merek;
        this.image = image;
    }

    public String getName() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getHarga() {return harga;}

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
