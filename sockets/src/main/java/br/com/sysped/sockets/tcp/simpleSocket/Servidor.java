package br.com.sysped.sockets.tcp.simpleSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    private ServerSocket serverSocket;
    
    public Servidor(){
        
        try{
            this.serverSocket = new ServerSocket(9600);
            System.out.println("Socket servidor no ar!");
        } catch (IOException ex) {
            System.out.println("Erro ao instanciar o Socket servidor na porta 9600! " + ex.getLocalizedMessage());
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public Socket connect(){
        Socket clientSocket = null;
        
        try{
            clientSocket = serverSocket.accept();
            System.out.println("Socket servidor aceitou a conexão!");
        } catch (IOException ex) {
            System.out.println("Erro ao aceitar a conexão do cliente! " + ex.getMessage());
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientSocket;
    }
    
    
}
