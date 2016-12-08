package isti.cnr.sse.rest.data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;

public class Tuple<E,T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4143024411110331332L;

	private E primo;
	
	private T secondo;
	
	
	public Tuple(){
		
	}
	

	public Tuple(E primo, T secondo) {
		
		this.primo = primo;
		this.secondo = secondo;
	}

	public E getPrimo() {
		return primo;
	}

	public void setPrimo(E primo) {
		this.primo = primo;
	}

	public T getSecondo() {
		return secondo;
	}

	public void setSecondo(T secondo) {
		this.secondo = secondo;
	}


	public static <E, T> Tuple<E,T> of(E e,T t) {
		Tuple tu = new Tuple(e, t);
		return tu;
	}
	
	

}
