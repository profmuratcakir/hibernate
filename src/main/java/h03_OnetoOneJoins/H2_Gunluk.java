package h03_OnetoOneJoins;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="gunlukler")
public class H2_Gunluk {
	
	@Id
	private int id;
    private String yazilar;
    
    @OneToOne
    @JoinColumn(name="ogr_id")
    private H1_Ogrenci ogrenci;

    public H2_Gunluk() {

    }

	public H2_Gunluk(int id, String yazilar) {
		this.id = id;
		this.yazilar = yazilar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYazilar() {
		return yazilar;
	}

	public void setYazilar(String yazilar) {
		this.yazilar = yazilar;
	}

	public H1_Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(H1_Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}

	@Override
	public String toString() {
		return "H2_Gunluk [id=" + id + ", yazilar=" + yazilar + ", ogrenci=" + ogrenci + "]";
	}

		
}