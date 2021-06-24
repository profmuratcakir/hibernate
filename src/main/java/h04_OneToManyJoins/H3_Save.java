package h04_OneToManyJoins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_Save {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(H1_Ogrenci.class)
				.addAnnotatedClass(H2_Kitap.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();

		H2_Kitap k1 = new H2_Kitap(1001, "Mat Kitabı");
		H2_Kitap k2 = new H2_Kitap(1002, "Fen Kitabı");	
		H2_Kitap k3 = new H2_Kitap(1003, "Biyoloji Kitabı");
		H2_Kitap k4 = new H2_Kitap(1004, "Sosyal Kitabı");
		
		// Ogrencilerin kitap listesinin olusturulmasi
		H1_Ogrenci o1 = new H1_Ogrenci(111,"Ayse Ozturk", 99);
		o1.getKitapListesi().add(k1);
		o1.getKitapListesi().add(k2);
				
		H1_Ogrenci o2 = new H1_Ogrenci(222,"Can Yilmaz", 88);
		o2.getKitapListesi().add(k3);
		o2.getKitapListesi().add(k4);

		
		H1_Ogrenci o3 = new H1_Ogrenci(333,"Berk Yatmaz", 90);
		
		// Kitaplara sahip atanmasi
		k1.setOgrenci(o1);
		k2.setOgrenci(o1);
		k3.setOgrenci(o2);
		k4.setOgrenci(o2);
		
		
		// Kitaplarin ve ogrenci nesnelerinin veritabaninana kaydedilmesi
		session.save(k1);
		session.save(k2);
		session.save(k3);
		session.save(k4);
		
		session.save(o1);
		session.save(o2);
		session.save(o3);
		
		tx.commit();
		sf.close();
		session.close();

	}

}
