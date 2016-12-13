package app.nexd.com.listtext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import app.xu.com.listtext.listener.OnTextItemClickListener;
import app.xu.com.listtext.view.ListTextView;

public class MainActivity extends AppCompatActivity {

    private ListTextView listTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listTextView = (ListTextView) findViewById(R.id.listText);
        List<String> items = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            items.add(String.valueOf(i));
        }
//        listTextView.isShowDividingLine(true);
//        listTextView.setHeight(300);
        listTextView.setItems(items);
//        listTextView.setSelection(ListTextView.DEFAULT_SELECTED_ITEM);
        listTextView.setItemSelectedColor(R.color.colorAccent);
//        listTextView.setItemUnselectedColor(R.color.item_unselected_color);
        listTextView.setOnTextItemClickListener(new OnTextItemClickListener() {
            @Override
            public void onItemClickListener(int which, String itemName) {
                Log.i("MainActivity", "which = " + which + "\n itemName = " + itemName);
            }
        });
    }

    public void changeSelection(View view) {
        listTextView.setSelection(4);
    }
}
