package com.inkapplications.android.standard.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import com.inkapplications.android.standard.activity.BaseActivity;
import dagger.ObjectGraph;

import java.util.List;

/**
 * Base Fragment
 *
 * Sets up a Fragment with Dependency Injection and registers Activity events
 * with the application event dispatcher / bus.
 *
 * @author Maxwell Vandervelde <Max@MaxVandervelde.com>
 */
public abstract class BaseFragment extends Fragment
{
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ButterKnife.inject(this.getActivity());
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
     * Uses Dagger to inject the current class with the base activity
     * dependencies.
     * This method may not be overridden, as fragments do not need their own
     * dependency graph.
     */
    private void injectDagger()
    {
        BaseActivity parentActivity = (BaseActivity) this.getActivity();
        List<Object> parentModules = parentActivity.getModules();

        ObjectGraph graph = ObjectGraph.create(parentModules.toArray());

        graph.inject(this);
        graph.injectStatics();
    }
}
