package app.xu.com.listtext;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * show item`s content
 * Created by xu on 2015/12/5.
 */
public class ListTextView extends RelativeLayout implements AdapterView.OnItemClickListener {

    /**
     * The default selected position
     */
    public static final int DEFAULT_SELECTED_ITEM = 0;

    /**
     * to show the list item
     */
    private ListView listView;

    private Context context;

    /**
     * Item`s click event
     * <p/>
     * When the item is clicked, to callback the click position and item`s data
     */
    private OnTextItemClickListener onTextItemClickListener;

    /**
     * The data of ListTextAdapter
     */
    private List<Item> items = new ArrayList<>();

    /**
     * set the selected style and unselected style
     */
    private ListTextAdapter listTextAdapter;

    /**
     * The lastPosition to record the position to change item`s isSelected status
     */
    private int lastPosition = 0;

    /**
     * The header is the ListView Head View
     * to show and remind user to scroll listview
     */
    private View header;

    /**
     * The footer is the ListView Foot View
     * to show and remind user to scroll listview
     */
    private View footer;

    private Integer DEFAULT_LAYOUT_HEIGHT = 200;

    public ListTextView(Context context) {
        super(context);
        this.context = context;
        listView = new ListView(context);
        invalidate();
        listTextAdapter = new ListTextAdapter();
        header = new HeadListTextView(context);
        footer = new FooterListTextView(context);
        listView.addFooterView(footer, null, false);
        listView.addHeaderView(header, null, false);
        listView.setOnItemClickListener(this);
        listView.setAdapter(listTextAdapter);
        listView.setDivider(null);
        listView.setVerticalScrollBarEnabled(false);
        listView.setHeaderDividersEnabled(true);
        listView.setFooterDividersEnabled(true);
        setLayoutParam();
        this.addView(listView);
    }

    public ListTextView(Context context, AttributeSet attributes) {
        super(context, attributes);
        this.context = context;
        invalidate();
        listView = new ListView(context, attributes);
        header = new HeadListTextView(context);
        listView.addHeaderView(header, null, false);
        footer = new FooterListTextView(context);
        listView.addFooterView(footer, null, false);
        listTextAdapter = new ListTextAdapter();
        listView.setOnItemClickListener(this);
        listView.setAdapter(listTextAdapter);
        listView.setDivider(null);
        setLayoutParam();
        listView.setVerticalScrollBarEnabled(false);
        this.addView(listView);
    }

    public ListTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        listView = new ListView(context, attrs, defStyleAttr);
        invalidate();
        header = new HeadListTextView(context);
        listView.addHeaderView(header, null, false);
        footer = new FooterListTextView(context);
        listView.addFooterView(footer, null, false);
        listTextAdapter = new ListTextAdapter();
        listView.setOnItemClickListener(this);
        listView.setAdapter(listTextAdapter);
        listView.setDivider(null);
        setLayoutParam();
        listView.setVerticalScrollBarEnabled(false);
        this.addView(listView);
    }
//
//    public ListTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        this.context = context;
//        invalidate();
//        listView = new ListView(context, attrs, defStyleAttr, defStyleRes);
//        header = new HeadListTextView(context);
//        listView.addHeaderView(header, null, false);
//        footer = new FooterListTextView(context);
//        listView.addFooterView(footer, null, false);
//        listTextAdapter = new ListTextAdapter();
//        listView.setOnItemClickListener(this);
//        listView.setAdapter(listTextAdapter);
//        listView.setDivider(null);
//        setLayoutParam();
//        listView.setVerticalScrollBarEnabled(false);
//        this.addView(listView);
//    }

    /**
     * to set the default selected position
     * <p/>
     * set the position to ListView that show the selected view
     * <p/>
     *
     * @param which position
     */
    public void setSelection(int which) {
        if (which > items.size()) {
            throw new ArrayIndexOutOfBoundsException("the index is out of items size");
        } else {
            items.get(which).setIsSelected(true);
            lastPosition = which;
            listTextAdapter.notifyDataSetChanged();
            listView.smoothScrollToPosition(which);
        }
    }

    /**
     * set the layout height , width default 34dp
     *
     * @param height 高度，单位 dp
     */
    public void setHeight(int height) {
        this.DEFAULT_LAYOUT_HEIGHT = height;
        setLayoutParam();
    }

    // set the layout height , height default 200dp
    private void setLayoutParam() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 34, getResources().getDisplayMetrics()),
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_LAYOUT_HEIGHT, getResources().getDisplayMetrics()));
        listView.setLayoutParams(params);
    }

    /**
     * set the data resource
     *
     * @param items
     */
    public void setItems(List<String> items) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        } else {
            this.items.clear();
        }

        if (items == null) {
            throw new NullPointerException("the items could not null");
        } else {
            for (String item : items) {
                this.items.add(new Item(item, false));
            }
            listTextAdapter.notifyDataSetChanged();
        }
    }

    /**
     * set the callback
     *
     * @param onTextItemClickListener item click event
     */
    public void setOnTextItemClickListener(OnTextItemClickListener onTextItemClickListener) {
        this.onTextItemClickListener = onTextItemClickListener;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if ((position - 1) != lastPosition) {
            updateSelectedStatu(position - 1, lastPosition);
            lastPosition = position - 1;
            listTextAdapter.notifyDataSetChanged();
        } else {
            Log.d("OnItemClick", "Repeat Click The Same Item");
            return;
        }
        if (onTextItemClickListener != null) {
            onTextItemClickListener.onItemClickListener(position - 1, listTextAdapter.getItem(position - 1).getItemName());
        }
    }


    private void updateSelectedStatu(int currentPosition, int lastPosition) {
        items.get(currentPosition).setIsSelected(true);
        items.get(lastPosition).setIsSelected(false);
    }

    private class ListTextAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Item getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(android.R.layout.test_list_item, null);
                holder.itemText = (TextView) convertView.findViewById(android.R.id.text1);
                holder.itemText.setGravity(Gravity.CENTER);
                holder.itemText.setSingleLine();
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.itemText.setText(getItem(position).getItemName());

            if (getItem(position).isSelected()) {
                setSelectedStyle(holder.itemText);
            } else {
                setUnSelectedStyle(holder.itemText);
            }
            return convertView;
        }
    }

    // selected style
    private void setSelectedStyle(TextView itemText) {
        itemText.setTextColor(Color.parseColor("#ffffff"));
        itemText.setBackgroundColor(Color.parseColor("#0000ff"));
    }

    // unselected style
    private void setUnSelectedStyle(TextView itemText) {
        itemText.setTextColor(Color.parseColor("#000000"));
        itemText.setBackgroundColor(Color.parseColor("#ffffff"));
    }

    private static class ViewHolder {
        TextView itemText;
    }

}


