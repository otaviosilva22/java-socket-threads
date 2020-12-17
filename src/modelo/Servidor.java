package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/*
 * Demonstrando a comunicação entre processos através de sockets 
 * multithreading
 * Classe Servidor, que aguarda conexão de clientes. Quando uma conexão é 
 * estabelecida, o cliente é encaminhado e tratado por uma thread (socket)
 */
public class Servidor {
   
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(8090);
            System.out.println("Servidor em execução na porta 8090...");

            /*
             * Agora temos um while(true), pois queremos que o servidor
             * fique sempre aguardando por uma nova conexao
             */
            System.out.println("Servidor aguardando nova conexão...");
            //esperando por uma conexao
            Socket cliente = servidor.accept();
            /*
             * O próximo comando só será executado quando uma conexão 
             * for estabelecida
             */
            System.out.println("Nova conexão estabelacida com o cliente " +
                    cliente.getInetAddress().getHostAddress());

            //adicionando o output do cliente
            BufferedImage img =ImageIO.read(ImageIO.createImageInputStream(cliente.getInputStream()));
            
            //constroi threads
            Thread1 thread1 = new Thread1(img);
            Thread2 thread2 = new Thread2(img);
            Thread3 thread3 = new Thread3(img);
            Thread4 thread4 = new Thread4(img);
            
            //executa a thread
            thread1.start(); 
            thread2.start();
            thread3.start();
            thread4.start();
            
            
            //encerra socket
            cliente.close();
            servidor.close();
                      
        }catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
