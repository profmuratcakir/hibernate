package h02_embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_Save {
	
	public static void main(String[] args) {
		
		
		Configuration con = new Configuration().
						configure("hibernate.cfg.xml").
						addAnnotatedClass(H1_Ogrenci.class);
				
	
		SessionFactory sf = con.buildSessionFactory();
				
				
		Session session = sf.openSession();

			
		Transaction tx = session.beginTransaction();
		
		H2_Dersler ders1 = new H2_Dersler("MUZIK","MAT");
		H2_Dersler ders2 = new H2_Dersler("BEDEN","FEN");
				
		H1_Ogrenci ogrenci1 = new H1_Ogrenci(101, "Ahmet  Balta", 100, ders1 );
		H1_Ogrenci ogrenci2 = new H1_Ogrenci(104, "Ahmet Yilmaz", 90, ders2 );
				
		session.save(ogrenci1);
		session.save(ogrenci2);
				
		tx.commit();
			
		sf.close();
		session.close();
	}
		
}

