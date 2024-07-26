package com.example.demo.infra;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "usuario_entity")
public class UsuarioEntity {
	
	@Id
	private String id;
	private String nome;
	private String email;
}
