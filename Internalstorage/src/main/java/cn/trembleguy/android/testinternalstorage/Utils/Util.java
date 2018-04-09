package cn.trembleguy.android.internalstorage.Utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by trembleguy on 2018/4/9.
 */
public class Util {
    public static boolean isExternalStorageWritable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    public static File getAlbumStorageDir(String albumName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("trembleguy", "Directory not created");
        }
        return file;
    }

}
