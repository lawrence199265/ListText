package app.xu.com.listtext.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.xu.com.listtext.listener.OnTextItemClickListener;
import app.xu.com.listtext.mode.Item;

/**
 * show item`s content
 * Created by xu on 2015/12/5.
 */
public class ListTextView extends LinearLayout implements AdapterView.OnItemClickListener {

    private static final String ANDROID_NAMESPACE = "http://schemas.android.com/apk/res/android";

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
    private RootListTextView header;

    /**
     * The footer is the ListView Foot View
     * to show and remind user to scroll listview
     */
    private RootListTextView footer;

    private Integer DEFAULT_LAYOUT_HEIGHT = 200;

    private Integer DEFAULE_LAYOUT_WIDTH = 34; // default layout width is 34 dip

    private float xml_height = 0;

    private float xml_width = 0;

    public ListTextView(Context context) {
        super(context);
        this.context = context;
        listView = new ListView(context);
        invalidate();
        listTextAdapter = new ListTextAdapter();
        header = new HeadListTextView(context);
        footer = new FooterListTextView(context);
        listView.setOnItemClickListener(this);
        listView.setAdapter(listTextAdapter);
        listView.setDivider(null);
        listView.setVerticalScrollBarEnabled(false);
        listView.setHeaderDividersEnabled(true);
        listView.setFooterDividersEnabled(true);
        setLayoutParam();
        this.addView(header);
        this.addView(listView);
        this.addView(footer);
        this.setOrientation(VERTICAL);
    }

    public ListTextView(Context context, AttributeSet attributes) {
        super(context, attributes);
//        init();
        String h = attributes.getAttributeValue(ANDROID_NAMESPACE, "layout_height");
        String w = attributes.getAttributeValue(ANDROID_NAMESPACE, "layout_width");


        if (!TextUtils.isEmpty(h)) {
            if (h.contains("dip")) {
                h = h.substring(0, h.lastIndexOf("d"));
            }
            xml_height = Float.parseFloat(h);
        }

        if (!TextUtils.isEmpty(w)) {
            if (w.contains("dip")) {
                w = w.substring(0, w.lastIndexOf("d"));
            }
            xml_width = Float.parseFloat(w);
        }
        this.context = context;
        invalidate();
        listView = new ListView(context, attributes);
        header = new HeadListTextView(context);
        footer = new FooterListTextView(context);
        listTextAdapter = new ListTextAdapter();
        listView.setOnItemClickListener(this);
        listView.setAdapter(listTextAdapter);
        listView.setDivider(null);
        listView.setVerticalScrollBarEnabled(false);
        setLayoutParam();
        this.addView(header);
        this.addView(listView);
        this.addView(footer);
        this.setOrientation(VERTICAL);
    }

    public ListTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        listView = new ListView(context, attrs, defStyleAttr);
        invalidate();
        header = new HeadListTextView(context);
        footer = new FooterListTextView(context);
        listTextAdapter = new ListTextAdapter();
        listView.setOnItemClickListener(this);
        listView.setAdapter(listTextAdapter);
        listView.setDivider(null);
        listView.setVerticalScrollBarEnabled(false);
        setLayoutParam();
        this.addView(header);
        this.addView(listView);
        this.addView(footer);
        this.setOrientation(VERTICAL);
    }

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
     */
    private void setHeight() {
//        if (xml_width == -1 || xml_width < DEFAULE_LAYOUT_WIDTH) { // 填充父类
////            DEFAULE_LAYOUT_WIDTH =
//        } else if (xml_width == -2) { // 文本自适应
//
//        } else if (xml_width < DEFAULE_LAYOUT_WIDTH) {
//
//        }

        // xml_height == -1 || xml_height == -2 ||
//
//        if (xml_height == -1 || xml_height == -2) {
//
//        } else if (xml_height <= 50 && (xml_height != -1 || xml_height != -2)) {
//            DEFAULT_LAYOUT_HEIGHT = 50;
//        } else if (xml_height > 50 && xml_height <= DEFAULT_LAYOUT_HEIGHT) {
//            DEFAULT_LAYOUT_HEIGHT = (int) xml_height;
//        } else if (xml_height > 200) {
//            DEFAULT_LAYOUT_HEIGHT = 200;
//        }


        int itemHeight = items.size() * 25;

//
//        //  判断当不为自适应或填充父类时,并且设置的高度不高于默认值,且大于最小值时,设置当前高度为设定高度
//        if (!(xml_height == -1 || xml_height == -2 || xml_height >= DEFAULT_LAYOUT_HEIGHT || xml_height <= 50) && itemHeight >= xml_height) {
//            DEFAULT_LAYOUT_HEIGHT = (int) xml_height;
//        } else if (xml_height >= 0 && xml_height < 50 && itemHeight >= xml_height) { // 当设定的高度小于50时, 设置当前值为最小值
//            // 当设定数值大于200时, 设定为最大值200
//            DEFAULT_LAYOUT_HEIGHT = 100;
//        } else if ((itemHeight < xml_height) && !(xml_height == -1 || xml_height == -2)) {
//            DEFAULT_LAYOUT_HEIGHT = itemHeight;
//        } else {
//            DEFAULT_LAYOUT_HEIGHT = (int) xml_height /*- 40*/;
//        }

        if (itemHeight < DEFAULT_LAYOUT_HEIGHT) {
            DEFAULT_LAYOUT_HEIGHT = itemHeight;
        }


//        if (xml_height < 50) { // 填充父类，或者是设定高度小于50时，或者自适应时， 设置默认高度为50dp
//            DEFAULT_LAYOUT_HEIGHT = 50;
//        } else if (items.size() * 25 < xml_height && items.size() * 25 <= DEFAULT_LAYOUT_HEIGHT) {
//            DEFAULT_LAYOUT_HEIGHT = items.size() * 25;
//        } else if (xml_height < items.size() * 25) {
//            DEFAULT_LAYOUT_HEIGHT = (int) (xml_height - 40);
//        }
        setLayoutParam();
    }

    // set the layout height , height default 200dp
    private void setLayoutParam() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULE_LAYOUT_WIDTH, getResources().getDisplayMetrics()),
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
        setHeight();
    }

    /**
     * set the header and footer to show the dividing line
     * <p/>
     * default false what do not show the dividing line
     *
     * @param isShowDividingLine
     */
    public void isShowDividingLine(boolean isShowDividingLine) {
        RootListTextView.isShowDividingLine = isShowDividingLine;
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
        if ((position) != lastPosition) {
            updateSelectedStatu(position, lastPosition);
            lastPosition = position;
            listTextAdapter.notifyDataSetChanged();
        } else {
            Log.d("OnItemClick", "Repeat Click The Same Item");
            return;
        }
        if (onTextItemClickListener != null) {
            onTextItemClickListener.onItemClickListener(position, listTextAdapter.getItem(position).getItemName());
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
                holder.itemText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
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


