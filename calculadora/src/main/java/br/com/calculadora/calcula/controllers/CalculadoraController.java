package br.com.calculadora.calcula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.calculadora.calcula.services.CalculadoraService;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@Autowired
	CalculadoraService calculadoraService;
	
    @GetMapping("/somar/{a}/{b}")
    @ResponseBody
    public ResponseEntity<Double> somar(@PathVariable double a,@PathVariable double b) {
    	Double resultado = calculadoraService.somar(a, b);
        return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("/subtrair")
    public Double subtrair(@RequestParam double a,@RequestParam double b) {
        return calculadoraService.subtrair(a,b);
    }

    @GetMapping("/multiplicar")
    public double multiplicar( double a, double b) {
        return a*b;
    }

    @GetMapping("/dividir")
    public double dividir( double a, double b) {
        if(b==0) {
        	throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        return a/b;
    }
}
