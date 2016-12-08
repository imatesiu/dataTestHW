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

	
	public List<Pair<String,String>> getDittaCert(){
		List<Pair<String,String>> l = new ArrayList<>();
		for (Ditta ditta : listaDitte) {
			Pair<String,String> p = Pair.of(ditta.getNomeDitta(), String.valueOf(ditta.getMisuratoriFiscali().size()));
			l.add(p);
		}
		 return l;
	}
	
	
	public Map<String, Integer> getCertforYear(){
		Map<String, Integer> dataxcert = new HashMap<>();
		for (Ditta ditta : listaDitte) {
			for(ModelloMF m : ditta.getMisuratoriFiscali()){
				try{
					
					DateFormat format =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
					Date date = format.parse(m.getDataArrivoModello());
					SimpleDateFormat df = new SimpleDateFormat("yyyy");
					String year = df.format(date);
					if(dataxcert.containsKey(year)){
						Integer n = dataxcert.get(year);
						n++;
					}else{
						dataxcert.put(year, new Integer(1));
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		return dataxcert;
	}

}
