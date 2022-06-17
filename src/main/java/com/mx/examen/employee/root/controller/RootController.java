package com.mx.examen.employee.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import lombok.Generated;

@Generated
@Controller
public class RootController {
	
	@GetMapping(value ="/")
    public RedirectView swaggerUi() {
		return new RedirectView("swagger-ui/#/");
    }
}

