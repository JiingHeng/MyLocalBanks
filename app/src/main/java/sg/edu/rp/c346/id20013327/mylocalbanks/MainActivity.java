package sg.edu.rp.c346.id20013327.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button DBS, OCBC, UOB;
    String bankClicked, link, contact;
    TextView tvTranslatedText, tvTranslatedText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.tvDBS);
        OCBC = findViewById(R.id.tvOCBC);
        UOB = findViewById(R.id.tvUOB);
        tvTranslatedText = findViewById(R.id.EnglishSelection);
        tvTranslatedText2 = findViewById(R.id.ChineseSelection);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

//        menu.add(0, 0, 0, "DBS");
//        menu.add(0, 0, 1, "OCBC");
//        menu.add(0, 0, 2, "UOB");
        menu.add(0, 0, 0, "Website");
        menu.add(0, 0, 1, "Contact the bank");

        if (v == DBS) {
            bankClicked = "DBS";
        } else if (v == OCBC) {
            bankClicked = "OCBC";
        } else if (v == UOB) {
            bankClicked = "UOB";
        } else {
            bankClicked = "";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu item) {
        getMenuInflater().inflate(R.menu.menu_main, item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.EnglishSelection) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
            return true;
        } else if (item.getItemId() == R.id.ChineseSelection) {
            DBS.setText("星展银行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");
            return true;
        }
//        } else {
//            Log.e("onOptionsItemSelected", "Error, neither English Nor Chinese Selected");
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(bankClicked.equals("DBS")) {
            link = "https://www.dbs.com.sg";
            contact = "18001111111";
        } else if (bankClicked.equals("OCBC")) {
            link = "https://www.ocbc.com";
            contact = "18003633333";
        } else if (bankClicked.equals("UOB")) {
            link = "https://www.uob.com.sg";
            contact = "18002222121";
        } else {
            link= "";
            contact = "";
        }

        if(item.getItemId() == 0) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            startActivity(intent);
        } else if (item.getItemId() == 1) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact));
            startActivity(intentCall);
        }

        return super.onContextItemSelected(item);
    }

}