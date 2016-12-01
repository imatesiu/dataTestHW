package isti.cnr.sse.rest.data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang3.tuple.Pair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import isti.cnr.sse.rest.data.Ditta;
import isti.cnr.sse.rest.data.ModelloMF;
import isti.cnr.sse.rest.data.TipoProve;

public class Init {



	public static List<Ditta> ini(){
		List<Ditta> e = new ArrayList<Ditta>();
		Ditta a = new Ditta("Custom", "Parma", "11");
		List<ModelloMF> misuratoriFiscali = new ArrayList<>();
		ModelloMF mf = new ModelloMF("TIPO1","14E","Custom");
		misuratoriFiscali.add(mf);
		a.setMisuratoriFiscali(misuratoriFiscali );



		e.add(a);
		Prova pp = new Prova(TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale.toString(), "", 
				TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale, true,mf);
		mf.getProve().add(pp);
		pp = new Prova(TipoProve.Termiche.toString(), "", 
				TipoProve.Termiche, true,mf);
		mf.getProve().add(pp);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		System.out.println(gson.toJson(a));

		Ditta b = new Ditta("SHS", "Roma", "1213");
		misuratoriFiscali = new ArrayList<>();
		mf = new ModelloMF("TIPO2","15E","SHS");
		misuratoriFiscali.add(mf);
		b.setMisuratoriFiscali(misuratoriFiscali );
		e.add(b);

		pp = new Prova(TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale.toString(), "", 
				TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale, true,mf);
		mf.getProve().add(pp);

		Ditta c = new Ditta("HP", "Pisa", "121");
		misuratoriFiscali = new ArrayList<>();
		mf = new ModelloMF("TIPO3","17E","HP");
		misuratoriFiscali.add(mf);
		c.setMisuratoriFiscali(misuratoriFiscali );
		e.add(c);
		pp = new Prova(TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale.toString(), "", 
				TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale, true,mf);
		mf.getProve().add(pp);
		return e;
	}

	public static Map<String, List<String>> getIni(){

		List<Ditta> element = ini();

		List<String> e = new ArrayList<String>();
		for (Ditta d : element) {
			e.add(d.getNomeDitta());
			List<String> t = new ArrayList<String>();
			for ( ModelloMF m : d.getMisuratoriFiscali()) {
				t.add(m.getNomeModello());
			}
		}




		return  null;
	}


	public static Map<String, Ditta> getini(){

		List<Ditta> element = ini();

		Map<String, Ditta> e = new HashMap<>();
		for (Ditta d : element) {
			e.put(d.getNomeDitta(),d);
			
		}




		return  e;
	}
}
