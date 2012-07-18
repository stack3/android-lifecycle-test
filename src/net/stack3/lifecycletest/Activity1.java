package net.stack3.lifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Activity1 extends BaseActivity {
	static {
		// static initializerでSystemプロパティの設定をする
		// *** 最初に起動されるActivityでアプリケーションの初期設定を行う悪い例 **
		// 例えばActivity3がトップのときにApplication Processsがkillされ復帰した時、まずActivity3が復帰され表示される
		// もちろんActivity1のstatic initializerは呼ばれない
		// 設定したSystemプロパティはnullになる
		// SystemプロパティはMyApplicationのonCreateで設定するとよい
    	System.setProperty("activity1.static.initializer", "true");
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     
        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Activity1.this, Activity2.class);
				startActivity(intent);
			}
		});
        
        Button showToastOnActivity1Button = (Button)findViewById(R.id.showToastOnActivity1Button);
        showToastOnActivity1Button.setVisibility(View.INVISIBLE);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	
    	MyApplication app = (MyApplication)getApplication();
    	if (app.isShowToastOnActivity1()) {
    		//
    		// Activity3でsetShowToastOnActivity1されていたらToast表示
    		//
    		Toast.makeText(this, "I returned from Activity3", Toast.LENGTH_LONG).show();
    		app.setShowToastOnActivity1(false);
    		setupCurrentInfo();
    	}
    }
    
	protected String getActivityTitle() {
		return "Activity1";
	}
}