/*
 * clase para la manipulacion de archivos tanto binarios como 
 * archvios de texto plano
 */
package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Alx Mijares
 */
public class Archivo {
    
    //atributos
    private String ruta;
    private File f;
    private boolean tipo = false; //false-> archivo de texto true-> binario
    
    
    //constructores 
    public Archivo(String ruta,boolean tipo){
        this.tipo = tipo; //tipo de archivo 
        this.ruta = ruta;
        this.f = new File(this.ruta);
    }
    
    //metodos
    public void leerArchivoTexto() throws FileNotFoundException, IOException {
        
        if(!this.tipo){
            String cadena;
            FileReader fr = new FileReader(f); // abrimos el flujo de datos al archivo
            BufferedReader br = new BufferedReader(fr);
            //mientras no sea el final del archivo
            while((cadena = br.readLine())!= null){
                System.out.println(cadena);
            }
            br.close(); //cerramos el buffer
        }else{
            System.out.println("No puedo leer el archivo, es de tipo binario");
        }
    }
    
    public void escribirArchivoTexto(String cadena) throws IOException{
        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.append(cadena+"\n"); //escribimos la linea en el archivo
        
        //cerramos el archivo
        pw.close();
        bw.close();
    }
    
    //metodo para abrir un archivo binario
    public void copiarArchivoBinario(String destino) throws FileNotFoundException, IOException{ 
        
        File destinyFile = new File(destino);  //archivo copia
        InputStream in = new FileInputStream(f);  //archivo origen
        OutputStream out = new FileOutputStream(destinyFile);  //flujo al archivo destino

        byte[] buf = new byte[2048];  //arreglo que servira como buffer
        int len;    //variable para el tamaño del buffer
        while ((len = in.read(buf)) > 0) {  
            out.write(buf, 0, len);  
        }  
        in.close();  //cerramos los flujos de entrada
        out.close();  //cerramos los flujos de salida
    }
    
    
}

