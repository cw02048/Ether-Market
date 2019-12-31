package android.wallet.com.wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.wallet.com.wallet.web3J.Web3jHandler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity {

    EditText name, price, stock;
    Button registButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        name = (EditText) findViewById(R.id.nameEditText);
        price = (EditText) findViewById(R.id.priceEditText);
        stock = (EditText) findViewById(R.id.stockEditText2);
        registButton = (Button) findViewById(R.id.registButton);

        registButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(name.length() == 0 || price.length() == 0 || stock.length() == 0) {
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력하세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(Integer.parseInt(price.getText().toString()) <= 0 || Integer.parseInt(stock.getText().toString()) <= 0) {
                    Toast.makeText(getApplicationContext(), "가격과 재고는 0보다 커야합니다", Toast.LENGTH_SHORT).show();
                    return;
                }
                Web3jHandler.registration(name.getText().toString(), Integer.parseInt(price.getText().toString()), Integer.parseInt(stock.getText().toString()));
                Toast.makeText(getApplicationContext(), "등록 완료", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
