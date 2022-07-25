package com.millicom.resourcemanager.adapter.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WOCreatedLog {

	public static void generarArchivo(String path, String filename, String data, String response) throws IOException {
		try {
			
			boolean existeArchivo = false;
			SimpleDateFormat dtf = new SimpleDateFormat("YYYYMMdd");
	        Calendar calendar = Calendar.getInstance();
	        Date dateObj = calendar.getTime();
	        String formattedDate = dtf.format(dateObj);
	        
	        SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	        String fechaRegistro = fr.format(dateObj);
	        
	        String nombreArchivo = path+formattedDate+filename+".txt";
	       
	        File archivo = new File(nombreArchivo);
			existeArchivo = (!archivo.exists() ? false : true);
			
			FileWriter myWriter = new FileWriter(nombreArchivo,existeArchivo);
			myWriter.write("===================================== \n");
		    myWriter.write(fechaRegistro +" : ");
		    myWriter.write("REQUEST: "+data+"\n");
		    myWriter.write("RESPONSE: "+response+"\n");  
		    myWriter.close();
		
		} 
		    catch (IOException e) {
		      System.out.println("Error al escribir archivo: "+e.getMessage());
		      e.printStackTrace();
		    }
	}
	
}
