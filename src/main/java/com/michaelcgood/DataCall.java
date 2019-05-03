package com.michaelcgood;

import org.assertj.core.api.UrlAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michaelcgood.dao.SystemRepository;
import com.michaelcgood.model.SystemExample;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@RestController
public class DataCall {
	@Autowired
	SystemRepository systemRepository;
	@GetMapping("good/{id}")
	public  String caller(@PathVariable("id") String id) {
		String  f=null;
		SystemExample systemExampleWindows = new SystemExample();
		Iterable<SystemExample> s=systemRepository.findAll();
		if(s!=null) {
		for (SystemExample systemExample : s) {
			if(systemExample.getName()!=null) {
			if(systemExample.getName().equalsIgnoreCase(id)) {
				f=" Your Name Already exists in DB";
			}
			}
		}
		}
		if(f==null) {
			
			 f="Your name updated in DB";
				systemExampleWindows.setName(id);
				systemRepository.save(systemExampleWindows);

			
		}
		
		return "Hello "+id +f;
	
	}
	@GetMapping("proxy/{id}")
	public  String callerProxy(@PathVariable("id") String id) throws IOException {
		URL url=new URL("http://localhost:8080/proxy/caller/"+id);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		System.out.println(con.getResponseCode());
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input = null;
		input=br.readLine();
			System.out.println(input);
		
		
		return input;
		
	}
	@GetMapping("proxy/caller/{id}")
	public  String callerProxyServer(@PathVariable String id) {
		
		return id+ " :Success Proxy Server Call";
		
	}
}
