package com.springboot.ecom.mapper;

import com.springboot.ecom.dto.Executive.ExecutiveUserDto;
import com.springboot.ecom.enums.JobTitle;
import com.springboot.ecom.model.Executive;
import com.springboot.ecom.model.User;
import org.springframework.stereotype.Component;

@Component
public class ExecutiveMapper
{
public  static Executive mapDtoToEntiry(JobTitle jobTitle, String name){
    Executive executive=new Executive();
    executive.setName(name);
    executive.setJobTitle(jobTitle);
    return  executive;
}

}
