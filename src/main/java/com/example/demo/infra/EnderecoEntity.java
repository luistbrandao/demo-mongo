package com.example.demo.infra;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "endereco_entity")
public class EnderecoEntity {

	@Id
	private String id;
	private String usuarioId;
	private String rua;
	private String numero;
}
