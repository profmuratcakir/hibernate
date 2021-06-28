package h05_crudProje;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CrudMetotlar {
	
	private static SessionFactory factory; 
	
	public void sessionFactoryOlustur() {
	
		try {
			Configuration con = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Personel.class);
				
			factory = con.buildSessionFactory();
			
		}catch(Throwable e){
			System.err.println("Session grubu olusturulurken hata olustu "+ e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	// Veritabanına bir personel ekleyen metot (Create)
	public Long personelEkle(String ad, String soyad, int maas){
		Long personelId = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); 
			Personel personel = new Personel(ad,soyad,maas);
			personelId = (Long) session.save(personel);
			tx.commit();
		
		}catch(HibernateException e){
			//yapilan islemde bir hata oldu ise 
			if(tx != null) {
				tx.rollback(); // islemi geri al
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return personelId;
	}
	
	// Veritabanindan bir personeli silen metot(Delete)
	public void  idIlePersonelSil(Long personelId) {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Personel personel = session.get(Personel.class, personelId);
			if(personel == null) {
				System.out.println(personelId + " nolu kisinin kaydi bulunamamistir.");
			}else {
				session.delete(personel);
				tx.commit();
				System.out.println(personelId + " nolu kisinin kaydi silinmistir.");
				System.out.println("Silinen:" + personel);
			}
			
		}catch(HibernateException e) {
			//yapilan islemde bir hata oldu ise 
			if(tx != null) {
				tx.rollback(); // islemi geri al
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//Veritabanindaki tum kayitlari listeleyen metot (READ)
	public void tumPersoneliListele() {
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List<Personel> personeller = session.createQuery("FROM Personel").getResultList();
			System.out.println("************* TUM PERSONELIN LISTESI *****************");
			personeller.stream().forEach((p)-> System.out.println(p));
			
			// Alternatif yazdirma
//			personeller.stream().forEach((p) -> {
//		       System.out.print(" ID: " + p.getId()); 
//		       System.out.print(" Ad: " + p.getAd()); 
//			   System.out.print(" Soyad: " + p.getSoyad()); 
//			   System.out.println(" Maas: " + p.getMaas()); 
//		    });
			
			tx.commit();
		}catch(HibernateException e) {
			//yapilan islemde bir hata oldu ise 
			if(tx != null) {
				tx.rollback(); // islemi geri al
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//id ile bir kayidin bilgilerini listeyen metot (READ)
	public void idIlePersonelListele(Long personelId) {
		Session session = factory.openSession();
		Transaction tx = null;
			
		try {
			tx = session.beginTransaction();
			Personel personel = session.get(Personel.class, personelId);
			System.out.println("************* "+ personelId + " ID'li Personel *****************");
			if(personel == null) {
				System.out.println(personelId + " nolu kisinin kaydi bulunamamistir.");
			}else {
				tx.commit();
				System.out.println(personel);
			}
				
		}catch(HibernateException e) {
			//yapilan islemde bir hata oldu ise 
			if(tx != null) {
				tx.rollback(); // islemi geri al
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	//id ile bir kaydin maas bilgisini guncelleyen metot (UPDATE)
		public void idIleMaasGuncelle(Long personelId, int maas) {
			Session session = factory.openSession();
			Transaction tx = null;
				
			try {
				tx = session.beginTransaction();
				Personel personel = session.get(Personel.class, personelId);
				System.out.println("******** "+ personelId + " ID'li Personelin Maas Guncellemesi ***********");
				if(personel == null) {
					System.out.println(personelId + " nolu kisinin kaydi bulunamamistir.");
				}else {
					personel.setMaas(maas);
					tx.commit();
					System.out.println(personelId + " nolu personelin yeni maasi : "+ maas);
				}
			}catch(HibernateException e) {
				//yapilan islemde bir hata oldu ise 
				if(tx != null) {
					tx.rollback(); // islemi geri al
				}
				e.printStackTrace();
			}finally {
				session.close();
			}
		}
		
	

}
