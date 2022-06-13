package com.spring.security.medi.care.app.controller;

import com.spring.security.medi.care.app.usuario.domain.Usuario;
import com.spring.security.medi.care.app.usuario.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
class AccountController {

	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	private final UsuarioService usuarioService;

	@Autowired
	public AccountController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * See section `Run Tests` at README.adoc to learn how to test.
	 */
	@RequestMapping(value = "/accounts", method = RequestMethod.GET , produces = MediaType.TEXT_HTML_VALUE )
	public String show(Model model) {

		LOG.info("entering  in show usuarios sistema");
		List<Usuario> usuariosList = usuarioService.buscarusuariosSistema();
		LOG.info("cantidad de usuarios encontrados: "+ usuariosList.size());

		LOG.info("agregando resultado al modelo");
		model.addAttribute("usuarioListBean", usuariosList);
		LOG.info("Return the view to use for rendering the response");
		// Return the view to use for rendering the response
		return "/pages/accounts/show";
	}
}