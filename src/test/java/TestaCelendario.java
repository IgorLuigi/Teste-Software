import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import paranavai.calendario.Calendario;

import static org.junit.Assert.*;

public class TestaCelendario {
    private final ByteArrayOutputStream saidaConsole = new ByteArrayOutputStream();
    private final PrintStream saidaOriginal = System.out;

    @Before
    public void executaAntes() {
        System.setOut(new PrintStream(saidaConsole));
    }

    @After
    public void executaDepois() {
        System.setOut(new PrintStream(saidaOriginal));
    }

    @Test
    public void testarimpressaoDoAnoRecebidoPorParametro() throws IOException {
        Path arquivo = Paths.get("src\\test\\resources", "2022.txt");
        String ano2022 = Files.readString(arquivo); //saida esperada
        Calendario.mostrarCalendario("2022");
        String obtido = saidaConsole.toString();
        assertEquals(ano2022.replaceAll("\\s+", ""), obtido.replaceAll("\\s+", ""));
    }

    @Test
    public void testarQuantidadeDeParametrosMaiorQueDois() throws IOException {
        Path arquivo = Paths.get("src\\test\\resources", "janeiro2022.txt");
        String janeiro2022 = Files.readString(arquivo); //saida esperada
        Calendario.mostrarCalendario("1", "2022", "12");
        String obtido = saidaConsole.toString();
        assertEquals(janeiro2022.replaceAll("\\s+", ""), obtido.replaceAll("\\s+", ""));
    }
    
    @Test
    public void testarUmParametroN„oInteiro() throws IOException {
    	//Path arquivo = Paths.get("src\\test\\resources", "janeiro2022.txt");
    	//String janeiro2022 = Files.readString(arquivo); //saida esperada
    	//Calendario.mostrarCalendario("2021");
    	//String obtido = saidaConsole.toString();
    	//assertEquals(janeiro2022.replaceAll("\\s+", ""), obtido.replaceAll("\\s+", ""));
    	
    	Throwable excecao = assertThrows(NumberFormatException.class,
    			() -> Calendario.mostrarCalendario("1,5"));
    	
    	assertEquals("mostrarCalendario: 1,5: ano invalido.", excecao.getMessage());
    }
    
    
    
    @Test 
    public void testarAnoMenorQueUm() throws IOException { 
    	//Path arquivo = Paths.get("src\\test\\resources", "janeiro2022.txt"); 
    	//String janeiro2022 = Files.readString(arquivo); //saida esperada
    	//Calendario.mostrarCalendario("1"); 
    	//String obtido = saidaConsole.toString();
    	//assertEquals(janeiro2022.replaceAll("\\s+", ""), obtido.replaceAll("\\s+","")); 
    	
    	Throwable excecao = assertThrows(NumberFormatException.class,
    			() -> Calendario.mostrarCalendario("-1"));
    	assertEquals("mostrarCalendario: -1: ano inv·lido.", excecao.getMessage());
    }
   
    @Test 
    public void testarAnoMaiorQue9999() throws IOException {
//    	Path arquivo = Paths.get("src\\test\\resources", "janeiro2022.txt"); 
//    	String janeiro2022 = Files.readString(arquivo); //saida esperada
//    	Calendario.mostrarCalendario("9999"); 
//    	String obtido = saidaConsole.toString();
//    	assertEquals(janeiro2022.replaceAll("\\s+", ""), obtido.replaceAll("\\s+","")); 
    	
    	Throwable excecao = assertThrows(NumberFormatException.class,
    			() -> Calendario.mostrarCalendario("10000"));
    	assertEquals("mostrarCalendario: 10000: ano inv·lido.", excecao.getMessage());
    }
    
    @Test 
    public void testarAnoMaiorQueMaiorQue1MenorQue9999() throws IOException {
    	Path arquivo = Paths.get("src\\test\\resources", "janeiro2022.txt"); 
    	String janeiro2022 = Files.readString(arquivo); //saida esperada
    	Calendario.mostrarCalendario("9998"); 
    	String obtido = saidaConsole.toString();
    	assertEquals(janeiro2022.replaceAll("\\s+", ""), obtido.replaceAll("\\s+","")); 
    }
    
    @Test
    public void testarMesNaoInteiroAnoN„oInteiro() throws IOException {
    	Path arquivo = Paths.get("src\\test\\resources", "marÁo2022.txt"); 
    	String marco2022 = Files.readString(arquivo); //saida esperada
    	Calendario.mostrarCalendario("3", "2001"); 
    	String obtido = saidaConsole.toString();
    	assertEquals(marco2022.replaceAll("\\s+", ""), obtido.replaceAll("\\s+","")); 
    }
    
    @Test
    public void testarMesNaoInteiroAnoMenorQue1() throws IOException {
    	
    }
    
    
//  @Test
//  public void testarAnoNaoInteiro() throws IOException {
//      Throwable excecao = assertThrows(NumberFormatException.class,
//              () -> Calendario.mostrarCalendario("@"));
//
//      assertEquals("mostrarCalendario: @: ano inv√°lido.", excecao.getMessage());
//  }    
    


}
