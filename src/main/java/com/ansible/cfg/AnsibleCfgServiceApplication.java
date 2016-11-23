package com.ansible.cfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/ansible/ssh")
public class AnsibleCfgServiceApplication {

	@Autowired
	private SSHCopyService sshCopyService;

	public static void main(String[] args) {
		SpringApplication.run(AnsibleCfgServiceApplication.class, args);
	}

	@RequestMapping("/copySSH")
	@ResponseBody
	public String copySSH(String userName,String host,String password){
		SSHAuthInfo sshAuthInfo=new SSHAuthInfo();
		sshAuthInfo.setHost(host);
		sshAuthInfo.setPassword(password);
		sshAuthInfo.setUserName(userName);
		return sshCopyService.login(sshAuthInfo);
	}

	@RequestMapping("host/list")
	@ResponseBody
	public List<String>listHost(){
		return sshCopyService.findHostList();
	}

}
