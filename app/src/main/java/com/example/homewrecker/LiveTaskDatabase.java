package com.example.homewrecker;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {LiveTask.class}, version = 1, exportSchema = false)
public abstract class LiveTaskDatabase extends RoomDatabase {

    private static LiveTaskDatabase instance;

    public abstract LiveTaskDao liveTaskDao();

    public static synchronized LiveTaskDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LiveTaskDatabase.class, "tugas_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private LiveTaskDao liveTaskDao;

        private PopulateDbAsyncTask(LiveTaskDatabase db) {
            liveTaskDao = db.liveTaskDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            liveTaskDao.insert(new LiveTask("Pemrograman Perangkat Bergerak",
                    "PPB",
                    "Live Data",
                    "homewrecker debes",
                    "28/03/2021",
                    "23:59",
                    1));
            liveTaskDao.insert(new LiveTask("Proyek Perangkat Lunak 4",
                    "PPL4", "IOT",
                    "monitor asma",
                    "28/03/2021",
                    "23:59",
                    2));
            liveTaskDao.insert(new LiveTask("Pengembangan Perangkat Lunak 1",
                    "PPL1",
                    "Web",
                    "php my sql",
                    "28/03/2021",
                    "23:59",
                    3));
            return null;
        }
    }
}
