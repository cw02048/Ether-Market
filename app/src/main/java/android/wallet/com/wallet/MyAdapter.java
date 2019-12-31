package android.wallet.com.wallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<ListData> List;

    public MyAdapter(Context context, ArrayList<ListData> data) {
        mContext = context;
        List = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return List.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ListData getItem(int position) {
        return List.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.listview, null);

        TextView name = (TextView) view.findViewById(R.id.productName);
        TextView address = (TextView) view.findViewById(R.id.sellerAddress);
        TextView price = (TextView) view.findViewById(R.id.productPrice);
        TextView stock = (TextView) view.findViewById(R.id.productStock);

        name.setText((List.get(position).getName()));
        address.setText("판매자 주소: " + List.get(position).getAddress());
        price.setText("가격: " + List.get(position).getPrice() + " ETH");
        stock.setText("재고: " + List.get(position).getStock() + "개");

        return view;
    }
}
