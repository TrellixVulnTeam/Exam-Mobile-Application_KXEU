package com.yorbax.EMA.lecturer;import android.content.Context;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.ImageView;import android.widget.TextView;import android.widget.Toast;import androidx.annotation.NonNull;import androidx.annotation.Nullable;import androidx.recyclerview.widget.RecyclerView;import com.google.firebase.database.DatabaseError;import com.google.firebase.database.DatabaseReference;import com.google.firebase.database.FirebaseDatabase;import com.yorbax.EMA.R;import com.yorbax.EMA.lecturer.model.MCQsModel;import java.util.List;public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ViewHolder> {    Context context;    List<MCQsModel> list;    public ExamAdapter(Context context, List<MCQsModel> list) {        this.context = context;        this.list = list;    }    @NonNull    @Override    public ExamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {        View view= LayoutInflater.from(context).inflate(R.layout.row_exam,parent,false);        return new ExamAdapter.ViewHolder(view);    }    @Override    public void onBindViewHolder(@NonNull ExamAdapter.ViewHolder holder, int position) {        holder.examNo.setText(" "+(position+1));        holder.totalQuestion.setText(""+list.get(position).totoalMcsq);//        holder.ic_edit.setOnClickListener(new View.OnClickListener() {//            @Override//            public void onClick(View view) {////                context.startActivity(new Intent(context, AddCourse.class).putExtra("activity","update")//                        .putExtra("updateData",list.get(position))////                );////            }//        });        holder.ic_delete.setOnClickListener(new View.OnClickListener() {            @Override            public void onClick(View view) {                FirebaseDatabase.getInstance().getReference().child("Exam").child(list.get(position).ExamId).removeValue(new DatabaseReference.CompletionListener() {                    @Override                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {                        notifyDataSetChanged();                        Toast.makeText(context, "Deleted...!", Toast.LENGTH_SHORT).show();                    }                });            }        });    }    @Override    public int getItemCount() {        return list.size();    }    class ViewHolder extends RecyclerView.ViewHolder {        TextView examQuestion,totalQuestion,examNo;        ImageView ic_edit,ic_delete;        public ViewHolder(@NonNull View itemView) {            super(itemView);            examNo=itemView.findViewById(R.id.textView4);            totalQuestion=itemView.findViewById(R.id.textView6);            ic_delete=itemView.findViewById(R.id.ic_delete);//            ic_edit=itemView.findViewById(R.id.ic_edit);        }    }}