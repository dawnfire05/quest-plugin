package org.quest.quest;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class QuestManager {
    private Map<String, QuestData> availableQuests = new HashMap<>();
    private Map<Player, QuestData> playerQuests = new HashMap<>();

    public QuestManager() {
        // 예시 퀘스트 추가
        availableQuests.put("monster_hunter", new QuestData("monster_hunter", "몬스터 10마리 처치", 10, 100));
        availableQuests.put("wood_collector", new QuestData("wood_collector", "나무 20개 수집", 20, 50));
    }

    public void startQuest(Player player, String questName) {
        if (!availableQuests.containsKey(questName)) {
            player.sendMessage("존재하지 않는 퀘스트입니다.");
            return;
        }

        QuestData quest = availableQuests.get(questName);
        playerQuests.put(player, quest);
        player.sendMessage(quest.getDescription() + " 퀘스트를 시작했습니다!");
    }

    public void completeQuest(Player player) {
        if (!playerQuests.containsKey(player)) {
            player.sendMessage("진행 중인 퀘스트가 없습니다.");
            return;
        }

        QuestData quest = playerQuests.get(player);
        // 목표 달성 여부 확인 로직 (예: 몬스터 처치 수, 아이템 수량 확인 등)
        player.sendMessage("퀘스트 완료! 보상으로 " + quest.getReward() + " 경험치를 획득했습니다.");
        player.giveExp(quest.getReward());
        playerQuests.remove(player);
    }

}
