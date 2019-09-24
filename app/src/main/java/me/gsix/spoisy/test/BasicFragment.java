package me.gsix.spoisy.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class BasicFragment extends Fragment {

    private FirebaseFirestore db;
    private RecyclerView recyclerView;
    private HolidayAdapter adapter;
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, parent, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        final List<HolidayModel> holidays = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        db.collection("RestDays").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot snapshot : list) {
                                HolidayModel holiday = snapshot.toObject(HolidayModel.class);
                                holidays.add(holiday);
                            }
                           adapter = new HolidayAdapter(context,holidays);
                            final HolidayAdapter.OnHolidayClickListener listener = new HolidayAdapter.OnHolidayClickListener() {
                                @Override
                                public void onClick(HolidayModel holidayModel) {
                                    Intent intent = new Intent(context, HolidayActivity.class);
                                    intent.putExtra("holiday", holidayModel);
                                    startActivity(intent);
                                }
                            };
                            adapter.setOnHolidayClickListener(listener);
                            recyclerView.setAdapter(adapter);
                        }
                    }
                });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}