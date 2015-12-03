package setec2015.app.ble;

import android.app.Activity;
import android.app.DownloadManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;

import java.lang.Override;import java.lang.System;import java.util.UUID;

import static android.support.v4.app.ActivityCompat.startActivityForResult;


/**
 * Created by chico on 27/11/2015.
 */
public class BLE {
    BluetoothManager ManBLE;
    BluetoothAdapter BLE_Adapter;
    BluetoothDevice DevBLE;
    private final static long TIME = 10000; //scanning time in miliseconds
    UUID[] id = new UUID[3]; // 3 UUIDs => 3 Pandlets?

    public void initBLE(){
        final boolean REQUEST_ENABLE_BT = true;
        ManBLE = (BluetoothManager)getSystemService(Context.BLUETOOTH_SERVICE);
        //Porque é que não reconhece?
        // Android Developers
        BLE_Adapter = ManBLE.getAdapter();
        Activity action = new Activity();
        if(BLE_Adapter.isEnabled())
            System.out.println("[INIT] Got BLE Adapter! NAME: " +
                    BLE_Adapter.getName() + "\n [INIT] OVER and OUT! \n");
        else {
            System.out.println("[INIT] Trying to Enable Adapter.\n" + "[INIT] Result: " + BLE_Adapter.enable() + "\n");
            //Pop-up caso BLE não esteja enabled
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            //startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT); // Problem
            //Porque é que pede as 4 variaveis? supostamente são só 2!
            //Android Developers
            if (BLE_Adapter.isEnabled()) System.out.println("[INIT] Everything is fine!\n" +
                    "[INIT] BLE Adapter NAME: " + BLE_Adapter.getName() + "\n [INIT] Over and OUT!\n");
            else System.out.println("[INIT] Something went Terribly WRONG!\n [INIT] Stopping...\n");
        }
    }

    // Existem 2 possibilidades ou procuramos os devices que tem um serviço especifico- UUID search
    // Ou procuramos geralmente todos os BLE Devices

    /*
    * Override of the BLE normal scan. Does what this code says when new devices are found.
    * @param device device that was found
    *
    */
    private BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(final BluetoothDevice device, final int rssi, final byte[] scanRecord) {
            // your implementation here
        }
    }

     /*
      * Search for a specific device that has a certain service UUID
      * @param services array of UUID services
      * @param callback BluetoothAdapter.LeScanCallback
      * @return true if scan started successfully otherwise false
     */
    public boolean startLeScan (UUID[] services, BluetoothAdapter.LeScanCallback callback){
        //
    }



    /*
    public int scanForBLE(){
        byte[] address;
        DevBLE = ;
        //DevBLE = BLE_Adapter.getRemoteDevice(address);
    }*/
}
