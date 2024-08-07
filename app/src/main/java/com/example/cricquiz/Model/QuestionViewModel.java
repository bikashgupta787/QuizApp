package com.example.cricquiz.Model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cricquiz.repository.QuestionRepository;

import java.util.HashMap;
import java.util.List;

public class QuestionViewModel extends ViewModel implements QuestionRepository.OnQuestionLoad, QuestionRepository.OnResultAdded {

    private MutableLiveData<List<QuestionModel>> questionMutableLiveData;
    private QuestionRepository repository;

    public QuestionViewModel(){
        questionMutableLiveData = new MutableLiveData<>();
        repository = new QuestionRepository(this,this);
    }

    public void addResults(HashMap<String,Object> resultMap){
        repository.addResults(resultMap);
    }

    public MutableLiveData<List<QuestionModel>> getQuestionMutableLiveData() {
        return questionMutableLiveData;
    }

    public void setQuizId(String quizId){
        repository.setQuizId(quizId);
        repository.getQuestions();
    }

    @Override
    public void onLoad(List<QuestionModel> questionModels) {
        questionMutableLiveData.setValue(questionModels);
    }

    @Override
    public boolean onSubmit() {
        return true;
    }

    @Override
    public void onError(Exception e) {
        Log.d("Quiz error","onError: " + e.getMessage());
    }
}
