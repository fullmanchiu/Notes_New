package cn.colafans.notes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import cn.colafans.notes.R;
import cn.colafans.notes.bean.Note;
import cn.colafans.notes.util.Util;

public class NoteListAdapter extends BaseAdapter {
    private List<Note> noteList;
    private Context context;
    //private int resource;
    private LayoutInflater inflater;

    public NoteListAdapter(Context context, List<Note> noteList) {
        this.context = context;
        this.noteList = noteList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return noteList.get(position);
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
            inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.note_list_item, null);
            holder.title = convertView.findViewById(R.id.note_list_item_title);
            holder.sumarry = convertView.findViewById(R.id.note_list_item_summary);
            holder.time = convertView.findViewById(R.id.note_list_item_time);
            holder.title.setText(noteList.get(position).getTitle());
            holder.sumarry.setText(noteList.get(position).getSummary());
            long timestamp = noteList.get(position).getTimestamp();
            String date = Util.getDateToString(timestamp, "M-dd HH:mm");
            holder.time.setText(date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            holder.title.setText(noteList.get(position).getTitle());
            holder.sumarry.setText(noteList.get(position).getSummary());
            long timestamp = noteList.get(position).getTimestamp();
            String date = Util.getDateToString(timestamp, "M-dd HH:mm");
            holder.time.setText(date);
        }
        return convertView;
    }

    static class ViewHolder {
        TextView title, sumarry, time;
    }

}


