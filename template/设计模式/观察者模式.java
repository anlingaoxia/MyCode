package 设计模式;
//listview中adapter相当于subject,会发布信息notifyDataSetChanged
//而每个listview在使用这个adapter时候,setAdapter,会调用register()方法.所以listview是observer

import java.util.ArrayList;

interface Observer {
    public void onChanged();
}


interface Subject {
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObserver();
}

class Subjector implements Subject {
    private final ArrayList<Observer> mList = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
    }

    @Override
    public void unregisterObserver(Observer o) {

    }

    @Override
    public void notifyObserver() {
        for (Observer o : mList) {
            o.onChanged();
        }

    }
}

class Observalbe implements Observer {

    @Override
    public void onChanged() {

    }
}


public class 观察者模式 {



}
