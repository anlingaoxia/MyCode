package 设计模式;

//将实体封装在装饰器内部,增加了一些操作方法.

interface Function {
    void fun();
}

class Original implements Function {
    @Override
    public void fun() {

    }
}

class Decorator implements Function {
    Function mFunction;

    public Decorator(Function function) {
        mFunction = function;
    }

    @Override
    public void fun() {
        mFunction.fun();
        //TODO 装饰器要做
    }
}
