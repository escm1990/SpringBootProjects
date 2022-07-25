package com.example.kafka.consumer.util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.example.kafka.consumer.dto.Mensaje;

public class GenerarArchivo {

	public static void generarArchivo(Mensaje mensaje) {
		try {
			
			SimpleDateFormat dtf = new SimpleDateFormat("ddMMYYYYHHmmss");
	        Calendar calendar = Calendar.getInstance();

	        Date dateObj = calendar.getTime();
	        String formattedDate = dtf.format(dateObj);
	        
	        String nombreArchivo = "C:/TEMP/LOG_"+formattedDate+".txt";
	        System.out.println(nombreArchivo);
	 
	        
		      FileWriter myWriter = new FileWriter(nombreArchivo);
		      myWriter.write("Id: "+mensaje.getId()+"\n");
		      myWriter.write("Text: "+mensaje.getText());
		      myWriter.close();
		        
		      System.out.println("Archivo generado");

		    } 
		    catch (IOException e) {
		      System.out.println("Error al escribir archivo: "+e.getMessage());
		      e.printStackTrace();
		    }
	}
}
