package br.unipe.series.controller;

import br.unipe.series.dto.DadosUsuarioFacebook;
import br.unipe.series.dto.LoginFacebookUrl;
import br.unipe.series.entity.Usuario;
import br.unipe.series.repository.UsuarioRepository;
import br.unipe.series.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/usuario", produces = "application/json")
public class UsuarioController {

    @Autowired
    private FacebookService facebookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<DadosUsuarioFacebook> getUsuario(@RequestHeader("Authorization") String accessToken){
        DadosUsuarioFacebook dadosUsuario = facebookService.getDados(accessToken);

        return new ResponseEntity<DadosUsuarioFacebook>(dadosUsuario, HttpStatus.OK);
    }
}
