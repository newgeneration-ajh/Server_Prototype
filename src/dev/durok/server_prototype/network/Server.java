package dev.durok.server_prototype.network;

import dev.durok.server_prototype.network.Interface.IServer;
import dev.durok.server_prototype.network.io.Interface.IAcceptor;
import dev.durok.server_prototype.network.io.Runnable.Acceptor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Executors;

public class Server implements IServer , IAcceptor {

    private boolean mStart = false;
    private ServerSocket mServerSocket = null;
    private int mServerPort = 0;

    private HashMap<Integer , Socket> mClients = null;

    private ThreadPoolExecutor mThreadPoolExcutor = null;
    private Acceptor mAccceptor = null;

    public Server ( int portNum )
    {
        mServerPort = portNum;
        mThreadPoolExcutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        mAccceptor = new Acceptor(mServerSocket, this);

        try {
            mServerSocket = new ServerSocket(mServerPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean startServer() {

        if ( null == mServerSocket )
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean stopServer() {
        return false;
    }

    @Override
    public boolean onAcceptor(Socket socket) {
        mClients.put( socket.hashCode() , socket );
        return true;
    }
}
