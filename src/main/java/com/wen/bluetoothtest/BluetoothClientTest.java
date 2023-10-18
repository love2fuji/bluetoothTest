package com.wen.bluetoothtest;

import javax.bluetooth.RemoteDevice;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * @author edgar
 * @version v1.0
 * @description: TODO
 * @date 2023/10/18 15:40
 */
public class BluetoothClientTest {
    public static void main(String[] argv) {
        final String serverUUID = "1000110100001000800000805F9B34FB"; //需要与服务端相同

        BluetoothClient client = new BluetoothClient();

        Vector<RemoteDevice> remoteDevices = new Vector<>();

        client.setOnDiscoverListener(new BluetoothClient.OnDiscoverListener() {

            @Override
            public void onDiscover(RemoteDevice remoteDevice) {
                remoteDevices.add(remoteDevice);
            }

        });

        client.setClientListener(new BluetoothClient.OnClientListener() {

            @Override
            public void onConnected(InputStream inputStream, OutputStream outputStream) {
                System.out.printf("Connected");
                //添加通信代码
            }

            @Override
            public void onConnectionFailed() {
                System.out.printf("Connection failed");
            }

            @Override
            public void onDisconnected() {

            }

            @Override
            public void onClose() {

            }

        });

        try {
            client.find();

//            if (remoteDevices.size() > 0) {
//                client.startClient(remoteDevices.firstElement(), serverUUID);
//            }

            if (remoteDevices.size() > 0) {
                for (RemoteDevice device : remoteDevices) {

                    System.out.print("Discovered Bluetooth Device Name: " + device.getFriendlyName(false));
                    System.out.println("; Device Address: " + device.getBluetoothAddress());
                }
//                client.startClient(remoteDevices.firstElement(), serverUUID);
            } else {
                System.out.println("No Bluetooth devices found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
