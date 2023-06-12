package java9_practice;

public class ProcessHandleClass {

    public long getCurrentPid(){
        ProcessHandle processHandleClass = ProcessHandle.current();
        return processHandleClass.pid();
    }

    public boolean isCurrentAlive(){
        ProcessHandle processHandleClass = ProcessHandle.current();
        return processHandleClass.isAlive();
    }
}
