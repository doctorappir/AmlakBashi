package ir.elegam.amlakbashi.Activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ir.elegam.amlakbashi.Classes.FontManager;
import ir.elegam.amlakbashi.R;

public class MainActivity extends AppCompatActivity {


    TextView
            advertising_icon,
            advertising_text,
            request_icon,
            request_text;

    Typeface
            font;


    @Override
    protected void onCreate(Bundle savedInstanceState) //**********************************************************
    {//_____________________________________________________________________________________________ Start onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntroductionView();
        SetFont();
    }//_____________________________________________________________________________________________ End onCreate


    private void IntroductionView()//**************************************************************************************
    {//_____________________________________________________________________________________________ Start IntroductionView

        //** TextView **\\
        advertising_icon = (TextView) findViewById(R.id.app_header_advertising_icon);
        advertising_text = (TextView) findViewById(R.id.app_header_advertising_text);
        request_icon     = (TextView) findViewById(R.id.app_header_request_icon);
        request_text     = (TextView) findViewById(R.id.app_header_request_text);

        //** Font **\\
        font = Typeface.createFromAsset(getAssets(), "fonts/BKOODKBD.ttf");

    }//_____________________________________________________________________________________________ End IntroductionView


    private void SetFont()//**************************************************************************************
    {//_____________________________________________________________________________________________ Start SetFont
        advertising_icon    .setTypeface(FontManager.getTypeface(MainActivity.this,FontManager.FONTAWESOME));
        request_icon        .setTypeface(FontManager.getTypeface(MainActivity.this,FontManager.FONTAWESOME));
        advertising_text    .setTypeface(font);
        request_text        .setTypeface(font);
    }//_____________________________________________________________________________________________ End SetFont
}
