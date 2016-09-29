package com.liompei.zhihudemo.util;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.liompei.zhihudemo.App;

/**
 * Created by Liompei
 * on 2016/9/29.
 */

public class ShowToast {

    public static void Short(@NonNull CharSequence sequence) {
        Toast.makeText(App.getInstance(), sequence, Toast.LENGTH_SHORT).show();
    }

    public static void Long(@NonNull CharSequence sequence) {
        Toast.makeText(App.getInstance(), sequence, Toast.LENGTH_SHORT).show();
    }
}
