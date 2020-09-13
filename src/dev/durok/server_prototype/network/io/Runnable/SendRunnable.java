package dev.durok.server_prototype.network.io.Runnable;

import dev.durok.server_prototype.network.io.Interface.ISend;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SendRunnable implements Runnable {

    private OutputStream mOutputStream = null;
    private ISend mSendListener = null;
    private int mSocketId = 0;

    private byte[] mOperateCode = new byte[4];
    private byte[] mSendDataSize = new byte[4];
    private byte[] mSendBuffer = null;

    public SendRunnable ( OutputStream outputStream , ISend sendListener , int socketId ) {
        mOutputStream = outputStream;
        mSendListener = sendListener;
        mSocketId = socketId;
    }

    public boolean setSendBuffer ( int operateCode , byte[] sendBuffer ) {

        if ( null == sendBuffer ) {
            return false;
        }

        mOperateCode[0] = (byte) ( ( operateCode & 0xff000000 ) >> 24 );
        mOperateCode[1] = (byte) ( ( operateCode & 0x00ff0000 ) >> 16 );
        mOperateCode[2] = (byte) ( ( operateCode & 0x0000ff00 ) >> 8 );
        mOperateCode[3] = (byte) ( ( operateCode & 0x000000ff) );

        int dataSize = sendBuffer.length;

        mSendDataSize[0] = (byte) ( ( dataSize & 0xff000000 ) >> 24 );
        mSendDataSize[1] = (byte) ( ( dataSize & 0x00ff0000 ) >> 16 );
        mSendDataSize[2] = (byte) ( ( dataSize & 0x0000ff00 ) >> 8 );
        mSendDataSize[3] = (byte) ( ( dataSize & 0x000000ff) );

        mSendBuffer = sendBuffer;

        return true;
    }

    @Override
    public void run() {
        try {
            if ( null == mSendBuffer ) {

            }
            else {
                mOutputStream.write( mOperateCode , 0 , 4 );
                mOutputStream.write( mSendDataSize , 0 , 4);
                mOutputStream.write( mSendBuffer , 0 , mSendBuffer.length );
                mSendListener.onSend( mSocketId );
            }
        }
        catch ( IOException e ) {

        }
    }
}
