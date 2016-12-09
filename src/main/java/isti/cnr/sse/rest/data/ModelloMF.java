package isti.cnr.sse.rest.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


@Generated("org.jsonschema2pojo")
@ManagedBean
@ViewScoped
public class ModelloMF implements Serializable,Comparable<ModelloMF>{
	
	@SerializedName("nomeModello")
    @Expose
	private String nomeModello = new String();
	
	@SerializedName("numeroRapportoProva")
    @Expose
	private String numeroRapportoProva = new String();
	 
	
	@SerializedName("nomeDitta")
	@Expose
	private String nomeDitta = new String();
	
	@SerializedName("dataArrivoModello")
	@Expose
	private String dataArrivoModello = new String();
	
	@SerializedName("ProveHWMisuratoreFiscale")
    @Expose
	private List<Prova> prove = new ArrayList<>();
	
	@SerializedName("isRT")
    @Expose
	private boolean RT = false;
	
	@SerializedName("isAllaperto")
    @Expose
	private boolean Allaperto = false;

	public ModelloMF(){
		
	}
	public ModelloMF(String nomeModello, String numeroRapportoProva, String nomeDitta, Date date) {
		super();
		this.nomeModello = nomeModello;
		this.numeroRapportoProva = numeroRapportoProva;
		this.nomeDitta = nomeDitta;
		this.dataArrivoModello = date.toString();
	}
	public ModelloMF(String nomeModello, String numeroRapportoProva, String nomeDitta, String date) {
		super();
		this.nomeModello = nomeModello;
		this.numeroRapportoProva = numeroRapportoProva;
		this.nomeDitta = nomeDitta;
		this.dataArrivoModello = date.toString();
	}
	
		
	
	public boolean isAllaperto() {
		return Allaperto;
	}
	public void setAllaperto(boolean allaperto) {
		Allaperto = allaperto;
	}
	public boolean isRT() {
		return RT;
	}
	public void setRT(boolean rT) {
		RT = rT;
	}
	public String getDataArrivoModello() {
		return dataArrivoModello;
	}
	public void setDataArrivoModello(String dataArrivoModello) {
		this.dataArrivoModello = dataArrivoModello;
	}
	public List<Prova> getProve() {
		if(prove==null){
			prove = new ArrayList<Prova>();
		}
		return prove;
	}
	public void setProve(List<Prova> prove) {
		this.prove = prove;
	}
	public String getNomeModello() {
		return nomeModello;
	}
	public void setNomeModello(String nomeModello) {
		this.nomeModello = nomeModello;
	}
	public String getNumeroRapportoProva() {
		return numeroRapportoProva;
	}
	public void setNumeroRapportoProva(String numeroRapportoProva) {
		this.numeroRapportoProva = numeroRapportoProva;
	}
	public String getNomeDitta() {
		return nomeDitta;
	}
	public void setNomeDitta(String nomeDitta) {
		this.nomeDitta = nomeDitta;
	}
	@Override
	public String toString() {
		return  nomeModello;
	}
	@Override
	public int compareTo(ModelloMF o) {
		
		return this.numeroRapportoProva.compareTo(o.getNumeroRapportoProva());
	}
	
	public boolean equals(Object o)
    {
		if(o instanceof ModelloMF){
			ModelloMF m = (ModelloMF)o;
			if(this.numeroRapportoProva ==null | m.numeroRapportoProva==null){
				if(this.nomeModello.equals(m.nomeModello))
					return true;
		        else
		            return false;
			}
		}
		
        if(o instanceof ModelloMF && ((ModelloMF)o).numeroRapportoProva.equals(this.numeroRapportoProva ))
            return true;
        else
            return false;   
    }
	
	
	
	
	

}
