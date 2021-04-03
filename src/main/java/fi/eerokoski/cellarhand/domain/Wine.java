package fi.eerokoski.cellarhand.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Wine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull(message="It was made by someone, right?")
	private String producer;
	@NotNull(message="Someone named the wine, right?")
	private String name; 
	@NotNull(message="A wine must have an appellation of origin")
	private String appellation;
	@NotNull(message="It was made in a region, right?")
	private String region;
	@NotNull(message="It was made some country, right?")
	private String country;
	@NotNull(message="It was made of grapes, right?")
	private String grapes;
	@NotNull(message="When was it made?")
	@Min(value = 1500, message=("Not that old?"))
	@Max(value = 2021, message="Not that young?")
	private String vintage;
	
	@ManyToOne
	@JoinColumn(name = "typeid")
	@Valid
	@JsonManagedReference
	private Type type;

	public Wine() {
	}

	public Wine(String producer, String name, String vintage, String appellation, String region, String country, String grapes,
			Type type) {
		super();
		this.producer = producer;
		this.name = name;
		this.appellation = appellation;
		this.region = region;
		this.country = country;
		this.grapes = grapes;
		this.vintage = vintage;
		this.type = type;
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

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getVintage() {
		return vintage;
	}

	public void setVintage(String vintage) {
		this.vintage = vintage;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Wine [id=" + id + ", producer=" + producer + ", name=" + name + ", appellation=" + appellation
				+ ", region=" + region + ", country=" + country + ", grapes=" + grapes + ", vintage=" + vintage
				+ ", type=" + type + "]";
	}
	
	
	
	
	
}
