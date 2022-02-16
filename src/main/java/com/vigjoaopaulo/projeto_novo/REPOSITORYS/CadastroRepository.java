package com.vigjoaopaulo.projeto_novo.REPOSITORYS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vigjoaopaulo.projeto_novo.MODEL.Cadastro;

@Repository
public interface CadastroRepository  extends JpaRepository<Cadastro, Long>{

	
	
	boolean existsByApelido(Cadastro apelido);
	boolean existsById(int id);

}
 