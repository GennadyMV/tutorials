package com.baeldung.system.git;

import java.util.ArrayList;

public class CmdCommander {

    static ArrayList<String> urls = new ArrayList<String>();

    static {
        urls.add("${URL:localhost}");
    }

    private final static String START_QUOTE = "\"";
    private final static String END_QUOTE = "\"";
    private final static String BASE_START = " cmd  /K start cmd /K ";
//    private final static String BASE_START = " \"C:\\Program Files\\Git\\git-bash.exe\"   /K start git-bash.exe  /K ";
    private final static String FIRST_COMMAND_CHCPFIRST_COMMAND_CHCP = " chcp 1251 ";
    private final static String GIT_CLONE = " &git clone ";
    private final static String CHANGE_DIR = " &cd C:\\git\\githost-prod ";
    private final static String COMMAND = "\"C:\\Program Files\\Git\\git-bash.exe\" -c \"cd /c/git/githost-prod/  && start git clone %s &&  start \"C:\\Program Files\\Git\\git-bash.exe -c \"";
    private final static String COMMAND2 = "for branch in `git branch -a | sed -e \"s/remotes\\/origin.//\" `; do git checkout  ${branch} done";


    public static void main(String[] args) throws Exception {

    /*
    Rules are:
    1.baseStart must be dual start
    2.first command must not have &.
    3.subsequent commands must be prepended with &
    4.drive change needs extra &
    5.use quotes at start and end of command batch
    */


        String totalCommand =
                BASE_START +
                    START_QUOTE +
                    FIRST_COMMAND_CHCPFIRST_COMMAND_CHCP +
                    CHANGE_DIR +
                    " %s" +
                    " %s " +
                    END_QUOTE;

//        runCmd("\"C:\\Program Files\\Git\\git-bash.exe\" -c \"cd /c/git/githost-prod/  && start git clone https://gitlab-01.githost.com/githost-prod/audit \"");
//        runCmd("\"C:\\Program Files\\Git\\git-bash.exe\" -c \"cd /c/git/githost-prod/  && start git clone https://gitlab-01.githost.com/githost-prod/audit \"");
//        "C:\Program Files\Git\git-bash.exe" -cd C:\git\githost-prod & start git clone https://gitlab-01.githost.com/githost-prod/audit"
//        urls.forEach(command -> {
//            try {
//                runCmd(String.format(COMMAND,  command));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
        String replace = "https://gitlab-01.githost.com/githost-prod/geo-storage.git".replace("https://gitlab-01.githost.com/githost-prod/", "").replace(".git","");

        runCmd( "\"C:\\Program Files\\Git\\git-bash.exe\" -c \"cd /c/git/githost-prod/"+ ""+replace+" "+ COMMAND2+"");
    }

    public static void runCmd(String command) throws Exception {

        Runtime rt = Runtime.getRuntime();
        System.out.println(command);
        Process proc = rt.exec(command);
//         rt.exec("\"C:\\Program Files\\Git\\git-bash.exe\" start git clone https://gitlab-01.githost.com/githost-prod/audit");
        System.out.println(proc.pid() + " finished");


    }
}