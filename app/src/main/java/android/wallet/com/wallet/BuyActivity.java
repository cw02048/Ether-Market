package android.wallet.com.wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.wallet.com.wallet.web3J.Web3jHandler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionTimeoutException;

import java.io.IOException;


public class BuyActivity extends AppCompatActivity {

    String name;
    EditText stockEditText;
    TextView transactionHashAddressTextView, subDetailsTextView;
    String address;
    int price;
    int stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        TextView productName = (TextView)findViewById(R.id.productNameText);
        Button buyButton = (Button)findViewById(R.id.buyButton);

        stockEditText = (EditText) findViewById(R.id.stockEditText);

        transactionHashAddressTextView = (TextView) findViewById(R.id.buyHashTextView);
        subDetailsTextView = (TextView) findViewById(R.id.buyDetailsTextView);

        Intent intent = getIntent();

        name = intent.getExtras().getString("name");
        productName.setText(name);

        address = intent.getExtras().getString("address");
        price = Integer.parseInt(intent.getExtras().getString("price"));
        stock = Integer.parseInt(intent.getExtras().getString("stock"));

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTransaction();
            }
        });
    }

    void sendTransaction(){

        /** condition for valid transaction amount */
        if(stockEditText.length()==0){
            Toast.makeText(this, "구매 수량을 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if(stock <  Integer.parseInt(stockEditText.getText().toString())) {
            Toast.makeText(this, "구매 수량이 재고보다 많습니다", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(stock == 0) {
            Toast.makeText(this, "품절입니다", Toast.LENGTH_SHORT).show();
            return;
        }

        else if(Integer.parseInt(stockEditText.getText().toString()) == 0) {
            Toast.makeText(this, "1개 이상 구매 가능합니다", Toast.LENGTH_SHORT).show();
            return;
        }

        int finalPrice = Integer.parseInt(stockEditText.getText().toString()) * price;
        try {
            TransactionReceipt transactionReceipt = Web3jHandler.transaction(address, Double.parseDouble(Integer.toString(finalPrice)));

            transactionHashAddressTextView.setText(transactionReceipt.getTransactionHash());

            subDetailsTextView.setText("Gas Used: " + transactionReceipt.getGasUsed() + "\n" +
                    "Block Hash: " + transactionReceipt.getBlockHash());

            /** toast for showing success message */
            Toast.makeText(this, "구매 완료", Toast.LENGTH_SHORT).show();

            Web3jHandler.buy(name, Integer.parseInt(stockEditText.getText().toString()));
        } catch (InterruptedException e) {
            Toast.makeText(this, "Interruption occurred during transaction", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this, "Please check your connection", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (TransactionTimeoutException e) {
            Toast.makeText(this, "Transaction Time out", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
