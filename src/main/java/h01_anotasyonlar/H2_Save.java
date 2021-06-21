package h01_anotasyonlar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H2_Save {

	public static void main(String[] args) {

		// Tabloya eklenecek verilerin olusuturulmasi
		H1_Ogrenci ogr1 = new H1_Ogrenci(101, "Canan Yilmaz", 90);
		H1_Ogrenci ogr2 = new H1_Ogrenci(102, "Ilık Su Ozturk", 75);
		
		// - Veritabanı baglanti ayarlarinin yapilmasi (hibernate.cfg.xml) 
		//   ve tabloyu olusturacak class'in gosterilmesi
		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(H1_Ogrenci.class);
		
		// Veritabani ile iletisim icin bir oturum (session) tanimlanmasi
		SessionFactory sf = con.buildSessionFactory();
		
		// tanimlanan oturumun baslatilmasi 
		Session session = sf.openSession();
		
		// Belirtilen oturum icin islemlerin (yazma, okuma v.b) baslatilmasi
		Transaction tx = session.beginTransaction();
		
		// Veritabanina verilerin kaydedilmesi 
		session.save(ogr1);
		session.save(ogr2);
		
		// Yukarida yapilan islemlerin veritabanina kalici olarak iletilmesi.
		tx.commit();
		session.close();

	}

}
