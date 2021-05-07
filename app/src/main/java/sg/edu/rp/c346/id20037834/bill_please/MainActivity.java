package sg.edu.rp.c346.id20037834.bill_please;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvTotalBill;
    TextView tvSplitBill;
    EditText etAmount;
    EditText etPax;
    EditText etDiscount;
    Button btnNoService;
    Button btnGST;
    Button btnSplit;
    Button btnReset;
    RadioGroup rgPaymentMethod;
    RadioButton rbCash;
    RadioButton rbPayNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTotalBill = findViewById(R.id.tvTotalBill);
        tvSplitBill = findViewById(R.id.tvSplitBill);
        etAmount = findViewById(R.id.etAmountProvided);
        etPax = findViewById(R.id.etPaxNumGiven);
        etDiscount = findViewById(R.id.etDiscountGiven);
        btnNoService = findViewById(R.id.btnServiceCharge);
        btnGST = findViewById(R.id.btnGST);
        btnSplit = findViewById(R.id.btnSplit);
        btnReset = findViewById(R.id.btnReset);
        rbCash = findViewById(R.id.radiobtnCash);
        rbPayNow = findViewById(R.id.radiobtnPaynow);
        rgPaymentMethod = findViewById(R.id.paymentMethod);

        btnGST.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String strAmount = etAmount.getText().toString();
                String strPax = etPax.getText().toString();

                double dAmount = Double.parseDouble(strAmount);
                double sStrPax = Double.parseDouble(strPax);
                double dDiscount = Double.parseDouble(etDiscount.getText().toString());

                double gstBill = dAmount * sStrPax * 0.07;
                double svrCharge = dAmount * sStrPax * 0.1;
                double withDiscount = (dAmount * sStrPax) * (dDiscount/100);
                double dWithGstBill = (dAmount * sStrPax + gstBill + svrCharge) - withDiscount;

                if(dDiscount > 0 && dDiscount <= 100  ) {
                    tvTotalBill.setText(String.format("Total bill: $%.2f", dWithGstBill));
                }
                else{
                    tvTotalBill.setText("Please enter a valid discount value");
                }
            }
        });

        btnNoService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strAmount = etAmount.getText().toString();
                String strPax = etPax.getText().toString();

                double dAmount = Double.parseDouble(strAmount);
                double sStrPax = Double.parseDouble(strPax);
                double dDiscount = Double.parseDouble(etDiscount.getText().toString());

                double gstBill = dAmount * sStrPax * 0.07;
                double svrCharge = dAmount * sStrPax * 0.1;
                double withDiscount = (dAmount * sStrPax) * (dDiscount/100);
                double dWithoutSvrCharge = (dAmount * sStrPax + gstBill - svrCharge) - withDiscount;

                if(dDiscount > 0 && dDiscount <= 100) {
                    tvTotalBill.setText(String.format("Total bill: $%.2f", dWithoutSvrCharge));
                }
                else{
                    tvTotalBill.setText("Please enter a valid discount value");
                }
            }
        });
            btnSplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strAmount = etAmount.getText().toString();
                String strPax = etPax.getText().toString();

                double dAmount = Double.parseDouble(strAmount);
                double sStrPax = Double.parseDouble(strPax);
                double dDiscount = Double.parseDouble(etDiscount.getText().toString());


                double gstBill = dAmount * sStrPax * 0.07;
                double svrCharge = dAmount * sStrPax * 0.1;
                double withDiscount = (dAmount * sStrPax) * (dDiscount/100);
                double splitBillWithDiscount = (dAmount * sStrPax + gstBill - svrCharge - withDiscount) / sStrPax;

                int paymentCheckbox = rgPaymentMethod.getCheckedRadioButtonId();
                if(paymentCheckbox == R.id.radiobtnCash){
                    tvSplitBill.setText(String.format("Each Pays: $%.2f in cash", splitBillWithDiscount));
                }
                else{
                    tvSplitBill.setText(String.format("Each Pays: $%.2f via PayNow to 912345678", splitBillWithDiscount));
                }
            }
        });
    }
}
