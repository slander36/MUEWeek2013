package com.example.topspy;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends Activity{
	
	// Different states corresponding to different button
	// presses in the application
	
	public static final int STATE_NORMAEDA = 1;
	public static final int STATE_STRESSEDEDA = 2;
	public static final int STATE_HEAT = 3;
	public static final int STATE_ACCEL = 4;
	public static final int STATE_DEFAULT = 0;
	
	// All Things 
	
	public static int STATE_CURRENT = 0;

	// Message types sent from the DeviceConnect Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;
	private static final int REQUEST_CONNECT_DEVICE = 1;
	private final static String TAG = "Menu";	
	private static final boolean D = true;
	Button btnStart;
	BluetoothAdapter btAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		btnStart=(Button)findViewById(R.id.btnStart);
		btAdapter=BluetoothAdapter.getDefaultAdapter();
		btnStart.setOnClickListener(new Button.OnClickListener() {
		   public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			    Intent start_test=new Intent("android.intent.action.STRESS");
				startActivity(start_test);
			   
			   
			   
			}
		});
		
		
		
		
	}
	
	public boolean turnOnBt() {
		// TODO Auto-generated method stub
		Intent Enable_Bluetooth=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		startActivityForResult(Enable_Bluetooth, 1234);
		return true;
	}
    

    
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.bs_menu, menu);
        return true;
    }

    @Override
	public boolean onOptionsItemSelected(MenuItem item){
		
		if(item.getItemId() == R.id.Connect){
			if(btAdapter.isEnabled())
			{			
			Intent serverIntent = new Intent(this, DeviceListActivity.class);
            startActivityForResult(serverIntent,REQUEST_CONNECT_DEVICE);
            return true;
            }
			else
			{
			    
				Toast.makeText(getApplicationContext(),"Enable BT before connecting",Toast.LENGTH_LONG).show();
				
				
			}
			
			
		}
		else if (item.getItemId() == R.id.Enable){
			if(btAdapter.isEnabled())
			{
				Toast.makeText(getApplicationContext(),"Bluetooth is already enabled ",Toast.LENGTH_LONG).show();
				
			}
			else
			{
				
				turnOnBt();
				
			}
			
            return true;
		}
		else if (item.getItemId() == R.id.Disable){
			btAdapter.disable();
			Toast.makeText(getApplicationContext(),"Bluetooth is disabled",Toast.LENGTH_LONG).show();
			
            return true;
		}
		return false;
	}
	
	
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case MESSAGE_STATE_CHANGE:
                if(D) Log.i(TAG, "MESSAGE_STATE_CHANGE: " + msg.arg1);
                switch (msg.arg1) {
                case DeviceConnect.STATE_CONNECTED:
                    Toast.makeText(getApplicationContext(),"Sensor Connected!" ,Toast.LENGTH_LONG).show();
                    break;
                case DeviceConnect.STATE_CONNECTING:
                	Toast.makeText(getApplicationContext(),"Connecting to the sensor" ,Toast.LENGTH_SHORT).show();
                    break;
                case DeviceConnect.STATE_LISTEN:
                	Toast.makeText(getApplicationContext(),"Listening for incoming connections..." ,Toast.LENGTH_SHORT).show();
                    break;
                case DeviceConnect.STATE_NONE:
                	Toast.makeText(getApplicationContext(),"Not connected to any device" ,Toast.LENGTH_SHORT).show();
                    break;
                case DeviceConnect.STATE_ERROR:
                	Toast.makeText(getApplicationContext(),"Unable to connect due an error" ,Toast.LENGTH_SHORT).show();
                    break;
                }
                break;
            
            case MESSAGE_READ:
            	/*
            	 * Add switch for STATE corresponding to data being collected
            	 * Split the data by comma
            	 */
            	switch(Menu.STATE_CURRENT) {
            	case Menu.STATE_NORMAEDA:
            		break;
            	case Menu.STATE_STRESSEDEDA:
            		break;
            	case Menu.STATE_HEAT:
            		break;
            	case Menu.STATE_ACCEL:
            		break;
            	case Menu.STATE_DEFAULT:
            	default:
            		// Do Nothing	
            	}
            	
            	
            	byte[] readBuf = (byte[]) msg.obj;
                String readMessage = new String(readBuf, 0, msg.arg1);
                break;
           
            
            }
        }
    };

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub		
		if(D) Log.d(TAG, "onActivityResult " + resultCode);
        switch (requestCode) {
        case REQUEST_CONNECT_DEVICE:
        	// When DeviceListActivity returns with a device to connect
            if (resultCode == Activity.RESULT_OK) {
                // Get the device MAC address
                String address = data.getExtras().getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);                
                BluetoothDevice device = btAdapter.getRemoteDevice(address);
                Toast.makeText(getApplicationContext(),"Trying to connect to"+ device.getName(), Toast.LENGTH_LONG).show();
                DeviceConnect SensorConnect;
                SensorConnect=new DeviceConnect(mHandler);
                SensorConnect.connect(address);
                
              }
           
            break;

        }
	}
    
    
    
    
    

}
