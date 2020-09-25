package com.baeldung.system.git;

import java.util.ArrayList;

public class CmdCommander {

    static ArrayList<String> urls = new ArrayList<String>();

    static {
        urls.add("https://gitlab-01.russpass.com/russpass-prod/audit");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/portal");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/basement");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/cms");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/idm");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/web-scanner");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/russpass");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/portal-ssr.git");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/rbc-gateway");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/billing-ms-atol");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/billing-ms-carding");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/billing-ms-integration");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/partner-lk");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/mdm-service");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/mdm-web");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/basement-front");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/russpass-idm");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/russpass-audit");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/russpass-theme");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/n2o-studio");
        urls.add("https://gitlab-01.russpass.com/russpass-prod/geo-storage.git");
    }

    private final static String START_QUOTE = "\"";
    private final static String END_QUOTE = "\"";
    private final static String BASE_START = " cmd  /K start cmd /K ";
    private final static String FIRST_COMMAND_CHCPFIRST_COMMAND_CHCP = " chcp 1251 ";
    private final static String GIT_CLONE = " &git clone ";
    private final static String CHANGE_DIR = " &cd C:\\git\\russpass-prod ";

    public static void main(String[] args) {

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
                    "%s" +
                    " %s " +
                    END_QUOTE;

        urls.forEach(command -> {
            try {
                runCmd(String.format(totalCommand, GIT_CLONE, command));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread t = Thread.currentThread();
    }

    public static void runCmd(String command) throws Exception {

        Runtime rt = Runtime.getRuntime();
        System.out.println(command);
        Process proc = rt.exec(command);
        System.out.println(proc.pid() + " finished");


    }
}