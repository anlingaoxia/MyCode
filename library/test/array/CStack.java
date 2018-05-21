package array;

import java.util.EmptyStackException;

public class CStack {
    private final double mFactor = 1.75;
    private final double mFullFactor = 0.75;
    private int mDefaultSize = 100;
    private int mMaxSize = mDefaultSize;
    private int[] mBucket;
    private int mSize = 0;

    public CStack() {
        mBucket = new int[mMaxSize];
    }

    public void clear() {
        mBucket = new int[mDefaultSize];
        mMaxSize = mDefaultSize;
        mSize = 0;
    }

    public void push(int i) {
        mBucket[mSize++] = i;
        checkState();
    }

    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        int t = mBucket[--mSize];
        return t;
    }

    public int size() {
        return mSize;
    }

    public boolean isEmpty() {
        if (mSize == 0) {
            return true;
        }
        return false;
    }

    private void checkState() {
        if ((double) mSize / mMaxSize > mFullFactor) {
            int[] newBucket = new int[(int) (mMaxSize * mFactor)];
            System.arraycopy(mBucket, 0, newBucket, 0, mSize);
        }
    }
}
