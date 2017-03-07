package com.apache.cxf.queryparam.service;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service("playerService")
public class PlayerServiceImpl implements IPlayerService {

	/**
	 * this method takes one argument from QueryParam and returns a Response
	 */
	public Response welcomePlayer(String playerName) {

		String greetMessage = "Welcome " + playerName + " to Lords - the home of cricket";
		return Response.status(200).entity(greetMessage).build();
	}

	/**
	 * this method takes three argument from QueryParam and returns a Response
	 */
	public Response getPlayerInfo(String playerName, int age, int matches) {

		String playerInfo = "[name=" + playerName +  ", age=" + age + ", matches=" + matches + "]";
		return Response.status(200).entity(playerInfo).build();
	}
}