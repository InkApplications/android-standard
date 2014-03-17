package com.inkapplications.android.standard.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import com.inkapplications.android.standard.activity.BaseActivity;
import dagger.ObjectGraph;

import java.util.List;

public abstract class BaseFragment extends Fragment
{
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.inject(this, view);
        this.injectDagger();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    /**
     * Inject Dagger
     *
     * Uses Dagger to inject the current class
     */
    private void injectDagger()
    {
        BaseActivity parentActivity = (BaseActivity) this.getActivity();
        List<Object> parentModules = parentActivity.getModules();

        ObjectGraph graph = ObjectGraph.create(parentModules.toArray());

        graph.inject(this);
    }
}
