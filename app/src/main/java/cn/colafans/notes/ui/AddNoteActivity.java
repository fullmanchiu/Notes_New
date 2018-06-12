package cn.colafans.notes.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

    Spinner spinner;
    TextView timestamp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = findViewById(R.id.toolbar_add_note);
        setSupportActionBar(toolbar);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        timestamp = findViewById(R.id.note_time);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Calendar calendar = Calendar.getInstance();
        timestamp.setText(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
        Log.d("lancelot", "1111111111111111");
        Note note = new Note();
        note.setTitle("aaa");
        note.setSummary("bbbb");
        note.setTimestamp(new Date().getTime());
        note.save();
        List<Note> notes = LitePal.findAll(Note.class);
        Toast.makeText(this,"111"+notes.toString(),Toast.LENGTH_LONG).show();
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
