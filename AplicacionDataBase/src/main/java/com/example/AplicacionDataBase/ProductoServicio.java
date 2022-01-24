package com.example.AplicacionDataBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

	@Autowired
	ProductoRepositorio repositorio;
	
	public void crearProducto(Producto producto) {
		if (!repositorio.existsById(producto.getId())) {
			repositorio.save(producto);
		}else {
			
		}
		
	}
	
	public void editarProducto(Producto producto) {
		if (repositorio.existsById(producto.getId())) {
			repositorio.save(producto);
		}else {
			
		}
		
	}
}
