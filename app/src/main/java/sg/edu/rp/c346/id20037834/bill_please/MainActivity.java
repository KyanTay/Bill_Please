package sg.edu.rp.c346.id20037834.bill_please;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText etAmount;
    EditText etPax;
    EditText etDiscount;
    Button btnNoService;
    Button btnGST;
    Button btnSplit;
    Button btnReset;
    RadioButton rbCash;
    RadioButton rbPayNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.etAmountProvided);
        etPax = findViewById(R.id.etPaxNumGiven);
        etDiscount = findViewById(R.id.etDiscountGiven);
        btnNoService = findViewById(R.id.btnServiceCharge);
        btnGST = findViewById(R.id.btnGST);
        btnSplit = findViewById(R.id.btnSplit);
        btnReset = findViewById(R.id.btnReset);
        rbCash = findViewById(R.id.radiobtnCash);
        rbPayNow = findViewById(R.id.radiobtnPaynow);


    }




}
