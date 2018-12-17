package accesodatos;

import java.util.ArrayList;
import modelo.Pieza;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public class ArchivoJson {
    private static final String RUTA = "data/";
    private static final String EXTENSION = ".json";

    public static boolean almacenarObjetos(ArrayList<Pieza> piezas, String nombreArchivo) {
        boolean respuesta = false;
        
        if (nombreArchivo != null) {

            Type listType = new TypeToken<List<Pieza>>(){}.getType();
            Gson gson = new Gson();
            String json = gson.toJson(piezas, listType);

            crearArchivo(nombreArchivo);

            try (FileWriter file = new FileWriter(RUTA+nombreArchivo+EXTENSION)){

                file.write(json);
                respuesta = true;

            } catch (IOException i){

                System.out.println(i.getMessage());

            } catch (Exception e){

                System.out.println(e.getMessage());

            }
        }

        return respuesta;
    }

    public static ArrayList<Pieza> recuperarObjetos(String nombre) {
        
        Gson gson = new Gson();
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(RUTA+nombre+EXTENSION));
        } catch (IOException i) {
            
            System.out.println(i.getMessage());
            
        } catch (NullPointerException pe) {
            
            System.out.println(pe.getMessage());
        }
        
        ArrayList<Pieza> pieza = gson.fromJson(br, new TypeToken<List<Pieza>>(){}.getType());
        
        return pieza;
    }
    
        
    public static String nombrarArchivo() {
        return (String)JOptionPane.showInputDialog(null, 
                "Ingrese el nombre de su archivo",
                "Guardar Lista",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);
        
    }
    
    public static void crearArchivo(String nombre) {
        String empty = "";
        try {
            Files.write(Paths.get(RUTA+nombre+EXTENSION), empty.getBytes(), StandardOpenOption.CREATE);
            System.out.println("Archivo creado");
            
        } catch (IOException i) {
            System.out.println(i.getMessage());
            
        }
    }
    
    public static List<String> listarArchivos(){
        List<String> listaArchivos = new ArrayList<>();
        try(Stream<Path> rutas = Files.walk(Paths.get(RUTA))) {
            rutas.forEach(rutaArchivo -> {
                if (Files.isRegularFile(rutaArchivo)) {
                    try {
                        listaArchivos.addAll(leerContenido(rutaArchivo));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
            
        }
        return listaArchivos;
    }
    
    public static List<String> leerContenido(Path rutaArchivos) throws IOException{
        return Files.readAllLines(rutaArchivos);
        
    }
    
    public static String buscarObjeto(){
        
        Object[] objetos = listarArchivos().toArray();
        String nombreLista = (String)JOptionPane.showInputDialog(
                    null,
                    "Seleccione su lista",
                    "Cargar Lista",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    objetos,
                    "Lista");
        
        return nombreLista;
    }
    
}