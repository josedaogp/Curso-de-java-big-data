package Analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PracticaMap {

	public static void main(String[] args) {

		/*Creamos una lista*/
		ArrayList<Float> lista1 = new ArrayList<>();
		lista1.add(2.3F);
		lista1.add(5.0F);
		lista1.add(2.9F);
		lista1.add(7.2F);
		lista1.add(6.8F);
		
		System.out.println("Lista inicial: " + lista1);
		
		//Sacar por pantalla la lista anterior multiplicado por dos
		List<Float> listfloat = lista1.stream().map(item -> item * 2).collect(Collectors.toList());
		System.out.println("listfloat: " + listfloat);
		
		/*lista1.stream().map( item ->
		{
			item = item * 2;
			System.out.println(item);
			return item;
				
		}).collect(Collectors.toList());*/
		
		/*Sacar por pantalla cada valor del stream multiplicado por dos*/
		lista1.stream().map(item -> item * 2).forEach( doble -> System.out.println("doble: " + doble));
		
		/*Sacar por pantalla cada valor del stream al cuadrado*/
		lista1.stream().map(item -> item * item).forEach( cuadrado -> System.out.println("cuadrado: " + cuadrado));
		
		/*Sacar por pantalla cada valor del stream al cuadrado con la libreria de Math*/
		lista1.stream().map(item -> Math.pow(item, 2)).forEach( cuadrado -> System.out.println("cuadrado: " + cuadrado));
		
		System.out.println("");
		
		/*Con .parallel se ejecuta en diferentes hilos*/
		lista1.stream().parallel().map(item -> Math.pow(item, 2)).forEach( cuadrado -> System.out.println("cuadrado: " + cuadrado));
		
		//Encadenamos operaciones con map y filter.
		List<Double> resultado = lista1.stream()
									.map(item -> item - 3)
									.filter(item -> item > 1.0F)
									.map(item -> Math.pow(item, 2))
									.filter(item -> item > 2.0F)
									.collect(Collectors.toList());
		
		System.out.println("Resultado : " + resultado);
		
		//Otra forma de hacer lo mismo y mostrarlo por pantalla
		lista1.stream()
			.map(item -> item - 3)
			.filter(item -> item > 1.0F)
			.map(item -> Math.pow(item, 2))
			.filter(item -> item > 2.0F)
			.forEach(item -> System.out.println(item));
		
	}

}
