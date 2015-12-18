package app.nexd.com.listtext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.xu.com.listtext.ListTextView;
import app.xu.com.listtext.OnTextItemClickListener;

public class MainActivity extends AppCompatActivity {

    private ListTextView listTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listTextView = (ListTextView) findViewById(R.id.listText);
        List<String> items = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            items.add(String.valueOf(i));
        }
        listTextView.setHeight(300);
        listTextView.setItems(items);
        listTextView.setSelection(ListTextView.DEFAULT_SELECTED_ITEM);
        listTextView.setOnTextItemClickListener(new OnTextItemClickListener() {
            @Override
            public void onItemClickListener(int which, String itemName) {
                Log.i("MainActivity", "which = " + which + "\n itemName = " + itemName);
            }
        });
    }
}
