package isti.cnr.sse.rest.data;

import java.util.ArrayList;
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
public class ModelloMF implements Comparable<ModelloMF>{
	
	@SerializedName("nomeModello")
    @Expose
	private String nomeModello = new String();
	
	@SerializedName("numeroRapportoProva")
    @Expose
	private String numeroRapportoProva = new String();
	 
	
	@SerializedName("nomeDitta")
	@Expose
	private String nomeDitta = new String();
	
	@SerializedName("ProveHWMisuratoreFiscale")
    @Expose
	private List<Prova> prove = new ArrayList<>();

	public ModelloMF(){
		
	}
	public ModelloMF(String nomeModello, String numeroRapportoProva, String nomeDitta) {
		super();
		this.nomeModello = nomeModello;
		this.numeroRapportoProva = numeroRapportoProva;
		this.nomeDitta = nomeDitta;
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
        if(o instanceof ModelloMF && ((ModelloMF)o).numeroRapportoProva.equals(this.numeroRapportoProva ))
            return true;
        else
            return false;   
    }
	
	
	
	
	

}
