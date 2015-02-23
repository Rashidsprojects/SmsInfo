package com.rashidinc.project.smsfolderinfo;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SmsFoldersListActivity extends ListActivity{
    // Массив строк, представляющий каталоги SMS
    String[] folders = {
            "inbox", "sent", "failed"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, folders));
    }

    public void onListItemClick(ListView parent, View v, int pos, long id)
    {
        Intent intent = new Intent(getApplicationContext(),
                SmsFolderInfoActivity.class);
        // формируем URI, представляющий каталог SMS
        intent.putExtra("uri", "content://sms/" + folders[pos]);
        this.startActivity(intent);
    }
}
