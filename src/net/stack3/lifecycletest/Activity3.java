package net.stack3.lifecycletest;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity3 extends BaseActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setVisibility(View.INVISIBLE);

        Button showToastOnActivity1Button = (Button)findViewById(R.id.showToastOnActivity1Button);
        showToastOnActivity1Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication app = (MyApplication)getApplication();
                app.setShowToastOnActivity1(true);
                setupCurrentInfo();
            }
        });
    }

    protected String getActivityTitle() {
        return "Activity3";
    }
}
