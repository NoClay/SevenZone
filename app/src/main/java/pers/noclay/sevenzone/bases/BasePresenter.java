package pers.noclay.sevenzone.bases;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by noclay on 2017/10/13.
 */

public class BasePresenter<V> {
    protected Reference<V> mViewReference;
    public void attachView(V view){
        mViewReference = new WeakReference<V>(view);
    }

    public Reference<V> getViewReference() {
        return mViewReference;
    }

    public void setViewReference(Reference<V> viewReference) {
        mViewReference = viewReference;
    }

    public V getView(){
        return mViewReference.get();
    }
    public boolean isViewAttached(){
        return mViewReference != null && mViewReference.get() != null;
    }

    public void detachView(){
        if (mViewReference != null){
            mViewReference.clear();
            mViewReference = null;
        }
    }
}
