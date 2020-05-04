package com.curiousapps.mvvm_practice.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.curiousapps.mvvm_practice.models.SchoolList;
import com.curiousapps.mvvm_practice.requests.SchoolApiClient;

import java.util.List;

public class SchoolRepository {

    private static SchoolRepository instance;
    //private MutableLiveData<List<SchoolList>> mSchoolList;
    private SchoolApiClient mSchoolApiClient;
//
    public static SchoolRepository getInstance() {
        if (instance == null) {
            instance = new SchoolRepository();
        }
        return instance;
    }

    private SchoolRepository(){
        //mSchoolList = new MutableLiveData<>();
        mSchoolApiClient = SchoolApiClient.getInstance();
    }

    public LiveData<List<SchoolList>> getSchools(){
        //return mSchoolList;
        return mSchoolApiClient.getSchoolList();
    }
//
//    public void searchSchoolsApi(int pageNumber){
//        if (pageNumber == 0){
//            pageNumber = 1;
//        }
//        mSchoolApiClient.searchSchoolsApi(pageNumber);
//    }
}
