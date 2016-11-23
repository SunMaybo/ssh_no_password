package com.ansible.cfg;

import java.util.List;

/**
 * Created by maybo on 2016/11/23.
 */
public class SSHCopyIdUtil {


    public static String sshCopyId(String  filePath,SSHAuthInfo sshAuthInfo){

        List<String> endList= null;
        try {
            endList = ShellExecuteUtil.runShell("sh " + filePath + " "
                    + sshAuthInfo.getUserName() + " "
                    + sshAuthInfo.getHost() + " "
                    + sshAuthInfo.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endList.toString();
    }
}
