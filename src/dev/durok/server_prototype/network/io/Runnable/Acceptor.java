package dev.durok.server_prototype.network.io.Runnable;

import dev.durok.server_prototype.network.io.Interface.IAcceptor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Acceptor implements Runnable {

    private ServerSocket mServerSocket;
    private IAcceptor mAcceptor;

    public Acceptor ( ServerSocket serverSocket , IAcceptor acceptor )
    {
        mServerSocket = serverSocket;
        mAcceptor = acceptor;
    }

    @Override
    public void run() {
        try {
            Socket tmpSocket = mServerSocket.accept();
            mAcceptor.onAcceptor(tmpSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
