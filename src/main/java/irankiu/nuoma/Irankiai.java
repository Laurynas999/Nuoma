package irankiu.nuoma;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Irankiai {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer id;
    private String pavadinimas;
    private String tipas;
    private String inventoriaus_nr;
    private String isigyjimo_data;
    private Double isigyjimo_kaina;
    private Double nuomos_kaina;
    
    public Irankiai(){	
	}
    
    public Irankiai(Integer id, String pavadinimas, String tipas, String inventoriaus_nr,String isigyjimo_data,Double isigyjimo_kaina,Double nuomos_kaina) {
		super();
		
		this.id = id;
		this.pavadinimas = pavadinimas;
		this.tipas = tipas;
		this.inventoriaus_nr = inventoriaus_nr;
		this.isigyjimo_data = isigyjimo_data;
		this.isigyjimo_kaina = isigyjimo_kaina;
		this.nuomos_kaina = nuomos_kaina;
	}
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public String getTipas() {
		return tipas;
	}

	public void setTipas(String tipas) {
		this.tipas = tipas;
		
	}
	
	public String getInventoriaus_nr() {
		return inventoriaus_nr;
	}

	public void setInventoriaus_nr(String inventoriaus_nr) {
		this.inventoriaus_nr = inventoriaus_nr;
	}
	
	public String getIsigyjimo_data() {
		return isigyjimo_data;
	}

	public void setIsigyjimo_data(String isigyjimo_data) {
		this.isigyjimo_data = isigyjimo_data;
	}
	
	public Double getIsigyjimo_kaina() {
		return isigyjimo_kaina;
	}

	public void setIsigyjimo_kaina(Double isigyjimo_kaina) {
		this.isigyjimo_kaina = isigyjimo_kaina;
	}
	public Double getNuomos_kaina() {
		return nuomos_kaina;
	}

	public void setNuomos_kaina(Double nuomos_kaina) {
		this.nuomos_kaina = nuomos_kaina;
	}
}
