package net.stack3.lifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 * @author EIMEI. stack3.net
 *
 */
public class Activity2 extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });

        Button showToastOnActivity1Button = (Button)findViewById(R.id.showToastOnActivity1Button);
        showToastOnActivity1Button.setVisibility(View.INVISIBLE);
    }

    protected String getActivityTitle() {
        return "Activity2";
    }
}
