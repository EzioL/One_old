package common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.ezio.one.R;

import com.ezio.one.AppContext;


public class BaseActivity extends AppCompatActivity {

    public AppContext getAppContext() {
        return (AppContext) getApplication();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    public void initToolbar(String title, boolean showBack, String text) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        TextView textRight = (TextView) findViewById(R.id.text_toolbar_right);
        //toolbarTitle.setCompoundDrawables(null, null, null, null);
        toolbarTitle.setText(title);
        if (showBack) {
            toolbar.setNavigationIcon(R.drawable.title_back);
        }
        if (text != null && !text.equals("")) {
            textRight.setText(text);
            textRight.setVisibility(View.VISIBLE);
        }
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void initToolbarWithSearch(String title, String text) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        TextView textRight = (TextView) findViewById(R.id.text_toolbar_right);
        toolbarTitle.setText(title);
        toolbar.setNavigationIcon(R.mipmap.search);

        if (text != null && !text.equals("")) {
            textRight.setText(text);
            textRight.setVisibility(View.VISIBLE);
        }
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //

            }
        });
    }
    public void setToolbarTitle(String title){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbarTitle.setText(title);
    }

}
