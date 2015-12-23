# ListText

## Manual

### xml init

``` xml
  <app.xu.com.listtext.view.ListTextView
        android:id="@+id/list_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp" />
```

you can set other attr what you need

### onCreate 

you can get it by id from layout xml.

when it init success, you need to set the height attr by `listTextView.setHeight(int height);` ,the unit id dip;

you need to set the adapter data by `listTextView.setItems(List<String> items)`;

you need to set default selected position by `listTextView.setSelected(int position);`; warning: the position could not bigger than items` size, otherwise it will throw exception with **the index is out of items size**

and you can set the on item clicked listener when it clicked. it will be return which you clicked and what the item is by `listTextView.setOnTextItemClickListener(OnTextItemClickListener onTextItemClickListener)`.

you can write a email to `zhuangbudong@gmail.com` when you have any question.

Thank you!



