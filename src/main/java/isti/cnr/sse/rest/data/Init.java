package isti.cnr.sse.rest.data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang3.tuple.Pair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import isti.cnr.sse.rest.data.Ditta;
import isti.cnr.sse.rest.data.ModelloMF;
import isti.cnr.sse.rest.data.TipoProve;
import isti.cnr.sse.rest.data.Allegato;

public class Init {



	public static List<Ditta> ini(){
		List<Ditta> e = new ArrayList<Ditta>();
        Ditta a = new Ditta("Custom", "Parma", "11");
        List<ModelloMF> misuratoriFiscali = new ArrayList<>();
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
        ModelloMF mf = new ModelloMF("TIPO1","14E","Custom", timeStamp);
        misuratoriFiscali.add(mf);
        a.setMisuratoriFiscali(misuratoriFiscali );



        e.add(a);
        Prova pp = new Prova(TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale.toString(), "",
                TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale, true,mf);
        pp.setTimeStartPHW("12/12/2016 12:15:16");
        Allegato a2 = new Allegato();
        a2.setMatricola("1122334455");
        a2.setNome("Foto1.jpg");
        a2.setTipo("image/jpeg");
        a2.setUserid("Gio");
        a2.setUrl("http://192.168.1.10:9090/cnr/sse/testhw/allegati/162023DD/"+a2.getNome());
        a2.setNumeroRapportoProva("162023DD");
        a2.setTime("12/12/2016 12:15:16");

        Allegato a1 = new Allegato();
        a1.setMatricola("1122334455");
        a1.setNome("Foto0.jpg");
        a1.setTipo("image/jpeg");
        a1.setUrl("http://192.168.1.10:9090/cnr/sse/testhw/allegati/162023DD/"+a1.getNome());
        a1.setUserid("Gio");
        a1.setNumeroRapportoProva("162023DD");
        a1.setTime("12/12/2016 12:15:16");

        pp.getListallegato().add(a1);
        pp.getListallegato().add(a2);

        mf.getProve().add(pp);
        pp = new Prova(TipoProve.Termiche.toString(), "",
                TipoProve.Termiche, true,mf);
        pp.setTimeStartPHW("12/12/2016 12:15:16");

        mf.getProve().add(pp);

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println(gson.toJson(a));



        Ditta b = new Ditta("SHS", "Roma", "1213");
        misuratoriFiscali = new ArrayList<>();
        mf = new ModelloMF("TIPO2","15E","SHS", timeStamp);
        misuratoriFiscali.add(mf);
        b.setMisuratoriFiscali(misuratoriFiscali );
        e.add(b);

        pp = new Prova(TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale.toString(), "",
                TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale, true,mf);
        mf.getProve().add(pp);
        pp.setTimeStartPHW("12/12/2016 12:15:16");
        Ditta c = new Ditta("HP", "Pisa", "121");
        misuratoriFiscali = new ArrayList<>();
        mf = new ModelloMF("TIPO3","17E","HP", timeStamp);
        misuratoriFiscali.add(mf);
        c.setMisuratoriFiscali(misuratoriFiscali );
        e.add(c);
        pp = new Prova(TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale.toString(), "",
                TipoProve.AlimentazioneBatteriaSenzaVincoloFiscale, true,mf);
        pp.setTimeStartPHW("12/12/2016 12:15:16");
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
