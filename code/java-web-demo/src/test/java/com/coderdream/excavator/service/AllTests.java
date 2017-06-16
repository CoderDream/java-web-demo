/***********************************************
 * Filename       : AllTests.java
 * Copyright      : Copyright (c) 2014
 * Company        : Innovaee
 * Created        : 11/27/2014
 ************************************************/

package com.coderdream.excavator.service;

import java.net.URI;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @Title: AllTests
 * @Description: 单元测试包
 * @version V1.0
 */
@RunWith(Suite.class)
@SuiteClasses({ ExcavatorServiceTest.class,
		UserResourceTest.class })
public class AllTests {

	/** RESTful的基本URI */
	public static final String BASE_URI = "http://localhost:8080/eorder-ws/rest";

	/** 服务器 */
	public static HttpServer server;

	/**
	 * 启动服务器
	 */
	@BeforeClass
	public static void startServer() {
		final ResourceConfig rc = new ResourceConfig();
		// 服务类所在的包路径
		rc.packages("com.innovaee.eorder.resources");
		// 注册JSON转换器
		rc.register(JacksonJsonProvider.class);

		server = GrizzlyHttpServerFactory.createHttpServer(
				URI.create(BASE_URI), rc);
	}

	/**
	 * 关闭服务器
	 */
	@AfterClass
	public static void shutdownServer() {
		server.shutdownNow();
	}

}