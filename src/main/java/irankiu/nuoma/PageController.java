package irankiu.nuoma;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@Autowired
	private KlientaiRepository klientai_repository;
	@Autowired
	private IrankiaiRepository irankiai_repository;
	@Autowired
	private Nuomos_zurnalasRepository nuomos_zurnalas_repository;
	
	
	@RequestMapping(path="/")	
	public  String pradzia() {
		
		return "pradzia";
	}
	
	
	@RequestMapping(path="/klientai", method= {RequestMethod.GET,RequestMethod.POST})
	public String klientai_ivedimas( 
			@RequestParam(name="id", required =true, defaultValue="")String id,
			@RequestParam(name="kategorija", required =true, defaultValue="")String kategorija,
			@RequestParam(name="pavadinimas", required =true, defaultValue="")String pavadinimas,
			@RequestParam(name="kontaktai", required =true, defaultValue="")String kontaktai,
			
			@RequestParam(name="siusti", required =true, defaultValue="")String siusti,

	Model model ) throws IOException {
		
				String url_tpl = "klientai";
				
				Iterable<Klientai> mano_klientai = klientai_repository.findAll();
				model.addAttribute("klientas",mano_klientai);
				
				if (siusti != null && siusti.equals("Patvirtinti")) {
					
					Klientai apklausa = new Klientai ( 
						null	
						,kategorija
						, pavadinimas
						, kontaktai		
					);
					klientai_repository.save(apklausa);
					
					//String vardas = klientai_repository.findById(apklausa.getId()).get().getPavadinimas();
					url_tpl="redirect:visi_klientai"/*?id=" + apklausa.getId() +"&name="+ vardas */;
	
				}
		return url_tpl;
		
	}
	
	@RequestMapping(path="/visi_klientai", method= {RequestMethod.GET,RequestMethod.POST})
	public String visi_klientai( 
			@RequestParam(name="id", required =true, defaultValue="")String id,

			@RequestParam(name="kliento_id", required =true, defaultValue="")String kliento_id,
			@RequestParam(name="irankio_id", required =true, defaultValue="")String irankio_id,
			@RequestParam(name="nuoma_nuo", required =true, defaultValue="")String nuoma_nuo,
			@RequestParam(name="nuoma_iki", required =true, defaultValue="")String nuoma_iki,
			@RequestParam(name="irankio_bukle", required =true, defaultValue="")String irankio_bukle,
			
			@RequestParam(name="siusti", required =true, defaultValue="")String siusti,

	Model model ) throws IOException {
		
		
		Iterable<Klientai> mano_klientai = klientai_repository.findAll();
			
		model.addAttribute("visu_klientu_info",mano_klientai );
		
		return "visi_klientai";

	}
	
	@RequestMapping(path="/uzsakymas", method= {RequestMethod.GET,RequestMethod.POST})
	public String uzakyti( 
			@RequestParam(name="id", required =true, defaultValue="")String id,

			@RequestParam(name="kliento_id", required =true, defaultValue="")String kliento_id,
			@RequestParam(name="irankio_id", required =true, defaultValue="")String irankio_id,
			@RequestParam(name="nuoma_nuo", required =true, defaultValue="")String nuoma_nuo,
			@RequestParam(name="nuoma_iki", required =true, defaultValue="")String nuoma_iki,
			@RequestParam(name="irankio_bukle", required =true, defaultValue="")String irankio_bukle,
			
			@RequestParam(name="siusti", required =true, defaultValue="")String siusti,

	Model model ) throws IOException {
		
		Iterable<Klientai> mano_klientai = klientai_repository.findAll();
		Iterable<Irankiai> mano_irankiai = irankiai_repository.findAll();
		Iterable<Nuomos_zurnalas> mano_zurnalas = nuomos_zurnalas_repository.findAll();
		
		model.addAttribute("visu_klientu_info",mano_klientai );
		model.addAttribute("visu_irankiu_info",mano_irankiai );
		model.addAttribute("visu_nuomos_zurnalu_info",mano_zurnalas );
		
		
		if (siusti != null && siusti.equals("Patvirtinti")) {
			
			Nuomos_zurnalas apklausa = new Nuomos_zurnalas ( 
				null	
				, Integer.parseInt(kliento_id) 
				, Integer.parseInt(irankio_id) 
				, nuoma_nuo
				, nuoma_iki
				, Integer.parseInt(irankio_bukle)
			);
			nuomos_zurnalas_repository.save(apklausa);
			
			return "ataskaita";
		}
		return "uzakymas";
	}
}
