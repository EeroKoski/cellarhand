package fi.eerokoski.cellarhand.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Wine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String producer;
	private String name; 
	private String denomination; 
	private String country; 
	private String grapes;
	private int vintage;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	private Type type;
	
	public Wine() {
		super();
	}
	public Wine(String producer, String name, int vintage, String denomination, String country, String grapes, Type type) {
		super();
		this.producer = producer;
		this.name = name;
		this.denomination = denomination;
		this.country = country;
		this.grapes = grapes;
		this.type = type;
		this.vintage = vintage;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getGrapes() {
		return grapes;
	}
	public void setGrapes(String grapes) {
		this.grapes = grapes;
	}
		
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getVintage() {
		return vintage;
	}
	public void setVintage(int vintage) {
		this.vintage = vintage;
	}
	@Override
	public String toString() {
		return "Wine [id=" + id + ", producer=" + producer + ", name=" + name + ", denomination=" + denomination
				+ ", country=" + country + ", grapes=" + grapes + ", type=" + type + ", vintage=" + vintage + "]";
	}
	
	
	
	
	
	

}
