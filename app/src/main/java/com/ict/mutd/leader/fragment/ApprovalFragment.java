package com.ict.mutd.leader.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ict.mutd.leader.R;
import com.ict.mutd.leader.util.ToastUtils;

/**
 * 审批
 */
public class ApprovalFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "ApprovalFragment";
    private RelativeLayout rl_budget, rl_plan; //预算审批、计划审批


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_approval, null);
        rl_budget = view.findViewById(R.id.rl_budget_approval);
        rl_plan = view.findViewById(R.id.rl_plan_approval);

        initListener();
        return view;
    }

    private void initListener() {
        rl_budget.setOnClickListener(this);
        rl_plan.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_budget_approval:
                ToastUtils.showToast(getActivity(), "此功能正在开发中");
                break;
            case R.id.rl_plan_approval:
                ToastUtils.showToast(getActivity(), "此功能正在开发中");
                break;
        }

    }
}
