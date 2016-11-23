package com.ansible.cfg;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maybo on 2016/11/23.
 */
public class ShellExecuteUtil {

    /**
     * 运行shell
     *
     * @param shStr
     *            需要执行的shell
     * @return
     * @throws IOException
     */
    public static List runShell(String shStr) throws Exception {
        List<String> strList = new ArrayList();

        Process process;
        process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",shStr},null,null);
        InputStreamReader ir = new InputStreamReader(process
                .getInputStream());
        LineNumberReader input = new LineNumberReader(ir);
        String line;
        process.waitFor();
        while ((line = input.readLine()) != null){
            strList.add(line);
        }

        return strList;
    }

    public static void main(String[] args){
        try {
            String root=System.getProperty("user.dir");
            System.out.println(root);
            List<String>excEnd=runShell("ssh root@192.168.100.95");
            System.out.println(excEnd.toString());
        } catch (Exception e) {e.printStackTrace();

        }

    }
}
