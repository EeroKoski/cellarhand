package fi.eerokoski.cellarhand.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Type {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long typeid;
	private String name;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
	private List<Wine> wines;

	public Type() {
	}
	
	public Type(String name) {
		this.name = name;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Wine> getWines() {
		return wines;
	}

	public void setWines(List<Wine> wines) {
		this.wines = wines;
	}

	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", name=" + name + "]";
	}
	
	
	
	

}
