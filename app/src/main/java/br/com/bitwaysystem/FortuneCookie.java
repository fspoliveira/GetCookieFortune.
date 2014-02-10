package br.com.bitwaysystem;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.os.StrictMode;

public class FortuneCookie extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune_cookie);

        Button buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public void onClick(View v) {

        TextView cookieID = (TextView) findViewById(R.id.editTextIDCookie);
        TextView cookieMessage = (TextView) findViewById(R.id.editTextIDCookie);

        CookieBean cookieBean = new CookieBean(
                Integer.parseInt(cookieID.getText().toString()));

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        SoapServices ws = new SoapServices();

        String values[] = ws.getFortuneCookie(cookieBean);
        cookieMessage.setText(values[1].toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fortune_cookie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_fortune_cookie, container, false);
            return rootView;
        }
    }

}