package com.baeldung.system.git;

import com.sun.jdi.connect.Transport;
import lombok.SneakyThrows;
import org.junit.Assert;

import java.io.*;
import java.nio.file.Files;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class CommandExecutor {

    public static void main(String[] args) throws Exception {
        exec();
    }
    private static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().startsWith("windows");
    private static String homeDirectory = System.getProperty("user.home");
    private static Consumer<String> consumer = Assert::assertNotNull;

    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumer);
        }
    }


    static void exec() throws Exception {


//        File workingDir = Files.createTempDirectory("workspace").toFile();
//        TransportConfigCallback transportConfigCallback = new SshTransportConfigCallback();
//        git = Git.cloneRepository()
//                .setDirectory(workingDir)
//                .setTransportConfigCallback(transportConfigCallback)
//                .setURI("ssh://example.com/repo.git")
//                .call();


//
//        ProcessBuilder builder = new ProcessBuilder();
//        if (IS_WINDOWS) {
//            builder.command("cmd.exe", "git", " -h");
//        } else {
//            builder.command("sh", "-c", "ls");
//        }
//        builder.directory(new
//
//                File(homeDirectory));
//        Process process = builder.start();
//        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), consumer);
//        Executors.newSingleThreadExecutor().
//
//                submit(streamGobbler);
//
//        int exitCode = process.waitFor();
    }
}

// class SshTransportConfigCallback implements TransportConfigCallback {
//    private final SshSessionFactory sshSessionFactory = new JschConfigSessionFactory() {
//        @Override
//        protected void configure(OpenSshConfig.Host hc, Session session) {
//            session.setConfig("StrictHostKeyChecking", "no");
//        }
//        @Override
//        protected JSch createDefaultJSch(FS fs) throws JSchException {
//            JSch jSch = super.createDefaultJSch(fs);
//            jSch.addIdentity("/path/to/key", "super-secret-passphrase".getBytes());
//            return jSch;
//        }
//    };
//    @Override
//    public void configure(Transport transport) {
//        SshTransport sshTransport = (SshTransport) transport;
//        sshTransport.setSshSessionFactory(sshSessionFactory);
//    }
//}
//
//
//    class SshTransportConfigCallback implements TransportConfigCallback {
//    private final SshSessionFactory sshSessionFactory = new JschConfigSessionFactory() {
//        @Override
//        protected void configure(OpenSshConfig.Host hc, Session session) {
//            session.setConfig("StrictHostKeyChecking", "no");
//        }
//    };
//    @Override
//    public void configure(Transport transport) {
//        SshTransport sshTransport = (SshTransport) transport;
//        sshTransport.setSshSessionFactory(sshSessionFactory);
//    }
//}


