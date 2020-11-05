package com.abddoul.actualis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.json.simple.JSONObject;

@Entity
public class Article {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	 @Lob
	 private String titre;
	 @Lob
	 private String corps;
	 private Date datePublication;
	 private String source; 
	 private String edition;
	 private String departements;
	 private String regions;
	 private String secteurs;
	 private String themes;
	 
	 
	 /**
	  * Constructeur par défaut 
	  */
	 public Article() {
		 
	 }
	 
	 /**
	  * Constructeur avec un objet JSON
	  * @param article
	  */
	 public Article(JSONObject article) {
		this.titre = (String) article.get("titre");
		 this.corps = (String) article.get("corps");
		 try {
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
			this.datePublication = formatter.parse((String) article.get("publication_date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 this.source = (String) article.get("source");
		 this.edition = (String) article.get("edition");
		 this.departements =(String) article.get("departements");
		 this.regions = (String) article.get("regions");
		 this.secteurs = (String) article.get("secteurs");
		 this.themes = (String) article.get("themes"); 
	 }

	 /*** Accesseurs  ***/
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getDepartements() {
		return departements;
	}

	public void setDepartements(String departements) {
		this.departements = departements;
	}

	public String getRegions() {
		return regions;
	}

	public void setRegions(String regions) {
		this.regions = regions;
	}

	public String getSecteurs() {
		return secteurs;
	}

	public void setSecteurs(String secteurs) {
		this.secteurs = secteurs;
	}

	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}

	/*** Méthode toString() ***/
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", corps=" + corps + ", datePublication=" + datePublication
				+" source ="+source+" ]\n";
	}
	 
}
