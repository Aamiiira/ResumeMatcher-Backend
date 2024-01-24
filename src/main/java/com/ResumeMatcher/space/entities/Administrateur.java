package com.ResumeMatcher.space.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@EqualsAndHashCode(callSuper = false)
@Table(name = "admins")

public class Administrateur extends UserInformation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	
}
