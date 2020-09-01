package dev.durok.server_prototype.network.Interface;

public interface INetwork {
    public boolean startService();
    public boolean stopService();
    public String getStatus();
}
