package com.curiousapps.mvvm_practice.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.curiousapps.mvvm_practice.models.SchoolList;
import com.curiousapps.mvvm_practice.repositories.SchoolRepository;

import java.util.List;

public class MainListViewModel extends ViewModel {

    private SchoolRepository mSchoolRepository;
    private boolean mIsPerformingQuery;

    public MainListViewModel() {
        mSchoolRepository = SchoolRepository.getInstance();
        mIsPerformingQuery = false;
    }

    public LiveData<List<SchoolList>> getSchoolList() {
        return mSchoolRepository.getSchoolList();
    }

    public LiveData<Boolean> isQueryExhausted() {
        return mSchoolRepository.isQueryExhausted();
    }

    public void searchSchoolsApi(int limit, int offset) {
        mIsPerformingQuery = true;
        mSchoolRepository.searchSchoolsApi(limit, offset);
    }

    public void searchNextPage() {
        if (!mIsPerformingQuery
                && !isQueryExhausted().getValue()) {
            mSchoolRepository.searchNextPage();
        }
    }

    public boolean onBackPressed() {
        if (mIsPerformingQuery) {
            mSchoolRepository.cancelRequest();
            mIsPerformingQuery = false;
        }
        return true;
    }

    public void setIsPerformingQuery(Boolean isPerformingQuery) {
        mIsPerformingQuery = isPerformingQuery;
    }

    public boolean isPerformingQuery() {
        return mIsPerformingQuery;
    }
}
