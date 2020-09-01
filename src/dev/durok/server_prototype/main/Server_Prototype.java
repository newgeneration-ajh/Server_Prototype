package dev.durok.server_prototype.main;

import dev.durok.server_prototype.network.Network;

public class Server_Prototype {
    public static void main ( String[] argv ) {
        Network network = new Network("Server Prototype");

        System.out.println(network.GetApplicationSummary());
    }
}
