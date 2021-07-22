package irankiu.nuoma;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Klientai {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer id;
    private String kategorija;
    private String pavadinimas;
    private String kontaktai;
    
    public Klientai(){	
	}
    
    public Klientai(Integer id, String kategorija, String pavadinimas, String kontaktai) {
		super();
		
		this.id = id;
		this.kategorija = kategorija;
		this.pavadinimas = pavadinimas;
		this.kontaktai = kontaktai;
	}
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
		
	}public String getKontaktai() {
		return kontaktai;
	}

	public void setKontaktai(String kontaktai) {
		this.kontaktai = kontaktai;
	}

}
