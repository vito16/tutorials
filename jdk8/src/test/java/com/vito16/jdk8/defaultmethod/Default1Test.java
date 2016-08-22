/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * muyu@yiji.com 2016-07-22 17:37 创建
 *
 */
package com.vito16.jdk8.defaultmethod;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/07/22
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class Default1Test {
	@Test
	public void testSay() {
		System.out.println(new Default1() {
			@Override
			public String say() {
				return "我再来修改下。";
			}
		}.say());
		
		Lists.newArrayList("a", "c", "b", "a").
                stream().
                map(String::toUpperCase).
                sorted((a,b)->a.compareTo(b)).
                forEach(System.out::println);
		
	}
}