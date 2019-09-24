package me.gsix.spoisy.test;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.HolidayViewHolder> {
    private List<HolidayModel> holidaysList;
    private Context context;
    private OnHolidayClickListener onHolidayClickListener;

    public HolidayAdapter(Context context, List<HolidayModel> holidayList) {
        super();
        holidaysList = holidayList;
        this.context = context;
    }

    public static class HolidayViewHolder extends RecyclerView.ViewHolder {
        public HolidayViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            monthNumber = itemView.findViewById(R.id.monthNumber);
            daymonthyear = itemView.findViewById(R.id.daymonthyear);
            destination = itemView.findViewById(R.id.destination);
            name = itemView.findViewById(R.id.name);
            religion = itemView.findViewById(R.id.religion);
            selected = itemView.findViewById(R.id.selected);
        }

        TextView date;
        TextView monthNumber;
        TextView daymonthyear;
        TextView destination;
        TextView name;
        TextView religion;
        TextView selected;

    }

    @NonNull
    @Override
    public HolidayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.holiday_iterm_layout, null, false);
        return new HolidayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolidayViewHolder holder, int position) {

        final HolidayModel holiday = holidaysList.get(position);
        if (holiday != null) {

            // holiday date
            if (holiday.date !=  0) {
                holder.date.setText(String.format("%d", holiday.date));
                holder.date.setVisibility(View.VISIBLE);
            } else {
                holder.date.setVisibility(View.GONE);
            }

            //holiday month number
            if (holiday.monthNumber!= 0) {
                holder.monthNumber.setText(String.format("%d",holiday.monthNumber));
                holder.monthNumber.setVisibility(View.VISIBLE);
            } else {
                holder.monthNumber.setVisibility(View.GONE);
            }

            //holiday day month year number
            if (!TextUtils.isEmpty(holiday.day)) {
                if (!TextUtils.isEmpty(holiday.month)) {
                    if (holiday.year != null) {
                        holder.daymonthyear.setText(String.format("%s/%s/%s",holiday.day, holiday.month, holiday.year));
                        holder.daymonthyear.setVisibility(View.VISIBLE);
                    }
                }
            } else {
                holder.daymonthyear.setVisibility(View.GONE);
            }

            // destination
            if (!TextUtils.isEmpty(holiday.destination)) {
                holder.destination.setText(holiday.destination);
                holder.destination.setVisibility(View.VISIBLE);
            } else holder.destination.setVisibility(View.GONE);

            // name
            if (!TextUtils.isEmpty(holiday.name)) {
                holder.name.setText(holiday.destination);
                holder.name.setVisibility(View.VISIBLE);
            } else holder.name.setVisibility(View.GONE);

            // religion
            if (!TextUtils.isEmpty(holiday.religion)) {
                holder.religion.setText(holiday.destination);
                holder.religion.setVisibility(View.VISIBLE);
            } else holder.religion.setVisibility(View.GONE);

            // selected
            if(holiday.selected){
                holder.selected.setText("selected");
                holder.selected.setVisibility(View.VISIBLE);
            } else {
                holder.selected.setText("not selected");
                holder.selected.setVisibility(View.VISIBLE);
            }


        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHolidayClickListener.onClick(holiday);
            }
        });

    }

    @Override
    public int getItemCount() {
        return holidaysList.size();
    }
    public interface OnHolidayClickListener{
        void onClick(HolidayModel holidayModel);

    }

    public void setOnHolidayClickListener(OnHolidayClickListener onHolidayClickListener) {
        this.onHolidayClickListener = onHolidayClickListener;
    }


}
