package ir.elegam.amlakbashi.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import ir.elegam.amlakbashi.R;

public class MainSearch extends AppCompatActivity {

    private Spinner sMelk, sMoamle, sMantaghe;

    private String strMelk, strMoamle, strMantaghe;
    List<String> list;
    private Typeface San;
    private Toolbar toolbar;
    private TextView txtToolbar;

    public enum TypeMembers {
        PEOPLE,
        NORMAL,
        AGENCYNORMAL,
        AGENCYPRO,
    }

    int[] TypeMember = {1, 2, 3, 4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_search);
        define();

        list = new ArrayList<String>();

        list.add("نوع ملک");
        list.add("نوع ملک 1 ");
        list.add("نوع ملک 2 ");
        list.add("نوع ملک 3 ");
        addToSpinner(sMelk, list);

        list.clear();
        list.add("نوع معامله");
        list.add("نوع معامله 1 ");
        list.add("نوع معامله 2 ");
        list.add("نوع معامله 3 ");
        addToSpinner(sMoamle, list);

        list.clear();
        list.add("نوع منظقه");
        list.add("نوع منظقه 1 ");
        list.add("نوع منظقه 2 ");
        list.add("نوع منظقه 3 ");
        addToSpinner(sMantaghe, list);

    }


    private void define() {
        San = Typeface.createFromAsset(getAssets(), "fonts/SansLight.ttf");

        sMelk = (Spinner) findViewById(R.id.spinner_amlak);
        sMoamle = (Spinner) findViewById(R.id.spinner_moamele);
        sMantaghe = (Spinner) findViewById(R.id.spinner_mantaghe);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtToolbar = (TextView) findViewById(R.id.tvToolBar);
        txtToolbar.setTypeface(San);
        txtToolbar.setText("جستجو");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok_search:
                Intent intent = new Intent(MainSearch.this, ActivitySearch.class);
                intent.putExtra("TypeMember", TypeMember[TypeMembers.NORMAL.ordinal()]);
                intent.putExtra("Melk", sMelk.getSelectedItem().toString());
                intent.putExtra("Moamele", sMoamle.getSelectedItem().toString());
                intent.putExtra("Mantaghe", sMantaghe.getSelectedItem().toString());
                startActivity(intent);
                break;
        }
    }

    public void addToSpinner(Spinner spinner, List<String> sList) {
        final List<String> plantsList = new ArrayList<>(sList);

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item, plantsList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_empty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            finish();
        }
        return true;
    }

}
