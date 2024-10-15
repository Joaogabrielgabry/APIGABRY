package br.com.calculadora.calcula.services;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

	public Double somar(double a,double b) {
		return a+b;
	}
	
	public Double subtrair(double a, double b) {
		return a-b;
	}
}
