package org.quest.quest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuestCommand implements CommandExecutor {
    private final QuestManager manager;

    public QuestCommand(QuestManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to use this command!");
            return true;
        }

        Player player = (Player) sender;

        if(args.length == 0){
            player.sendMessage("/quest list - 가능한 퀘스트 목록 보기");
            player.sendMessage("/quest start - <퀘스트명> - 퀘스트 시작");
            return true;
        }

        if(args[0].equalsIgnoreCase("list")){
            player.sendMessage("/quest list");
            // 퀘스트 목룍 출력 로직
        } else if(args[0].equalsIgnoreCase("start")){
            if(args.length <2){
                player.sendMessage("퀘스트 이름을 입력하세요.");
                return true;
            }
            String questName = args[1];
            player.sendMessage("/quest start " + questName);
        }
        return true;
    }

}
