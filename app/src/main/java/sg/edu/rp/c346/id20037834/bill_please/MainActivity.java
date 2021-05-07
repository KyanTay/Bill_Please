package sg.edu.rp.c346.id20037834.bill_please;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText amount;
    EditText pax;
    EditText discount;
    Button noSVC;
    Button GST;
    Button split;
    Button reset;
    RadioButton cash;
    RadioButton payNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.etAmountProvided);
        pax = findViewById(R.id.etPaxNumGiven);
        discount = findViewById(R.id.etDiscountGiven);
        noSVC = findViewById(R.id.btnServiceCharge);
        GST = findViewById(R.id.btnGST);
        split = findViewById(R.id.btnSplit);
        reset = findViewById(R.id.btnReset);
        cash = findViewById(R.id.radiobtnCash);
        payNow = findViewById(R.id.radiobtnPaynow);

    }




}
