package h05_crudProje;

public class Main {

	public static void main(String[] args) {
		
		//Crud islemleri icin gerekli olan class'dan nesnenin turetilmesi
		CrudMetotlar metot = new CrudMetotlar();
		
		//Tum CRUD islemleri session factory olusturan metodu calistir. 
		metot.sessionFactoryOlustur();
		
		//Veritabanina yeni personeller ekle
//		metot.personelEkle("Ahmet","Yilmaz", 5500);
//		metot.personelEkle("Mustafa","Baki", 7200);
//		metot.personelEkle("Can","Ali", 4450);
		
		metot.idIlePersonelSil(41L);
//		metot.idIlePersonelSil(44L);
//		
//		metot.tumPersoneliListele();
//		metot.idIlePersonelListele(21L);
//		
//		metot.idIleMaasGuncelle(21L, 7500);
		metot.tumPersoneliListele();
		
	}

}
