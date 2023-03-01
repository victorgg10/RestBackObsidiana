package org.obisidiana.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "user")
@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	@Column(updatable = false, nullable = false, unique = true)
	private String email;
	
	@Column(name="first_name")
	private String name;
	
	private String password;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="confirm_id")
	private Confirms confirm;*/
	
	
	
	
}
