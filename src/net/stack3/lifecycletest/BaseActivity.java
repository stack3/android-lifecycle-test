package net.stack3.lifecycletest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BaseActivity extends Activity {
	protected String getActivityTitle() {
		return null;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        setContentView(R.layout.activity);
        
        if (savedInstanceState != null) {
	        //
	        // Get previous information.
	        //
	        String previousInfo = savedInstanceState.getString("previousInfo");
	        //
	        // Set previous information on TextView.
	        //
	        TextView previousInfoTextView = (TextView)findViewById(R.id.previousInfoTextView);
	        previousInfoTextView.setText(previousInfo);
        }
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
        setupCurrentInfo();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		outState.putString("previousInfo", getCurrentInfo());
	}
	
	protected String getCurrentInfo() {
        MyApplication app = (MyApplication)getApplication();
		//
        // Set title on TextView
        //
        TextView titleTextView = (TextView)findViewById(R.id.titleTextView);
        titleTextView.setText(getActivityTitle());
        //
        // Build current Information.
        //
        StringBuilder sb = new StringBuilder();
        
        sb.append("Process ID: ");
        sb.append(android.os.Process.myPid());		
        sb.append("\n");
        
        sb.append("Application Object ID: ");
        sb.append(app.hashCode());		
        sb.append("\n");

        sb.append("Application created at: ");
        sb.append(app.getCreatedAt().getTime());		
        sb.append("\n");

        sb.append("Application isShowToastOnActivity1: ");
        sb.append(app.isShowToastOnActivity1());		
        sb.append("\n");
        
        sb.append("Activity Object ID: ");
        sb.append(this.hashCode());		
        sb.append("\n");
        
        sb.append("System property activity1.static.initializer: ");
        sb.append(System.getProperty("activity1.static.initializer"));		
        sb.append("\n");

        sb.append("System property application.on.create: ");
        sb.append(System.getProperty("application.on.create"));
        sb.append("\n");
        
        return sb.toString();
	}
	
	protected void setupCurrentInfo() {
        //
        // Set current information on TextView. 
        //
        TextView currentInfoTextView = (TextView)findViewById(R.id.currentInfoTextView);
        currentInfoTextView.setText(getCurrentInfo());
	}
}
