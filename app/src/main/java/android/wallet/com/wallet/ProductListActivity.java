package android.wallet.com.wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.wallet.com.wallet.WalletProfile.WalletProfile;
import android.wallet.com.wallet.web3J.Web3jHandler;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ProductListActivity extends AppCompatActivity {

    ArrayList<ListData> productDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        this.InitializeMovieData();

        ListView listView = (ListView)findViewById(R.id.listView);
        final MyAdapter myAdapter = new MyAdapter(this, productDataList);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Toast.makeText(getApplicationContext(), myAdapter.getItem(position).getName(), Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "구매 페이지로 이동", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), BuyActivity.class);
                intent.putExtra("name", myAdapter.getItem(position).getName());
                intent.putExtra("address", myAdapter.getItem(position).getAddress());
                intent.putExtra("price", myAdapter.getItem(position).getPrice());
                intent.putExtra("stock", myAdapter.getItem(position).getStock());

                startActivity(intent);
            }
        });
    }

    public void InitializeMovieData()
    {
        productDataList = new ArrayList<ListData>();

        int productCount;
        String productName;

        int i;
        try {
            productCount = Integer.parseInt(Web3jHandler.productCount());

            for (i = 0; i < productCount; i++) {
                productName = Web3jHandler.productName(i);
                productDataList.add(new ListData(productName, Web3jHandler.address(productName),Web3jHandler.price(productName), Web3jHandler.stock(productName)));
            }
        } catch (InterruptedException e){
        } catch (ExecutionException e) {
        }

    }
}