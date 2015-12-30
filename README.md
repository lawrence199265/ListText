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

you should set the layout_width and layout_height where it is wrap_content or fill_parent ,you can set other attr what you need.

### onCreate 

you can get it by id from layout xml.

you need to set the adapter data by `listTextView.setItems(List<String> items)`;

you need to set default selected position by `listTextView.setSelected(int position);`; 

warning: the position could not bigger than items` size, otherwise it will throw exception that **the index is out of items size**

and you can set onItemClickedListener when it clicked. it will be return which you clicked and what the item is by `listTextView.setOnTextItemClickListener(OnTextItemClickListener onTextItemClickListener)`.

you can write a email to `zhuangbudong@gmail.com` when you have any question.

Thank you!



