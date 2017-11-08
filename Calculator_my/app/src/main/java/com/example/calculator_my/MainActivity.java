package com.example.calculator_my;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null)
        {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            FragMain fragMain = new FragMain();
            fragmentTransaction.add(R.id.fragment, fragMain);
            fragmentTransaction.commit();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                Toast toast = Toast.makeText(this, R.string.about_me, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                LinearLayout tosatContainer = (LinearLayout) toast.getView();
                ImageView ico_image = new ImageView(getApplicationContext());
                ico_image.setImageResource(R.drawable.ico_calc);
                tosatContainer.addView(ico_image, 0);
                toast.show();
                break;
            case R.id.action_exit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
