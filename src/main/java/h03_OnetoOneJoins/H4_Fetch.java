package h03_OnetoOneJoins;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(H1_Ogrenci.class)
				.addAnnotatedClass(H2_Gunluk.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
	
		Transaction tx = session.beginTransaction();
		
		H1_Ogrenci ogrenci = new H1_Ogrenci();
		H2_Gunluk gunluk = new H2_Gunluk();
		//id=101 olan ogrencinin bilgilerin get() metodu ile sorgulayalim.
//		ogrenci = session.get(H1_Ogrenci.class, 101);
//		System.out.println(ogrenci);
				
		//id=12 olan gunlugun bilgilerini getirelim.
//		gunluk = session.get(H2_Gunluk.class, 12);
//		System.out.println(gunluk);
		
		// Ogrenciler ve Gunlukler tablolarindaki ortak olan kayıtların,
		// Ogrenci adi, gunluk yazisi(yazilar) ve ogrenci notu (ogrNot) bilgilerini sorgulayiniz.
		
		// SQL komutlari 
//		String sql1 = "SELECT o.ogr_adi, g.yazilar, o.ogrNot "
//					+ "FROM ogrenciler o INNER JOIN gunlukler g "
//					+ "ON o.ogr_id = g.ogr_id";
//		
//		List <Object[]> sonucListesi1 = session.createSQLQuery(sql1).getResultList();
//		
//		for(Object [] w: sonucListesi1) {
//			System.out.println(Arrays.toString(w));
//		}
	
		// HQL komutlari (Sadece Class ve degisken isimleri kullanimalidir. 
		// Tablo tarafindaki isimlerdirmeler kullanilmaz)
//		String hql2 = "SELECT o.ogrAd, g.yazilar, o.ogrNot "
//					+ "FROM H1_Ogrenci o INNER JOIN H2_Gunluk g "
//					+ "ON o.ogrId = g.ogrenci";
//	
//		List<Object[]> sonucListesi2 = session.createQuery(hql2).getResultList();
//		for(Object [] w: sonucListesi2) {
//			System.out.println(Arrays.toString(w));
//		}
//		
		
		// İki tablodaki kayıtlarin herseyini sorgulaylim.

		String hql3 = "FROM H1_Ogrenci o FULL JOIN H2_Gunluk g "
				    + "ON o.ogrId = g.ogrenci";
		
		List <Object []> sonucListesi3 = session.createQuery(hql3).getResultList();
		sonucListesi3.stream().forEach((x) -> System.out.println(Arrays.toString(x)));
		
		tx.commit()	;
		session.close();
		sf.close();
	}

}
