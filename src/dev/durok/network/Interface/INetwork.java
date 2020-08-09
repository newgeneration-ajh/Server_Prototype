package dev.durok.network.Interface;

public interface INetwork {
    public boolean startService();
    public boolean stopService();
    public String getStatus();
}
