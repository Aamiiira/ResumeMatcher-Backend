package com.ResumeMatcher.space.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateAppelOffre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//clé primaire composée
	@EmbeddedId
	private PKCandidateAppelOffre pkCandidateAppelOffre;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
	private Candidat candidat;

	@ManyToOne
	@JoinColumn(name = "idOffre", referencedColumnName = "idOffre", insertable = false, updatable = false)
	private AppelOffre appelOffre;

}
