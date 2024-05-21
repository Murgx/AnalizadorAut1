/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Murgo
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 = "D:/Users/FGR/Documents/NetBeansProjects/Analizador/src/Codigo/Lexer.flex";
        String ruta2 = "D:/Users/FGR/Documents/NetBeansProjects/Analizador/src/Codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "D:/Users/FGR/Documents/NetBeansProjects/Analizador/src/Codigo/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
        
    }
    
    public static void generar (String ruta1, String ruta2, String[] rutaS ) throws IOException, Exception{
        File archivo; 
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        
        Path rutaSym = Paths.get("D:/Users/FGR/Documents/NetBeansProjects/Analizador/src/Codigo/sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }        
        
        Files.move(
                Paths.get("D:/Users/FGR/Documents/NetBeansProjects/Analizador/sym.java"),
                Paths.get("D:/Users/FGR/Documents/NetBeansProjects/Analizador/src/Codigo/sym.java")
        );
        
        Path rutaSin = Paths.get("D:/Users/FGR/Documents/NetBeansProjects/Analizador/src/Codigo/Sintax.java");
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        } 
        
        Files.move(
        Paths.get("D:/Users/FGR/Documents/NetBeansProjects/Analizador/Sintax.java"),
        Paths.get("D:/Users/FGR/Documents/NetBeansProjects/Analizador/src/Codigo/Sintax.java")
        );
        
    }
}
