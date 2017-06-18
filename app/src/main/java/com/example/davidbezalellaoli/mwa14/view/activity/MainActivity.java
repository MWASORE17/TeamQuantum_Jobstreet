package com.example.davidbezalellaoli.mwa14.view.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.example.davidbezalellaoli.mwa14.R;
import com.example.davidbezalellaoli.mwa14.model.session.SessionManager;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ParentActivity {

    String[] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initiation
        listView=(ListView)findViewById(R.id.buckysListView);
        editText=(EditText)findViewById(R.id.txtsearch);
        initList();
        //text changed
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int
                    after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int
                    count) {
                if(s.toString().equals("")){
                    // reset listview
                    initList();
                }
                else{
                    // perform search
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /* checking the session */
        if (!SessionManager.with(getApplicationContext()).isuserlogin()) {
            this.doChangeActivity(getApplicationContext(), AuthActivity.class);
        }
        this.setTitle("Quantum");
    }

    public void searchItem(String textToSearch){
        for(String item:items){
            //jika bukan yang dicari maka diremove
            if(!item.contains(textToSearch)){
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void initList(){
        //buat list view nya
        items = new String[]{"Lowongan Kerja Admin PT. Indofood", "Lowongan Kerja Sales PT. Deltamas Abadi", "Lowongan Kerja Accounting Medan Musik", "Lowongan Kerja IT PT. Swastisiddhi Amagra", "Lowongan Kerja Graphic Design PT. Grafika", "Lowongan Kerja Driver Blue Bird", "Lowongan Kerja Kasir PT. Matahari"};
        listItems = new ArrayList<>(Arrays.asList(items));
        //custom_row ke layout custom row untuk menampilkan gambar
        adapter = new ArrayAdapter<String>(this, R.layout.custom_row, R.id.buckysText, listItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, loker0.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //logout
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                SessionManager.with(getApplicationContext()).clearsession();
                ParentActivity.doChangeActivity(getApplicationContext(), AuthActivity.class);
                break;

            case R.id.photo:
                Intent photo = new Intent(MainActivity.this, profile_camera.class);
                startActivity(photo);
                break;

            case R.id.notes:
                Intent notes = new Intent(MainActivity.this, notes.class);
                startActivity(notes);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


}
