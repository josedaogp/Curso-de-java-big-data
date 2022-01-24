package com.example.AplicacionDataBase;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HolaMundo implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProductoRepositorio repositorio;
	
	@Autowired
	private ProductoServicio productoServicio;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Creación de dos productos usando el constructor con parámetros
		Producto producto1 = new Producto(1L, "Libro Fundación", 3.0F); 
		Producto producto2 = new Producto(2L, "Coche", 2.0F); 
		
		//Metemos el producto1 en base de datos
		//repositorio.save(producto1); //-> También se puede hacer de esta forma
		productoServicio.crearProducto(producto1);
		
		repositorio.save(producto2);
		//producto2.setNombre("Nuevo nombre");
		repositorio.save(producto2);
		
		Optional<Producto> productoLeido = repositorio.findById(2L);
		
		if (productoLeido.isPresent()) {
			Producto p = productoLeido.get();
			//log.info("El producto es: {} {} {}", p.getId(), p.getNombre(), p.getPrecio() );
			log.info("El producto es: {}", p);
		}
		else {
			log.error("El producto no se ha encontrado");
		}
		
		
		/*List<Producto> listaProducto = repositorio.findAll();
		
		Stream<Producto> flujo = listaProducto.stream();
		
		flujo.forEach( elemento -> log.info("El producto (foreach) es: {} {} {}", elemento.getId(), elemento.getNombre(), elemento.getPrecio()));*/
		
		repositorio.findAll()
			.stream()
			.forEach(elemento -> log.info("{}", elemento));
		
	}
	
}
