package dev.durok.server_prototype.main;

import dev.durok.server_prototype.network.Network;
import dev.durok.server_prototype.network.Server;

public class Server_Prototype {
    public static void main ( String[] argv ) {
        Network network = new Network("Server Prototype");
        Server server = new Server ( 12030 );
        System.out.println(network.GetApplicationSummary());
    }
}
