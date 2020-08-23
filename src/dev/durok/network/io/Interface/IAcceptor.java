package dev.durok.network.io.Interface;

import java.net.Socket;

public interface IAcceptor {
    public boolean onAcceptor (Socket socket);
}
