package dev.durok.server_prototype.network.io.Interface;

import java.net.Socket;

public interface IAcceptor {
    public boolean onAcceptor (Socket socket);
}
