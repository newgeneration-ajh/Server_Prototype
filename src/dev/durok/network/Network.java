package dev.durok.network;


import dev.durok.network.Interface.INetwork;

public class Network implements INetwork {
    final private String mApplicationSummary;

    public Network ( String applicationSummary ) {
        mApplicationSummary = applicationSummary;
    }

    public String GetApplicationSummary( ) {
        return mApplicationSummary;
    }

    @Override
    public boolean startService() {

        return true;
    }

    @Override
    public boolean stopService() {
        return true;
    }

    @Override
    public String getStatus() {
        return null;
    }
}
