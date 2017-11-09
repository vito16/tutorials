package com.vito16.customannotation;

import com.vito16.customannotation.common.ApiService;
import org.springframework.stereotype.Service;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2017/11/09
 */
@Service
public class DemoService {

    @ApiService
    public void test(){
        System.out.println("method body....");
    }

}
