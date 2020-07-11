package springdemo.di;

import springdemo.di.interfaces.Knight;
import springdemo.di.interfaces.Quest;

public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void embarkOnQuest() {
        quest.embark();
    }

}
