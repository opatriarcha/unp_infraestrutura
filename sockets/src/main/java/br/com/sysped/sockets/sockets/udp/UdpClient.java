package br.com.sysped.sockets.sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class UdpClient {
    
    private static final int PORT = 6666;
    private static final String HOST = "127.0.0.1";
            
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName(HOST);
        System.out.println(socket.getLocalSocketAddress());
        String mensagem = JOptionPane.showInputDialog(null, 
                "Insira a Mensagem: ");
        
        DatagramPacket pacote = new DatagramPacket(mensagem.getBytes(), 
                mensagem.length(), ip, PORT);
        
        socket.send(pacote);
        
        socket.close();

    }
}
