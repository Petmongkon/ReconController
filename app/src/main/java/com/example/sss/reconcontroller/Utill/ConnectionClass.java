package com.example.sss.reconcontroller.Utill;

import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by U5713364 on 21/9/2560.
 */

public class ConnectionClass extends AsyncTask<Void,Void,Void>{

    private String dstIP;
    private String dstPort;
    private Socket socket;
    private InputStream inputStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] buffer;
    private String move;
    private PrintWriter printWriter;

    public ConnectionClass(String move){
        dstIP=Preference.getInstance().Get(Constant.PI_IP);
        dstPort=Preference.getInstance().Get(Constant.PI_PORT);
        this.move = move;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            socket = new Socket(dstIP,Integer.parseInt(dstPort));
            printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.flush();
            printWriter.println(move);
            printWriter.close();
            socket.close();

        }catch (UnknownHostException un){
            Log.e("Exception",un.getMessage());
            un.printStackTrace();
        }catch (IOException e){
            Log.e("Exception",e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }


}
