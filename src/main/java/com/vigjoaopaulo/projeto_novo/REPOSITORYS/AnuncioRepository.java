package com.vigjoaopaulo.projeto_novo.REPOSITORYS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.vigjoaopaulo.projeto_novo.MODEL.Anuncios;

@RestController
public interface AnuncioRepository extends JpaRepository<Anuncios, Long> {

}
