package springdemo.di;

import springdemo.di.interfaces.Quest;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest (PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void embark() {
        stream.println("Dragon has been slayed");
    }

}
