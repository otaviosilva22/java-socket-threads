package modelo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Otávio
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.imageio.ImageIO;

public class Cliente {

    /**
     * @param args the command line arguments
     */
    
    private String host;
    private int porta;

    public Cliente(String host, int porta) {
            this.host = host;
            this.porta = porta;
    }

    public void executa() throws UnknownHostException, IOException {
        /*
         * Tentando se conectar ao servidor, que está rodando
         * no localhost, porta 8090
         */
        Socket cliente = new Socket(this.host, this.porta);
        //os códigos a seguir só serão executados se a conexao for bem sucedida
        System.out.println("Cliente conectado!");
        
        BufferedImage imagem = ImageIO.read(new File("src/img.jpg"));
        
        ImageIO.write(imagem,"JPG",cliente.getOutputStream());
        cliente.close();
        
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        try {
            new Cliente("127.0.0.1", 8090).executa();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }    
}
