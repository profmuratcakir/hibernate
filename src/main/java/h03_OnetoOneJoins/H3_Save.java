package h03_OnetoOneJoins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_Save {

	public static void main(String[] args) {
		
		// Gunluklerin tanimlanmasi
		H2_Gunluk gunluk1 = new H2_Gunluk(11, "Mehmet'in Gunlugu");
		H2_Gunluk gunluk2 = new H2_Gunluk(12, "Alinini Gunlugu");
		H2_Gunluk gunluk3 = new H2_Gunluk(13, "Tayyarın Gunlugu");
		
		// Ogrencilerin (sahiplerin) tanimlanmasi
		H1_Ogrenci ogrenci1 = new H1_Ogrenci(101, "Mehmet Can", 10, gunluk1);
		H1_Ogrenci ogrenci2 = new H1_Ogrenci(102, "Ali Han", 9, gunluk2);
		H1_Ogrenci ogrenci3 = new H1_Ogrenci(103, "Tayyar Tan", 11, gunluk3);
		
		// Gunluklere sahip atanmasi
		gunluk1.setOgrenci(ogrenci1);
		gunluk2.setOgrenci(ogrenci2);
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
												.addAnnotatedClass(H1_Ogrenci.class)
												.addAnnotatedClass(H2_Gunluk.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		// Gunluklerin ve ogrenci nesnelerinin veritabaninana kaydedilmesi
		session.save(gunluk1);
		session.save(gunluk2);
		session.save(gunluk3);
		
		session.save(ogrenci1);
		session.save(ogrenci2);
		session.save(ogrenci3);
		
		tx.commit();
		session.close();

	}

}