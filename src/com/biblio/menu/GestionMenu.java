package com.biblio.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.biblio.bbdd.connection.Conexion;
import com.biblio.bbdd.query.QuerysDocumentos;
import com.biblio.bbdd.query.QuerysUsuarios;
import com.biblio.util.GestionNumeros;

public class GestionMenu {
	public static final Integer opSalir = 10;
	public static Object documentoSeleccionado;

	/**
	 * Menu con las opciones que puede gestionar el bibliotecario
	 * 
	 * @param scan el Scanner
	 * @return entero con la opcion seleccionada
	 */
	public static Integer mostrarMenu(Scanner scan) {
		System.out.println("1 - Seleccionar documento por titulo.");
		System.out.println("2 - ");
		System.out.println("3 - ");
		System.out.println("4 - ");
		System.out.println("5 - Buscar usuario por dni ");
		System.out.println("6 - ");
		System.out.println("7 - ");
		System.out.println("8 - ");
		System.out.println("9 - ");
		System.out.println("10 - Salir.");
		Integer opcion = GestionNumeros.scanNumero("Introduce un numero entre 1 y " + opSalir, scan);
		return opcion;
	}

	/**
	 * Gestion del menu, mostramos el menu mientras no se seleccione la opcion
	 * salir, para cualquier gestion hay que seleccionar primero un documento
	 * 
	 * @param conn       la Conexion con bbdd
	 * @param biblioteca la biblioteca a gestionar
	 * @param scan       Scanner
	 * @throws SQLException
	 */
	public static void menu(Connection conn, Scanner scan) throws SQLException {
		Integer seleccionada = -1;
		do {
			seleccionada = mostrarMenu(scan);
			switch (seleccionada) {
			case 1: { // Seleccionar documento por titulo.
				String titulo = GestionNumeros.scanFrase("Introduce el titulo a buscar: ", scan);
				documentoSeleccionado = QuerysDocumentos.findDocumento(conn, titulo);
				System.out.println(documentoSeleccionado);
				break;
			}
			case 2: {

				break;
			}
			case 3: {

				break;
			}
			case 4: {

				break;
			}
			case 5: {
				String dni = GestionNumeros.scanFrase("Introduzca dni: ", scan);
				System.out.println(QuerysUsuarios.findDni(conn, dni));
				break;
			}
			case 6: {

				break;
			}
			case 7: {

				break;
			}
			case 8: {

				break;
			}
			case 9: {

				break;
			}
			case 10: {
				Conexion.closeConnection();
				System.exit(0);
				break;
			}

			default: {
				System.out.println("Error. Se debe seleccionar una opcion entre 1 y " + opSalir
						+ ", vuelve a seleccionar una opcion.");
				throw new IllegalArgumentException("Unexpected value: " + seleccionada);
			}
			}
		} while (!seleccionada.equals(opSalir));
	}

}
