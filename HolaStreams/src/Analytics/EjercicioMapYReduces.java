package Analytics;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

//Hacerlo una clase nueva 
//Hacer un stream de numeros enteros con negativos y postivios a los cuales le vamos a filtrar los negativos y calcular la suma. 
//Hacer un stream de numeros enteros con negativos y positivos, se quede con los impares y les calcule el cuadrado a todos.

public class EjercicioMapYReduces {

	public static void main(String[] args) {

		//Paso por paso
		Stream<Integer> flujo = Stream.of(1, -3, 4, 5, -9, 20); //Creo un stream nuevo de negativos y positivos
		
		Stream<Integer> soloPositivos = flujo.filter( valor -> valor >= 0); //filtro para quedarme con los positivos
		
		Optional<Integer> suma = soloPositivos.reduce((acc, i) -> acc+i); //hago la suma
		
		suma.ifPresentOrElse(System.out::println, () -> System.out.println("No hay valores")); //si suma no está vacía, la muestro. Si no, pinto que no hay valores
		
		
		//Forma Inline: Lo mismo que antes pero todo en una sentencia
		ArrayList<Integer> array = new ArrayList<>();
		
		Integer sumaInLine = array.stream()
				.filter(valor -> valor >= 0)
				.reduce(0, (acc,i) -> acc+i );
		
		System.out.println("Suma inline: "+sumaInLine);
		
		
		//Calcular cuadrados
		Stream.of(1, -3, 4, 5, -9, 20) //me creo un stream nuevo
			.map( valor -> Math.abs(valor)) //transformo los números para que estén todos en positivo (Con el Math.abs())
			.filter( valor -> valor%2 != 0) //filtro por impares (me quedo con los impares)
			.map( item -> item*item) //les calculo el cuadrado
			.forEach(System.out::println);
		
	}

}
