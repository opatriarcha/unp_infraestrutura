package br.com.sysped.sockets.tcp.simpleSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    
    public void enviar( Socket socket, String mensagem){
        OutputStream out = null;
        try{
            out = socket.getOutputStream();
            out.write(mensagem.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String receber( Socket socket ){
        InputStream in = null;
        byte buffer[] = new byte[100];
        int bytesQuantity;
        String message = "";
        
        try{
            in = socket.getInputStream();
            bytesQuantity = in.read(buffer);
            if( bytesQuantity > 0){
                message = new String(buffer);
            }
        } catch (IOException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }
    
}
