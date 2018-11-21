package com.maryang.jetpack.util;

import androidx.lifecycle.Lifecycle;

class MyLocationListener {

    private Lifecycle lifecycle;

    public MyLocationListener(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public void enable() {
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
        }
    }
}