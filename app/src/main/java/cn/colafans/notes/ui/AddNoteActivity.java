package cn.colafans.notes.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.colafans.notes.R;
import cn.colafans.notes.bean.Note;

public class AddNoteActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private TextView timestamp;
    private EditText etTitle;
    private EditText etSummary;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = findViewById(R.id.toolbar_add_note);
        setSupportActionBar(toolbar);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        timestamp = findViewById(R.id.note_time);
        etTitle = findViewById(R.id.et_note_title);
        etSummary = findViewById(R.id.et_note_summary);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Calendar calendar = Calendar.getInstance();
        timestamp.setText(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!isNoteEmpty()) {
            saveNote();
        }
    }

    private boolean isNoteEmpty() {
        boolean empty = true;
        if (!TextUtils.isEmpty(etTitle.getText())) {
            empty = false;
        }
        if (!TextUtils.isEmpty(etSummary.getText())) {
            empty = false;
        }
        return empty;
    }

    private void saveNote() {
        Note note = new Note();
        note.setSort(spinner.getSelectedItemPosition());
        note.setTitle(etTitle.getText().toString());
        note.setSummary(etSummary.getText().toString());
        note.setTimestamp(System.currentTimeMillis());
        note.saveThrows();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        textView.setTextColor(Color.GRAY);
        textView.setTextSize(12);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
