package br.unipe.series.controller;

import br.unipe.series.dto.DadosUsuarioFacebook;
import br.unipe.series.dto.LoginFacebookUrl;
import br.unipe.series.entity.Usuario;
import br.unipe.series.repository.UsuarioRepository;
import br.unipe.series.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/login", produces = "application/json")
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FacebookService facebookService;

    @ResponseBody
    @RequestMapping(value = "/url", method = RequestMethod.GET)
    public LoginFacebookUrl loginUrl() {
        return new LoginFacebookUrl(facebookService.createFacebookAuthorizationURL());
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.POST)
    @ResponseBody
    public Usuario createFacebookAccessToken(@PathVariable("code") String code){
        String accessToken = facebookService.createFacebookAccessToken(code);
        DadosUsuarioFacebook dados = facebookService.getDados(accessToken);
        Usuario usuario = null;
        List<Usuario> usuarios = usuarioRepository.findByFacebookId(dados.getId());

        if (usuarios.size() == 0) {
            usuario = new Usuario(dados.getId(), dados.getName(), dados.getPicture().getData().getUrl(), accessToken);
        } else {
            usuario = usuarios.get(0);
            usuario.atualizarToken(accessToken);
        }

        usuarioRepository.save(usuario);

        return usuario;
    }
}
