package br.com.sysped.sockets.tcp.simpleSocket;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlando
 */
public class Cliente {
    private static Conexao conexao;
    private static Socket socket;
    
    public Cliente(){
        try {
            socket = new Socket("localhost", 9600); // fase de negociação e conexão.
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        
        String mensagemRecebida = null;
        String mensagemEnviada = "E AE BELEZA?";
        try{
            new Cliente();
            conexao = new Conexao();
            conexao.enviar(socket, mensagemEnviada); // fase transferencia de dados
            mensagemRecebida = conexao.receber(socket);
            System.out.println("O servidor enviou de volta a mensagem: " + mensagemRecebida + " respondida pelo Servidor!");
            socket.close(); // fase de desconexão
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
