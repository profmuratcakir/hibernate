package h03_OnetoOneJoins;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ogrenciler")
 public class H1_Ogrenci {
	
	@Id
	@Column(name="ogr_id")
	private int ogrId;
	
	@Column(name="ogr_adi")
	private String ogrAd;
	
	private int ogrNot;
	
	@OneToOne(mappedBy="ogrenci")
	private H2_Gunluk gunluk;
	
	public H1_Ogrenci() {
		
	}

	public H1_Ogrenci(int ogrId, String ogrAd, int ogrNot, H2_Gunluk gunluk) {
		this.ogrId = ogrId;
		this.ogrAd = ogrAd;
		this.ogrNot = ogrNot;
		this.gunluk = gunluk;
	}
	public int getOgrId() {
		return ogrId;
	}

	public void setOgrId(int ogrId) {
		this.ogrId = ogrId;
	}

	public String getOgrAd() {
		return ogrAd;
	}

	public void setOgrAd(String ogrAd) {
		this.ogrAd = ogrAd;
	}

	public int getOgrNot() {
		return ogrNot;
	}

	public void setOgrNot(int ogrNot) {
		this.ogrNot = ogrNot;
	}

	public H2_Gunluk getGunluk() {
		return gunluk;
	}

	public void setGunluk(H2_Gunluk gunluk) {
		this.gunluk = gunluk;
	}

	@Override
	public String toString() {
		return "Ogrenci : ogrId=" + ogrId + ", ogrAd=" + ogrAd + ", ogrNot=" + ogrNot;
	}
	

}