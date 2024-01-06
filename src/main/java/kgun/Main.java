package kgun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.Random;


public class Main extends ListenerAdapter{

    public static String prefix = "!";
    public static JDA jda;
    public static void main(String[] args) throws LoginException {


        String token = "";

        //토큰 연결 구문
        jda = JDABuilder.createDefault(token) // enable all default intents
                .enableIntents(GatewayIntent.MESSAGE_CONTENT) // also enable privileged intent
                .addEventListeners(new Main())
                .build();

        //현재 상태 구문
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        //현재상태창 구문
        jda.getPresence().setActivity(Activity.playing("WACCA Reverse"));

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");

        //명령어 시작 구문

        if(!event.getAuthor().isBot()) { //명령어(봇은 입력안되게함)
            //명령어 모음집 항상 추가할것
            if(args[0].equals(prefix + "릴리명령어")){
                EmbedBuilder info = new EmbedBuilder();

                info.setTitle("릴리 봇");
                info.setDescription("릴리 봇 명령어 모음집");
                info.addField("왓카","왓카 재밌습니다", false);
                info.addField("퇴사각","퇴사각을 재주는 각도기", false);
                info.addField("네비게이터","네비게이터의 정보 출력 (!네비게이터 이름)", false);
                info.addField("풀콤보","릴리의 풀 콤보 이모지", false);
                info.addField("귀여워","릴리가 꼴받게함", false);
                info.addField("퍽","릴리 한대 때리기", false);
                info.setColor(0xcfffe5);
                info.setFooter("이 사람에 의해 만들어짐",event.getMember().getUser().getAvatarUrl());

                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessageEmbeds(info.build()).queue();
                //event.getChannel().sendMessage("test").queue();
                info.clear();
            }
            //때리기 작동
            if(args[0].equals(prefix + "퍽")){
                event.getChannel().sendMessage("악!").queue();
                EmbedBuilder info = new EmbedBuilder();
                info.setImage("https://media.discordapp.net/attachments/877518846733455370/877527899593400350/icon_28_2.png");
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessageEmbeds(info.build()).queue();
                info.clear();
            }
            //풀콤보
            if(args[0].equals(prefix + "풀콤보")){
                event.getChannel().sendMessage("Full Combo!").queue();
                EmbedBuilder info = new EmbedBuilder();
                info.setImage("https://cdn.discordapp.com/attachments/877518846733455370/878654360777810010/unknown.png");
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessageEmbeds(info.build()).queue();
                info.clear();
            }
            if(args[0].equals(prefix + "귀여워")){
                event.getChannel().sendMessage("훗").queue();
                EmbedBuilder info = new EmbedBuilder();
                info.setImage("https://cdn.discordapp.com/attachments/877518846733455370/878655806684405790/dccon.png");
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessageEmbeds(info.build()).queue();
                info.clear();
            }
            if(args[0].equals(prefix + "죽여라")){
                event.getChannel().sendMessage("으아아악!!").queue();
                EmbedBuilder info = new EmbedBuilder();
                info.setImage("https://cdn.discordapp.com/attachments/379594106667663360/878662841366904882/12.jpg");
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessageEmbeds(info.build()).queue();
                info.clear();
            }
            //왓카는 재밌다 출력프로그램
            if (args[0].equals(prefix + "왓카")) {
                if (args.length == 1) {
                    //왓카만 입력되었을때
                    event.getChannel().sendMessage("왓카 리버스 재밌습니다.").queue();
                }
                else{
                    //리버스 입력
                    if(args[1].equals("리버스")){
                        event.getChannel().sendMessage("왓카 리버스 재밌습니다.").queue();
                    }
                    //그 외 입력
                    else{
                        event.getChannel().sendMessage("왓카 "+args[1]+" 는 종료되었습니다").queue();
                    }

                }
            }
            //퇴사각 재는 프로그램
            if (args[0].equals(prefix + "퇴사각")){
                Random rand = new Random();
                int randval = rand.nextInt(180)+1;
                event.getChannel().sendMessage("퇴사각!퇴사각!퇴사각!").queue();
                event.getChannel().sendMessage("현재 퇴사각은 "+ randval +"도 입니다.").queue();
                if(randval <= 45){
                    event.getChannel().sendMessage("안타깝네요 어림도없지 일하세요").queue();
                }
                else if(45 < randval && randval<=90){
                    event.getChannel().sendMessage("오~ 조금 아쉽지만 일하세요").queue();
                }
                else if(90 < randval && randval <=135){
                    event.getChannel().sendMessage("보인다 보여 퇴사각!!").queue();
                }
                else{
                    event.getChannel().sendMessage("퇴사 가즈아~~~!").queue();
                    EmbedBuilder info = new EmbedBuilder();
                    info.setTitle("사직서 양식");
                    info.setImage("https://media.discordapp.net/attachments/877518846733455370/877527969994793000/1629289362885.jpg?width=481&height=676");
                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendMessageEmbeds(info.build()).queue();
                    info.clear();
                }

            }
            //네비게이터 소환구문
            if (args[0].equals(prefix + "네비게이터")){
                EmbedBuilder info = new EmbedBuilder();

                if(args.length == 1){
                    event.getChannel().sendMessage("한국에 공개된 네비게이터는 총 4명 그 중 3명의 정보가있습니다.").queue();
                    event.getChannel().sendMessage("엘리자베스,릴리,룬 입니다.").queue();
                }
                else if(args[1].equals("엘리자베스")){
                    info.setTitle("⭐ 왓카 네비게이터 정보⭐");
                    info.setDescription("왓카 리버스는 8월 10일에 업데이트 된 왓카의 신작입니다");
                    info.addField("엘리쟈베스","가장 초창기의 네비게이터", false);
                    info.setColor(0xe63883);
                    info.setFooter("이 사람에 의해 소환됨",event.getMember().getUser().getAvatarUrl());
                    info.setImage("https://media.discordapp.net/attachments/877518846733455370/877519290935418891/image0.png?width=1077&height=676");
                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendMessageEmbeds(info.build()).queue();
                }
                else if(args[1].equals("릴리")){
                    info.setTitle("⭐ 왓카 네비게이터 정보⭐");
                    info.setDescription("왓카 리버스는 8월 10일에 업데이트 된 왓카의 신작입니다");
                    info.addField("릴리","엘리쟈베스의 여동생이다 두번째 네비게이터", false);
                    info.setColor(0x8cca46);
                    info.setFooter("이 사람에 의해 소환됨",event.getMember().getUser().getAvatarUrl());
                    info.setImage("https://media.discordapp.net/attachments/877518846733455370/877519303413469194/image0.png?width=1077&height=676");
                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendMessageEmbeds(info.build()).queue();
                }
                else if(args[1].equals("룬")){
                    info.setTitle("⭐ 왓카 네비게이터 정보⭐");
                    info.setDescription("왓카 리버스는 8월 10일에 업데이트 된 왓카의 신작입니다");
                    info.addField("룬","고대인으로써 가장최근 추가된 네비게이터 숨겨진 힘이 있다", false);
                    info.setColor(0x783cbf);
                    info.setFooter("이 사람에 의해 소환됨",event.getMember().getUser().getAvatarUrl());
                    info.setImage("https://media.discordapp.net/attachments/877518846733455370/877519312917762088/image0.png?width=1077&height=676");
                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendMessageEmbeds(info.build()).queue();
                }
                else {
                    event.getChannel().sendMessage("네비게이터가 존재하지 않습니다.").queue();
                }

                info.clear();
            }

        }
    }        //사용자의 명령어를 저장함

}
