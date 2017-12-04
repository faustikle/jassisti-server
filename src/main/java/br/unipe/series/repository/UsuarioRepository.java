package br.unipe.series.repository;

import br.unipe.series.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findByFacebookId(String facebookId);

    List<Usuario> findByAccessToken(String accessToken);
}
