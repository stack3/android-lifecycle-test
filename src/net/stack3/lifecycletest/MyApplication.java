package net.stack3.lifecycletest;

import java.util.Date;

import android.app.Application;
import android.util.Log;

/**
 * 
 * @author EIMEI. stack3.net
 *
 */
public class MyApplication extends Application {
    private Date createdAt;
    // 次にActivity1を開いたらトーストを表示
    // *** こういうメモリだけで管理するフラグを持ってはならないという悪い例 ***
    // やるなら設定するたびにSharedPreferenceに保存、onCreateで復元するなどの方法をとる
    private boolean isShowToastOnActivity1;

    public MyApplication() {
        super();
        createdAt = new Date();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public boolean isShowToastOnActivity1() {
        return isShowToastOnActivity1;
    }

    public void setShowToastOnActivity1(boolean isShowToastOnActivity1) {
        this.isShowToastOnActivity1 = isShowToastOnActivity1;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(getClass().getSimpleName(), "MyApplication#onCreate");

        // Systemプロパティは、onCreateで設定すると良い
        // この設定はApplication Process生成後常に行われるので
        // すべてのActivityで有効な設定となる
        System.setProperty("application.on.create", "true");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(getClass().getSimpleName(), "MyApplication#onTerminate");
    }
}
