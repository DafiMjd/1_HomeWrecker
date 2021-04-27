package com.example.homewrecker;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;

public class LiveTaskRepository {

    private LiveTaskDao liveTaskDao;
    private LiveData<ArrayList<LiveTask>> allTasks;

    public LiveTaskRepository(Application application) {
        LiveTaskDatabase database = LiveTaskDatabase.getInstance(application);
        liveTaskDao = database.liveTaskDao();
        allTasks = liveTaskDao.getAllTasks();
    }

    public void insert (LiveTask liveTask) {
        new InsertLiveTaskAsyncTask(liveTaskDao).execute(liveTask);
    }

    public void update (LiveTask liveTask) {
        new UpdateLiveTaskAsyncTask(liveTaskDao).execute(liveTask);
    }

    public void delete (LiveTask liveTask) {
        new DeleteLiveTaskAsyncTask(liveTaskDao).execute(liveTask);
    }

    public void deleteAllTasks() {
        new DeleteAllLiveTaskAsyncTask(liveTaskDao).execute();
    }

    public LiveData<ArrayList<LiveTask>> getAllTasks() {
        return allTasks;
    }

    private static class InsertLiveTaskAsyncTask extends AsyncTask<LiveTask, Void, Void> {
        private LiveTaskDao liveTaskDao;

        private InsertLiveTaskAsyncTask(LiveTaskDao liveTaskDao) {
            this.liveTaskDao = liveTaskDao;
        }

        @Override
        protected Void doInBackground(LiveTask... liveTasks) {

            liveTaskDao.insert(liveTasks[0]);
            return null;
        }
    }

    private static class UpdateLiveTaskAsyncTask extends AsyncTask<LiveTask, Void, Void> {
        private LiveTaskDao liveTaskDao;

        private UpdateLiveTaskAsyncTask(LiveTaskDao liveTaskDao) {
            this.liveTaskDao = liveTaskDao;
        }

        @Override
        protected Void doInBackground(LiveTask... liveTasks) {

            liveTaskDao.update(liveTasks[0]);
            return null;
        }
    }

    private static class DeleteLiveTaskAsyncTask extends AsyncTask<LiveTask, Void, Void> {
        private LiveTaskDao liveTaskDao;

        private DeleteLiveTaskAsyncTask(LiveTaskDao liveTaskDao) {
            this.liveTaskDao = liveTaskDao;
        }

        @Override
        protected Void doInBackground(LiveTask... liveTasks) {

            liveTaskDao.delete(liveTasks[0]);
            return null;
        }
    }

    private static class DeleteAllLiveTaskAsyncTask extends AsyncTask<Void, Void, Void> {
        private LiveTaskDao liveTaskDao;

        private DeleteAllLiveTaskAsyncTask(LiveTaskDao liveTaskDao) {
            this.liveTaskDao = liveTaskDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            liveTaskDao.deleteAll();
            return null;
        }
    }
}
