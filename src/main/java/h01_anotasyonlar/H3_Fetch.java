package h01_anotasyonlar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_Fetch {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(H1_Ogrenci.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Belirtilen tablodan istenilen id'li kisiyi getirelim.
		H1_Ogrenci ogr1  = session.get(H1_Ogrenci.class, 103);
		H1_Ogrenci ogr2 = session.get(H1_Ogrenci.class, 104);
		
		System.out.println(ogr1);
		System.out.println(ogr2);
		
		tx.commit();
		
		sf.close();
		session.close();
	}

}
