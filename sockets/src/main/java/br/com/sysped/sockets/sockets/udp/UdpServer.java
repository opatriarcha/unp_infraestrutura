package br.com.sysped.sockets.sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import javax.swing.JOptionPane;

public class UdpServer{ 

    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws SocketException, IOException{
        
        DatagramSocket socket = new DatagramSocket(6666);
        JOptionPane.showMessageDialog(null, "Servidor Iniciado");
        System.out.println("Servidor Iniciado, aguardando conexão.");
        
        
        byte[] buffer = new byte[BUFFER_SIZE];
        DatagramPacket pacote = new DatagramPacket(buffer, BUFFER_SIZE);
                
        socket.receive(pacote);
        System.out.println(pacote.getAddress() + " " + pacote.getPort());
        String mensagemRecebida = new String(pacote.getData());
        
        System.out.println("Mensagem Recebida: " + mensagemRecebida);
        JOptionPane.showMessageDialog(null, mensagemRecebida, 
                "Mensagem Recebida", JOptionPane.OK_OPTION);
        
    }
}