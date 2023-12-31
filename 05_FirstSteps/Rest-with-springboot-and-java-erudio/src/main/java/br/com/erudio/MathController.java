package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsuportedMathOperatorException;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperatorException("Please set a numeric value!");
		}
				
		return ConvertToDouble(numberOne) + ConvertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{
		if(!isNumeric(numberOne)||!isNumeric(numberTwo)) {
			throw new UnsuportedMathOperatorException("Please set a numeric value!");
		}
		return ConvertToDouble(numberOne) - ConvertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multi(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
			throws Exception{
		if(!isNumeric(numberOne)||!isNumeric(numberTwo)) {
			throw new UnsuportedMathOperatorException("Please set a numeric value!");
		}
		return ConvertToDouble(numberOne)*ConvertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
		if(!isNumeric(numberOne)||!isNumeric(numberTwo)) {
			throw new UnsuportedMathOperatorException("Please set a numeric value");
		}
		return ConvertToDouble(numberOne)/ConvertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo)
	throws Exception{
		if(!isNumeric(numberOne)||!isNumeric(numberTwo)) {
			throw new UnsuportedMathOperatorException("Please set a numeric value");
		}
		return (ConvertToDouble(numberOne)+ConvertToDouble(numberTwo))/2;
	}
	
	@RequestMapping(value = "/sqr/{numberOne}", method = RequestMethod.GET)
	public Double sqr(
			@PathVariable(value ="numberOne") String numberOne)
			
	throws Exception{
		
		if(!isNumeric(numberOne)) {
			throw new UnsuportedMathOperatorException("Please set a numeric value");
		}
		return (Math.sqrt((ConvertToDouble(numberOne))));
	}
	
	
	
	
 	private Double ConvertToDouble(String strNumber) {
			if (strNumber == null)  return 0D;
			String number = strNumber.replaceAll(",", ".");
			
			if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null)  return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	};
}
