package com.ict.mutd.leader.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ict.mutd.leader.R;
import com.ict.mutd.leader.util.ActvityManager;
import com.ict.mutd.leader.util.cache.ACache;
import com.ict.mutd.leader.util.constant.Constant;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lockpattern.util.LockPatternUtil;
import lockpattern.widget.LockPatternView;

public class ReGestureLoginActivity extends AppCompatActivity {

    private static final String TAG = ReGestureLoginActivity.class.getSimpleName();

    @Bind(R.id.lockPatternView)
    LockPatternView lockPatternView;
    @Bind(R.id.messageTv)
    TextView messageTv;
    @Bind(R.id.forgetGestureBtn)
    Button forgetGestureBtn;

    private ACache aCache;
    private static final long DELAYTIME = 600l;
    private byte[] gesturePassword;
//    private String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_login);
        ActvityManager.activityList.add(ReGestureLoginActivity.this);
        ButterKnife.bind(this);
//        tag = getIntent().getExtras().getString("tag");
        this.init();
        forgetGestureBtn.setVisibility(View.GONE);
    }

    private void init() {
        aCache = ACache.get(ReGestureLoginActivity.this);
        //得到当前用户的手势密码
        gesturePassword = aCache.getAsBinary(Constant.GESTURE_PASSWORD);
        lockPatternView.setOnPatternListener(patternListener);
        updateStatus(Status.DEFAULT);
    }

    private LockPatternView.OnPatternListener patternListener = new LockPatternView.OnPatternListener() {

        @Override
        public void onPatternStart() {
            lockPatternView.removePostClearPatternRunnable();
        }

        @Override
        public void onPatternComplete(List<LockPatternView.Cell> pattern) {
            if (pattern != null) {
                if (LockPatternUtil.checkPattern(pattern, gesturePassword)) {
                    updateStatus(Status.CORRECT);
                } else {
                    updateStatus(Status.ERROR);
                }
            }
        }
    };

    /**
     * 更新状态
     *
     * @param status
     */
    private void updateStatus(Status status) {
        messageTv.setText(status.strId);
        messageTv.setTextColor(getResources().getColor(status.colorId));
        switch (status) {
            case DEFAULT:
                lockPatternView.setPattern(LockPatternView.DisplayMode.DEFAULT);
                break;
            case ERROR:
                lockPatternView.setPattern(LockPatternView.DisplayMode.ERROR);
                lockPatternView.postClearPatternRunnable(DELAYTIME);
                break;
            case CORRECT:
                lockPatternView.setPattern(LockPatternView.DisplayMode.DEFAULT);
                loginGestureSuccess();
                break;
        }
    }

    /**
     * 手势登录成功（去首页）
     */
    private void loginGestureSuccess() {

        Intent intent = new Intent(ReGestureLoginActivity.this, ReCreateGestureActivity.class);
        startActivity(intent);
        this.finish();

    }

    /**
     * 忘记手势密码（去账号登录界面）
     */
    @OnClick(R.id.forgetGestureBtn)
    void forgetGesturePasswrod() {

        Intent intent = new Intent(ReGestureLoginActivity.this, CreateGestureActivity.class);

        startActivity(intent);
        this.finish();

    }

    private enum Status {

        //默认的状态

        DEFAULT(R.string.regesture_default, R.color.grey_a5a5a5),
        //密码输入错误
        ERROR(R.string.gesture_error, R.color.red_f4333c),
        //密码输入正确
        CORRECT(R.string.gesture_correct, R.color.grey_a5a5a5);

        private Status(int strId, int colorId) {
            this.strId = strId;
            this.colorId = colorId;
        }

        private int strId;
        private int colorId;
    }
}
