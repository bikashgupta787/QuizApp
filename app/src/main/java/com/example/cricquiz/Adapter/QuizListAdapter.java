package com.example.cricquiz.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cricquiz.Model.QuizListModel;
import com.example.cricquiz.R;

import java.util.List;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.QuizListViewHolder> {

    private List<QuizListModel> quizListModelList;

    public void setQuizListModelList(List<QuizListModel> quizListModelList) {
        this.quizListModelList = quizListModelList;
    }

    @NonNull
    @Override
    public QuizListAdapter.QuizListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_quiz,parent,false);
        return new QuizListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizListAdapter.QuizListViewHolder holder, int position) {
        QuizListModel model = quizListModelList.get(position);
        holder.title.setText(model.getTitle());
        Glide.with(holder.itemView).load(model.getImage()).into(holder.quizImage);
    }

    @Override
    public int getItemCount() {
        return quizListModelList.size();
    }

    public class QuizListViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView quizImage;
        public QuizListViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.quizTitleList);
            quizImage = itemView.findViewById(R.id.quizImageList);
        }
    }
}
