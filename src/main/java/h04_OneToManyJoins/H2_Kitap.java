package h04_OneToManyJoins;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="kitaplar")
public class H2_Kitap {
	
	@Id
	private int id;
	private String isim;
	
	@ManyToOne
	@JoinColumn(name="ogrId")
	private H1_Ogrenci ogrenci;

	public H2_Kitap() {
		
	}
	
	public H2_Kitap(int id, String isim) {
		this.id = id;
		this.isim = isim;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	@Override
	public String toString() {
		return "Kitap id=" + id + ", isim=" + isim;
	}

	public H1_Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(H1_Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}

}
