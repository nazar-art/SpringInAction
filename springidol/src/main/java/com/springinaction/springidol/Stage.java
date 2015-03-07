//<start id="stage_java" /> 
package com.springinaction.springidol;

public class Stage {
    private Stage() {
    }

    public static Stage getInstance() {
        return StageSingletonHolder.instance; //<co id="co_returnInstance"/>
    }

    private static class StageSingletonHolder {
        static Stage instance = new Stage(); //<co id="co_lazyLoad"/>
    }
}
//<end id="stage_java" />
