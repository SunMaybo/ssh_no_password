package com.ansible.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by maybo on 2016/11/23.
 */
@Service
public class SSHCopyService {

    @Autowired
    private FileConfig fileConfig;

    public String login(SSHAuthInfo sshAuthInfo){
        String end= SSHCopyIdUtil.sshCopyId(fileConfig.getShellFilePath(),sshAuthInfo);
        try {
            FilePropertiesUtil.WriteProperties(fileConfig.getSaveFilePath(),
                    sshAuthInfo.getUserName()+"@"+sshAuthInfo.getHost(),sshAuthInfo.getHost());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return end;
    }

    public List<String>findHostList(){
        try {
            return FilePropertiesUtil.GetAllProperties(fileConfig.getSaveFilePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
