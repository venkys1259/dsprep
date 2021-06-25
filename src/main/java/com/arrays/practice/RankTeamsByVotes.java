package com.arrays.practice;

import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/rank-teams-by-votes/
In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.
The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.
Return a string of all teams sorted by the ranking system.

Example 1:

Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
Team B was ranked second by 2 voters and was ranked third by 3 voters.
Team C was ranked second by 3 voters and was ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team and team B is the third.
 */
public class RankTeamsByVotes {
    /*
    Idea is to construct as below:
    for votes = ["ABC","ACB","ABC","ACB","ACB"],
    we take first String and assume the same teams while be there in entire input.
    Now, for eg: first String ABC,
    take first character A and see how may votes polled for A in each position.
    for A is voted 5 times in first Position
    A is voted 0 times in second position
    A is voted 0 times in third position
    Construct a Map as follows:
    Map<Character,Integer>
    A:500
    B:023
    C:032
    Then sort by values, if all values are same, sort by keys.
     */
    public String rankTeams(String[] votes) {
    char[] teams = votes[0].toCharArray ();
    Map<Character,String> rankMap = new HashMap<>();
        int counter = 0;
        int position;
            for (char ch : teams) { // we need to find how many number of votes polled for each character ( team)
                position=0;
              while(position < teams.length){
                   for (int i = 0; i < votes.length; i++) { // iterate through whole input
                       if (votes[i].indexOf(ch) == position) { // check if the team got voted in same position
                           counter++;
                       }
                   }
                   if (!rankMap.containsKey (ch)) {
                       rankMap.put (ch, counter + "");
                   } else {
                       rankMap.put (ch, rankMap.get(ch) + "" + counter + "");
                   }
                   position++;
                   counter = 0;
               }
            }
        LinkedHashMap<Character, String> sortedByRankMap =
                rankMap.entrySet().stream()
                        .sorted(Map.Entry.<Character, String>comparingByValue().reversed ()
                                .thenComparing(Map.Entry.comparingByKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Set<Character> rankedTeams = sortedByRankMap.keySet();
        String result = "";
        for(Character ch: rankedTeams){
            result = result+ch;
        }
        return result;
    }
    public static void main(String[] args) {
      // String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        String[] votes = {"XDELQOKZUGMCBTWAJNPFRVIS","IQKGUDCWMNLSABZEPVXFJRTO","SFPUJWZABNRLQEMXKIGDVCTO","FISQWOZAGXJDNLTKPRECVUBM","BMXIRQOWJSLPDNGAEFKZTUVC","SCUFTIAQMWNXBGZEOJVDLKRP","LMNXWKDBTAGPFUCJSROIQZEV","NVDICPQFBZLRGWTMXJOAUESK","PGZRUWNFMKTVJSLCDEXOABIQ","BFKNDXRIGWTVSUJOCMPZAEQL","MJLDKRNWPQXUFSTEGCOBVAIZ","VCIMLFJSPZTDRKBAGXWUOEQN","TERGMVDPILNQSFJCAKZWXBOU","KOPFCIDQSVAMRBLNTWUZXJGE","NKWPJGUAFOTZIERXMSLBDCQV","QUKLSIFCDVZEAMXGJNTWROPB","DSAGZRFWTMJEILKOPUNQVXCB","ARQIVZNCMBJGWUPKEOSLFTDX","ESMATLNJKPRFGXWVUCOQDIZB","QNGTVDFICPSKMWUJBOZELAXR","JAOMTSGFQPDWKRNLUXEVBCIZ","FORAQBEDSTNPUZICVXGWMKLJ","UWAFSXITRMPEGVQDLZBCNJOK","IKFOVMNWJLCZBUAGERQPXTSD","SLEOPWNDBUVIGQJZMRACXTFK","GTDKMOJSILNAVXFPZQCUWRBE","AZGRVFJDEUSCNLTBXWQIPMOK","VQPNUMCJKSBXWIAFTGDOEZRL","PVNODUXIMJSGACQTWRFBKLZE","QGKDUAIMEVTXSZFBJLOWNPRC","MDUOXBVQJPSAGNIKLRFZTCWE","FMRTEDKWPVLGBICXSNZAQJOU","WUEFMGXSIRNAOPCBDLQTKJZV","UDGSPEQVZOBMNICJKXTWALRF","SFNWLTARVKPJQZMGUDBOICEX","FSPCMAJZEKNRLDWBGOXQIUVT","VRUOAMJQGFSIZNXLEPWTDCBK","VNCMBRLKUPDISJEWOAZGTXFQ","VGJQZXMPKEIRLTNODCABWFSU","IMALJVBCXSQPOUGEKNTRFDWZ","UPJBVKQOAIDGWEZRLTNSXFMC","IUAPCZFWOQTXBSNLKGVRDMEJ","DOIRNGMKJLEUCPTWZQSVXFAB","VJMWTPZFOGBNIDCQAULERKSX","OAISKWCDLVRQFGNZPUTJEMXB","NBTGWMEUROJDCKAZLFQXISPV","DSOBAIJXFWNTUVERGQMCLKPZ","SBLFZOGCNDWPXAEKTVRJUMIQ","EKWMAQNURJBZPLFDSGOVIXCT","BKXRSNVMWGAPCIFLZJTEUQOD","VQNWJSZTCPEURAKBLIXOFGMD","TQKFDXCWIUARVBELNOPJZGMS","MSCPWBTKQUFVDGEXROANJLIZ","XFQVITPRZMONWCLKBUAJGSED","MVKLRFQWICOPDJBUSTXNEZGA","DMKBRGLONJEIFTXZPUACQWSV","NKSJBQZORVFTXWAUCDLGEMIP","JQUIXNBRDMOLGSTFVAZCPEWK","MEBXTJUNVWCQAZGRLIKSPDFO","EKNUQILMTDPOSFJZWXGVCARB","JOZNFECPVSXRLGDUKQWBITAM","UXNZISEGTCVABJMKFLWDQPOR","IJCFLPGZRXQUMANODKBVSETW","KCJQRFEWNGAMBIXZVLPDSUTO","TMSEDRAUWZGQXJPIFVLCOBKN","ZPRXJNOEKCGFUSDQAILWMVTB","WTBXANSJLRKFEPOIVDMQUZCG","IRLVZNQPECOJATFWUSDMGKBX","BGMPAZOIKWCSUDJNXLTVREQF","BZXSTPRMLEKWCFIVONGADUQJ","UFGZCWTARKSBDJXPMVQIENOL","ZBROLDUFMNQAPJEGITXWCSKV","FWLJXQDTRCGNVUZMAPBKISEO","SJXLKAVZCPBIEWFQTNODGRMU","VAIBDLOEXGUZQWMPNSJTCRKF","XFLMPECKOQINGWSZJRTVBADU","ZAJCPMSKUBFWEXQDTVGNLORI","FUVECNMKZWJBGXTDLPASIOQR","COFKSVMTNLBWXAREZDQIJUGP","TKRVFXUIONEALPCDSJGBZWQM","VJNQLTARZSGCPOMFBUWIXKDE","GMUSFBPDZATKWEQONXCJILVR","RFNCLTQZXMSVWPIUBGDEAKOJ","NARSWLXMEIGQCFBOVDUJPZTK","OBZVJGSKDUCXAQWPIFNEMTRL","RIEQDWFSLCGTPKNBAJUVMZOX","GBAXDSVUEOJNTLPIRKZCWQMF","ZOETNALWVPGXRIMQKDBFUSCJ","NAMBJKFZQTOSGWCDPIRXLEUV","NWQJUZMKIXCGDSBREFPATLOV","KWAECTUZODSPIJMNLVQRXFBG","JXPWZNOCGRDKLQITUSEVAFBM","FNAXSLPRWUBMQJICZTVKDOEG","GMAWSUXVPZINTODEBRJFKQLC","FACUKTLWNJSXRQMEDZVGBOIP","FXEGPVLUJDRNQMTOWSIKAZCB","ZNEKOJXDVQSUFARMLWPGICTB","IRSZQGUKVJXCANFWLOBDEMPT","IUEDPRJFVGQSAXNOWCBMZTLK","XGKLOPJVQCWTBMSNUZARIEDF","VSOJUPRFDCNQXTLMBKIGZWEA","UDGIKPAFNTZWCJRMSLVOXEQB","GQOIULRNMCJVPFEAZBSDWKTX","ZJUTMKIFXRSCOPENVGLBDAQW","ZUQOBCPWNJKVARLTDEGIXFSM","ADBOKTGCWFMNVUEZLRPIQJSX","ALDVEQZKCTOJRWBMISPNXFGU","CEGUFDRXLAVTQNWOKMPZIJBS","EMBXCVQDJLNWSGIZPRAFTUKO","KJSQEPNOVGRWZLUIADFBCTXM","UWVFQEDASJBGXCNPTZIORMLK","XFLCZSMJAVEPIQDRTUBNKGWO","URFBQMVATJWEPDCNGSILOZXK","ZLDPUVIWOJEXGNTQFRBKSACM","IEQBVDUPNLCGJASFRXTWZOMK","TVWMROKSUPCXNFEALDQZIGBJ","GFKEZOICNTXPASMBJVRUWLDQ","NVWKLBMQJFPIRCSDOZGTXEAU","QANRCGLPMDZKFOTXBVJEIWUS","UPCLXNVQZTRKMEBGAOSFDJWI","PANMJZIFCWGKQDXSRUETOLVB","JGWVNUXLKAEODTBZIQRCMPFS","TEOMUIZFSXPGWLADRBQKJVCN","XPFDJLGZAWEKTRVCMBNUSOQI","OCQSTRKAZPIMUBNDGEXJVWLF","MILWTBRAVGZODFJUCSPXQENK","FREBOSZDPMCNUJXAVKIGLWQT","TQWPUCERNGIBMXDZKJVASFOL","APLDRMWCQNFUTSKXVEGJIZBO","SUWEMPJNFITABXVOCRZLDQKG","FGRZBWMUTIACNEJKVQPXDOSL","PBUWQEIDOLXCRNFVSZJTKAMG","BRFZUGVLWEJKNIASPMTXDQOC","XLIPMTZQSUFVANKOGBEJDRCW","GSCRPUAKMEIDBVOLQXWZNFTJ","KCQMJXRWSFGNBDLAUOTEIVZP","GKDPJSRMALVEXUNWOICTFQZB"};
        RankTeamsByVotes rankTeamsByVotes = new RankTeamsByVotes ();
        System.out.println (rankTeamsByVotes.rankTeams (votes));
    }
}
