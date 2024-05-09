package br.com.sysped.sockets.tcp.simpleSocket;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Executor {
    public static void main(String[] args) {
        
        String mensagem = null;
        Servidor servidor = new Servidor();
        Conexao conexao = new Conexao();
        
        while(true){
            Socket client = servidor.connect();
            if( client.isConnected() ){
                mensagem = conexao.receber(client);
                System.out.println(" O Cliente enviou a mensagem: " + mensagem);
                
                conexao.enviar(client, mensagem + " respondida pelo Servidor!");
                
                try {
                    client.close();
                } catch (IOException ex) {
                    Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
