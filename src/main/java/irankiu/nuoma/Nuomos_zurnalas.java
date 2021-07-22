package irankiu.nuoma;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nuomos_zurnalas {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private Integer id;
	private Integer kliento_id;
    private Integer irankio_id;
    private String nuoma_nuo;
    private String nuoma_iki;
    private Integer irankio_bukle;
    
    public Nuomos_zurnalas(){	
	}
    
    public Nuomos_zurnalas(Integer id, Integer kliento_id, Integer irankio_id, String nuoma_nuo, String nuoma_iki, Integer irankio_bukle) {
		super();
		
		this.id = id;
		this.kliento_id = kliento_id;
		this.irankio_id = irankio_id;
		this.nuoma_nuo = nuoma_nuo;
		this.nuoma_iki = nuoma_iki;
		this.irankio_bukle = irankio_bukle;
	}
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getKliento_id() {
		return kliento_id;
	}

	public void setKliento_id(Integer kliento_id) {
		this.kliento_id = kliento_id;
	}
	
	public Integer getIrankio_id() {
		return irankio_id;
	}

	public void setIrankio_id(Integer irankio_id) {
		this.irankio_id = irankio_id;
	}

	public String getNuoma_nuo() {
		return nuoma_nuo;
	}

	public void setNuoma_nuo(String nuoma_nuo) {
		this.nuoma_nuo = nuoma_nuo;
		
	}
	
	public String getNuoma_iki() {
		return nuoma_iki;
	}

	public void setNuoma_iki(String nuoma_iki) {
		this.nuoma_iki = nuoma_iki;
	}
	
	public Integer getIrankio_bukle() {
		return irankio_bukle;
	}

	public void setIrankio_bukle(Integer irankio_bukle) {
		this.irankio_bukle = irankio_bukle;
	}
}
