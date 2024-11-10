package org.quest.quest;

public class QuestData {
    private String name;
    private String description;
    private int targetCount; // 목표 수량
    private int reward; // 보상 (예: 경험치 또는 아이템 ID)

    public QuestData(String name, String description, int targetCount, int reward) {
        this.name = name;
        this.description = description;
        this.targetCount = targetCount;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getTargetCount() {
        return targetCount;
    }

    public int getReward() {
        return reward;
    }
}
