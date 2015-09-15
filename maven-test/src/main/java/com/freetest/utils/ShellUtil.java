package com.freetest.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author free
 * 
 */
public class ShellUtil {
    public static final String STDOUT = "stdout";
    public static final String STDERR = "stderr";
    public static final String EXIT_CODE = "exit_code";
    public static final String CHARSET = "utf8";
    /**
     * 10M
     */
    public static int MAX_SIZE = 10 * 1024 * 1024;
    private static final String ERR_MSG = "output was too big,it was out of max (" + MAX_SIZE + ") memeory ";

    /**
     * 运行shell
     * 
     * @param cmd
     * @return [key=input:value=,key=error:value=,key=exit_code:value=? 执行结果为0就是成功 ]
     */
    public static Map<String, StringBuilder> execShell(String cmd) {
        return exec(new String[] { "/bin/sh", "-c", cmd }, CHARSET);
    }

    /**
     * 
     * @param cmd
     * @param charset
     * @return
     */
    public static Map<String, StringBuilder> exec(String[] cmd, String charset) {
        Map<String, StringBuilder> result = new HashMap<String, StringBuilder>();
        Process process = null;
        try {
            process = new ProcessBuilder(cmd).start();
            result = dealResult(process, charset);
        } catch (IOException e) {
            throw new RuntimeException("IO error: ", e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
        return result;

    }

    private static Map<String, StringBuilder> dealResult(final Process process, final String charset)
            throws UnsupportedEncodingException, InterruptedException {
        final Map<String, StringBuilder> result = new HashMap<String, StringBuilder>();
        final BufferedReader ibr = new BufferedReader(new InputStreamReader(process.getInputStream(), charset));
        final BufferedReader ebr = new BufferedReader(new InputStreamReader(process.getErrorStream(), charset));
        new Thread(new Runnable() {
            @Override
            public void run() {
                String line = "";
                StringBuilder sb = new StringBuilder("");
                try {
                    while ((line = ibr.readLine()) != null) {
                        sb.append(line).append("\n");
                        if (sb.length() > MAX_SIZE) {
                            sb.append(ERR_MSG);
                            break;
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(process.exitValue() + "", e);
                } catch (Exception e) {
                    throw new RuntimeException(process.exitValue() + "", e);
                } finally {
                    result.put(STDOUT, sb);
                    IOUtil.close(ibr);
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String line = "";
                StringBuilder sb = new StringBuilder("");
                try {
                    while ((line = ebr.readLine()) != null) {
                        sb.append(line).append("\n");
                        if (sb.length() > MAX_SIZE) {
                            sb.append(ERR_MSG);
                            break;
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(process.exitValue() + "", e);
                } catch (Exception e) {
                    throw new RuntimeException(process.exitValue() + "", e);
                } finally {
                    result.put(STDERR, sb);
                    IOUtil.close(ibr);
                }

            }
        }).start();
        int exitVal = process.waitFor();
        result.put(EXIT_CODE, new StringBuilder(exitVal + ""));
        while (true) {
            if (result.containsKey(STDOUT) && result.containsKey(STDERR)) {
                break;
            }
        }
        return result;
    }

}
