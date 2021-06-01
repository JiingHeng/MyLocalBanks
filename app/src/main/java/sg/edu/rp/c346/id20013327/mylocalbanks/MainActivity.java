package sg.edu.rp.c346.id20013327.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button DBS, OCBC, UOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.tvDBS);
        OCBC = findViewById(R.id.tvOCBC);
        UOB= findViewById(R.id.tvUOB);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "English");
        menu.add(0, 0, 1, "Chinese");

        if(v == DBS) {

        } else if(v == OCBC) {

        } else if(v == UOB) {

        }
    }
}