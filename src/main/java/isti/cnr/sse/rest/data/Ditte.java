package isti.cnr.sse.rest.data;

import java.awt.datatransfer.StringSelection;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang3.tuple.Pair;

import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Ditte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7508221557887925709L;


	
	
	@SerializedName("ListaDitte")
    @Expose
	private List<Ditta> listaDitte = new  ArrayList<>();

	public List<Ditta> getListaDitte() {
		return listaDitte;
	}


	public void setListaDitte(List<Ditta> listaDitte) {
		this.listaDitte = listaDitte;
	}


	@Override
	public String toString() {
		return "Ditte [listaDitte=" + listaDitte + "]";
	}


	public List<String> getDitteString() {
		List<String> l = new ArrayList<>();
		for (Ditta ditta : listaDitte) {
			l.add(ditta.getNomeDitta());
		}
		return l;
	}

	
	private List<Tuple<String,String>> getDittaCert(){
		List<Tuple<String,String>> l = new ArrayList<>();
		for (Ditta ditta : listaDitte) {
			Tuple<String,String> p = Tuple.of(ditta.getNomeDitta(), String.valueOf(ditta.getMisuratoriFiscali().size()));
			l.add(p);
		}
		 return l;
	}
	
	
	private Map<String, String> getCertforYear(){
		Map<String, String> dataxcert = new HashMap<>();
		for (Ditta ditta : listaDitte) {
			for(ModelloMF m : ditta.getMisuratoriFiscali()){
				try{
					
					DateFormat format =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					Date date = format.parse(m.getDataArrivoModello());
					SimpleDateFormat df = new SimpleDateFormat("yyyy");
					String year = df.format(date);
					if(dataxcert.containsKey(year)){
						String n = dataxcert.get(year);
						int i = Integer.valueOf(n);
						i++;
						String newval = String.valueOf(i);
						dataxcert.replace(year, n, newval);
					}else{
						dataxcert.put(year, new Integer(1).toString());
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		return dataxcert;
	}
	
	public Tuple<List<Tuple<String, String>>,Map<String, String>> getStat(){
		List<Tuple<String, String>> dttec = getDittaCert();
		Map<String, String> annocert = getCertforYear();
		return Tuple.of(dttec, annocert);
	}

	public List<Tuple<String, String>> getStat2(){
		List<Tuple<String, String>> dttec = getDittaCert();
		
		return dttec;
	}
	
}
